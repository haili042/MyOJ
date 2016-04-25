package com.haili.exam.test;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wxweven
 * @date 2015�?�?7�?
 * @version 1.0
 * @email wxweven@163.com
 * @blog http://wxweven.blog.163.com/
 * @Copyright: Copyright (c) wxweven 2014
 * @Description:附件实体
 */
public class ViewExtraConfig implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;// id
	private String extraColumn;// 额外字段�?
	private String extraColumnName;// 额外字段注释
	private String confValue;// 额外字段配置内容
	private String dataSource;// 数据�?
	private String dataValue;// 运行�?
	private String cityNumber;// 地州
	private String needDisplay;// 是否�?��展示
	private Date createTime;// 配置时间
	private String userName;// 配置�?
	private String description;// 说明
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getExtraColumn() {
		return extraColumn;
	}
	public void setExtraColumn(String extraColumn) {
		this.extraColumn = extraColumn;
	}
	public String getExtraColumnName() {
		return extraColumnName;
	}
	public void setExtraColumnName(String extraColumnName) {
		this.extraColumnName = extraColumnName;
	}
	public String getConfValue() {
		return confValue;
	}
	public void setConfValue(String confValue) {
		this.confValue = confValue;
	}
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public String getDataValue() {
		return dataValue;
	}
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}
	public String getCityNumber() {
		return cityNumber;
	}
	public void setCityNumber(String cityNumber) {
		this.cityNumber = cityNumber;
	}
	public String getNeedDisplay() {
		return needDisplay;
	}
	public void setNeedDisplay(String needDisplay) {
		this.needDisplay = needDisplay;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


}
