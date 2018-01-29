package com.staples.salesattribution.dto;

/**
 * 
 * @author rayni002
 * AttributedSalesInfo class is the DTO class which holds the data fetched from database
 */

public class AttributedSalesInfo {
	
	private String memberNumber;
	private String tranId;
	private String tranDate;
	private String orderNum;
	private String tranType;
	private String storeNum;	
	private String contactID;
	private String dataSubInd;
	private String skuQuantity;
	private String classNum;
	private String deptNum;
	private String unitPrice;
	private String unitCost;
	private String skuNum;
	private String subClassNum;
	private String extendedPriceAmt;
	private String lastModDate;	
	private String couponAmt;
	private String discAmt;
	private String tranLineID;
	private String consumableInd;
	private String qualifySku;
	private String mop;
	private String salesTranId;
	private String salesTranLineItemId;
	private boolean stale;
	
	public AttributedSalesInfo() {
		this.memberNumber = "";
		this.tranId = "";
		this.tranDate = "";
		this.orderNum = "";
		this.tranType = "";
		this.storeNum = "";	
		this.contactID = "";
		this.dataSubInd = "";
		this.skuQuantity = "";
		this.classNum = "";
		this.deptNum = "";
		this.unitPrice = "";
		this.unitCost = "";
		this.skuNum = "";
		this.subClassNum = "";
		this.extendedPriceAmt = "";
		this.lastModDate = "";	
		this.couponAmt = "";
		this.discAmt = "";
		this.tranLineID = "";
		this.consumableInd = "";
		this.qualifySku = "";
		this.mop = "";
		this.salesTranId = "";
		this.salesTranLineItemId = "";
		this.stale = false;
	}

	public String getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getTranId() {
		return tranId;
	}

	public void setTranId(String tranId) {
		this.tranId = tranId;
	}

	public String getTranDate() {
		return tranDate;
	}

	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public String getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(String storeNum) {
		this.storeNum = storeNum;
	}

	public String getContactID() {
		return contactID;
	}

	public void setContactID(String contactID) {
		this.contactID = contactID;
	}

	public String getDataSubInd() {
		return dataSubInd;
	}

	public void setDataSubInd(String dataSubInd) {
		this.dataSubInd = dataSubInd;
	}

	public String getSkuQuantity() {
		return skuQuantity;
	}

	public void setSkuQuantity(String skuQuantity) {
		this.skuQuantity = skuQuantity;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public String getDeptNum() {
		return deptNum;
	}

	public void setDeptNum(String deptNum) {
		this.deptNum = deptNum;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(String unitCost) {
		this.unitCost = unitCost;
	}

	public String getSkuNum() {
		return skuNum;
	}

	public void setSkuNum(String skuNum) {
		this.skuNum = skuNum;
	}

	public String getSubClassNum() {
		return subClassNum;
	}

	public void setSubClassNum(String subClassNum) {
		this.subClassNum = subClassNum;
	}

	public String getExtendedPriceAmt() {
		return extendedPriceAmt;
	}

	public void setExtendedPriceAmt(String extendedPriceAmt) {
		this.extendedPriceAmt = extendedPriceAmt;
	}

	public String getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(String lastModDate) {
		this.lastModDate = lastModDate;
	}

	public String getCouponAmt() {
		return couponAmt;
	}

	public void setCouponAmt(String couponAmt) {
		this.couponAmt = couponAmt;
	}

	public String getDiscAmt() {
		return discAmt;
	}

	public void setDiscAmt(String discAmt) {
		this.discAmt = discAmt;
	}

	public String getTranLineID() {
		return tranLineID;
	}

	public void setTranLineID(String tranLineID) {
		this.tranLineID = tranLineID;
	}

	public String getConsumableInd() {
		return consumableInd;
	}

	public void setConsumableInd(String consumableInd) {
		this.consumableInd = consumableInd;
	}

	public String getQualifySku() {
		return qualifySku;
	}

	public void setQualifySku(String qualifySku) {
		this.qualifySku = qualifySku;
	}

	public String getMop() {
		return mop;
	}

	public void setMop(String mop) {
		this.mop = mop;
	}

	public String getSalesTranId() {
		return salesTranId;
	}

	public void setSalesTranId(String salesTranId) {
		this.salesTranId = salesTranId;
	}

	public String getSalesTranLineItemId() {
		return salesTranLineItemId;
	}

	public void setSalesTranLineItemId(String salesTranLineItemId) {
		this.salesTranLineItemId = salesTranLineItemId;
	}

	public boolean isStale() {
		return stale;
	}

	public void setStale(boolean stale) {
		this.stale = stale;
	}

	@Override
	public String toString() {
		return "AttributedSalesInfo [memberNumber=" + memberNumber + ", tranId=" + tranId + ", tranDate=" + tranDate
				+ ", orderNum=" + orderNum + ", tranType=" + tranType + ", storeNum=" + storeNum + ", contactID="
				+ contactID + ", dataSubInd=" + dataSubInd + ", skuQuantity=" + skuQuantity + ", classNum=" + classNum
				+ ", deptNum=" + deptNum + ", unitPrice=" + unitPrice + ", unitCost=" + unitCost + ", skuNum=" + skuNum
				+ ", subClassNum=" + subClassNum + ", extendedPriceAmt=" + extendedPriceAmt + ", lastModDate="
				+ lastModDate + ", couponAmt=" + couponAmt + ", discAmt=" + discAmt + ", tranLineID=" + tranLineID
				+ ", consumableInd=" + consumableInd + ", qualifySku=" + qualifySku + ", mop=" + mop + ", salesTranId="
				+ salesTranId + ", salesTranLineItemId=" + salesTranLineItemId + ", stale=" + stale + "]";
	}

			
}