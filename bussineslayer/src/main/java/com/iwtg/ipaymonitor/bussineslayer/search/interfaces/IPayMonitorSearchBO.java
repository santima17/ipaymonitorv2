package com.iwtg.ipaymonitor.bussineslayer.search.interfaces;

import java.util.List;

import com.iwtg.ipaymonitor.datalayer.model.Traceability;
import com.iwtg.ipaymonitor.generic.datatypes.DataSearchTransactionParameter;
import com.iwtg.ipaymonitor.generic.datatypes.DataTransactionSearchResult;

public interface IPayMonitorSearchBO {

	List<DataTransactionSearchResult> searchTransactions(final DataSearchTransactionParameter createSearchParameter);

	List<Traceability> getTransactionLog(final Integer id);

}
