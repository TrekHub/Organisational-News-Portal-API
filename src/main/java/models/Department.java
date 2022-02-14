package models;

public class Department {

    private int id;
    private String departName;
    private String departDesc;
    private int employeeNo;


    public Department(String departName, String departDesc, int employeeNo) {
        this.departName = departName;
        this.departDesc = departDesc;
        this.employeeNo = employeeNo;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getDepartDesc() {
        return departDesc;
    }

    public void setDepartDesc(String departDesc) {
        this.departDesc = departDesc;
    }

    public int getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }
}
