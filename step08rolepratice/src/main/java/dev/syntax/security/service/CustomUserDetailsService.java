package dev.syntax.security.service;

import dev.syntax.security.model.Users;
import dev.syntax.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. JPA를 이용한 조회
        Users userEntity = userRepository.findUserByUserName(username);

        System.out.println(userEntity.getRole().getRoleName());

        if(userEntity == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        // 2. 비밀번호 암호화
//        String encode = passwordEncoder.encode(userEntity.getPassword());

        // 3. User 반환
//        return User.withUsername(userEntity.getUser_name()).build();
        return User.withUsername(userEntity.getUserName()).password(userEntity.getUserPw()).authorities(userEntity.getRole().getRoleName()).build();
    }
}
