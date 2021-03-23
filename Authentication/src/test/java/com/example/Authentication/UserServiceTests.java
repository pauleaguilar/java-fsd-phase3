package com.example.Authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.Authentication.entities.User;
import com.example.Authentication.services.UserService;

@DataJpaTest
public class UserServiceTests {
	
		@Autowired
		private TestEntityManager entityManager;
		@Autowired
	    private UserService userService;
	   
	   private User dummyUser = new User();
	   
	   @BeforeEach
	   public void init() {
		   
	         dummyUser.setName("Dummy");
	         dummyUser.setEmail("test@test.com");
	         dummyUser.setPassword("password");
	         entityManager.persist(dummyUser);
	         entityManager.flush();
	   }
	   
	   
	   @Test 
	    public void whenFindById_thenReturnUser() {
	    	
	    	

	         // when
	        User found = userService.GetUserById(dummyUser.getId());

	         // then, checks if both have the same name. Must be equal and pass the test. 

	         assertEquals(found.getName(), dummyUser.getName());
	     }
	    	
	    @Test	
	    public void whenlogin_UserisAuthenticated() {
	    
	         boolean abc = userService.authenticate(dummyUser.getName(), dummyUser.getPassword(), dummyUser);
	         assertTrue(abc = true);
	   
	    
	    }
	    
	    

}
