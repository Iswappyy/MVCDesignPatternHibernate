package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Entities.StudentEntities;

public class StudentDaoImpl implements StudentDao {
	SessionFactory factory = HibernateUtill.getSessionFactory();

	@Override
	public boolean createStudent(StudentEntities std) {
		Session session = null;
		try {
			 session = factory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(std);
			tx.commit();
			session.close();
			System.out.println("Student record save to database succesfully....");
			return true;
		} catch (Exception e) {
			System.out.println("Student record not found in DB...");
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public StudentEntities getStudentRollNum(int rollnum) {
		StudentEntities entity;
		Session session = null;
		String query = "from StudentEntities student where student.rollnum =:rollnum";
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Query q1 = session.createQuery(query);
			q1.setParameter("rollnum", rollnum);
			entity = (StudentEntities) q1.uniqueResult();
			tx.commit();
            System.out.println("Student roll number  get succesfully...");
            System.out.println(entity);
			return entity;

		} catch (Exception e) {
			System.out.println("Oops ...object not get...");
			e.printStackTrace();
			return null;

		} 
		finally {
			session.close();
		}
		

	}

	@Override
	public List<StudentEntities> listStudents() {
		List<StudentEntities> std;
		Session session = null;
		String query = "from StudentEntities";
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Query q1 = session.createQuery(query);
			List<StudentEntities> std1 = q1.list();
			for (StudentEntities student : std1) {
				System.out.println(student.getRollnum() + " : " + student.getName() + " : " + student.getAddress());
			}
			tx.commit();
			System.out.println("we got the list of student...");
			return std1;
			

		} catch (Exception e) {
			System.out.println("oops List of student not found...");
			return null;
		}

		finally {
			session.close();
		}
		
		
		

	}

	@Override
	public boolean updateStudent(int rollnum, StudentEntities std) {
		
		Session session = null;
		String q = "update StudentEntities set address =:a where rollnum =: q";
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
            Query query = session.createQuery(q);
			query.setParameter("q",rollnum);
			query.setParameter("a", std.getAddress());

			int r = query.executeUpdate();
			System.out.println("Updated...");
			System.out.println(r);
			tx.commit();

			System.out.println("update operation get succesfully completed..");
			return true;

		} catch (Exception e) {
			System.out.println("oops data not get uppdated...");
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		
	}

	@Override
	public boolean deleteStudent(int rollnum) {
		StudentEntities entity ;
		Session session = null;
		String query = "delete from StudentEntities where rollnum =: e";
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery(query);
			q.setParameter("e",rollnum);
			int r = q.executeUpdate();
			System.out.println("deleted...: ");
			System.out.println(r);
			tx.commit();
			System.out.println("Object deleted succesfully...");
			return true;

		} catch (Exception e) {
			System.out.println("Oops object not get deleted...");
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		

	}

}
