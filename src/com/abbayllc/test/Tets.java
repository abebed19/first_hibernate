package com.abbayllc.test;

import com.abbayllc.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Tets {
    public static void main(String[] args) {
        SessionFactory sessionFactory=null;
        Transaction tx=null;
        Session session=null;

        try {

            Configuration cfg=new Configuration();
            cfg.configure("com/abbayllc/resources/hibernate.cfg.xml");
            sessionFactory= cfg.buildSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();
            Employee employee=new Employee();
            employee.setEno("2222");
            employee.setEname("Noah Abebe Demis");
            employee.setEaddr("Addis Abeba");
            employee.setEsal("500000");
            session.saveOrUpdate(employee);
            tx.commit();
            System.out.println("Employee Updated Successfully");
            System.out.println("Transaction Success");

        }catch (Exception e){
            tx.rollback();
            System.out.println("Transaction Failure");
            e.printStackTrace();

        }finally {

        }

    }
}
