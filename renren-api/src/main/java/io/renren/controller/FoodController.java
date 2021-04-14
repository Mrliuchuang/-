package io.renren.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.renren.annotation.Login;
import io.renren.common.validator.ValidatorUtils;
import io.renren.entity.FoodEntity;
import io.renren.entity.MenuEntity;
import io.renren.service.FoodService;
import io.renren.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import org.springframework.web.multipart.MultipartFile;


/**
 * 晒美食
 *
 * @date 2021-04-13 22:33:09
 */
@RestController
@RequestMapping("api/food")
@Api(tags = "晒美食接口")
public class FoodController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private TokenService tokenService;

    /**
     * 列表
     */
    @PostMapping("/list")
    @RequiresPermissions("sys:food:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = foodService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @Login
    @PostMapping("/info/{token}")
    @RequiresPermissions("sys:food:info")
    @ApiOperation("查询美食信息")
    public R info(@PathVariable("token") String token) {
        /*获取userid*/
        Long userId = tokenService.queryByToken(token).getUserId();
        QueryWrapper<FoodEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<FoodEntity> menu = foodService.list(queryWrapper);
        return R.ok().put("food", menu);
    }

    /**
     * 保存
     */
    @Login
    @PostMapping("/save")
    @RequiresPermissions("sys:food:save")
    @ApiOperation("添加美食信息")
    public R save(@ApiParam(name = "token", value = "token", required = true) @RequestParam("token") String token,
                  @ApiParam(name = "nameFood", value = "美食名称", required = true) @RequestParam("nameFood") String nameFood,
                  @ApiParam(name = "contentFood", value = "美食内容", required = true) @RequestParam("contentFood") String contentFood,
                  @ApiParam(name = "file", value = "美食图片（file）", required = true) @RequestParam("file") MultipartFile file) {
        FoodEntity food = new FoodEntity();
        /*获取userid*/
        Long userId = tokenService.queryByToken(token).getUserId();
        food.setUserId(userId);
        food.setUrlFood("urlMenu");
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        String timeFood = df.format(new Date());
        food.setTimeFood(timeFood);
        food.setNameFood(nameFood);
        food.setContentFood(contentFood);
        foodService.save(food);
        ImageUoload imageUoload = new ImageUoload();
        try {
            imageUoload.imageupload(file, userId, 2);
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
    @RequiresPermissions("sys:food:update")
    @ApiOperation("修改美食信息")
    public R update(@ApiParam(name = "token", value = "token", required = true) @RequestParam("token") String token,
                    @ApiParam(name = "nameFood", value = "美食名称", required = true) @RequestParam("nameFood") String nameFood,
                    @ApiParam(name = "contentFood", value = "美食内容", required = true) @RequestParam("contentFood") String contentFood,
                    @ApiParam(name = "foodId", value = "主键（根据此字段更新）", required = true) @RequestParam("foodId") int foodId) {
        /*获取userid*/
        Long userId = tokenService.queryByToken(token).getUserId();
        UpdateWrapper updateWrapper = new UpdateWrapper();
        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setNameFood(nameFood);
        foodEntity.setContentFood(contentFood);
        updateWrapper.eq("food_id", foodId);
        updateWrapper.eq("user_id", userId);
        // menuService.updateById(menu);
        boolean update = foodService.update(foodEntity, updateWrapper);
        return R.ok();
    }

    /**
     * 删除
     */
    @Login
    @PostMapping("/delete")
    @RequiresPermissions("sys:food:delete")
    @ApiOperation("删除美食信息")
    public R delete(@ApiParam(name = "token", value = "token", required = true) @RequestParam("token") String token,
                    @ApiParam(name = "foodIds", value = "传入想删除的foodIds的数组  eg:[12,1]", required = true) @RequestBody Integer[] foodIds) {
        foodService.removeByIds(Arrays.asList(foodIds));

        return R.ok();
    }

}
