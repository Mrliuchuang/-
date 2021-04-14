package io.renren.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.entity.FoodEntity;


import java.util.Map;

/**
 * 晒美食
 * @date 2021-04-13 22:33:09
 */
public interface FoodService extends IService<FoodEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

