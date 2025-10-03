package digitalers.service.impl;

import digitalers.entity.Role;
import digitalers.entity.UserApi;
import digitalers.repository.UserRepository;
import digitalers.service.UserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UserDetailServiceImpl implements UserDetailService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        UserApi usuario = userRepository.findByUsername(username);

        if (usuario == null) {
            log.error("Error login: no existe el usuario '"+username+"'");
            throw new UsernameNotFoundException("username " + username + " no existe en el sitema");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        for (Role role : usuario.getRoles()){
            log.info("Role: " + role.getAuthority());
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }

        if(authorities.isEmpty()){
            log.error("Error de login: usuario " + username + "No tiene roles asignados");
            throw new UsernameNotFoundException("Error de login: usuario " + username + "No tiene roles asignados");
        }

        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnable(), true, true, true, authorities);
    }
}
