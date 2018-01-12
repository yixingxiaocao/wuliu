package cn.itcast.bos.javabean;


import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:收派标准
 */
	public class Standard implements Serializable {
	private Integer id; // 主键
	private String name; // 标准名称
	private Integer minWeight; // 最小重量
	private Integer maxWeight; // 最大重量
	private Integer minLength; // 最小长度
	private Integer maxLength; // 最大重量
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date operatingTime;// 操作时间
	private String operator; // 操作员
	private String operatingCompany; // 操作单位

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getMinWeight() {
		return minWeight;
	}

	public Integer getMaxWeight() {
		return maxWeight;
	}

	public Integer getMinLength() {
		return minLength;
	}

	public Integer getMaxLength() {
		return maxLength;
	}

	public Date getOperatingTime() {
		return operatingTime;
	}

	public String getOperator() {
		return operator;
	}

	public String getOperatingCompany() {
		return operatingCompany;
	}

	public void setId(Integer id) {

		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMinWeight(Integer minWeight) {
		this.minWeight = minWeight;
	}

	public void setMaxWeight(Integer maxWeight) {
		this.maxWeight = maxWeight;
	}

	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	public void setOperatingTime(Date operatingTime) {
		this.operatingTime = operatingTime;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public void setOperatingCompany(String operatingCompany) {
		this.operatingCompany = operatingCompany;
	}
}
