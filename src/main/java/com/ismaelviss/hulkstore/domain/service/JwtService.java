package com.ismaelviss.hulkstore.domain.service;


import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ismaelviss.hulkstore.domain.model.JWT;
import com.ismaelviss.hulkstore.domain.model.User;
import com.ismaelviss.hulkstore.persistence.repository.ProductRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JwtService {
    private static final int EXPIRATION_TIME = 1000 * 60 * 60;
    private static final String AUTHORITIES = "authorities";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String EMAIL = "email";
    private final String SECRET_KEY;
    
    @Autowired
    private final AuthService authService;
    
    public JwtService() {
        SECRET_KEY = Base64.getEncoder().encodeToString("wRAhaK8aGMK43c3pOA9CVMQa5R3mlfR+HUJQjubRMBzpcsKOgn+HMApLzUDhyCh6HnnmOmU0BSJwB1Z/eqDLxA==".getBytes());
		this.authService = null;
    }

    public JWT createToken(UserDetails userDetails) {
        String username = userDetails.getUsername();
        
        User user = authService.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        JWT jwt = new JWT();	
        jwt.setJwt(Jwts.builder()
	                .setSubject(username)
	                .claim(FIRST_NAME,firstName)
	                .claim(LAST_NAME,lastName)
	                .claim(EMAIL, email)
	                .claim(AUTHORITIES, authorities)
	                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
	                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
	                .compact());
        return jwt;
    }

    public Boolean hasTokenExpired(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return (userDetails.getUsername().equals(username) && !hasTokenExpired(token));

    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    @SuppressWarnings("unchecked")
	public Collection<? extends GrantedAuthority> getAuthorities(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return (Collection<? extends GrantedAuthority>) claims.get(AUTHORITIES);
    }
}
