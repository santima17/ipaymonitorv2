package com.iwtg.ipaymonitor.servicelayer.search.implementations;

import java.util.List;

import com.iwtg.ipaymonitor.bussineslayer.context.IpayMonitorBussinesContextLoader;
import com.iwtg.ipaymonitor.bussineslayer.search.interfaces.IPayMonitorSearchBO;
import com.iwtg.ipaymonitor.bussineslayer.search.implementations.IPayMonitorSearchBOImplementation;
import com.iwtg.ipaymonitor.bussineslayer.system.interfaces.IPayMonitorSystemBO;
import com.iwtg.ipaymonitor.datalayer.model.Traceability;
import com.iwtg.ipaymonitor.datalayer.model.Transaction;
import com.iwtg.ipaymonitor.generic.datatypes.DataSearchTransactionParameter;
import com.iwtg.ipaymonitor.generic.datatypes.DataTransactionSearchResult;
import com.iwtg.ipaymonitor.servicelayer.search.interfaces.IPayMonitorSearchService;


public class IPayMonitorSearchServiceImplementation implements IPayMonitorSearchService{
	
	IPayMonitorSearchBO searchBO = (IPayMonitorSearchBOImplementation) IpayMonitorBussinesContextLoader.contextLoader()
			.getBean("searchBO");

	public List<DataTransactionSearchResult> searchTransactions(final DataSearchTransactionParameter createSearchParameter) {
		return searchBO.searchTransactions(createSearchParameter);
	}

	public List<Traceability> getTransactionLog(final Integer id) {
		return searchBO.getTransactionLog(id);
	}
  
}
