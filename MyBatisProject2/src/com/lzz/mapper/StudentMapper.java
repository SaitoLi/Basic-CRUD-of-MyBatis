package com.lzz.mapper;

import java.util.List;

import com.lzz.entity.Student;
/**
 * mapper��̬����ʽ��CRUD��MyBatis�ӿڿ�����
 * @author CunsiALIEN
 *
 */
public interface StudentMapper {
	public abstract Student queryStudentById(int id);
	public abstract List<Student> queryAllStudent();
}
