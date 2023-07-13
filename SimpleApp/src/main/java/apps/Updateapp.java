package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Emp;

public class Updateapp {

	public static void main(String[] args) {
		//create the service
				StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
								
				//read the info hibernate.cfg.xml file
				Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
								
				//actually conn to database
				SessionFactory sf = metadata.getSessionFactoryBuilder().build();
						
				//open the session
				Session session = sf.openSession();
				
				Emp e = session.get(Emp.class, 7912);
				
				if(e != null)
				{
					e.setSal(3000.00f);
					Transaction tr = session.beginTransaction();
					session.update(e);
					tr.commit();
					System.out.println("Emp updated");			
				}
				
				session.close();
				sf.close();

			

	}

}
