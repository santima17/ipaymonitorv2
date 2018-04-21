package com.iwtg.ipaymonitor.facades.search.implementations;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.iwtg.ipaymonitor.datalayer.model.Traceability;
import com.iwtg.ipaymonitor.datalayer.model.Transaction;
import com.iwtg.ipaymonitor.facades.datatypes.search.DataSearchTransaction;
import com.iwtg.ipaymonitor.facades.datatypes.search.DataTransactionLog;
import com.iwtg.ipaymonitor.facades.exceptions.IPayMonitorException;
import com.iwtg.ipaymonitor.facades.search.interfaces.IPayMonitorSearchFacades;
import com.iwtg.ipaymonitor.generic.datatypes.DataSearchTransactionParameter;
import com.iwtg.ipaymonitor.generic.datatypes.DataTransactionSearchResult;
import com.iwtg.ipaymonitor.servicelayer.context.IpayMonitorServicesContextLoader;
import com.iwtg.ipaymonitor.servicelayer.search.interfaces.IPayMonitorSearchService;
import com.iwtg.ipaymonitor.servicelayer.search.implementations.IPayMonitorSearchServiceImplementation;

public class IPayMonitorSearchFacadesImplementation implements IPayMonitorSearchFacades {

	private static final String SEARCH_ERROR = "Errror during the search, please try again or contact support team";

	IPayMonitorSearchService searchServices = (IPayMonitorSearchServiceImplementation) IpayMonitorServicesContextLoader
			.contextLoader().getBean("searchServices");

	public List<DataTransactionSearchResult> searchTransactions(
			final DataSearchTransaction dataSearchTransactionParameter) throws IPayMonitorException {
		try {
			return searchServices.searchTransactions(createSearchParameter(dataSearchTransactionParameter));
		} catch (Exception e) {
			throw new IPayMonitorException(SEARCH_ERROR);
		}
	}

	public List<DataTransactionLog> getTransactionLog(Integer id) throws IPayMonitorException {
		try {
			List<Traceability> logHistory = searchServices.getTransactionLog(id);
			return convertLogHistory(logHistory);
		} catch (Exception e) {
			throw new IPayMonitorException(SEARCH_ERROR);
		}
	}

	private DataSearchTransactionParameter createSearchParameter(final DataSearchTransaction dataSearchTransaction) {
		DataSearchTransactionParameter param = new DataSearchTransactionParameter();
		param.setBank(dataSearchTransaction.getBank());
		param.setCardBrand(dataSearchTransaction.getCardBrand());
		param.setChannel(dataSearchTransaction.getChannel());
		param.setCountry(dataSearchTransaction.getCountry());
		param.setCurrency(dataSearchTransaction.getCurrency());
		param.setDateFrom(dataSearchTransaction.getDateFrom());
		param.setDateTo(dataSearchTransaction.getDateTo());
		param.setDocument(dataSearchTransaction.getDocument());
		param.setStatus(dataSearchTransaction.getStatus());
		param.setTransactionID(dataSearchTransaction.getTransactionID());
		param.setAcquirerID(dataSearchTransaction.getAcquirerID());
		return param;
	}

	private List<DataTransactionLog> convertLogHistory(List<Traceability> logHistory) {
		List<DataTransactionLog> resultList = new ArrayList<DataTransactionLog>();
		if (CollectionUtils.isNotEmpty(logHistory)) {
			for (Traceability t : logHistory) {
				DataTransactionLog dataTransactionLog = new DataTransactionLog();
				dataTransactionLog.setDate(t.getDate());
				dataTransactionLog.setId(t.getId());
				dataTransactionLog.setProcessStepCode(t.getProcessStepCode());
				dataTransactionLog.setReservationNumber(t.getReservationNumber());
				dataTransactionLog.setTransactionStatusCode(t.getTransactionStatusCode());
				resultList.add(dataTransactionLog);
			}
		}
		return resultList;
	}

}
