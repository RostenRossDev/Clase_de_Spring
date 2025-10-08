package digitalers.service;

import digitalers.entity.UserApi;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailService extends UserDetailsService {

    User loadUserByUsername(String username) throws UsernameNotFoundException;

    UserApi findUserByUsername(String username) throws UsernameNotFoundException;
}
