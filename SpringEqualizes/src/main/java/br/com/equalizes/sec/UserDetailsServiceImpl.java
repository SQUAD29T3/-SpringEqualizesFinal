package br.com.equalizes.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;

import br.com.equalizes.model.Perfil;
import br.com.equalizes.repository.PerfilRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

    private PerfilRepository perfilRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Perfil perfil = perfilRepository.getPerfilByEmail(email);

        if (perfil == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(perfil);
    }
}
