package br.com.equalizes.sec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity.IgnoredRequestConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class AppSec {

  // Uma forma de acessar os dados
  // agnostica ao banco
  private JdbcTemplate template;

  IgnoredRequestConfigurer liberaRecursos(WebSecurity web) throws Exception {
    return web.ignoring().antMatchers("/resources/** ");
  }

  @Bean
  public UserDetailsService userDetailsService() {
    return new UserDetailsServiceImpl();
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService());

    return authProvider;
  }

  public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().dataSource(template.getDataSource())
        .usersByUsernameQuery("select nome,senha from user where username=?");
  }

  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authenticationProvider());
  }

  @Bean
  @Order(100)
  SecurityFilterChain filtroBasico(final HttpSecurity http) throws Exception {
    // FIXME usar um estilo so
    // lambda de preferencia
    http.authorizeRequests(authConf -> {
      authConf.antMatchers("/").permitAll();
      authConf.antMatchers("/error").permitAll();
    }).authorizeRequests().antMatchers("/cadastroEscola").permitAll().antMatchers("/cadastroEmpresa").permitAll()
        .antMatchers("/login").permitAll().antMatchers("/contato").permitAll().antMatchers("/css").permitAll()
        .antMatchers("/js").permitAll().antMatchers("/img").permitAll().anyRequest().authenticated().and().formLogin()
        .loginPage("/login");
    return http.build();
  }

  @Bean
  @Order(99)
  SecurityFilterChain adminChain(final HttpSecurity http) throws Exception {
    // REVIEW testar filtro
    // acho que esta faltando alguma coisa
    return http.authorizeHttpRequests().antMatchers("/admin**").hasRole("ADMIN").and().formLogin().loginPage("/login")
        .and().build();
  }

  // SecurityFilterChain escolaChain(final HttpSecurity http,
  // ) {
  // return
  // http.authorizeHttpRequests().antMatchers("/pedidos").hasRole("ESCOLA").antMatcher("/escola
  // cc")
  // }
}
