package HibernateJPAProject.dao;

import HibernateJPAProject.DB.DBConnection;
import HibernateJPAProject.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Scanner;

public class CrudOperation implements Crud{
    Scanner sc;

    public CrudOperation() {
        sc = new Scanner(System.in);
    }
    @Override
    public void insert() {
        EntityManager em = DBConnection.getEntryManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();
        // -----Start Transaction------
        t.begin();
        System.out.println("Enter no of data to be entered");
        int nofData = sc.nextInt();
        int max = 0;
        while (max < nofData) {
            System.out.println("Enter the EmployeeId : ");
            Integer id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter the Employee Name : ");
            String Empname = sc.nextLine();

            System.out.println("Enter the Employee PhoneNo : ");
            Long EmpPhone = sc.nextLong();
            sc.nextLine();

            System.out.println("Enter the Employee Dept");
            String EmpDept = sc.nextLine();

            Employee e = new Employee(id, Empname, EmpPhone, EmpDept);
            em.persist(e);
            max++;

        }

        t.commit();// --------end transaction----------

        em.close();
        System.out.println("Data added successfully!!!");

    }

    @Override
    public void update() {

        EntityManager em = DBConnection.getEntryManagerFactory().createEntityManager();
        EntityTransaction t= em.getTransaction();

        t.begin();
        System.out.println("Enter the EmployeeId : ");
        Integer uid = sc.nextInt();
        sc.nextLine();

        Employee e = em.find(Employee.class,uid);

        if(e != null){
            System.out.println("Enter the EmployeeName to update : ");
            String Empname=sc.nextLine();
            e.setEmployee_Name(Empname);

            System.out.println("Enter the Employee_PhoneNo to update : ");
            Long Emp_Phone=sc.nextLong();
            e.setEmployee_PhoneNo(Emp_Phone);
            sc.nextLine();

            System.out.println("Enter the Employee_Dept to update : ");
            String Emp_Dept=sc.nextLine();
            e.setEmployee_Dept(Emp_Dept);

            em.merge(e);

            t.commit();
            em.close();
            System.out.println("Employee details Updated successfully!!!");
        }
        else{
            System.out.println("Employee Not Found");
        }
    }

    @Override
    public void fetchById() {

        EntityManager em = DBConnection.getEntryManagerFactory().createEntityManager();
        EntityTransaction t= em.getTransaction();
        t.begin();

        System.out.println("Enter the EmployeeId to fetch");
        Integer fid=sc.nextInt();

        Employee e=em.find(Employee.class, fid);

        if(e != null){
            System.out.println("Employee Id: "+ e.getEmployee_Id()+"Employee Name: "+ e.getEmployee_Name()+"Employee Phone No: "+e.getEmployee_PhoneNo()+"Employee Dept: "+e.getEmployee_Dept());

            t.commit();
            em.close();
            System.out.println("Employee Fetched by Id Successfully");

        }
        else {
            System.out.println("Employee Not Found");
        }
    }

    @Override
    public void fetchAll() {

        EntityManager em = DBConnection.getEntryManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();

        List<Employee> list = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();

        if(list.isEmpty()) {
            System.out.println("No Employees Found!");
        } else {
            System.out.println("\n------ Employee List ------");
            for(Employee e : list) {
                System.out.println("Employee Id      : " + e.getEmployee_Id());
                System.out.println("Employee Name    : " + e.getEmployee_Name());
                System.out.println("Employee PhoneNo : " + e.getEmployee_PhoneNo());
                System.out.println("Employee Dept    : " + e.getEmployee_Dept());
                System.out.println("----------------------------");
            }
        }
        t.commit();
        em.close();
        System.out.println("\nAll Employees Fetched Successfully!");
    }


    @Override
    public void remove() {

        EntityManager em = DBConnection.getEntryManagerFactory().createEntityManager();
        EntityTransaction t= em.getTransaction();
        t.begin();

        System.out.println("Enter the EmployeeId : ");
        Integer did = sc.nextInt();
        sc.nextLine();

        if(did != null){
            Employee e = em.find(Employee.class,did);
            em.remove(e);

            t.commit();
            em.close();
            System.out.println("Employee removed successfully!!!");
        }
        else {
            System.out.println("Employee Not Found");
        }
    }
}
