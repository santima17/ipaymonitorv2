package com.iwtg.ipaymonitor.bussineslayer.users.implementations;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.iwtg.ipaymonitor.datalayer.interfaces.IPayMonitorMySQLDAO;
import com.iwtg.ipaymonitor.datalayer.implementations.IPayMonitorMySQLDAOImplementation;
import com.iwtg.ipaymonitor.bussineslayer.users.interfaces.IPayMonitorUserBO;
import com.iwtg.ipaymonitor.datalayer.context.IpayMonitorDAOContextLoader;
import com.iwtg.ipaymonitor.datalayer.model.User;
import com.iwtg.ipaymonitor.datalayer.model.UserHasCcbrand;
import com.iwtg.ipaymonitor.datalayer.model.UserHasChannel;
import com.iwtg.ipaymonitor.datalayer.model.UserHasCountry;
 
public class IPayMonitorUserBOImplementation implements IPayMonitorUserBO {

	IPayMonitorMySQLDAO daoServices = (IPayMonitorMySQLDAOImplementation) IpayMonitorDAOContextLoader.contextLoader()
			.getBean("daoServices");

	public int saveUser(User user) {
		
		return daoServices.save(user);
	}

	public List<User> getAll() {
		return daoServices.getAll(User.class);
	}

	public User getUserByNickname(String nickname) {
		User exampleUser = new User();
		exampleUser.setUser(nickname);
		List<User> resultList = daoServices.getAllByExample(User.class, exampleUser);
		if (CollectionUtils.isNotEmpty(resultList)) {
			return resultList.get(0);
		}else {
			return null;
		}
		
	}

	public boolean findUser(String nickname, String password) {
		User exampleUser = new User();
		exampleUser.setUser(nickname);
		exampleUser.setPass(password);	
		exampleUser.setBaja(false);
		exampleUser.setAdmin(0);
		List<User> resultList = daoServices.getAllByExample(User.class, exampleUser);
		if (CollectionUtils.isNotEmpty(resultList)) {
			return true;
		}else {
			exampleUser.setAdmin(1);
			resultList = daoServices.getAllByExample(User.class, exampleUser);
			if (CollectionUtils.isNotEmpty(resultList)) {
				return true;
			}
			return false;
		}
	}

	public boolean updateUser(User user) {
		User storedUser = daoServices.get(User.class, user.getUserId());
		storedUser.setAdmin(user.getAdmin());
		storedUser.setLastName(user.getLastName());
		storedUser.setBaja(user.isBaja());
		storedUser.setMotivo(user.getMotivo());
		storedUser.setName(user.getName());
		storedUser.setPass(user.getPass());
		storedUser.setUser(user.getUser());
		return daoServices.saveOrUpdate(storedUser);
	}

	public boolean deleteUser(User user) {
		user.setBaja(true);
		return daoServices.saveOrUpdate(user);
	}

	public User getUserById(Integer id) {
		return daoServices.get(User.class, id);
	}

	public boolean userExist(User user) {
		User exampleUser = new User();
		exampleUser.setUser(user.getUser());
		List result = daoServices.getAllByExample(User.class, exampleUser);
		return CollectionUtils.isNotEmpty(result);
	}

	public boolean addCountryForUser(UserHasCountry phu) {
		daoServices.save(phu);
		return true;
	}

	public boolean addCardbrandForUser(UserHasCcbrand mhu) {
		daoServices.save(mhu);
		return true;
	}

	public boolean addChannelForUser(UserHasChannel chu) {
		daoServices.save(chu);
		return true;
	}

	public boolean removeCountryForUser(UserHasCountry phu) {
			daoServices.delete(phu);
			return true;
	}

	public boolean removeChannelForUser(UserHasChannel chu) {
		daoServices.delete(chu);
		return true;
	}

	public boolean removeCardbrandForUser(UserHasCcbrand mhu) {
		daoServices.delete(mhu);
		return true;
	}

}
