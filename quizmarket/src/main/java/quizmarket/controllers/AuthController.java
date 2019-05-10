package quizmarket.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import quizmarket.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import quizmarket.services.AuthService;

import java.util.*;

@Controller
@RequestMapping(value="/auth")
public class AuthController {

  @Autowired
  private AuthService _authService;

  @Autowired
  JwtTokenProvider jwtTokenProvider;

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity login(@RequestParam("email") String email, @RequestParam("token") String token) {
    // "email " + username + " password " + password;
    //long id = _authService.login(email, token).getId();
    ArrayList<String> roles = new ArrayList();
    String jwtToken = jwtTokenProvider.createToken(email, roles);

    Map<Object, Object> model = new HashMap<>();
    model.put("email", email);
    model.put("token", jwtToken);
    return new ResponseEntity(model, HttpStatus.OK);
  }

  @RequestMapping(value = "/signup", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity signup(@RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName,
                       @RequestParam("token") String token,  @RequestParam("email") String email,
                       @RequestParam("image") String image ){

    ArrayList<String> roles = new ArrayList();
    String jwtToken = jwtTokenProvider.createToken(email, roles);

    Map<Object, Object> model = new HashMap<>();
    model.put("email", email);
    model.put("token", jwtToken);
    return new ResponseEntity(model, HttpStatus.OK);
  }


} // class AuthController
