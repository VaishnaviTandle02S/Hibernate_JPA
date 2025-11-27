package HibernateJPAProject;

import HibernateJPAProject.dao.CrudOperation;

import java.util.Scanner;

public class EM_Application {
    public static void main(String[] args) {

        CrudOperation crud=new CrudOperation();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Hi user, lets do CRUD operations using Hibernate");
            System.out.println("Enter the operation you want to perform");
            System.out.println("1--> Add Employee");
            System.out.println("2--> FetchBy Id");
            System.out.println("3--> Fetch All");
            System.out.println("4--> Update Employee");
            System.out.println("5--> RemoveBy Id");

            Integer n = sc.nextInt();
            switch(n){
                case 1: crud.insert();
                    break;
                case 2: crud.fetchById();
                    break;
                case 3: crud.fetchAll();
                    break;
                case 4: crud.update();
                    break;
                case 5: crud.remove();
                    break;
                default:
                    System.out.println("exit");
            }
        }
    }
}

