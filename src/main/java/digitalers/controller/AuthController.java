package digitalers.controller;

import digitalers.auth.JwtUtil;
import digitalers.dto.Credential;
import digitalers.entity.UserApi;
import digitalers.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Credential credencial){
        User userDetails = userDetailService.loadUserByUsername(credencial.getUsername());
        UserApi userApi = userDetailService.findUserByUsername(credencial.getUsername());

        Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("username", userDetails.getUsername());
        additionalInfo.put("roles",userApi.getRoles());
        additionalInfo.put("email", userApi.getEmail());

        String accessToken = jwtUtil.generateToken((UserDetails) userDetails, additionalInfo);
        String refreshToken = jwtUtil.generateRefreshToken((UserDetails) userDetails);

        Map<String, Object> response = new HashMap<>();
        response.put("accessToken", accessToken);
        response.put("refreshToken", refreshToken);

        return ResponseEntity.ok(response);
    }
}
