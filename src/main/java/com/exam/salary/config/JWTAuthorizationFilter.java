package com.exam.salary.config;

import com.exam.salary.constants.SecurityConstants;
import com.exam.salary.service.impl.UserDetailsServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

//    @Autowired
//    private UserDetailsServiceImpl userService;

    public JWTAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        String header = req.getHeader(SecurityConstants.HEADER_AUTHORIZACION_KEY);
        if (header == null || !header.startsWith(SecurityConstants.TOKEN_BEARER_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }
//        UserDetails user = userService.loadUserByUsername(userName);
        final String token = header.replace(SecurityConstants.TOKEN_BEARER_PREFIX, "");

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(SecurityConstants.HEADER_AUTHORIZACION_KEY);
        if (token != null) {
            // Se procesa el token y se recuperan los claims.
            Claims claims = Jwts.parser()
                    .setSigningKey(SecurityConstants.SUPER_SECRET_KEY)
                    .parseClaimsJws(token.replace(SecurityConstants.TOKEN_BEARER_PREFIX, ""))
                    .getBody();

            // Se procesa el token y se recupera el usuario.
            String user = Jwts.parser()
                    .setSigningKey(SecurityConstants.SUPER_SECRET_KEY)
                    .parseClaimsJws(token.replace(SecurityConstants.TOKEN_BEARER_PREFIX, ""))
                    .getBody()
                    .getSubject();

            final List<SimpleGrantedAuthority> authorities =
                    Arrays.stream(claims.get(SecurityConstants.AUTHORITIES_KEY).toString().split(","))
                            .map(SimpleGrantedAuthority::new)
                            .collect(Collectors.toList());

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, authorities);
            }
            return null;
        }
        return null;
    }
}