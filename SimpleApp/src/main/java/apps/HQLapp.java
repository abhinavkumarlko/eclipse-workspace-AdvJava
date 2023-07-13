package apps;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import entities.Emp;

public class HQLapp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		//create the service
				StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
								
				//read the info hibernate.cfg.xml file
				Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
								
				//actually conn to database
				SessionFactory sf = metadata.getSessionFactoryBuilder().build();
						
				//open the session
				Session session = sf.openSession();
		
			/*	Query q= session.createQuery("from Emp");
				List<Emp> emps=q.getResultList();
		
				for(Emp e: emps)
				System.out.println(e.getEmpid()+":"+e.getEname()+":"+e.getSal());
			*/
				
			/*	Query<Object[]> q=session.createQuery("select empno,ename from Emp where deptno=30",Object[].class);
				
				List<Object[]> emps= q.getResultList();
				
					for(Object[] emp: emps)
					System.out.println(emp[0]+":"+emp[1]);
				*/
				
			/*	Query<Object[]> q= session.createNamedQuery("getBySal");
				q.setParameter("min", 1000.0f);
				q.setParameter("max", 4000.0f);
				
				List<Object[]> emps=q.getResultList();
				
				for(Object[] emp: emps)
					System.out.println(emp[0]+":"+emp[1]);
					*/
				
				/*
				//native Query
				Query q=session.createNativeQuery("select * from emptemp where sal>3000 ");
						List<Object[]> emps= q.getResultList();
						
						for(Object[] emp: emps)
						System.out.println(emp[0]+":"+emp[1]);
						*/
//				UPDATE Customers
//				SET ContactName = 'Alfred Schmidt', City= 'Frankfurt'
//				WHERE CustomerID = 1;
				
				Query q=session.createQuery("UPDATE Emp set sal= :sal where empno=:no");
				List<Object[]> emps= q.getResultList();
				
				for(Object[] emp: emps)
				System.out.println(emp[0]+":"+emp[1]);
				
	}

}
