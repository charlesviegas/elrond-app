package com.elrond;

import com.elrond.handler.AuthenticationFailureHandlerImpl;
import com.elrond.handler.AuthenticationSuccessHandlerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;


    @Autowired
    protected void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(new Md5PasswordEncoder())
                .usersByUsernameQuery("select usuario, senha, 'true' from empresa where usuario=?")
                .authoritiesByUsernameQuery("select usuario, papel from empresa where usuario=?");
    }


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/home")
                    .permitAll()
                        .anyRequest()
                        .authenticated()
                .and()
                    .formLogin()
                        .loginPage("/login")
                        .failureHandler(new AuthenticationFailureHandlerImpl("/login?error"))
                        .successHandler(new AuthenticationSuccessHandlerImpl())
                        .permitAll()
                .and()
                    .logout()
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/403")
                .and()
                    .csrf();
    }

}