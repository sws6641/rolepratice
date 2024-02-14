package dev.syntax.security.config;

import dev.syntax.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserRepository userRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Http Basic 인증 방식을 적용하기 위해 해당 필터 추가
        http.formLogin(Customizer.withDefaults());

        http.authorizeRequests() // 요청에 대해 권한을 확인할 것
                .anyRequest() // 서버에 존재하는 모든 경로(Endpoint)의 요청에 대해
//                .hasAuthority("ROLE_ADMIN"); // READ권한을 가진 사용자만 접근 가능
                .hasRole("ADMIN");
//                .hasAnyAuthority("READ", "WRITE"); // READ나 WRITE 권한을 하나라도 가진 사용자 접근 가능
                // DELETE 권한을 가진 kang는 접근 불가


        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(String username) {
//
//        User user = userRepository.findUserByUserName(username)
//                .orElseThrow(() -> new UsernameNotFoundException("해당하는 사용자가 없음"));
//
//        return user;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
