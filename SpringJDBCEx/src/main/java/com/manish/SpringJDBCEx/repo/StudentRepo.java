package com.manish.SpringJDBCEx.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.manish.SpringJDBCEx.model.Student;

@Repository
public class StudentRepo {
	
	private JdbcTemplate jdbc;
	
	public JdbcTemplate getJdbc() {
		return jdbc;
	}
	
	@Autowired
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public void save(Student st) {
		String sql = "insert into students values (?, ?, ?)";
		int row =jdbc.update(sql, st.getRoll(), st.getName(), st.getMarks());
		System.out.println("Saved to dataBase "+row);
	}

	public List<Student> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from students";
		
		//RowMapper will iterate over each row of result set and will return the object
		// and this objects will be passed to jdbc template as select query will return objects
		RowMapper<Student> mapper = new RowMapper<Student>() {
			
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Student st = new Student();
				st.setRoll(rs.getInt("rollno"));
				st.setName(rs.getString("name"));
				st.setMarks(rs.getInt("marks"));
				return st;
			}
		};
		
		
		return jdbc.query(sql, mapper);
	}
}
