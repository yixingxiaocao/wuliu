package cn.itcast.bos.javabean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;




/**
 * @description:地域信息实体类，主要包含 省市区(县)
 */
public class Area implements Serializable {

	private String id;
	private String province; // 省
	private String city; // 城市
	private String district; // 区域
	private String postcode; // 邮编
	private String citycode; // 城市编码
	private String shortcode; // 简码

	private Set<SubArea> subareas = new HashSet<SubArea>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getShortcode() {
		return shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public Set<SubArea> getSubareas() {
		return subareas;
	}

	public void setSubareas(Set<SubArea> subareas) {
		this.subareas = subareas;
	}



}
