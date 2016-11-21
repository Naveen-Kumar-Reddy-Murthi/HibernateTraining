package com.mnr.main;

import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.mnr.util.SessionFactoryBuilder;

@SuppressWarnings("deprecation")
public class CallProcedure {

	public static void main(String[] args) throws HibernateException,
			SQLException {
		SessionFactory sessionFactory = SessionFactoryBuilder
				.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// Procedure Without any params

		/*
		 * PreparedStatement st =
		 * session.connection().prepareStatement("{call updateDate}");
		 * st.execute();
		 */

		// Procedure with IN and OUT params Method 1

		/*
		 * String name="naveen"; String procString = "{ call MNR_PRC(?, ?) }";
		 * String result = null; try { CallableStatement cs =
		 * session.connection().prepareCall(procString); cs.setString(1, name);
		 * cs.registerOutParameter(2, java.sql.Types.VARCHAR); cs.execute();
		 * result= cs.getString(2); System.out.println("result="+result);
		 * cs.close(); } catch(SQLException e) { e.printStackTrace(); }
		 */

		// Procedure with IN params and without OUT params using Query

		/*
		 * String name="xyz";
		 * 
		 * Query query = session.createSQLQuery("{ call  MNR_PRC(?) }"); //1
		 * query.setParameter(0, name); int result = query.executeUpdate();
		 * System.out.println("result list="+result);
		 * 
		 * Query query = session.createSQLQuery("{ call  MNR_PRC('hello') }");
		 * //2 int result2 = query.executeUpdate();
		 * System.out.println("result list="+result2); session.close();
		 */

		// Procedure with IN and OUT params using Query

		Query query = session.getNamedQuery("MNR_PRC");
		query.setString("param1", "1");
		Object result = query.uniqueResult();
		System.out.print(result);

	}
}
