// package br.com.equalizes.sec;

// import java.util.Collection;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import br.com.equalizes.model.Escola;

// public class detalhesUsuario implements UserDetails {
// private Escola escola;

// public MyUserDetails(Escola escola) {
// this.user = user;
// }

// @Override
// public Collection<? extends GrantedAuthority> getAuthorities() {
// SimpleGrantedAuthority authority = new
// SimpleGrantedAuthority(user.getRole());
// return Arrays.asList(authority);
// }

// @Override
// public String getPassword() {
// return user.getPassword();
// }

// @Override
// public String getUsername() {
// return user.getUsername();
// }

// @Override
// public boolean isAccountNonExpired() {
// return true;
// }

// @Override
// public boolean isAccountNonLocked() {
// return true;
// }

// @Override
// public boolean isCredentialsNonExpired() {
// return true;
// }

// @Override
// public boolean isEnabled() {
// return true;
// }

// }
