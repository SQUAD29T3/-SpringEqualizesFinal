package br.com.equalizes.sec;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.equalizes.model.Acessos;
import br.com.equalizes.model.Perfil;

public class MyUserDetails implements UserDetails {

    private final Perfil perfil;

    public MyUserDetails(final Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final Set<Acessos> acessos = perfil.getAcessos();
        final List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (final Acessos acesso : acessos) {
            authorities.add(new SimpleGrantedAuthority(acesso.getAcesso()));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return perfil.getSenha();
    }

    @Override
    public String getUsername() {
        return perfil.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return perfil.isEnabled();
    }

}
