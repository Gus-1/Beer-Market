package com.spring.henallux.beerMarket.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final static String LOGIN_REQUEST = "/login";
    private static final String LOGIN_FAILURE_REQUEST = LOGIN_REQUEST + "/error";
    private final static String[] AUTHORIZED_REQUESTS_ANYBODY = new String[]{"/home", "/about", "/beers/**", "/", "/welcome", "/hello", "/vendor/**", "/cart/**", "/images/**", "/details/**", "/privacy", "/register", "/register/send"};
    private final static String[] AUTHORIZED_REQUEST_ADMIN = new String[]{"/admin"};

    private UserDetailsService userDetailsServiceImpl;

    @Autowired
    public WebSecurityConfiguration(UserDetailsService userDetailsServiceImplementation){
        this.userDetailsServiceImpl = userDetailsServiceImplementation;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // Disable because not necessary

        http
                .authorizeRequests() // We define the authorization here
                .antMatchers(AUTHORIZED_REQUESTS_ANYBODY).permitAll() // For the request to the index page, any user has access
                .anyRequest().authenticated() // For all the other requests, the user needs to be authenticated

                .and()
                .formLogin() // We define the login part here.
                .successHandler(new SavedRequestAwareAuthenticationSuccessHandler()) // provided by spring to redirect to the last request
                .loginPage(LOGIN_REQUEST) // We specify a login page. Otherwise spring creates one by default
                .permitAll() // To make the login page the available for any user


                .and()
                .logout() // We define the logout part here - By default : URL = "/logout"
                .logoutSuccessUrl("/")  // URL to return if logout is successful
                .permitAll(); // To make the logout available for any user
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
    }
}
