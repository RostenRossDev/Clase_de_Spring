package digitalers.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailService {

    User loadUserByUsername(String username) throws UsernameNotFoundException;

}
