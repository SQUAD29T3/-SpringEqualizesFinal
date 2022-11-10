package br.com.equalizes.sec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity.IgnoredRequestConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class AppSec {

  // Does this work?
  IgnoredRequestConfigurer liberaRecursos(WebSecurity web) throws Exception {
    return web.ignoring().antMatchers("/resources/** ");
  }

  @Bean
  public SecurityFilterChain filtroBasico(final HttpSecurity http)
      throws Exception {

    // TODO redo ant matcher in lambda
    http
        // .authorizeRequests(authConf -> {
        // authConf.antMatchers("/").permitAll();
        // authConf.antMatchers("/error").permitAll();
        // })
        .authorizeRequests()
        .antMatchers("/cadastroEscola")
        .permitAll()
        .antMatchers("/cadastroEmpresa")
        .permitAll()
        .antMatchers("/login")
        .permitAll()
        .antMatchers("/contato")
        .permitAll()
        .antMatchers("/css")
        .permitAll()
        .antMatchers("/js")
        .permitAll()
        .antMatchers("/img")
        .permitAll()
        .anyRequest()
        // .and()
        // .formLogin(form -> form.loginPage("/login").permitAll())
        .authenticated()
        .and()
        .formLogin();
    return http.build();
  }
}
