package com.insurance.model;
import java.sql.Date;
public class Vehicleinsurance {

	public Vehicleinsurance(String underwriterid, String policyNo, String vehicleNo, String vehicleType, String customerName,
			int engineNo, int chassisNo, long phoneNo, String type, int premiumAmt, Date fromDate, Date toDate) {
		this.underwriterid = underwriterid;
		this.policyNo = policyNo;
		this.vehicleNo = vehicleNo;
		this.vehicleType = vehicleType;
		this.customerName = customerName;
		this.engineNo = engineNo;
		this.chassisNo = chassisNo;
		this.phoneNo = phoneNo;
		this.type = type;
		this.premiumAmt = premiumAmt;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public Vehicleinsurance() {
		// TODO Auto-generated constructor stub
	}
	private String underwriterid;
	private String policyNo;
    private String vehicleNo;
    private String vehicleType;
    private String customerName;
    private int engineNo;
    private int chassisNo;
    private long phoneNo;
    private String type;
    private int premiumAmt;
    private Date fromDate;
    private Date toDate;
	
	public String getUnderwriterid() {
		return underwriterid;
	}
	public void setUnderwriterid(String underwriterid) {
		this.underwriterid = underwriterid;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(int engineNo) {
		this.engineNo = engineNo;
	}
	public int getChassisNo() {
		return chassisNo;
	}
	public void setChassisNo(int chassisNo) {
		this.chassisNo = chassisNo;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPremiumAmt() {
		return premiumAmt;
	}
	public void setPremiumAmt(int premiumAmt) {
		this.premiumAmt = premiumAmt;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	
}


