package com.usercrud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usercrud.dao.UserRepository;
import com.usercrud.entity.User;
import com.usercrud.service.UserService;
import com.usercrud.utill.APIStatus;
import com.usercrud.utill.ResponseMessage;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;
	

	@Override
	public APIStatus<User> register(User user) {
		// TODO Auto-generated method stub
		APIStatus<User> status;
		// checking email already registered or not 
		if(repo.findByEmail(user.getEmail()) !=null)
		{
			status = new APIStatus<User>( ResponseMessage.FAILED_MESSAGE, ResponseMessage.EMAIL_EXIST, null);

		}
		else {
		User newUser = repo.save(user);
		if(newUser!=null)
		{
			status = new APIStatus<User>( ResponseMessage.SUCCESS_MESSAGE, ResponseMessage.REGISTER_SUCCESS, newUser);
		}
		else
		{
			status = new APIStatus<User>( ResponseMessage.FAILED_MESSAGE, ResponseMessage.REGISTER_FAILED, null);

		}
		}
		return status;
	}

	@Override
	public APIStatus<User> login(String email, String password) {
		// TODO Auto-generated method stub
		APIStatus<User> status;
		
		User newUser = repo.findByEmailAndPassword(email, password);
		if(newUser!=null)
		{
			status = new APIStatus<User>( ResponseMessage.SUCCESS_MESSAGE, ResponseMessage.LOGIN_SUCCESS, newUser);
		}
		else
		{
			status = new APIStatus<User>( ResponseMessage.FAILED_MESSAGE, ResponseMessage.LOGIN_SUCCESS, null);

		}
		return status;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	

	@Override
	public APIStatus<User> deleteUser(int id) {
		// TODO Auto-generated method stub
		APIStatus<User> status;

		User user = repo.findById(id).orElse(null);
		if(user!=null)
		{
		repo.deleteById(id);
		status = new APIStatus<User>( ResponseMessage.SUCCESS_MESSAGE, ResponseMessage.DELETE_SUCCESS,null);

		}else
		{
			status = new APIStatus<User>( ResponseMessage.FAILED_MESSAGE, ResponseMessage.DELETE_ERROR, null);

		}
		
		return status;
	}

	@Override
	public APIStatus<User> updateUser(int id, User user) {
		// TODO Auto-generated method stub
		APIStatus<User> status;

		User updateUser = repo.findById(id).orElse(null);
		if(updateUser!=null)
		{
			updateUser.setAge(user.getAge());
			updateUser.setName(user.getName());
			updateUser.setPassword(user.getPassword());
		repo.save(updateUser);
		status = new APIStatus<User>( ResponseMessage.SUCCESS_MESSAGE, ResponseMessage.UPDATE_SUCCESS,null);

		}else
		{
			status = new APIStatus<User>( ResponseMessage.FAILED_MESSAGE, ResponseMessage.UPDATE_ERROR, null);

		}
		
		return status;
	}

}
