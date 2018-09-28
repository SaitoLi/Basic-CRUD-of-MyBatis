package com.lzz.mapper;

import java.util.List;

import com.lzz.entity.Student;
/**
 * mapper动态代理方式的CRUD（MyBatis接口开发）
 * @author CunsiALIEN
 *
 */
public interface StudentMapper {
	public abstract Student queryStudentById(int id);
	public abstract List<Student> queryAllStudent();
}
