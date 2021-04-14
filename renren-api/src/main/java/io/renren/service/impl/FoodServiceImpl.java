package io.renren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.Query;
import io.renren.dao.FoodDao;
import io.renren.entity.FoodEntity;
import io.renren.service.FoodService;
import org.springframework.stereotype.Service;
import java.util.Map;
import io.renren.common.utils.PageUtils;



@Service("foodService")
public class FoodServiceImpl extends ServiceImpl<FoodDao, FoodEntity> implements FoodService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FoodEntity> page = this.page(
                new Query<FoodEntity>().getPage(params),
                new QueryWrapper<FoodEntity>()
        );

        return new PageUtils(page);
    }

}
