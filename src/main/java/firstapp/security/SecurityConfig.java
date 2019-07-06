package firstapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private UserDetailsServiceImpl userDetailsService;
    private SimpleUrlAuthenticationSuccessHandler simpleUrlAuthenticationSuccessHandler;

    @Autowired
    public SecurityConfig(UserDetailsServiceImpl userDetailsService, SimpleUrlAuthenticationSuccessHandler simpleUrlAuthenticationSuccessHandler) {
        this.userDetailsService = userDetailsService;
        this.simpleUrlAuthenticationSuccessHandler = simpleUrlAuthenticationSuccessHandler;
    }

    public SecurityConfig(boolean disableDefaults, UserDetailsServiceImpl userDetailsService, SimpleUrlAuthenticationSuccessHandler simpleUrlAuthenticationSuccessHandler) {
        super(disableDefaults);
        this.userDetailsService = userDetailsService;
        this.simpleUrlAuthenticationSuccessHandler = simpleUrlAuthenticationSuccessHandler;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/admin/**").hasAnyAuthority("admin")
                .antMatchers("/user").hasAnyAuthority("user", "admin")
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login").failureUrl("/login?error")
                .loginProcessingUrl("/processing-url")
                .usernameParameter("login").passwordParameter("password").permitAll()
                .successHandler(simpleUrlAuthenticationSuccessHandler)
                .and()
                .logout().logoutSuccessUrl("/login?logout").permitAll().logoutUrl("/logout")
                .and()
                .exceptionHandling().accessDeniedPage("/error");

    }

}
