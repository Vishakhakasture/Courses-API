package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	@Autowired
	JdbcTemplate jtemp;
     
   @RequestMapping(value = "/courses", method = RequestMethod.POST)   
   public ResponseEntity<Object> createCourse(@RequestBody Course Course)
   {
  int x=jtemp.update("insert into courses values(?,?,?,?)",Course.getId(),Course.getTitle(),Course.getCourseCode(),Course.getDescription());
  if(x>=1)
	  return new ResponseEntity<>("Course is inserted successfully", HttpStatus.CREATED);
  else
	  return new ResponseEntity<>("Course is not inserted", HttpStatus.CREATED);
   }
   
   @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
   public ResponseEntity<Object> getCourse(@PathVariable("id") String id, @RequestBody Course course) {
   	 jtemp.update("slect * from courses where id=?",course.getTitle(),course.getCourseCode(),course.getDescription(),id);  
      return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
      }  
   
   @RequestMapping(value = "/courses/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Object> deleteCourse(@PathVariable("id") String id) { 
	  	jtemp.update("delete from courses where id=?",id);
    return new ResponseEntity<>("Course is deleted successsfully", HttpStatus.OK);
   }
   
   
   @RequestMapping(value = "/courses")
   public List<Course> getProduct() {
	   List<Course>l=new ArrayList<>();
		jtemp.query("select * from courses", new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course c=new Course();
				c.setId(rs.getString(1));
				c.setTitle(rs.getString(2));
				c.setCourseCode(rs.getString(3));
				c.setDescription(rs.getString(4));
				l.add(c);
				return c;
			}
		});
		return l; 
   }
}
