package apps;

import entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.*;

public class SaveMasterChild {

	public static void main(String[] args) {
		//create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
						
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
						
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();	

		Session session = sf.openSession();	// TODO Auto-generated method stub
		
		//========================================================
		//master is saved separately
		
		/*Order o1= new Order("xxx");
		
		Transaction tr =session.beginTransaction();
		
		session.save(o1);
		
		tr.commit();

		*/
		
		//========================================================
		//child is saved separately for existing master
		
		/*OrderItem oi1 = new OrderItem(3, 5, session.get(Order.class, 10));
		
		Transaction tr =session.beginTransaction();
		
		session.save(oi1);
		
		tr.commit();
		*/
		
		//==============================================================
		
		//saving new master along with its children
		//cascade annotation
		//iterate the child collection and assign this for every child
		Product p1 = new Product("Parle-g",500);
		Product p2 = new Product("Head&Shoulder",350);
		Set<Product> items = new HashSet();
		items.add(p1);
		items.add(p2);
		
		
		Category c2 = new Category("fmcg","Food products",items);
		//c2.setItems(items);
		
		Transaction tr =session.beginTransaction();
		
		
		session.save(c2);
		
		tr.commit();
		
		session.close();
		
		sf.close();
		

	}

}
