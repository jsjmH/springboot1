package com.stone.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.stone.spring.entities.User;
import com.stone.spring.repository.UserRepository;



@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;

	public List<User> getUserByUsername(String username) {
		List<User> result = this.userRepository.findUserByUsernameContaining(username);
		return result;
	}
	
	public List<User> findUserByUserId(Long userId) {
		 List<User> result = this.userRepository.findUserByUserId(userId);
		return result;
	}


	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public boolean saveUser(User user) {
		userRepository.saveAndFlush(user);
		return true;
	}

}
