package edu.ulima.main;

import edu.ulima.bean.Curso;
import edu.ulima.jdbc.CursoDAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spark.ModelAndView;
import static spark.Spark.get;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;
import spark.template.freemarker.FreeMarkerEngine;

public class Main {
    
public static void main(String[] args) {

        port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");

        get("/s00", (req, res) -> {
            "Este metodo funciona !!!"; 
        }

        get("/s01", (req, res) -> {
            Map<String, Object> attributes = new HashMap<>();

            List<Curso> rpta = CursoDAO.getAllCursos();
            attributes.put("results", rpta);
            return new ModelAndView(attributes, "db.ftl");
        }, new FreeMarkerEngine());
    }
    
}
