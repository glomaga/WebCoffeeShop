package edu.mum.coffee.config;


import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

	  auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"select username,password, enabled from users where username=?")
		.authoritiesByUsernameQuery(
			"select username_username, authority from authorities where username_username=?");
	}

	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.authorizeRequests().antMatchers("/", "/home",
		// "/index").permitAll().anyRequest().authenticated().and()
		// .formLogin().permitAll().and().logout().logoutRequestMatcher(new
		// AntPathRequestMatcher("/logout"))
		// .logoutSuccessUrl("/").permitAll();
		http.formLogin().loginPage("/login").usernameParameter("userId").passwordParameter("password");
		http.formLogin().defaultSuccessUrl("/market/products/").failureUrl("/login?error");
		http.logout().logoutSuccessUrl("/login?logout");
		http.exceptionHandling().accessDeniedPage("/login?accessDenied");
		http.authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/**/admin").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/market/cart/*").access("hasRole('ROLE_USER')");
		//.antMatchers("/market/cart/*").access("hasRole('ROLE_ADMIN')");
				//.antMatchers("/**/market/**").access("hasRole('USER')");
		http.csrf().disable();

	}

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("super").password("pw").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("gina").password("gina").roles("USER");
//		auth.inMemoryAuthentication().withUser("glo").password("glo").roles("ADMIN");
//
//	}

}