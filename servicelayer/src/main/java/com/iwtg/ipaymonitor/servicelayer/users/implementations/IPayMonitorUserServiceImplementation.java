package com.iwtg.ipaymonitor.servicelayer.users.implementations;

import java.util.List;

import com.iwtg.ipaymonitor.bussineslayer.users.interfaces.IPayMonitorUserBO;
import com.iwtg.ipaymonitor.bussineslayer.users.implementations.IPayMonitorUserBOImplementation;
import com.iwtg.ipaymonitor.bussineslayer.context.IpayMonitorBussinesContextLoader;
import com.iwtg.ipaymonitor.bussineslayer.system.implementations.IPayMonitorSystemBOImplementation;
import com.iwtg.ipaymonitor.bussineslayer.system.interfaces.IPayMonitorSystemBO;
import com.iwtg.ipaymonitor.datalayer.model.User;
import com.iwtg.ipaymonitor.datalayer.model.UserHasCcbrand;
import com.iwtg.ipaymonitor.datalayer.model.UserHasCcbrandId;
import com.iwtg.ipaymonitor.datalayer.model.UserHasChannel;
import com.iwtg.ipaymonitor.datalayer.model.UserHasChannelId;
import com.iwtg.ipaymonitor.datalayer.model.UserHasCountry;
import com.iwtg.ipaymonitor.datalayer.model.UserHasCountryId;
import com.iwtg.ipaymonitor.servicelayer.users.interfaces.IPayMonitorUserService;

public class IPayMonitorUserServiceImplementation implements IPayMonitorUserService {

	IPayMonitorUserBO userBO = (IPayMonitorUserBOImplementation) IpayMonitorBussinesContextLoader.contextLoader()
			.getBean("userBO");

	IPayMonitorSystemBO systemBO = (IPayMonitorSystemBOImplementation) IpayMonitorBussinesContextLoader.contextLoader()
			.getBean("systemBO");

	public int saveUser(User user) {
		return userBO.saveUser(user);
	}

	public List<User> getAll() {
		return userBO.getAll();
	}

	public User getUserByNickname(String nickname) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean findUser(String nickname, String password) {
		return userBO.findUser(nickname, password);
	}

	public boolean updateUser(User user) {
		return userBO.updateUser(user);
	}

	public boolean deleteUser(Integer id) {
		User user = userBO.getUserById(id);
		if (user != null) {
			return userBO.deleteUser(user);
		} else {
			return false;
		}
	}

	public User getUserById(Integer id) {
		return userBO.getUserById(id);
	}

	public boolean userExist(User user) {
		return userBO.userExist(user);
	}

	public boolean addCountryForUser(Integer userID, String countryID) {
		UserHasCountry phu = new UserHasCountry();
		UserHasCountryId phuID = new UserHasCountryId();
		phuID.setIsoCode(countryID);
		phuID.setUserId(userID.intValue());
		phu.setId(phuID);
		return userBO.addCountryForUser(phu);
	}

	public boolean addCardbrandForUser(Integer userID, String cardbrandID) {
		UserHasCcbrand mhu = new UserHasCcbrand();
		UserHasCcbrandId mhuID = new UserHasCcbrandId();
		mhuID.setBrandCode(cardbrandID);
		mhuID.setUserId(userID.intValue());
		mhu.setId(mhuID);
		return userBO.addCardbrandForUser(mhu);
	}

	public boolean addChannelForUser(Integer userID, String channelID) {
		UserHasChannel chu = new UserHasChannel();
		UserHasChannelId chuID = new UserHasChannelId();
		chuID.setChannelCode(channelID);
		chuID.setUserId(userID.intValue());
		chu.setId(chuID);
		return userBO.addChannelForUser(chu);
	}

	public boolean removeCountryForUser(Integer userID, String countryID) {
		UserHasCountry phu = new UserHasCountry();
		UserHasCountryId phuID = new UserHasCountryId();
		phuID.setIsoCode(countryID);
		phuID.setUserId(userID.intValue());
		phu.setId(phuID);
		return userBO.removeCountryForUser(phu);
	}

	public boolean removeChannelForUser(Integer userID, String channelID) {
		UserHasChannel chu = new UserHasChannel();
		UserHasChannelId chuID = new UserHasChannelId();
		chuID.setChannelCode(channelID);
		chuID.setUserId(userID.intValue());
		chu.setId(chuID);
		return userBO.removeChannelForUser(chu);
	}

	public boolean removeCardbrandForUser(Integer userID, String cardbrandID) {
		UserHasCcbrand mhu = new UserHasCcbrand();
		UserHasCcbrandId mhuID = new UserHasCcbrandId();
		mhuID.setBrandCode(cardbrandID);
		mhuID.setUserId(userID.intValue());
		mhu.setId(mhuID);
		return userBO.removeCardbrandForUser(mhu);
	}

	public boolean login(String userName, String passEncrptyed) {
		return findUser(userName, passEncrptyed);
	}

}
