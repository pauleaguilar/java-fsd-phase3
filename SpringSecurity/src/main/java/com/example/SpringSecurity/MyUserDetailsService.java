package com.example.SpringSecurity;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entities.User;
import com.example.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    	 Optional<User> user = userRepository.findByName(name);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + name));

        return user.map(MyUserDetails::new).get();
    }
    
}
