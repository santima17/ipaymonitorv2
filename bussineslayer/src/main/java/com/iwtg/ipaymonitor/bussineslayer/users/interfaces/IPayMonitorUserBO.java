package com.iwtg.ipaymonitor.bussineslayer.users.interfaces;

import java.util.List;

import com.iwtg.ipaymonitor.datalayer.model.User;
import com.iwtg.ipaymonitor.datalayer.model.UserHasCcbrand;
import com.iwtg.ipaymonitor.datalayer.model.UserHasChannel;
import com.iwtg.ipaymonitor.datalayer.model.UserHasCountry;

public interface IPayMonitorUserBO {

	int saveUser(final User user);

	List<User> getAll();

	User getUserByNickname(final String nickname);

	boolean findUser(final String nickname, final String password);

	boolean updateUser(final User user);

	boolean deleteUser(final User user);

	User getUserById(final Integer id);

	boolean userExist(final User user);

	boolean addCountryForUser(final UserHasCountry phu);

	boolean addCardbrandForUser(final UserHasCcbrand mhu);
	
	boolean addChannelForUser(final UserHasChannel chu);

	boolean removeCountryForUser(UserHasCountry phu);

	boolean removeChannelForUser(UserHasChannel chu);

	boolean removeCardbrandForUser(UserHasCcbrand mhu);

}
