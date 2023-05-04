package com.example.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.example.common.valid.AddGroup;
import com.example.common.valid.ListValue;
import com.example.common.valid.UpdateGroup;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author sunhb
 * @email sunlightcs@gmail.com
 * @date 2023-04-05 22:04:24
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotNull(message = "更新品牌id必须指定id",groups = {UpdateGroup.class})
	@Null(message = "新增不能指定id",groups = {AddGroup.class})
	@NotBlank(message = "不满足名字的命名规则")
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotBlank(message = "品牌名称必须提交",groups = {AddGroup.class})
	@URL(message = "logo必须是一个合法的url地址",groups = {AddGroup.class, UpdateGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@ListValue(vals = {0,1},groups = {AddGroup.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotBlank(groups = {AddGroup.class})
	@Pattern(regexp = "/^[a-zA-Z]$/",message = "必须是a-z或者A-Z",groups = {AddGroup.class, UpdateGroup.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@Min(value = 0,message = "需要大于等于0",groups = {AddGroup.class, UpdateGroup.class})
	private Integer sort;

}
