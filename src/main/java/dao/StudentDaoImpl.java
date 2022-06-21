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
		try {
			Session session = factory.openSession();
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
			HibernateUtill.close();
		}
	}

	@Override
	public StudentEntities getStudentRollNum(int rollnum) {
		Session session = null;
		StudentEntities entity;
		String query = "from StudentEntities student where student.rollnum =:rollnum";
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Query<StudentEntities> q1 = session.createQuery(query);
			q1.setParameter("rollnum", rollnum);
			entity = q1.uniqueResult();
			tx.commit();
            System.out.println("Student roll number  get succesfully...");
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
		Session session = null;
		List<StudentEntities> entity = null;
		String query = "from StudentEntities";
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Query q1 = session.createQuery(query);
			List<StudentEntities> std = q1.list();
			for (StudentEntities student : std) {
				System.out.println(student.getRollnum() + " : " + student.getName() + " : " + student.getAddress());
			}
			tx.commit();
			System.out.println("we got the list of student...");
			return entity;

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
		StudentEntities entity;
		Query q = session.createQuery("update StudentEntities set address =:a where rollnum =: q");
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();

			q.setParameter("a", "Nasik");
			q.setParameter("q", 100);

			int r = q.executeUpdate();
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
		Session session = null;
		StudentEntities entity = new StudentEntities();
		Query q = session.createQuery("delete from Student1 where rollnum =: e");
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			q.setParameter("e", 100);
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
