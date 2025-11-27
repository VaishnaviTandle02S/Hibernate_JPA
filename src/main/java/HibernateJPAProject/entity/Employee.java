package HibernateJPAProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    Integer Employee_Id;
    String Employee_Name;
    Long Employee_PhoneNo;
    String Employee_Dept;

    public Employee(Integer employee_Id, String employee_Name, Long employee_PhoneNo, String employee_Dept) {
        Employee_Id = employee_Id;
        Employee_Name = employee_Name;
        Employee_PhoneNo = employee_PhoneNo;
        Employee_Dept = employee_Dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Employee_Id=" + Employee_Id +
                ", Employee_Name='" + Employee_Name + '\'' +
                ", Employee_PhoneNo=" + Employee_PhoneNo +
                ", Employee_Dept='" + Employee_Dept + '\'' +
                '}';
    }

    public Integer getEmployee_Id() {
        return Employee_Id;
    }

    public void setEmployee_Id(Integer employee_Id) {
        Employee_Id = employee_Id;
    }

    public String getEmployee_Name() {
        return Employee_Name;
    }

    public void setEmployee_Name(String employee_Name) {
        Employee_Name = employee_Name;
    }

    public Long getEmployee_PhoneNo() {
        return Employee_PhoneNo;
    }

    public void setEmployee_PhoneNo(Long employee_PhoneNo) {
        Employee_PhoneNo = employee_PhoneNo;
    }

    public String getEmployee_Dept() {
        return Employee_Dept;
    }

    public void setEmployee_Dept(String employee_Dept) {
        Employee_Dept = employee_Dept;
    }

    public Employee(){

    }
}


