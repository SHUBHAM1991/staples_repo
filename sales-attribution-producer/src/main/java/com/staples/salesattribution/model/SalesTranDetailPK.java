package com.staples.salesattribution.model;

import java.io.Serializable;
/**
 * @author rayni002
 *This class contains the keys which are used 
 *as composite key in the application.
 */
public class SalesTranDetailPK implements Serializable {

	private static final long serialVersionUID = -2445275520087170628L;
	
	private Long salesTranId;
	private Long salesTranLineItemId;	
	
	
	public SalesTranDetailPK() {
		super();
	}

	public SalesTranDetailPK(Long salesTranId, Long salesTranLineItemId) {
		super();
		this.salesTranId = salesTranId;
		this.salesTranLineItemId = salesTranLineItemId;		
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((salesTranId == null) ? 0 : salesTranId.hashCode());
		result = prime * result + ((salesTranLineItemId == null) ? 0 : salesTranLineItemId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesTranDetailPK other = (SalesTranDetailPK) obj;
		if (salesTranId == null) {
			if (other.salesTranId != null)
				return false;
		} else if (!salesTranId.equals(other.salesTranId))
			return false;
		if (salesTranLineItemId == null) {
			if (other.salesTranLineItemId != null)
				return false;
		} else if (!salesTranLineItemId.equals(other.salesTranLineItemId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SalesTranDetailPK [salesTranId=" + salesTranId + ", salesTranLineItemId=" + salesTranLineItemId + "]";
	}
	
}
