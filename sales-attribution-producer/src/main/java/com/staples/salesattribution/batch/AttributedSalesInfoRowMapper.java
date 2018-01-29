package com.staples.salesattribution.batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.staples.salesattribution.dto.AttributedSalesInfo;

public class AttributedSalesInfoRowMapper implements RowMapper<AttributedSalesInfo> {

	final static Logger logger = Logger.getLogger(AttributedSalesInfoRowMapper.class);

	/**
	 * mapRow fetch the data returned by the query in variables and creates the
	 * LineItemCouponInfo and return it.
	 */
	@Override
	public AttributedSalesInfo mapRow(ResultSet rs, int rownum) throws SQLException {

		/**
		 * Fetch the data returned by the query in variables
		 */
		
		String memberNumber = rs.getString("MemberNumber");
		String tranId = rs.getString("TranId");
		String tranDate = rs.getString("TranDate");
		String orderNum = rs.getString("OrderNum");
		String tranType = rs.getString("TranType");
		String storeNum = rs.getString("StoreNum");	
		String contactID = rs.getString("ContactID");
		String dataSubInd = rs.getString("DataSubInd");
		String skuQuantity = rs.getString("SkuQuantity");
		String classNum = rs.getString("ClassNum");
		String deptNum = rs.getString("DeptNum");
		String unitPrice = rs.getString("UnitPrice");
		String unitCost = rs.getString("UnitCost");
		String skuNum = rs.getString("SkuNum");
		String subClassNum = rs.getString("SubClassNum");
		String extendedPriceAmt = rs.getString("ExtendedPriceAmt");
		String lastModDate = rs.getString("LastModDate");	
		String couponAmt = rs.getString("CouponAmt");
		String discAmt = rs.getString("DiscAmt");
		String tranLineID = rs.getString("TranLineID");
		String consumableInd = rs.getString("ConsumableInd");
		String qualifySku = rs.getString("QualifySku");
		String mop = rs.getString("Mop");
		String salesTranId = rs.getString("SalesTranId");
		String salesTranLineItemId = rs.getString("SalesTranLineItemId");
		
		/**
		 * Check for null value and trim the fetched data for spaces if value is
		 * not null. Populate AttributedSalesInfo with attribute values fetched
		 * from database
		 */

		AttributedSalesInfo attributedSalesInfo = new AttributedSalesInfo();

		attributedSalesInfo.setMemberNumber((memberNumber != null) ? memberNumber.trim() : "");
		attributedSalesInfo.setTranId((tranId != null) ? tranId.trim() : "");
		attributedSalesInfo.setTranDate((tranDate != null) ? tranDate.trim() : "");
		attributedSalesInfo.setOrderNum((orderNum != null) ? orderNum.trim() : "");
		attributedSalesInfo.setTranType((tranType != null) ? tranType.trim() : "");
		attributedSalesInfo.setStoreNum((storeNum != null) ? storeNum.trim() : "");
		attributedSalesInfo.setContactID((contactID != null) ? contactID.trim() : "");
		attributedSalesInfo.setDataSubInd((dataSubInd != null) ? dataSubInd.trim() : "");
		attributedSalesInfo.setSkuQuantity((skuQuantity != null) ? skuQuantity.trim() : "");
		attributedSalesInfo.setClassNum((classNum != null) ? classNum.trim() : "");
		attributedSalesInfo.setDeptNum((deptNum != null) ? deptNum.trim() : "");
		attributedSalesInfo.setUnitPrice((unitPrice != null) ? unitPrice.trim() : "");	
		attributedSalesInfo.setUnitCost((unitCost != null) ? unitCost.trim() : "");
		attributedSalesInfo.setSkuNum((skuNum != null) ? skuNum.trim() : "");
		attributedSalesInfo.setSubClassNum((subClassNum != null) ? subClassNum.trim() : "");
		attributedSalesInfo.setExtendedPriceAmt((extendedPriceAmt != null) ? extendedPriceAmt.trim() : "");
		attributedSalesInfo.setLastModDate((lastModDate != null) ? lastModDate.trim() : "");
		attributedSalesInfo.setCouponAmt((couponAmt != null) ? couponAmt.trim() : "");
		attributedSalesInfo.setDiscAmt((discAmt != null) ? discAmt.trim() : "");
		attributedSalesInfo.setTranLineID((tranLineID != null) ? tranLineID.trim() : "");
		attributedSalesInfo.setConsumableInd((consumableInd != null) ? consumableInd.trim() : "");
		attributedSalesInfo.setQualifySku((qualifySku != null) ? qualifySku.trim() : "");
		attributedSalesInfo.setMop((mop != null) ? mop.trim() : "");
		attributedSalesInfo.setSalesTranId((salesTranId != null) ? salesTranId.trim() : "");
		attributedSalesInfo.setSalesTranLineItemId((salesTranLineItemId != null) ? salesTranLineItemId.trim() : "");
				
		//log the data fetched from DB
		logger.debug(Thread.currentThread().getName() + "- salesTranId=" + salesTranId + ", salesTranLineItemId=" + salesTranLineItemId);
		/*
		logger.debug("memberNumber =" + memberNumber);
		logger.debug("tranId =" + tranId);
		logger.debug("tranDate =" + tranDate);
		logger.debug("orderNum =" + orderNum);
		logger.debug("tranType =" + tranType);
		logger.debug("storeNum =" + storeNum );
		logger.debug("contactID =" + contactID);
		logger.debug("dataSubInd =" + dataSubInd);
		logger.debug("skuQuantity =" + skuQuantity);
		logger.debug("classNum =" + classNum);
		logger.debug("deptNum =" + deptNum);
		logger.debug("unitPrice =" + unitPrice);
		logger.debug("unitCost =" + unitCost);
		logger.debug("skuNum =" + skuNum);
		logger.debug("subClassNum =" + subClassNum);
		logger.debug("extendedPriceAmt =" + extendedPriceAmt);
		logger.debug("lastModDate =" + lastModDate);
		logger.debug("couponAmt =" + couponAmt);
		logger.debug("discAmt =" + discAmt);
		logger.debug("tranLineID =" + tranLineID);
		logger.debug("consumableInd =" + consumableInd);
		logger.debug("qualifySku =" + qualifySku);
		logger.debug("mop =" + mop);
		logger.debug("salesTranId =" + salesTranId);
		logger.debug("salesTranLineItemId =" + salesTranLineItemId);
*/
		return attributedSalesInfo;
	}
}
