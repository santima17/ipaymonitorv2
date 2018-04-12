package com.iwtg.ipaymonitor.servicelayer.system.interfaces;

import java.util.List;
import com.iwtg.ipaymonitor.datalayer.model.Ccbrand;
import com.iwtg.ipaymonitor.datalayer.model.Channel;
import com.iwtg.ipaymonitor.datalayer.model.Country;

public interface IPayMonitorSystemService {

	List<Country> getAllCountries();

	List<Ccbrand> getAllCardBrands();

	List<Channel> getAllChannels();

}
