package quizmarket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import quizmarket.models.User;
import quizmarket.services.LoginService;

@Controller
public class LoginController {

  @Autowired
  private LoginService _loginService;

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @ResponseBody
  public long login(@RequestParam("email") String email, @RequestParam("token") String token) {
    // "email " + username + " password " + password;
    return _loginService.login(email, token).getId();
  }

  @RequestMapping(value = "/signup", method = RequestMethod.POST)
  @ResponseBody
  public long signup(@RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName,
                       @RequestParam("token") String token,  @RequestParam("email") String email,
                       @RequestParam("image") String image ){

    return _loginService.createUser(firstName, lastName, token, email, image).getId();
  }




} // class LoginController
