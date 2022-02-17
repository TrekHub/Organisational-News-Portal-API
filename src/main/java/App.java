import com.google.gson.Gson;
import dao.*;
import models.Department;
import models.News;
import models.User;
import org.sql2o.Sql2o;

import static spark.Spark.*;


public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");

//        String connectmetodatabase = "jdbc:postgresql://localhost:5432/news_api";
//        Sql2o sql2o = new Sql2o(connectmetodatabase, "postgres", "Cosmo1088%");

        String connectionString = "jdbc:postgresql://ec2-54-235-108-217.compute-1.amazonaws.com:5432/depfaq7dad9vjq?sslmode=require"; //!
        Sql2o sql2o = new Sql2o(connectionString, "zndrpnkpeihnzo", "9f4ca03e298af7259ec1fccc87564351deb7f61c4a70ad6e10487dc9066a6de7"); //!


        Sql2oDepartmentDao sql2oDepartmentDao = new Sql2oDepartmentDao(sql2o);
        Sql2oUserDao sql2oUserDao = new Sql2oUserDao(sql2o);
        Sql2oNewsDao sql2oNewsDao = new Sql2oNewsDao(sql2o);
        Gson gson = new Gson();


        //FILTERS
        after((req, res) -> {
            res.type("application/json");
        });


        //Root Route
        get("/", (request, response) -> {
            return
                    "<div style=\"text-align: center;\">" +
                            "<h2 >Hello Hacker</h2>" +
                            "<br>" +
                            "<p>Kindly Interact with the Api Using The base url provided below here</p>" +

                            "<a href=\"url\">https://newsapited.herokuapp.com/</a>" +
                            "<br>" +
                            "<p>Refer to the documentation provided for Endpoint reference</p>" +
                            "<a href=\"url\">https://github.com/TrekHub/Organisational-News-Portal-API/blob/master/README.md</a>" +
                            "<br>" +
                            "</div>";
        });


        //Add new Departments
        post("/departments/new", (request, response) -> {
            Department department = gson.fromJson(request.body(), Department.class);
            sql2oDepartmentDao.add(department);
            response.status(201);
            return gson.toJson(department);
        });

        //Get all Departments
        get("/departments", (request, response) -> {
            return gson.toJson(sql2oDepartmentDao.getAllDeparts());
        });

        //Get departments by id;
        get("/departments/:id", (req, res) -> {
            int departId = Integer.parseInt(req.params("id"));
            return gson.toJson(sql2oDepartmentDao.findById(departId));
        });


        //Create new USer
        post("/users/new", (request, response) -> {
            User user = gson.fromJson(request.body(), User.class);
            sql2oUserDao.add(user);
            response.status(201);
            return gson.toJson(user);
        });

        //Get all Users
        get("/users", (req, res) -> {
            return gson.toJson(sql2oUserDao.getAllUsers());
        });

        //Get USers by id;
        get("/users/:id", (req, res) -> {
            int userId = Integer.parseInt(req.params("id"));
            return gson.toJson(sql2oUserDao.findById(userId));
        });


        //Get USers by department;
        get("/users/departments/:departId", (req, res) -> {
            int departId = Integer.parseInt(req.params("departId"));
            return gson.toJson(sql2oUserDao.findUsersByDepart(departId));
        });


        //Create News
        post("/news/new", (request, response) -> {
            News news = gson.fromJson(request.body(), News.class);
            sql2oNewsDao.add(news);
            response.status(201);


            return gson.toJson(news);
        });

        //Get all news
        get("/news", (req, res) -> {

            return gson.toJson(sql2oNewsDao.getAllNews());
        });

        //Get News by id;
        get("/news/:id", (req, res) -> {

            int newsId = Integer.parseInt(req.params("id"));
            return gson.toJson(sql2oNewsDao.findById(newsId));
        });


        //Get News by department;
        get("/news/departments/:departId", (req, res) -> {

            int departId = Integer.parseInt(req.params("departId"));
            return gson.toJson(sql2oNewsDao.findNewsByDepart(departId));
        });





    }
}
