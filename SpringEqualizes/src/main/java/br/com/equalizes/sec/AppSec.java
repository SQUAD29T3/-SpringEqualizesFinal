package br.com.equalizes.sec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class AppSec {

  @Bean
  public SecurityFilterChain filtroBasico(final HttpSecurity http)
      throws Exception {
    http.authorizeRequests()
        .antMatchers("/")
        .permitAll()
        .antMatchers("/error")
        .permitAll()
        .antMatchers("/cadastroEscola")
        .permitAll()
        .antMatchers("/cadastroEmpresa")
        .permitAll()
        .antMatchers("/login")
        .permitAll()
        .antMatchers("/contato")
        .permitAll()
        .anyRequest()
        // .and()
        // .formLogin(form -> form.loginPage("/login").permitAll())
        .authenticated()
        .and()
        .httpBasic();

    return http.build();
  }
}
