import com.google.gson.Gson;
import dao.*;
import models.Department;
import models.News;
import models.User;
import org.sql2o.Sql2o;

import static spark.Spark.*;


public class App {
    public static void main(String[] args) {

        String connectmetodatabase = "jdbc:postgresql://localhost:5432/news_api";
        Sql2o sql2o = new Sql2o(connectmetodatabase, "postgres", "Cosmo1088%");


        Sql2oDepartmentDao sql2oDepartmentDao = new Sql2oDepartmentDao(sql2o);
        Sql2oUserDao sql2oUserDao = new Sql2oUserDao(sql2o);
        Sql2oNewsDao sql2oNewsDao = new Sql2oNewsDao(sql2o);
        Gson gson = new Gson();




        //Root Route
        get("/", (request, response) -> {
            return "Hello Ted";
        });


        //Add new Departments
        post("/departments/new", (request, response) -> {
            Department department = gson.fromJson(request.body(), Department.class);
            sql2oDepartmentDao.add(department);
            response.status(201);
            response.type("application/json");
            return gson.toJson(department);
        });

        //Get all Departments
        get("/departments", (request, response) -> {
            response.type("application/json");
            return gson.toJson(sql2oDepartmentDao.getAllDeparts());
        });

        //Get departments by id;
        get("/departments/:id", (req, res) -> {
            res.type("application/json");
            int departId = Integer.parseInt(req.params("id"));
            return gson.toJson(sql2oDepartmentDao.findById(departId));
        });



        //Create new USer
        post("/users/new", (request, response) -> {
            User user = gson.fromJson(request.body(), User.class);
            sql2oUserDao.add(user);
            response.status(201);
            response.type("application/json");

            return gson.toJson(user);
        });

        //Get all Users
        get("/users", (req, res) -> {
           res.type("application/json");
           return  gson.toJson(sql2oUserDao.getAllUsers());
        });

        //Get USers by id;
        get("/users/:id", (req, res) -> {
            res.type("application/json");
            int userId = Integer.parseInt(req.params("id"));
            return gson.toJson(sql2oUserDao.findById(userId));
        });


        //Get USers by department;
        get("/users/departments/:departId", (req, res) -> {
            res.type("application/json");
            int departId = Integer.parseInt(req.params("departId"));
            return gson.toJson(sql2oUserDao.findUsersByDepart(departId));
        });





        //Create News
        post("/news/new", (request, response) -> {
            News news = gson.fromJson(request.body(), News.class);
            sql2oNewsDao.add(news);
            response.status(201);
            response.type("application/json");

            return gson.toJson(news);
        });

        //Get all news
        get("/news", (req, res) -> {
            res.type("application/json");
            return gson.toJson(sql2oNewsDao.getAllNews());
        });

        //Get News by id;
        get("/news/:id", (req, res) -> {
            res.type("application/json");
            int newsId = Integer.parseInt(req.params("id"));
            return gson.toJson(sql2oNewsDao.findById(newsId));
        });


        //Get News by department;
        get("/news/departments/:departId", (req, res) -> {
            res.type("application/json");
            int departId = Integer.parseInt(req.params("departId"));
            return gson.toJson(sql2oNewsDao.findNewsByDepart(departId));
        });


    }
}
