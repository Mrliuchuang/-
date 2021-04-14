package io.renren.controller;


import io.renren.common.utils.EnterJdbcTemplate;
import io.renren.common.utils.Urls;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Controller
public class ImageUoload extends EnterJdbcTemplate {
    public ImageUoload(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }
    public ImageUoload() {

    }
    private String filePath = "E:/test/touxiang/";

    @RequestMapping("/imageUpload")
    @ResponseBody
    public void imageupload(MultipartFile file, Long userId,int tag) throws IOException {
        System.out.println(userId);
        File filee = new File(filePath);
        if (!filee.exists()) {
            filee.mkdirs();
        }
        //文件名称
        String realFileName = file.getOriginalFilename();
        //文件后缀
        String suffix = realFileName.substring(realFileName.lastIndexOf(".") + 1);
        /***************文件处理*********************/
        String newFileName = UUID.randomUUID() + realFileName;
        String newFilePath = filePath + newFileName;
        System.out.println(newFilePath + ":::" + newFileName);
        imagesql(newFileName, userId,tag);
        //新文件的路径
        try {
            file.transferTo(new File(newFilePath));
            //将传来的文件写入新建的文件
            System.out.println("上传图片成功进行上传文件测试");

        } catch (IllegalStateException e) {
            //处理异常
        } catch (IOException e1) {
            //处理异常
        }
    }

    private void imagesql(String newFileName, Long userId,int tag) {
        String pathvideo = Urls.BASE_URL + "touxiang/" + newFileName;
        String sql = null;
        if (tag==1){
             sql = "UPDATE tb_menu set url_menu='" + pathvideo + "' where user_id='" + userId + "'";
        }else if(tag==2){
            sql = "UPDATE tb_food set url_food='" + pathvideo + "' where user_id='" + userId + "'";
        }
        int a = getJdbcTemplate().update(sql);
        if (a > 0) {
            System.out.println(pathvideo + "插入成功");
        }
    }

    @RequestMapping("/getimagepath")
    @ResponseBody
    private String get_image_path(Long user) {
        /*String sql = "select touxiang from user where name_user='"+user+"'";*/
        String sql = "select * from tb_menu ";
        List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
        String url = (String) list.get(0).get("url_menu");
        return url;
    }
}
