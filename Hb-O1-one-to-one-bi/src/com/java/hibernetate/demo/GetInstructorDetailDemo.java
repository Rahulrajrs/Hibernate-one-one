package com.java.hibernetate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernetate.demo.entity.Instructor;
import com.java.hibernetate.demo.entity.Instructordetail;
import com.java.hibernetate.demo.entity.Student;

public class GetInstructorDetailDemo {

	
	
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
			// get instructor detail object
			
			int theId=2;
			Instructordetail theInstructordetail=
					session.get(Instructordetail.class, theId);
			
			System.out.println(theInstructordetail);
			
			System.out.println("Associated Instructor"+theInstructordetail.getInstructor());
			
			session.getTransaction().commit();
			System.out.println("Done");
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		finally{
			session.close();
			factory.close();
			
		}
		
		
	}

}
