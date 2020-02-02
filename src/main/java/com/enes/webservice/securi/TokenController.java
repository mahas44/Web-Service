package com.enes.webservice.securi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;

import com.enes.webservice.model.AppUser;
import com.enes.webservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
public class TokenController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/token")
    public ResponseEntity<String> getToken(@RequestBody AppUser login) throws ServletException {

        String jwttoken = "";

        if(login.getUsername().isEmpty() || login.getPassword().isEmpty())
            return new ResponseEntity<String>("Username or password cannot be empty.", HttpStatus.BAD_REQUEST);

        String name = login.getUsername(),
                password = login.getPassword();


        if(!userIsExist(name))
            return new ResponseEntity<String>("Invalid credentials. Please check the username and password.", HttpStatus.UNAUTHORIZED);
        else {
            // Creating JWT using the user credentials.
            Map<String, Object> claims = new HashMap<String, Object>();
            claims.put("usr", login.getUsername());
            claims.put("sub", "Authentication token");
            claims.put("iss", Iconstants.ISSUER);
            claims.put("rol", "Administrator, Developer");
            claims.put("iat", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            jwttoken = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, Iconstants.SECRET_KEY).compact();

        }

        return new ResponseEntity<String>(jwttoken, HttpStatus.OK);
    }

    private boolean userIsExist(String username){
        if (anyUsersAreExistInCollection()){
            Optional<AppUser> user  = userRepository.findByUsername(username);
            return user.isPresent();
        } else {
            return false;
        }
    }

    private boolean anyUsersAreExistInCollection(){
        int i  = userRepository.findAll().size();
        return i > 0;
    }
}
