package com.kgyam.securingweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


//    @Autowired
//    public void initialize(AuthenticationManagerBuilder builder, DataSource dataSource) throws Exception {
//        builder.jdbcAuthentication().dataSource(dataSource).withUser("user")
//                .password("pwd").roles("USER");
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/", "home").permitAll()
                .antMatchers("/credit/c1").hasAuthority("ADMIN")
                .antMatchers("/credit/c2").hasAuthority("ROLES")
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login").permitAll().and().logout()
                .permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails usr = User.withUsername("user").password("password")
                .authorities("ROLES").build();
        UserDetails kg = User.withUsername("kgyam")
                .password("123")
                .authorities("ADMIN").build();
        return new InMemoryUserDetailsManager(usr, kg);
    }
}
