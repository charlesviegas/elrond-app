package com.elrond;

import com.elrond.handler.AuthenticationFailureHandlerImpl;
import com.elrond.handler.AuthenticationSuccessHandlerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;


    @Autowired
    protected void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
        /*
        auth.inMemoryAuthentication().withUser("user1").password("123").roles("USER", "PAGE1");
        auth.inMemoryAuthentication().withUser("user2").password("123").roles("USER", "PAGE2");
        auth.inMemoryAuthentication().withUser("user3").password("123").roles("USER", "PAGE3");
        auth.inMemoryAuthentication().withUser("none").password("123").roles("NONE");
        */

        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(new Md5PasswordEncoder())
                .usersByUsernameQuery(
                        "select usuario, senha, 'true' from empresa where usuario=?")
                .authoritiesByUsernameQuery(
                        "select usuario, papel from empresa where usuario=?");
    }


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/home").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    //.failureUrl("/login?error")
                    .failureHandler(new AuthenticationFailureHandlerImpl())
                    .successHandler(new AuthenticationSuccessHandlerImpl())
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout().permitAll()
                //.and()
                //    .exceptionHandling()
                //    .accessDeniedPage("/403")
                .and()
                    .csrf();
    }

}