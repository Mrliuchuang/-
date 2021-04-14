package io.renren.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜谱
 * @date 2021-04-12 12:36:11
 */
@Data
@TableName("tb_menu")
public class MenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户user_id
	 */
	private Long userId;
	/**
	 * 菜谱名
	 */
	private String nameMenu;
	/**
	 * 菜谱内容
	 */
	private String contentMenu;
	/**
	 * 菜谱文件的url
	 */
	private String urlMenu;
	/**
	 * 菜谱上传时间
	 */
	private String timeMenu;
	/**
	 * 拓展字段1
	 */
	private String extends1;
	/**
	 * 拓展字段2
	 */

	private String extends2;
	/**
	 *
	 */
	@TableId
	private Integer menuId;
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNameMenu() {
		return nameMenu;
	}

	public void setNameMenu(String nameMenu) {
		this.nameMenu = nameMenu;
	}

	public String getContentMenu() {
		return contentMenu;
	}

	public void setContentMenu(String contentMenu) {
		this.contentMenu = contentMenu;
	}

	public String getUrlMenu() {
		return urlMenu;
	}

	public void setUrlMenu(String urlMenu) {
		this.urlMenu = urlMenu;
	}

	public String getTimeMenu() {
		return timeMenu;
	}

	public void setTimeMenu(String timeMenu) {
		this.timeMenu = timeMenu;
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

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
}
