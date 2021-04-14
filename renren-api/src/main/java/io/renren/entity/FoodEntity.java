package io.renren.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 晒美食
 * @date 2021-04-13 22:33:09
 */
@Data
@TableName("tb_food")
public class FoodEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户user_id
	 */
	private Long userId;
	/**
	 * 美食名
	 */
	private String nameFood;
	/**
	 * 美食内容
	 */
	private String contentFood;
	/**
	 * 美食文件的url
	 */
	private String urlFood;
	/**
	 * 美食上传时间
	 */
	private String timeFood;
	/**
	 * 拓展字段1
	 */
	private String extends1;
	/**
	 * 拓展字段2
	 */
	private String extends2;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNameFood() {
		return nameFood;
	}

	public void setNameFood(String nameFood) {
		this.nameFood = nameFood;
	}

	public String getContentFood() {
		return contentFood;
	}

	public void setContentFood(String contentFood) {
		this.contentFood = contentFood;
	}

	public String getUrlFood() {
		return urlFood;
	}

	public void setUrlFood(String urlFood) {
		this.urlFood = urlFood;
	}

	public String getTimeFood() {
		return timeFood;
	}

	public void setTimeFood(String timeFood) {
		this.timeFood = timeFood;
	}

	public String getExtends1() {
		return extends1;
	}

	public void setExtends1(String extends1) {
		this.extends1 = extends1;
	}

	public String getExtends2() {
		return extends2;
	}

	public void setExtends2(String extends2) {
		this.extends2 = extends2;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	/**
	 * 
	 */
	@TableId
	private Integer foodId;

}
