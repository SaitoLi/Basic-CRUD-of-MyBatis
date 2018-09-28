package com.lzz.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lzz.entity.Student;

public class Test {
	public static void main(String[] args) throws IOException {
		queryAllStudent();
		deleteStudentById(2);
		queryAllStudent();
		queryStudentById(3);
		Student student1 = new Student(2,"关羽",22 , 93);
		addStudent(student1);
		queryAllStudent();
		deleteStudentById(3);
		queryAllStudent();
		Student student2 = new Student();
		student2.setId(2);
		student2.setStuName("诸葛亮");
		student2.setAge(24);
		student2.setScore(100);
		updateStudentById(student2);
		queryAllStudent();
	}
	
	public static void queryStudentById(int id) throws IOException {
		Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//session -- connection
		SqlSession session = sessionFactory.openSession();
		String statement = "com.lzz.entity.studentMapper.queryStudentById";
		Student student = session.selectOne(statement,id);
		session.commit();
		System.out.println(student);
		session.close();
	}
	
	public static void queryAllStudent() throws IOException {
		Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//session -- connection
		SqlSession session = sessionFactory.openSession();
		String statement = "com.lzz.entity.studentMapper." + "queryAllStudent";
		List<Student> student = session.selectList(statement);
		session.commit();
		System.out.println(student);
		session.close();
	}
	
	public static void addStudent(Student student) throws IOException {
		Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//session -- connection
		SqlSession session = sessionFactory.openSession();
		String statement = "com.lzz.entity.studentMapper." + "addStudent";
		int count = session.insert(statement,student);
		session.commit();
		System.out.println("添加" + count + "个学生");
		session.close();
	}
	
	public static void deleteStudentById(int id) throws IOException {
		Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//session -- connection
		SqlSession session = sessionFactory.openSession();
		String statement = "com.lzz.entity.studentMapper." + "deleteStudentById";
		int count = session.delete(statement,id);
		session.commit();
		System.out.println("删除" + count + "个学生");
		session.close();
	}
	
	public static void updateStudentById(Student student) throws IOException {
		Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//session -- connection
		SqlSession session = sessionFactory.openSession();
		String statement = "com.lzz.entity.studentMapper." + "updateStudentById";
		int count = session.delete(statement,student);
		session.commit();
		System.out.println("修改" + count + "个学生信息");
		session.close();
	}
}
