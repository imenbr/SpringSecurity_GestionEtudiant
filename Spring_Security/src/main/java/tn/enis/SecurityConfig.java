package tn.enis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	 public void globalConfig(AuthenticationManagerBuilder auth) throws Exception {    
		auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN","PROF");
		auth.inMemoryAuthentication().withUser("prof1").password("123").roles("PROF");
		auth.inMemoryAuthentication().withUser("et1").password("123").roles("ETUDIANT");
		auth.inMemoryAuthentication().withUser("sco1").password("123").roles("SCOLARITE");

	 } 
	
	 protected void configure(HttpSecurity http) throws Exception {
    
          
//          .sessionManagement().maximumSessions(100).maxSessionsPreventsLogin(false).expiredUrl("/Login");
         http
         .csrf().disable()
          .authorizeRequests()
          	.anyRequest().authenticated()// TOUTES LES REQUETES DOIVENT ETRE AUTHENTIQUÉ
          .and()
         .formLogin()
            .loginPage("/login") 
            .permitAll() 
            .defaultSuccessUrl("/index.html")
            .failureUrl("/error.html")
            ;

    }
	 

}
