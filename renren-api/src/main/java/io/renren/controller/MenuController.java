package io.renren.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.renren.annotation.Login;
import io.renren.common.validator.ValidatorUtils;
import io.renren.entity.MenuEntity;
import io.renren.entity.TokenEntity;
import io.renren.service.MenuService;
import io.renren.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.aspectj.weaver.patterns.IToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.spring.web.json.Json;


/**
 * 菜谱
 *
 * @date 2021-04-12 12:36:11
 */
@RestController
@RequestMapping("/api/menu")
@Api(tags = "菜谱接口")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private TokenService tokenService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:menu:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = menuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @Login
    @PostMapping("/info/{token}")
    @RequiresPermissions("sys:menu:info")
    @ApiOperation("查询菜谱信息")
    public R info(@PathVariable("token") String token) {
        /*获取userid*/
        Long userId = tokenService.queryByToken(token).getUserId();
        QueryWrapper<MenuEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<MenuEntity> menu = menuService.list(queryWrapper);
        return R.ok().put("menu", menu);
    }

    /**
     * 保存
     */
    @Login
    @PostMapping("/save")
    @RequiresPermissions("sys:menu:save")
    @ApiOperation("添加菜谱信息")
    public R save(@ApiParam(name = "token", value = "token", required = true) @RequestParam("token") String token,
                  @ApiParam(name = "nameMenu", value = "菜谱名称", required = true)  @RequestParam("nameMenu")String nameMenu,
                  @ApiParam(name = "contentMenu", value = "菜谱内容", required = true) @RequestParam("contentMenu") String contentMenu,
                  @ApiParam(name = "file", value = "菜谱图片（file）", required = true) @RequestParam("file") MultipartFile file) {
        MenuEntity menu = new MenuEntity();
        /*获取userid*/
        Long userId = tokenService.queryByToken(token).getUserId();
        menu.setUserId(userId);
        menu.setUrlMenu("urlMenu");
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        String timeMenu = df.format(new Date());
        menu.setTimeMenu(timeMenu);
        menu.setNameMenu(nameMenu);
        menu.setContentMenu(contentMenu);
        menuService.save(menu);
        ImageUoload imageUoload = new ImageUoload();
        try {
            imageUoload.imageupload(file,userId,1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @Login
    @PostMapping("/update")
    @RequiresPermissions("sys:menu:update")
    @ApiOperation("修改菜谱信息")
    public R update(@ApiParam(name = "token", value = "token", required = true) @RequestParam("token") String token,
                    @ApiParam(name = "nameMenu", value = "菜谱名称", required = true)  @RequestParam("nameMenu")String nameMenu,
                    @ApiParam(name = "contentMenu", value = "菜谱内容", required = true) @RequestParam("contentMenu") String contentMenu,
                    @ApiParam(name = "menuId", value = "主键（根据此字段更新）", required = true) @RequestParam("menuId") int menuId) {
        /*获取userid*/
        Long userId = tokenService.queryByToken(token).getUserId();
        UpdateWrapper updateWrapper = new UpdateWrapper();
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setNameMenu(nameMenu);
        menuEntity.setContentMenu(contentMenu);
        updateWrapper.eq("menu_id", menuId);
        updateWrapper.eq("user_id", userId);
       // menuService.updateById(menu);
        boolean update = menuService.update(menuEntity, updateWrapper);
        return R.ok();
    }

    /**
     * 删除
     */
    @Login
    @PostMapping("/delete")
    @RequiresPermissions("sys:menu:delete")
    @ApiOperation("删除菜谱信息")
    public R delete(@ApiParam(name = "token", value = "token", required = true) @RequestParam("token") String token,
                    @ApiParam(name = "menuIds", value = "传入想删除的menuid的数组  eg:[12,1]", required = true) @RequestBody Integer[] menuIds) {
        menuService.removeByIds(Arrays.asList(menuIds));
        return R.ok();
    }

}
