package com.staples.salesattribution.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
/**
 * @author rayni002
 * This model class used for the 
 * updation of indicator in DB.
 */
@Entity
@IdClass(SalesTranDetailPK.class)
@Table(name = "SALESTRANDETAIL", schema="CEX01_OWN")
public class SalesTranDetailModel implements Serializable {

	private static final long serialVersionUID = -1436953055147927672L;
	
	@Id
	@Column(name = "SALESTRANID", columnDefinition = "NUMBER")
	private Long salesTranId;
	
	@Id
	@Column(name = "SALESTRANLINEITEMID", columnDefinition = "NUMBER")
	private Long salesTranLineItemId;
	
	@Transient
	@Column(name = "PRODUCTID", columnDefinition = "NUMBER")
	private Long productId;
	
	@Transient
	@Column(name = "TRANQUANTITY", columnDefinition = "NUMBER")
	private Integer tranQty;
	
	@Transient
	@Column(name = "UNITPRICE", columnDefinition = "NUMBER(18,2)")
	private Double unitPrice;
	
	@Transient
	@Temporal(TemporalType.DATE)
	@Column(name = "SOURCEINSERTDATE")
	private Date srcInsertDate;
	
	@Transient
	@Column(name = "SOURCESYSTEMID", columnDefinition = "NUMBER")
	private Long srcSystemId;
	
	@Transient
	@Temporal(TemporalType.DATE)
	@Column(name = "SOURCEUPDATEDATE")
	private Date srcUpdateDate;
	
	@Transient
	@Column(name = "SOURCESYSTEMTABLE", columnDefinition = "VARCHAR2(50)")
	private String srcSystemTable;
	
	@Transient
	@Column(name = "SOURCENUMBER", columnDefinition = "VARCHAR2(50)")
	private String srcNumber;
	
	@Transient
	@Temporal(TemporalType.DATE)
	@Column(name = "INSERTDATE")
	private Date insertDate;
	
	@Transient
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATEDATE")
	private Date updateDate;
	
	@Transient
	@Column(name = "SOURCEHEADERKEY", columnDefinition = "VARCHAR2(100)")
	private String srcHeaderKey;
	
	@Transient
	@Column(name = "SOURCEDETAILKEY", columnDefinition = "VARCHAR2(100)")
	private String srcDetailKey;
	
	@Transient
	@Column(name = "SOURCEINSERTUSERID", columnDefinition = "VARCHAR2(50)")
	private String srcInsertUserId;
	
	@Transient
	@Column(name = "SOURCEUPDATEUSERID", columnDefinition = "VARCHAR2(50)")
	private String srcUpdateUserId;
	
	@Transient
	@Column(name = "PRODUCTQUALIFYID", columnDefinition = "NUMBER")
	private Long productQualifyId;
	
	@Transient
	@Column(name = "PRODUCTCLASSNUMBER", columnDefinition = "VARCHAR2(50)")
	private String productClassNum;
	
	@Transient
	@Column(name = "PRODUCTDEPTNUMBER", columnDefinition = "VARCHAR2(50)")
	private String productDeptNum;
	
	@Transient
	@Column(name = "UNITCOST", columnDefinition = "NUMBER(19,6)")
	private Long unitCost;
	
	@Transient
	@Column(name = "PRODUCTSKU", columnDefinition = "VARCHAR2(50)")
	private String productSku;
	
	@Transient
	@Column(name = "PRODUCTSUBCLASSNUMBER", columnDefinition = "VARCHAR2(50)")
	private String productSubClassNum;
	
	@Transient
	@Column(name = "EXTENDEDPRICE", columnDefinition = "NUMBER(19,6)")
	private Long extendedPrice;
	
	@Transient
	@Temporal(TemporalType.DATE)
	@Column(name = "TRANDATE")
	private Date tranDate;
	
	@Transient
	@Column(name = "MANUFACTURERNAME", columnDefinition = "VARCHAR2(50)")
	private String manufacturerName;
	
