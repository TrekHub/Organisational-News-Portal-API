import com.google.gson.Gson;
import dao.DepartmentDao;
import dao.Sql2oDepartmentDao;
import models.Department;
import org.sql2o.Sql2o;

import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
        Sql2oDepartmentDao sql2oDepartmentDao;
        Gson gson = new Gson();

        String con = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(con, "", "");
        DepartmentDao departmentDao = new Sql2oDepartmentDao(sql2o);

        get("/", (request, response) -> {
            return "Hello Ted";
        });


        //Add new Departments

        post("/departments/new", (request, response) -> {
            Department department = gson.fromJson(request.body(), Department.class);
            departmentDao.add(department);
            response.status(201);
            response.type("application/json");
            return gson.toJson(department);
        });


        //Get all Departments

        get("/departments", (request, response) -> {
            response.type("application/json");
            return gson.toJson(departmentDao.getAllDeparts());
        });

    }
}
