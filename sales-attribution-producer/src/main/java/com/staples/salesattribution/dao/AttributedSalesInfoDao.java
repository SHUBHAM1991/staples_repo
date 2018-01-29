package com.staples.salesattribution.dao;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.staples.salesattribution.dto.AttributedSalesInfo;
import com.staples.salesattribution.model.SalesTranDetailModel;
import com.staples.salesattribution.model.SalesTranDetailPK;

@Repository("attributedSalesInfoDao")
@Transactional(propagation = Propagation.REQUIRED)
public class AttributedSalesInfoDao {

	final static Logger logger = Logger.getLogger(AttributedSalesInfoDao.class);
	private final static int flushSize = 25;
	private final static Gson gson = new Gson();

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public synchronized void updateSalesTranDetRewardSentIndicator(final Set<String> listForIndUpdate) {

		try {
			int ctr = 0;

			if (!listForIndUpdate.isEmpty()) {
				for (String attributedSalesInfoJson : listForIndUpdate) {

					AttributedSalesInfo attributedSalesInfo = gson.fromJson(attributedSalesInfoJson,
							AttributedSalesInfo.class);
					logger.debug(Thread.currentThread().getName() + "::JSON in DAO :: " + attributedSalesInfoJson);
					//synchronized (attributedSalesInfo) {
						Long salesTranId = Long.valueOf(attributedSalesInfo.getSalesTranId());
						Long salesTranLineItemId = Long.valueOf(attributedSalesInfo.getSalesTranLineItemId());
						logger.info(Thread.currentThread().getName() + "<-->" + entityManager.toString()
								+ "::updating salesTranId=" + salesTranId + " & salesTranLineItemId="
								+ salesTranLineItemId);
						SalesTranDetailPK salesTranDetPK = new SalesTranDetailPK(salesTranId, salesTranLineItemId);

						SalesTranDetailModel objSalesTranDet = entityManager.find(SalesTranDetailModel.class,
								salesTranDetPK);
						objSalesTranDet.setRewardDataSentInd("Y");

						/*
						 * if (!entityManager.contains(objSalesTranDet)) {
						 * logger.debug(Thread.currentThread().getName() +
						 * "::Updating SalesTranDetModel:: " +
						 * objSalesTranDet.toString());
						 * entityManager.merge(objSalesTranDet); }
						 */

						if (++ctr % flushSize == 0) {
							entityManager.flush();
						}
					//} // end of synchronized
				} // end of for
			} // end of if
		} finally {
			if (null != entityManager) {
				if (listForIndUpdate.size() % flushSize != 0) {
					entityManager.flush();
				} // end of exact list size check
				entityManager.clear();

				if (entityManager.isOpen()) {
					entityManager.close();
				} // end of isOpen check
			} // end of null check

		}

	}
}
