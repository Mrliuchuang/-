package io.renren.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.entity.FoodEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 晒美食
 * @date 2021-04-13 22:33:09
 */
@Mapper
public interface FoodDao extends BaseMapper<FoodEntity> {
	
}
