package quizmarket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import quizmarket.dao.CatalogDao;
import quizmarket.models.Catalog;

import java.util.List;

@Controller
@RequestMapping(value="/catalog")
public class CatalogController {

  @Autowired
  private CatalogDao _catalogDao;

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  @ResponseBody
  public String delete(@PathVariable("id") long  id) {
    try {
      Catalog catalog = new Catalog(id);
      //_catalogDao.delete(catalog);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Catalog successfully deleted!";
  }

  @RequestMapping(value="/", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity get() {
    List<Catalog> catalogs = _catalogDao.getAll();
    return new ResponseEntity(catalogs, HttpStatus.OK);
  }


} // class UserController
