package com.example.TaskManager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManager.repositories.UserRepository;
import com.example.TaskManager.entities.User;
import com.example.TaskManager.exceptions.UserNotFoundException;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	   public Iterable<User> GetAllUsers()
	    {
	        return userRepository.findAll();
	    }


	    public User GetUserByName(String name) {
	        User foundUser = userRepository.findByName(name);
	        return foundUser;
	    }
	    
	    public User GetUserById(int id) {
	    	Optional<User> foundUser = userRepository.findById(id);
	    	
	    	
	    	if (!foundUser.isPresent()) {
	    		throw new UserNotFoundException();
	    	}
	    	
	    	return(foundUser.get());
	    }
	    
	    public void UpdateUser(User usertoUpdate) {
	    	userRepository.save(usertoUpdate);
	    }
	    
	    public boolean authenticate(String username, String password, User user) {
			
			 if (user != null && user.getPassword().equals(password)) {
		         return true;
		     }
			
			return false;
			
		}

	
}
