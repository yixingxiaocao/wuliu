package cn.itcast.bos.javabean;

import java.io.Serializable;
import java.util.Date;



/**
 * @description:子档案类，记录了档案分级后的子信息
 */
public class SubArchive implements Serializable{
	private Integer id; // 主键
	private String subArchiveName; // 子档名称
	private String mnemonicCode; // 助记码
	private String remark; // 备注
	private Character mothballed; // 封存标志
	private Date operatingTime;// 操作时间
	private String operator; // 操作员
	private String operatingCompany; // 操作单位

	private Archive archive; // 关联基本档案信息

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubArchiveName() {
		return subArchiveName;
	}

	public void setSubArchiveName(String subArchiveName) {
		this.subArchiveName = subArchiveName;
	}

	public String getMnemonicCode() {
		return mnemonicCode;
	}

	public void setMnemonicCode(String mnemonicCode) {
		this.mnemonicCode = mnemonicCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getOperatingTime() {
		return operatingTime;
	}

	public void setOperatingTime(Date operatingTime) {
		this.operatingTime = operatingTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Archive getArchive() {
		return archive;
	}

	public void setArchive(Archive archive) {
		this.archive = archive;
	}

	public String getOperatingCompany() {
		return operatingCompany;
	}

	public void setOperatingCompany(String operatingCompany) {
		this.operatingCompany = operatingCompany;
	}

	public Character getMothballed() {
		return mothballed;
	}

	public void setMothballed(Character mothballed) {
		this.mothballed = mothballed;
	}

}
