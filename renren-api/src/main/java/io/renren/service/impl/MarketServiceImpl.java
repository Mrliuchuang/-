package io.renren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.Query;
import io.renren.dao.MarketDao;
import io.renren.entity.MarketEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import io.renren.common.utils.PageUtils;
import io.renren.service.MarketService;

@Service("marketService")
public class MarketServiceImpl extends ServiceImpl<MarketDao, MarketEntity> implements MarketService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MarketEntity> page = this.page(
                new Query<MarketEntity>().getPage(params),
                new QueryWrapper<MarketEntity>()
        );

        return new PageUtils(page);
    }

}