	@Transient
	@Column(name = "VENDORNAME", columnDefinition = "VARCHAR2(50)")
	private String vendorName;
	
	@Transient
	@Column(name = "VENDORSKU", columnDefinition = "VARCHAR2(50)")
	private String vendorSku;
	
	@Transient
	@Column(name = "LINETOTALAMOUNT", columnDefinition = "NUMBER(19,6)")
	private Long lineTotAmt;

	@Transient
	@Column(name = "INVOICELINETOTALAMOUNT", columnDefinition = "NUMBER(19,6)")
	private Long invoiceLineTotAmt;

	@Transient
	@Column(name = "TAXABLEIND", columnDefinition = "VARCHAR2(1)")
	private String taxableInd;

	@Transient
	@Column(name = "PRODUCTNAME", columnDefinition = "VARCHAR2(200)")
	private String productName;

	@Transient
	@Column(name = "PRODUCTDESCRIPTION", columnDefinition = "VARCHAR2(500)")
	private String productDesc;

	@Transient
	@Column(name = "UNITOFMEASURE", columnDefinition = "VARCHAR2(10)")
	private String unitOfMeasure;

	@Transient
	@Column(name = "COSTCURRENCY", columnDefinition = "VARCHAR2(10)")
	private String costCurrency;

	@Transient
	@Column(name = "INVOICEQUANTITY", columnDefinition = "NUMBER(19,6)")
	private Long invoiceQty;

	@Transient
	@Column(name = "TRANLINESTATUSID", columnDefinition = "VARCHAR2(50)")
	private String tranLineStatusId;

	@Transient
	@Column(name = "TRANLINESTATUSDESCRIPTION", columnDefinition = "VARCHAR2(200)")
	private String tranLineStatusDesc;

	@Transient
	@Column(name = "PRODUCTDIVISIONNUMBER", columnDefinition = "NUMBER")
	private Long productDivisionNum;

	@Transient
	@Column(name = "PRODUCTDIVISIONDESCRIPTION", columnDefinition = "VARCHAR2(50)")
	private String productVisionDesc;

	@Transient
	@Temporal(TemporalType.DATE)
	@Column(name = "INVOICEFINANCIALGLDATE")
	private Date invoiceFinancialDate;

	@Transient
	@Temporal(TemporalType.DATE)
	@Column(name = "INVOICECASHPOSTINGDATE", columnDefinition = "DATE")
	private Date invoiceCashPostingDate;

	@Transient
	@Column(name = "SALESATTRIBUTIONIND", columnDefinition = "VARCHAR2(1)")
	private String salesAttributionInd;

	@Transient
	@Column(name = "REWARDAPPLIEDIND", columnDefinition = "VARCHAR2(1)")
	private String rewardAppliedInd;

	@Column(name = "REWARDDATASENTIND", columnDefinition = "VARCHAR2(1)")
	private String rewardDataSentInd;

	@Transient
	@Column(name = "TRANTAXEXEMPTNUMBER", columnDefinition = "VARCHAR2(50)")
	private String tranTaxExemptNum;

	@Transient
	@Column(name = "MASTERSALESTRANDETAILID", columnDefinition = "NUMBER")
	private Long masterSalesTranDetailId;

	@Transient
	@Column(name = "MASTERSALESTRANID", columnDefinition = "NUMBER")
	private Long masterSalestTranId;

	@Transient
	@Column(name = "MASTERTRANLINENUMBER", columnDefinition = "VARCHAR2(50)")
	private String masterTranLineNum;

	@Transient
	@Column(name = "MASTERTRANNUMBER", columnDefinition = "VARCHAR2(50)")
	private String masterTranNumber;

	@Transient
	@Column(name = "ORIGINALORDERQUANTITY", columnDefinition = "NUMBER(5,0)")
	private Double origOrderQty;

	@Transient
	@Column(name = "PNIIMAGE", columnDefinition = "VARCHAR2(300)")
	private String pniImage;

	@Transient
	@Column(name = "PNIJOBID", columnDefinition = "VARCHAR2(200)")
	private String pniJobId;

