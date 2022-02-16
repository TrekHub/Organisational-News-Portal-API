package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public  void user_InstantiateCorrectly_True(){
        User testUser = new User("Trekhub", "Android Developer", "Develop Mobile Apps", "IT", 2);
        assertEquals(true, testUser instanceof  User);
    }

    @Test
    public  void user_InstantiateWithName_True(){
        User testUser = new User("Trekhub", "Android Developer", "Develop Mobile Apps", "IT", 2);
        assertEquals("Trekhub", testUser.getName());
    }

    @Test
    public  void user_InstantiateWithRole_True(){
        User testUser = new User("Trekhub", "Android Developer", "Develop Mobile Apps", "IT", 2);
        assertEquals("Develop Mobile Apps", testUser.getRole());
    }

    @Test
    public  void user_InstantiateWithPosition_True(){
        User testUser = new User("Trekhub", "Android Developer", "Develop Mobile Apps", "IT", 2);
        assertEquals("Android Developer", testUser.getPosition());
    }


    @Test
    public  void user_InstantiateWithDepart_True(){
        User testUser = new User("Trekhub", "Android Developer", "Develop Mobile Apps", "IT", 2);
        assertEquals("IT", testUser.getDepartment());
    }

    @Test
    public  void user_InstantiateWithDepartId_True(){
        User testUser = new User("Trekhub", "Android Developer", "Develop Mobile Apps", "IT", 2);
        assertEquals(2, testUser.getDepartId());
    }





}