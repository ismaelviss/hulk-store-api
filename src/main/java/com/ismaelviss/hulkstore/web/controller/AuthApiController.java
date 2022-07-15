package com.ismaelviss.hulkstore.web.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ismaelviss.hulkstore.domain.model.JWT;
import com.ismaelviss.hulkstore.domain.model.Role;
import com.ismaelviss.hulkstore.domain.model.User;
import com.ismaelviss.hulkstore.domain.service.AuthService;
import com.ismaelviss.hulkstore.domain.service.JwtService;
import com.ismaelviss.hulkstore.domain.service.RoleService;
import com.ismaelviss.hulkstore.domain.service.UsersDetailsService;
import com.ismaelviss.hulkstore.web.controller.ifc.AuthApi;

import io.swagger.annotations.ApiParam;
//@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-07-13T23:59:29.046Z")
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequiredArgsConstructor
public class AuthApiController implements AuthApi {

	
    private static final Logger log = LoggerFactory.getLogger(AuthApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    
    private final AuthenticationManager authenticationManager;
    private final UsersDetailsService usersDetailsService;
    private final AuthService authService;
    private final RoleService roleService;
    private final JwtService jwtService;


    //private final PasswordEncoder encoder;
    
    /*
    @org.springframework.beans.factory.annotation.Autowired
    public AuthApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
    */

    public ResponseEntity<?> loginUser(@ApiParam(value = "Login user object" ,required=true ) @RequestBody User body) {

    	try {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(body.getUsername(), body.getPassword());
            authenticationManager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            //throw new Exception("Invalid username or password", e);
        	log.error(e.getMessage());
            return new ResponseEntity<JWT>(HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = usersDetailsService.loadUserByUsername(body.getUsername());
        //String token = jwtService.createToken(userDetails);
        //UserDetails userDetails = usersDetailsService.loadUserByUsername(body.getUsername());
        return new ResponseEntity<JWT>(jwtService.createToken(userDetails),HttpStatus.OK);
    }

    public ResponseEntity<?> registerUser(@ApiParam(value = "Register user object" ,required=true ) @RequestBody User body) {
        /*
    	String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
        */
        if (authService.existsByUsername(body.getUsername())) {
            return ResponseEntity.badRequest().body("Error: Username is already taken!");
        }

        if (authService.existsByEmail(body.getEmail())) {
            return ResponseEntity.badRequest().body(("Error: Email is already in use!"));
        }

          // Create new user's account
          
          User user = new User(body.getUsername(),
        		  			   body.getFirstName(),
        		  			   body.getLastName(),
			                   body.getEmail(),
			                   body.getPassword(),
			                   body.getPhone(),
			                   body.getUserStatus());

          //                     encoder.encode(body.getPassword()));

          /*
          Set<String> strRoles = body.getRole();
          Set<Role> roles = new HashSet<>();
          */
          Set<Role> setRoles = body.getRoles();
          //Set<String> strRoles = new HashSet<String>();
          Set<Role> roles = new HashSet<>();
          for (Role role : setRoles){
        	  Optional<Role> optRole = roleService.findByName(role.getName());
        	  Role opt = optRole.get();
        	  roles.add(opt);

          }
          

          /*
          if (strRoles == null) {
            Role userRole = roleService.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
          } else {
            strRoles.forEach(role -> {
              switch (role) {
              case "admin":
                Role adminRole = roleService.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles.add(adminRole);

                break;
              case "mod":
                Role modRole = roleService.findByName(ERole.ROLE_MODERATOR)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles.add(modRole);

                break;
              default:
                Role userRole = roleService.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles.add(userRole);
              }
            });
          }
          */

		  //user.setRoles(roles);
		  user.setRoles(roles);
		  authService.save(user);
		
		  //return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
		  return ResponseEntity.ok(user);
    }
	
}
