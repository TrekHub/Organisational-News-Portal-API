package dao;

import models.Department;

import java.util.List;

public interface DepartmentDao {
    //post
    void add(Department department);

    //get
    List<Department> getAllDeparts();

    //get by id
    Department findById(int id);
}
