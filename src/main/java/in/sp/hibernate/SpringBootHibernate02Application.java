package in.sp.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.sp.hibernate.entities.User;

@SpringBootApplication
public class SpringBootHibernate02Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernate02Application.class, args);
		Configuration cfg = new Configuration();
		cfg.configure("in/sp/hibernate/config/hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();

//		
//		User user = session.get(User.class, 2L);
//		System.out.println("ID: "+user.getId());
//		System.out.println("Name: "+user.getName());
//		System.out.println("Email: "+user.getEmail());
//		System.out.println("Password: "+user.getPassword());
//		System.out.println("Gender: "+user.getGender());
//		System.out.println("City: "+user.getCity());

//		USE WIH TRY CATCH BLOCK --------------------------------------->

		try {
			User user = session.get(User.class, 1L);

			if (user != null) {
				System.out.println("ID: " + user.getId());
				System.out.println("Name: " + user.getName());
				System.out.println("Email: " + user.getEmail());
				System.out.println("Password: " + user.getPassword());
				System.out.println("Gender: " + user.getGender());
				System.out.println("City: " + user.getCity());
			} else {
				System.out.println("User Not found!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
