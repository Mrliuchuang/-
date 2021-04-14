package io.renren.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.annotation.Login;
import io.renren.common.validator.ValidatorUtils;
import io.renren.entity.MarketEntity;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.service.MarketService;
import org.springframework.web.multipart.MultipartFile;


/**
 * 集市
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2021-04-14 00:08:55
 */
@RestController
@RequestMapping("api/market")
public class MarketController {
    @Autowired
    private MarketService marketService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:market:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = marketService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{marketId}")
    @RequiresPermissions("sys:market:info")
    public R info(@PathVariable("marketId") Integer marketId){
        MarketEntity market = marketService.getById(marketId);

        return R.ok().put("market", market);
    }

    /**
     * 保存
     */
    @Login
    @RequestMapping("/save")
    @RequiresPermissions("sys:market:save")
    @ApiOperation("添加商品信息（后台管理系统）")
    public R save(@ApiParam(name = "token", value = "token", required = true) @RequestParam("token") String token,
                  @ApiParam(name = "nameMarket", value = "商品名称", required = true)  @RequestParam("nameMarket")String nameMarket,
                  @ApiParam(name = "contentMarket", value = "商品的详细信息", required = true) @RequestParam("contentMarket") String contentMarket,
                  @ApiParam(name = "file", value = "图片（file）", required = true) @RequestParam("file") MultipartFile file){


        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:market:update")
    public R update(@RequestBody MarketEntity market){
            ValidatorUtils.validateEntity(market);
            marketService.updateById(market);

            return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:market:delete")
    public R delete(@RequestBody Integer[] marketIds){
        marketService.removeByIds(Arrays.asList(marketIds));

        return R.ok();
    }

}
