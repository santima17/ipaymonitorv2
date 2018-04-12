package com.iwtg.ipaymonitor.bussineslayer.system.implementations;

import java.util.List;

import com.iwtg.ipaymonitor.bussineslayer.system.interfaces.IPayMonitorSystemBO;
import com.iwtg.ipaymonitor.datalayer.context.IpayMonitorDAOContextLoader;
import com.iwtg.ipaymonitor.datalayer.implementations.IPayMonitorMySQLDAOImplementation;
import com.iwtg.ipaymonitor.datalayer.interfaces.IPayMonitorMySQLDAO;
import com.iwtg.ipaymonitor.datalayer.model.Ccbrand;
import com.iwtg.ipaymonitor.datalayer.model.Channel;
import com.iwtg.ipaymonitor.datalayer.model.Country;

public class IPayMonitorSystemBOImplementation implements IPayMonitorSystemBO{
	
	IPayMonitorMySQLDAO daoServices = (IPayMonitorMySQLDAOImplementation) IpayMonitorDAOContextLoader.contextLoader()
			.getBean("daoServices");

	public List<Country> getAllCountries() {
		return daoServices.getAll(Country.class);
	}

	public List<Ccbrand> getAllCardBrands() {
		return daoServices.getAll(Ccbrand.class);
	}

	public List<Channel> getAllChannels() {
		return daoServices.getAll(Channel.class);
	}

}
