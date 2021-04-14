package io.renren.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.entity.MarketEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 集市
 * @date 2021-04-14 00:08:55
 */
@Mapper
public interface MarketDao extends BaseMapper<MarketEntity> {
	
}
