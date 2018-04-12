package com.iwtg.ipaymonitor.facades.converters.user;

import java.util.ArrayList;
import java.util.List;

import com.iwtg.ipaymonitor.datalayer.model.User;
import com.iwtg.ipaymonitor.facades.converters.IConverter;
import com.iwtg.ipaymonitor.facades.datatypes.user.DataUser;

public class UserConverter implements IConverter<DataUser, User>{

	public DataUser converter(User source) {
		DataUser dtUser = new DataUser();
		dtUser.setDeleted(source.isBaja());
		dtUser.setDeleteReason(source.getMotivo());
		dtUser.setId(source.getUserId());
		dtUser.setIsAdmin(source.getAdmin());
		dtUser.setLastName(source.getLastName());
		dtUser.setName(source.getName());
		dtUser.setPassword(source.getPass());
		dtUser.setUser(source.getUser());
		return dtUser;
	}

	public User deConverter(DataUser source) {
		User user = new User();
		user.setBaja(source.getDeleted());
		user.setMotivo(source.getDeleteReason());
		user.setUserId(source.getId());
		user.setAdmin(source.getIsAdmin());
		user.setLastName(source.getLastName());
		user.setName(source.getName());
		user.setPass(source.getPassword());
		user.setUser(source.getUser());
		return user;
	}

	public List<DataUser> convertAll(List<User> source) {
		List<DataUser> userDataList = new ArrayList<DataUser>();
		for(User usuario : source) {
			userDataList.add(converter(usuario));
		}
		return userDataList;
	}

	public List<User> deConvertAll(List<DataUser> source) {
		// TODO Auto-generated method stub
		return null;
	}

}
