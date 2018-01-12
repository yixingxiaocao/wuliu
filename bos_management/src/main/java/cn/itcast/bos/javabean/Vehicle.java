package cn.itcast.bos.javabean;


import java.io.Serializable;

/**
 * @description:车辆
 */
public class Vehicle implements Serializable {

	private Integer id;
	private String routeType; // 线路类型
	private String routeName; // 线路名称
	private String shipper; // 承运商
	private String driver; // 司机
		private String vehicleNum; // 车牌号
	private String telephone; // 电话
	private String vehicleType;// 车型
	private Integer ton; // 吨控
	private String remark;// 备注

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRouteType() {
		return routeType;
	}

	public void setRouteType(String routeType) {
		this.routeType = routeType;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getShipper() {
		return shipper;
	}

	public void setShipper(String shipper) {
		this.shipper = shipper;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Integer getTon() {
		return ton;
	}

	public void setTon(Integer ton) {
		this.ton = ton;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
