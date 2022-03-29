package com.java.hibernetate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernetate.demo.entity.Instructor;
import com.java.hibernetate.demo.entity.Instructordetail;
import com.java.hibernetate.demo.entity.Student;

public class CreateDemo {

	
	
	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory =new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(Instructordetail.class)
								.buildSessionFactory();
		
		//create session
		
		Session session=factory.getCurrentSession();
		
		try{
			
			
			
		
			
			
			
			
			
			session.beginTransaction();
			//start a transaction
			int pid=3;
			Instructor tempInstructor=session.get(Instructor.class, pid);
			System.out.println("Found "+tempInstructor);
			
			if(tempInstructor !=null){
				System.out.println("Deleting "+tempInstructor);
			session.delete(tempInstructor);
		
			}
			//commit transaction
			
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally{
			factory.close();
			
		}
		
		
	}

}
