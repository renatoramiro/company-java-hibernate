/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;
import model.Department;
import model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author renato
 */
public class Insert {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
  
        session.beginTransaction();
 
        Department department = new Department("java");
        session.save(department);
        
        Department department1 = new Department("ruby");
        session.save(department1);
 
        session.save(new Employee("Jakab Gipsz",department));
        session.save(new Employee("Captain Nemo",department1));
      
        session.getTransaction().commit();
 
        Query q = (Query) session.createQuery("From Employee ");
                 
        List<Employee> resultList = q.list();
        System.out.println("num of employess:" + resultList.size());
        for (Employee next : resultList) {
            System.out.println("next employee: " + next);
        }
    }
    
}