	@Transient
	@Column(name = "RESHIPLINETYPE", columnDefinition = "VARCHAR2(20)")
	private String reshipLineType;

	@Transient
	@Column(name = "TRANLINETOTALAMOUNT", columnDefinition = "NUMBER(19,6)")
	private Long tranLineTotAmt;

	@Transient
	@Column(name = "TRANLINETYPE", columnDefinition = "VARCHAR2(50)")
	private String tranLineType;

	@Transient
	@Column(name = "TRANLINENUMBER", columnDefinition = "NUMBER(3,0)")
	private Integer tranLineNum;

	public Long getSalesTranId() {
		return salesTranId;
	}

	public void setSalesTranId(Long salesTranId) {
		this.salesTranId = salesTranId;
	}

	public Long getSalesTranLineItemId() {
		return salesTranLineItemId;
	}

	public void setSalesTranLineItemId(Long salesTranLineItemId) {
		this.salesTranLineItemId = salesTranLineItemId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getTranQty() {
		return tranQty;
	}

	public void setTranQty(Integer tranQty) {
		this.tranQty = tranQty;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Date getSrcInsertDate() {
		return srcInsertDate;
	}

	public void setSrcInsertDate(Date srcInsertDate) {
		this.srcInsertDate = srcInsertDate;
	}

	public Long getSrcSystemId() {
		return srcSystemId;
	}

	public void setSrcSystemId(Long srcSystemId) {
		this.srcSystemId = srcSystemId;
	}

	public Date getSrcUpdateDate() {
		return srcUpdateDate;
	}

	public void setSrcUpdateDate(Date srcUpdateDate) {
		this.srcUpdateDate = srcUpdateDate;
	}

	public String getSrcSystemTable() {
		return srcSystemTable;
	}

	public void setSrcSystemTable(String srcSystemTable) {
		this.srcSystemTable = srcSystemTable;
	}

	public String getSrcNumber() {
		return srcNumber;
	}

	public void setSrcNumber(String srcNumber) {
		this.srcNumber = srcNumber;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getSrcHeaderKey() {
		return srcHeaderKey;
	}

	public void setSrcHeaderKey(String srcHeaderKey) {
		this.srcHeaderKey = srcHeaderKey;
	}

	public String getSrcDetailKey() {
		return srcDetailKey;
	}

	public void setSrcDetailKey(String srcDetailKey) {
		this.srcDetailKey = srcDetailKey;
	}

	public String getSrcInsertUserId() {
		return srcInsertUserId;
	}

	public void setSrcInsertUserId(String srcInsertUserId) {
		this.srcInsertUserId = srcInsertUserId;
	}

	public String getSrcUpdateUserId() {
		return srcUpdateUserId;
	}

	public void setSrcUpdateUserId(String srcUpdateUserId) {
		this.srcUpdateUserId = srcUpdateUserId;
	}

	public Long getProductQualifyId() {
		return productQualifyId;
	}

	public void setProductQualifyId(Long productQualifyId) {
		this.productQualifyId = productQualifyId;
	}

	public String getProductClassNum() {
		return productClassNum;
	}

	public void setProductClassNum(String productClassNum) {
		this.productClassNum = productClassNum;
	}

	public String getProductDeptNum() {
		return productDeptNum;
	}

	public void setProductDeptNum(String productDeptNum) {
		this.productDeptNum = productDeptNum;
	}

	public Long getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Long unitCost) {
		this.unitCost = unitCost;
	}

	public String getProductSku() {
		return productSku;
	}

	public void setProductSku(String productSku) {
		this.productSku = productSku;
	}

	public String getProductSubClassNum() {
		return productSubClassNum;
	}

	public void setProductSubClassNum(String productSubClassNum) {
		this.productSubClassNum = productSubClassNum;
	}

	public Long getExtendedPrice() {
		return extendedPrice;
	}

	public void setExtendedPrice(Long extendedPrice) {
		this.extendedPrice = extendedPrice;
	}

	public Date getTranDate() {
		return tranDate;
	}

	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorSku() {
		return vendorSku;
	}

	public void setVendorSku(String vendorSku) {
		this.vendorSku = vendorSku;
	}

	public Long getLineTotAmt() {
		return lineTotAmt;
	}

	public void setLineTotAmt(Long lineTotAmt) {
		this.lineTotAmt = lineTotAmt;
	}

	public Long getInvoiceLineTotAmt() {
		return invoiceLineTotAmt;
	}

	public void setInvoiceLineTotAmt(Long invoiceLineTotAmt) {
		this.invoiceLineTotAmt = invoiceLineTotAmt;
	}

	public String getTaxableInd() {
		return taxableInd;
	}

	public void setTaxableInd(String taxableInd) {
		this.taxableInd = taxableInd;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public String getCostCurrency() {
		return costCurrency;
	}

	public void setCostCurrency(String costCurrency) {
		this.costCurrency = costCurrency;
	}

	public Long getInvoiceQty() {
		return invoiceQty;
	}

	public void setInvoiceQty(Long invoiceQty) {
		this.invoiceQty = invoiceQty;
	}

	public String getTranLineStatusId() {
		return tranLineStatusId;
	}

	public void setTranLineStatusId(String tranLineStatusId) {
		this.tranLineStatusId = tranLineStatusId;
	}

	public String getTranLineStatusDesc() {
		return tranLineStatusDesc;
	}

	public void setTranLineStatusDesc(String tranLineStatusDesc) {
		this.tranLineStatusDesc = tranLineStatusDesc;
	}

	public Long getProductDivisionNum() {
		return productDivisionNum;
	}

	public void setProductDivisionNum(Long productDivisionNum) {
		this.productDivisionNum = productDivisionNum;
	}

	public String getProductVisionDesc() {
		return productVisionDesc;
	}

	public void setProductVisionDesc(String productVisionDesc) {
		this.productVisionDesc = productVisionDesc;
	}

	public Date getInvoiceFinancialDate() {
		return invoiceFinancialDate;
	}

	public void setInvoiceFinancialDate(Date invoiceFinancialDate) {
		this.invoiceFinancialDate = invoiceFinancialDate;
	}

	public Date getInvoiceCashPostingDate() {
		return invoiceCashPostingDate;
	}

	public void setInvoiceCashPostingDate(Date invoiceCashPostingDate) {
		this.invoiceCashPostingDate = invoiceCashPostingDate;
	}

	public String getSalesAttributionInd() {
		return salesAttributionInd;
	}

	public void setSalesAttributionInd(String salesAttributionInd) {
		this.salesAttributionInd = salesAttributionInd;
	}

	public String getRewardAppliedInd() {
		return rewardAppliedInd;
	}

	public void setRewardAppliedInd(String rewardAppliedInd) {
		this.rewardAppliedInd = rewardAppliedInd;
	}

	public String getRewardDataSentInd() {
		return rewardDataSentInd;
	}

	public void setRewardDataSentInd(String rewardDataSentInd) {
		this.rewardDataSentInd = rewardDataSentInd;
	}

	public String getTranTaxExemptNum() {
		return tranTaxExemptNum;
	}

	public void setTranTaxExemptNum(String tranTaxExemptNum) {
		this.tranTaxExemptNum = tranTaxExemptNum;
	}

	public Long getMasterSalesTranDetailId() {
		return masterSalesTranDetailId;
	}

	public void setMasterSalesTranDetailId(Long masterSalesTranDetailId) {
		this.masterSalesTranDetailId = masterSalesTranDetailId;
	}

	public Long getMasterSalestTranId() {
		return masterSalestTranId;
	}

	public void setMasterSalestTranId(Long masterSalestTranId) {
		this.masterSalestTranId = masterSalestTranId;
	}

	public String getMasterTranLineNum() {
		return masterTranLineNum;
	}

	public void setMasterTranLineNum(String masterTranLineNum) {
		this.masterTranLineNum = masterTranLineNum;
	}

	public String getMasterTranNumber() {
		return masterTranNumber;
	}

	public void setMasterTranNumber(String masterTranNumber) {
		this.masterTranNumber = masterTranNumber;
	}

	public Double getOrigOrderQty() {
		return origOrderQty;
	}

	public void setOrigOrderQty(Double origOrderQty) {
		this.origOrderQty = origOrderQty;
	}

	public String getPniImage() {
		return pniImage;
	}

	public void setPniImage(String pniImage) {
		this.pniImage = pniImage;
	}

	public String getPniJobId() {
		return pniJobId;
	}

	public void setPniJobId(String pniJobId) {
		this.pniJobId = pniJobId;
	}

	public String getReshipLineType() {
		return reshipLineType;
	}

	public void setReshipLineType(String reshipLineType) {
		this.reshipLineType = reshipLineType;
	}

	public Long getTranLineTotAmt() {
		return tranLineTotAmt;
	}

	public void setTranLineTotAmt(Long tranLineTotAmt) {
		this.tranLineTotAmt = tranLineTotAmt;
	}

	public String getTranLineType() {
		return tranLineType;
	}

	public void setTranLineType(String tranLineType) {
		this.tranLineType = tranLineType;
	}

	public Integer getTranLineNum() {
		return tranLineNum;
	}

	public void setTranLineNum(Integer tranLineNum) {
		this.tranLineNum = tranLineNum;
	}

	@Override
	public String toString() {
		return "SalesTranDetailModel [salesTranId=" + salesTranId + ", salesTranLineItemId=" + salesTranLineItemId
				+ ", productId=" + productId + ", tranQty=" + tranQty + ", unitPrice=" + unitPrice + ", srcInsertDate="
				+ srcInsertDate + ", srcSystemId=" + srcSystemId + ", srcUpdateDate=" + srcUpdateDate
				+ ", srcSystemTable=" + srcSystemTable + ", srcNumber=" + srcNumber + ", insertDate=" + insertDate
				+ ", updateDate=" + updateDate + ", srcHeaderKey=" + srcHeaderKey + ", srcDetailKey=" + srcDetailKey
				+ ", srcInsertUserId=" + srcInsertUserId + ", srcUpdateUserId=" + srcUpdateUserId
				+ ", productQualifyId=" + productQualifyId + ", productClassNum=" + productClassNum
				+ ", productDeptNum=" + productDeptNum + ", unitCost=" + unitCost + ", productSku=" + productSku
				+ ", productSubClassNum=" + productSubClassNum + ", extendedPrice=" + extendedPrice + ", tranDate="
				+ tranDate + ", manufacturerName=" + manufacturerName + ", vendorName=" + vendorName + ", vendorSku="
				+ vendorSku + ", lineTotAmt=" + lineTotAmt + ", invoiceLineTotAmt=" + invoiceLineTotAmt
				+ ", taxableInd=" + taxableInd + ", productName=" + productName + ", productDesc=" + productDesc
				+ ", unitOfMeasure=" + unitOfMeasure + ", costCurrency=" + costCurrency + ", invoiceQty=" + invoiceQty
				+ ", tranLineStatusId=" + tranLineStatusId + ", tranLineStatusDesc=" + tranLineStatusDesc
				+ ", productDivisionNum=" + productDivisionNum + ", productVisionDesc=" + productVisionDesc
				+ ", invoiceFinancialDate=" + invoiceFinancialDate + ", invoiceCashPostingDate="
				+ invoiceCashPostingDate + ", salesAttributionInd=" + salesAttributionInd + ", rewardAppliedInd="
				+ rewardAppliedInd + ", rewardDataSentInd=" + rewardDataSentInd + ", tranTaxExemptNum="
				+ tranTaxExemptNum + ", masterSalesTranDetailId=" + masterSalesTranDetailId + ", masterSalestTranId="
				+ masterSalestTranId + ", masterTranLineNum=" + masterTranLineNum + ", masterTranNumber="
				+ masterTranNumber + ", origOrderQty=" + origOrderQty + ", pniImage=" + pniImage + ", pniJobId="
				+ pniJobId + ", reshipLineType=" + reshipLineType + ", tranLineTotAmt=" + tranLineTotAmt
				+ ", tranLineType=" + tranLineType + ", tranLineNum=" + tranLineNum + ", getSalesTranId()="
				+ getSalesTranId() + ", getSalesTranLineItemId()=" + getSalesTranLineItemId() + ", getProductId()="
				+ getProductId() + ", getTranQty()=" + getTranQty() + ", getUnitPrice()=" + getUnitPrice()
				+ ", getSrcInsertDate()=" + getSrcInsertDate() + ", getSrcSystemId()=" + getSrcSystemId()
				+ ", getSrcUpdateDate()=" + getSrcUpdateDate() + ", getSrcSystemTable()=" + getSrcSystemTable()
				+ ", getSrcNumber()=" + getSrcNumber() + ", getInsertDate()=" + getInsertDate() + ", getUpdateDate()="
				+ getUpdateDate() + ", getSrcHeaderKey()=" + getSrcHeaderKey() + ", getSrcDetailKey()="
				+ getSrcDetailKey() + ", getSrcInsertUserId()=" + getSrcInsertUserId() + ", getSrcUpdateUserId()="
				+ getSrcUpdateUserId() + ", getProductQualifyId()=" + getProductQualifyId() + ", getProductClassNum()="
				+ getProductClassNum() + ", getProductDeptNum()=" + getProductDeptNum() + ", getUnitCost()="
				+ getUnitCost() + ", getProductSku()=" + getProductSku() + ", getProductSubClassNum()="
				+ getProductSubClassNum() + ", getExtendedPrice()=" + getExtendedPrice() + ", getTranDate()="
				+ getTranDate() + ", getManufacturerName()=" + getManufacturerName() + ", getVendorName()="
				+ getVendorName() + ", getVendorSku()=" + getVendorSku() + ", getLineTotAmt()=" + getLineTotAmt()
				+ ", getInvoiceLineTotAmt()=" + getInvoiceLineTotAmt() + ", getTaxableInd()=" + getTaxableInd()
				+ ", getProductName()=" + getProductName() + ", getProductDesc()=" + getProductDesc()
				+ ", getUnitOfMeasure()=" + getUnitOfMeasure() + ", getCostCurrency()=" + getCostCurrency()
				+ ", getInvoiceQty()=" + getInvoiceQty() + ", getTranLineStatusId()=" + getTranLineStatusId()
				+ ", getTranLineStatusDesc()=" + getTranLineStatusDesc() + ", getProductDivisionNum()="
				+ getProductDivisionNum() + ", getProductVisionDesc()=" + getProductVisionDesc()
				+ ", getInvoiceFinancialDate()=" + getInvoiceFinancialDate() + ", getInvoiceCashPostingDate()="
				+ getInvoiceCashPostingDate() + ", getSalesAttributionInd()=" + getSalesAttributionInd()
				+ ", getRewardAppliedInd()=" + getRewardAppliedInd() + ", getRewardDataSentInd()="
				+ getRewardDataSentInd() + ", getTranTaxExemptNum()=" + getTranTaxExemptNum()
				+ ", getMasterSalesTranDetailId()=" + getMasterSalesTranDetailId() + ", getMasterSalestTranId()="
				+ getMasterSalestTranId() + ", getMasterTranLineNum()=" + getMasterTranLineNum()
				+ ", getMasterTranNumber()=" + getMasterTranNumber() + ", getOrigOrderQty()=" + getOrigOrderQty()
				+ ", getPniImage()=" + getPniImage() + ", getPniJobId()=" + getPniJobId() + ", getReshipLineType()="
				+ getReshipLineType() + ", getTranLineTotAmt()=" + getTranLineTotAmt() + ", getTranLineType()="
				+ getTranLineType() + ", getTranLineNum()=" + getTranLineNum() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
