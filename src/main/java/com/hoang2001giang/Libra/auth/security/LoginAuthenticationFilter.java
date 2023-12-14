package com.hoang2001giang.Libra.auth.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.hoang2001giang.Libra.auth.dto.LoginInVO;
import com.hoang2001giang.Libra.auth.dto.LoginOutVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Autowired
    private JwtTokenProvider tokenProvider;

    public LoginAuthenticationFilter(AuthenticationManager authenticationManager,
                                     JwtTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
        super.setAuthenticationManager(authenticationManager);
        this.setFilterProcessesUrl("/api/auth/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response)
            throws AuthenticationException {
        try {
            // get login credentials
            LoginInVO creds = new ObjectMapper()
                    .readValue(request.getInputStream(), LoginInVO.class);

            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getEmail(),
                            creds.getPassword()
                    )
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        // generate jwt with user details
        String jwt = tokenProvider.generateToken((UserDetailsImpl) auth.getPrincipal());

        // convert to json
        String returnValue = new Gson().toJson(new LoginOutVO(jwt));

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        var writer = res.getWriter();
        writer.print(returnValue);
        writer.flush();
    }
}
