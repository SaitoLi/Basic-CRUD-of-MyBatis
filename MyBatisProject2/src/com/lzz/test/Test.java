package com.lzz.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lzz.entity.Student;
import com.lzz.mapper.StudentMapper;

public class Test {
	public static void main(String[] args) throws IOException {
		queryStudentById(1);
	}
	
	public static void queryStudentById(int id) throws IOException {
		Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//session -- connection
		SqlSession session = sessionFactory.openSession();
		
		//CRUD基础方式
//		String statement = "com.lzz.entity.studentMapper.queryStudentById";
//		Student student = session.selectOne(statement,id);
		
		//MyBatis支持mapper动态代理方式的CRUD（方便直接定位SQL语句）
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student student = studentMapper.queryStudentById(id);
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
