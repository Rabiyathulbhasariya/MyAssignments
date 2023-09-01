package org.student;

import org.college.College;
import org.department.Department;

public class Student {

	public void studentName()
	{
		System.out.println("Name - Rabiya");
	}

	public void studentDept()
	{
		System.out.println("Student Dept - Civil");
	}

	public void studentId()
	{
		System.out.println("id - 2509");
	}


	public static void main(String[] args) {
		College col = new College();
		col.collegeName();
		col.collegeCode();
		col.collegeRank();
		Department dept = new Department();
		dept.deptName();
		Student stu = new Student();
		stu.studentName();
		stu.studentDept();
		stu.studentId();

	}

}
