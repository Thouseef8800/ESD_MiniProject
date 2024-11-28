package com.thouseef.backend.helper;

import com.thouseef.backend.entity.Employees;
import com.thouseef.backend.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Employees user = repo.findByEmail(username);
        if(user == null) {
            System.out.println("User Not found");
            throw new UsernameNotFoundException("User Not found");
        }

        return new UserPrincipal(user);
    }
}
