package quizmarket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import quizmarket.dao.QuizDao;
import quizmarket.models.Catalog;
import quizmarket.models.Quiz;

import java.util.List;

@Controller
@RequestMapping(value="/quiz")
public class QuizController {

  @Autowired
  private QuizDao _quizDao;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Quiz getByID(@PathVariable("id") long  id) {
    return _quizDao.getById(id);
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  @ResponseBody
  public Quiz save(@PathVariable("id") long  id) {
    return _quizDao.getById(id);
  }

  @RequestMapping(value="/", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity get() {
    List<Quiz> quizzes = _quizDao.getAll();
    return new ResponseEntity(quizzes, HttpStatus.OK);
  }


} // class QuizController
