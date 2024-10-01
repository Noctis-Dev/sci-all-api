package com.sci_all.demo.configuration.security.user;

import com.sci_all.demo.persistance.entities.User;
import com.sci_all.demo.service.ISessionService;
import com.sci_all.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Autowired
    private ISessionService sessionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByEmail(username);
        sessionService.createSession(user);
        return new UserDetailsImpl(user);
    }
}
