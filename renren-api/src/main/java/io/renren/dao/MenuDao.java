package io.renren.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.entity.MenuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 菜谱
 * @date 2021-04-12 12:36:11
 */
@Mapper
public interface MenuDao extends BaseMapper<MenuEntity> {
	
}
