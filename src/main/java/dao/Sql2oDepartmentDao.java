package dao;

import models.Department;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentDao implements  DepartmentDao{

    private final Sql2o sql2o;

    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public  void add(Department department){
        String sql = "INSERT INTO departments(departName, departDesc, employeeNo) VALUES (:departName, :departDesc, :employeeNo) ";

        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .throwOnMappingFailure(false)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);


        }catch (Sql2oException err){
            System.out.println("Did not add the object to db " + err);
        }
    }



    @Override
    public List<Department> getAllDeparts(){
        String sql = "SELECT * FROM departments";
        try(Connection con = sql2o.open()){
            return  con.createQuery(sql)
                    .executeAndFetch(Department.class);
        }
    }

    @Override
    public Department findById(int id){
        String sql = "SELECT * FROM departments WHERE  id = :id";
        try(Connection con = sql2o.open()){
          return  con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Department.class);
        }
    }
}
