package models;

import org.junit.Test;

import static org.junit.Assert.*;
public class DepartmentTest {

    @Test
    public void department_InstantiateCorrectly_true() {
        Department testDepart = new Department("IT", "Handle all Tech Related Issues", 2);
        assertEquals(true, testDepart instanceof Department);
    }

    @Test
    public void department_InstantiateWithDepartName_true() {
        Department testDepart = new Department("IT", "Handle all Tech Related Issues", 2);
        assertEquals("IT", testDepart.getDepartName());
    }

    @Test
    public void department_InstantiateWithDepartDesc_true() {
        Department testDepart = new Department("IT", "Handle all Tech Related Issues", 2);
        assertEquals("Handle all Tech Related Issues", testDepart.getDepartDesc());
    }
    @Test
    public void department_InstantiateWithEmployeeNo_true() {
        Department testDepart = new Department("IT", "Handle all Tech Related Issues", 2);
        assertEquals(2, testDepart.getEmployeeNo());
    }

}