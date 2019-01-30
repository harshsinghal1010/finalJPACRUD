package com.usercrud.service;

import java.util.List;

import com.usercrud.entity.User;
import com.usercrud.utill.APIStatus;

public interface UserService {

	public APIStatus<User> register(User user);
	public APIStatus<User> login (String email , String password);
	public User getUserById(int id);
	public List<User> getAllUser();
	public APIStatus<User> updateUser(int id, User user);
	public APIStatus<User> deleteUser(int id);
}
