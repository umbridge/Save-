package com.hashedin.huTaxer.Services;


import com.hashedin.huTaxer.Exception.InvalidCredentials;
import com.hashedin.huTaxer.Exception.UserNotFoundException;
import com.hashedin.huTaxer.Modal.JwtRequest;
import com.hashedin.huTaxer.Modal.JwtResponse;
import com.hashedin.huTaxer.Modal.User;
import com.hashedin.huTaxer.Repository.UserRepository;
import com.hashedin.huTaxer.util.JwtUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String userName = jwtRequest.getUserName();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(userName, userPassword);

        UserDetails userDetails = loadUserByUsername(userName);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        User user = userRepository.findByUserName(userName);
        return new JwtResponse(user, newGeneratedToken);
    }

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        checkUser(name);
        User user = userRepository.findByUserName(name);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getUserName(),
                    user.getUserPassword()
                    ,getAuthority(user)
            );
        } else {

                throw new UsernameNotFoundException("User not found with userName: " + name);

        }


    }

    private void checkUser(String name) throws UserNotFoundException {
        if(userRepository.findByUserName(name)==null)
            throw new UserNotFoundException("Invalid username , Please try again !!");
    }

    private Set getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getUserName()));
        return authorities;
    }

    private void authenticate(String userName, String userPassword) throws Exception {
        try {
            String pass = userPassword;
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userName,userPassword);


            authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        } catch (DisabledException e) {
            System.out.println(e);
            throw new InvalidCredentials(e.getMessage());

        } catch (BadCredentialsException e) {
            System.out.println(e);
            throw new InvalidCredentials( e.getMessage());
        }
    }


}
