package com.iwtg.ipaymonitor.servicelayer.system.implementations;

import java.util.List;

import com.iwtg.ipaymonitor.bussineslayer.context.IpayMonitorBussinesContextLoader;
import com.iwtg.ipaymonitor.bussineslayer.system.interfaces.IPayMonitorSystemBO;
import com.iwtg.ipaymonitor.bussineslayer.system.implementations.IPayMonitorSystemBOImplementation;
import com.iwtg.ipaymonitor.datalayer.model.Ccbrand;
import com.iwtg.ipaymonitor.datalayer.model.Channel;
import com.iwtg.ipaymonitor.datalayer.model.Country;
import com.iwtg.ipaymonitor.servicelayer.system.interfaces.IPayMonitorSystemService;

public class IPayMonitorSystemServiceImplementation implements IPayMonitorSystemService{
	
	IPayMonitorSystemBO systemBO = (IPayMonitorSystemBOImplementation) IpayMonitorBussinesContextLoader.contextLoader()
			.getBean("systemBO");

	public List<Country> getAllCountries() {
		return systemBO.getAllCountries();
	}

	public List<Ccbrand> getAllCardBrands() {
		return systemBO.getAllCardBrands();
	}

	public List<Channel> getAllChannels() {
		return systemBO.getAllChannels();
	}

}
