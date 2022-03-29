package com.java.hibernetate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernetate.demo.entity.Instructor;
import com.java.hibernetate.demo.entity.Instructordetail;
import com.java.hibernetate.demo.entity.Student;

public class DeleteDemo {

	
	
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
			
			
			
			//create the object
			Instructor tempInstructor=
					new Instructor("kiran", "pal","kiran@gmail.com");
			
			Instructordetail tempInstructorDetail=
					new Instructordetail("www.youtube.com", "Guitar");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.beginTransaction();
			//start a transaction
			
			System.out.println("Save"+tempInstructor);
			session.save(tempInstructor);
		
			
			//commit transaction
			
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally{
			factory.close();
			
		}
		
		
	}

}
