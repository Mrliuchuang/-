package io.renren.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 集市
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2021-04-14 00:08:55
 */
@Data
@TableName("tb_market")
public class MarketEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户user_id
	 */
	private Long userId;
	/**
	 * 商品名
	 */
	private String nameMarket;
	/**
	 * 商品内容
	 */
	private String contentMarket;
	/**
	 * 商品文件的url
	 */
	private String urlMarket;
	/**
	 * 商品上传时间
	 */
	private String timeMarket;
	/**
	 * 拓展字段1
	 */
	private String extends1;
	/**
	 * 拓展字段2
	 */
	private String extends2;
	/**
	 * 商品价格
	 */
	private Integer moneyMarket;
	/**
	 * 商品数量
	 */
	private Integer numberMarket;
	/**
	 * 
	 */
	@TableId
	private Integer marketId;

}
