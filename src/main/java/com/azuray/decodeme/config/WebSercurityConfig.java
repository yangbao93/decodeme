package com.azuray.decodeme.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSercurityConfig extends WebSecurityConfigurerAdapter {

    //
    //    @Override
    //    @Bean
    //    public UserDetailsService userDetailsService() {
    //        return new UserServiceImpl();
    //    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**/demo/say2").permitAll()
                .anyRequest().authenticated().and().rememberMe();
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
        //        .and().formLogin()
        //                .loginPage("/login")
        //                .permitAll()
        //                .and()
        //                .logout()
        //                .permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/demo/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // auth.userDetailsService(userDetailsService());
        auth.inMemoryAuthentication().
                withUser("user").password("1").roles("USER")
                .and().withUser("admin").password("1").roles("USER", "ADMIN");
    }

}
