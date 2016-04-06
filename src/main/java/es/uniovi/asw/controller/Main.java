package es.uniovi.asw.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;


@Controller
public class Main {

  private static final Logger LOG = LoggerFactory.getLogger(Main.class);

  @RequestMapping("/")
  public String landing(Map<String,Object> model) {
      model.put("usuario","Naucé López");
      model.put("marcador","Voting System");
    return "freemarkerTest";
  }

    public class Nacho {

 private       String name;

        public String getName(){
            return name;
        }
        public void setName(String name){

            this.name=name;
        }

    }



  @RequestMapping("/Vote")
    public String loadVote(Map<String,Object> values){


      Nacho n = new Nacho();
      n.setName("n");
      values.put("nacho",n);


      return "landing";

  }
  
}