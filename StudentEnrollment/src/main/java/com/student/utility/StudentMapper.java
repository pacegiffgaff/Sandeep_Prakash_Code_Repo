package com.student.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.student.model.Student;
	
public class StudentMapper implements RowMapper<Student> {
	
	
	   public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
	      Student student = new Student();
	      student.setStudentId(rs.getString("studentId"));
	      student.setStudentName((rs.getString("studentName")));
	      student.setStudentMarks((rs.getInt("studentMarks")));
	      
	      return student;
	   }
	}
