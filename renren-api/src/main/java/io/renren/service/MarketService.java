package io.renren.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.entity.MarketEntity;

import java.util.Map;

/**
 * 集市
 * @date 2021-04-14 00:08:55
 */
public interface MarketService extends IService<MarketEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

