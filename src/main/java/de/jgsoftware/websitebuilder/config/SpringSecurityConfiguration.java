package de.jgsoftware.websitebuilder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{



	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {
		authBuilder.jdbcAuthentication()
				.dataSource(dataSource)
				.passwordEncoder(new BCryptPasswordEncoder())
				.authoritiesByUsernameQuery("select username, role from users where username=?")
				.usersByUsernameQuery("select username, password, enabled from users where username=?")

		;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}



	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
				.authorizeRequests()
				.antMatchers(
						"/index.html",
						"/signup.html",
						"/login.html",
						"/h2/**",
						"/resources/**",
						"/static/**,").permitAll()

				.antMatchers("/profile/**").access("hasRole('ROLE_USER')")
				.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/manager/**").access("hasRole('ROLE_MANAGER')")
				.and()
				.formLogin()
				.loginPage("/login")
				.usernameParameter("email")
				.passwordParameter("password")
				.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login")
				.and()
				//.rememberMe().tokenValiditySeconds(30000).key("keytoken!")
				//.rememberMeParameter("checkRememberMe");
				.rememberMe().disable();



	}









}
