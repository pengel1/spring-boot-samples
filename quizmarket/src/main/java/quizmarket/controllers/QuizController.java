package quizmarket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quizmarket.dao.QuizDao;
import quizmarket.models.Quiz;

import java.util.List;

@RestController
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
  public ResponseEntity get(@RequestParam(value = "search", required=false) final String search) {
    List<Quiz> quizzes = _quizDao.getAll(search);
    return new ResponseEntity(quizzes, HttpStatus.OK);
  }


} // class QuizController
