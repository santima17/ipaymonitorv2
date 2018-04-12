package com.iwtg.ipaymonitor.facades.converters.system;

import java.util.ArrayList;
import java.util.List;


import com.iwtg.ipaymonitor.datalayer.model.Ccbrand;
import com.iwtg.ipaymonitor.datalayer.model.Channel;
import com.iwtg.ipaymonitor.datalayer.model.Country;
import com.iwtg.ipaymonitor.facades.converters.IConverter;
import com.iwtg.ipaymonitor.facades.datatypes.system.DataCardBrand;
import com.iwtg.ipaymonitor.facades.datatypes.system.DataChannel;
import com.iwtg.ipaymonitor.facades.datatypes.system.DataCountry;
import com.iwtg.ipaymonitor.facades.datatypes.system.DataSystemItem;

public class SystemItemConverter implements IConverter<DataSystemItem, Object> {
	
	public DataSystemItem converter(Object source) {
		if (source instanceof Country) {
			DataCountry target = new DataCountry();
			target.setId(((Country) source).getIsoCode());
			target.setName(((Country) source).getName());
			return target;
		} else if (source instanceof Channel) {
			DataChannel target = new DataChannel();
			target.setId(String.valueOf(((Channel) source).getCode()));
			target.setName(((Channel) source).getName());
			return target;
		} else {
			DataCardBrand target = new DataCardBrand();
			target.setId(((Ccbrand) source).getCode());
			target.setName(((Ccbrand) source).getName());
			return target;
		}
	}

	public Object deConverter(DataSystemItem source) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DataSystemItem> convertAll(List<Object> source) {
		List<DataSystemItem> dataSystemItemList = new ArrayList<DataSystemItem>();
		for (Object systemItem : source) {
			dataSystemItemList.add(converter(systemItem));
		}
		return dataSystemItemList;
	}

	public List<Object> deConvertAll(List<DataSystemItem> source) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<DataCountry> convertAllCountries(List<Country> source) {
		List<DataCountry> dataSystemItemList = new ArrayList<DataCountry>();
		for (Country pais : source) {
			dataSystemItemList.add((DataCountry)converter(pais));
		}
		return dataSystemItemList;
	}
	
	public List<DataCardBrand> convertAllCardBrands(List<Ccbrand> source) {
		List<DataCardBrand> dataSystemItemList = new ArrayList<DataCardBrand>();
		for (Ccbrand mediopago : source) {
			dataSystemItemList.add((DataCardBrand)converter(mediopago));
		}
		return dataSystemItemList;
	}
	
	public List<DataChannel> convertAllChannels(List<Channel> source) {
		List<DataChannel> dataSystemItemList = new ArrayList<DataChannel>();
		for (Channel canal : source) {
			dataSystemItemList.add((DataChannel)converter(canal));
		}
		return dataSystemItemList;
	}
	

}
