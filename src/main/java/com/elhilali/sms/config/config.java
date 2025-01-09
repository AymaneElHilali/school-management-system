package com.elhilali.sms.config;


import com.elhilali.sms.filter.JwtFilter;
import com.elhilali.sms.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class config {

    @Autowired
    JwtFilter jwtFilter;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
                .csrf(off -> off.disable())
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/student/signup","/student/login","/teacher/login","/teacher/signup","/admin/signup","/admin/login","/director/login","/director/signup","/addClassroom").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();

    }



    @Bean
    public AuthenticationProvider authenticationProvider(){

            DaoAuthenticationProvider daoAuthenticationProviderprovider = new DaoAuthenticationProvider();
            daoAuthenticationProviderprovider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
            daoAuthenticationProviderprovider.setUserDetailsService(myUserDetailsService);
            return daoAuthenticationProviderprovider;

    }


}
