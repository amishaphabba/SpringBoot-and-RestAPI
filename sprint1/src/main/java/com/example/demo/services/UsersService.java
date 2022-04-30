package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	UsersRepository usersrepo;

	public String getUsers() {
		// TODO Auto-generated method stub
		List userlist = usersrepo.findAll();
		if(userlist.size()!=0) {
			return userlist.toString();
		}
		return "empty list";
	}

	public String getUserOnId(int user_id) {
		// TODO Auto-generated method stub
		if(usersrepo.existsById(user_id)){
			return usersrepo.getById(user_id).toString();
		}
		return "no user found with id "+user_id;	
	}

	public String addUser(Users user) {
		// TODO Auto-generated method stub
		return "user added \n"+usersrepo.save(user).toString();
	}

	public String updateUser(Users user, int user_id) {
		// TODO Auto-generated method stub
		if(usersrepo.existsById(user_id)) {
			return "user updated \n"+usersrepo.save(user).toString();
		}
		return "no user found with id "+user_id;																
	}

	public String deleteUser(int user_id) {
		// TODO Auto-generated method stub
		if(usersrepo.existsById(user_id)) {
			 Users userdel = usersrepo.getById(user_id);
			 usersrepo.delete(userdel);
			 return "userdeleted \n"+ userdel.toString();
		}
		return "no user found with id "+user_id;
	}


}
