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
public class CourseInstanceController {
	@Autowired
	JdbcTemplate jtemp;
  
     
   @RequestMapping(value = "/courses", method = RequestMethod.POST)   
   public ResponseEntity<Object> createCourseInstance(@RequestBody CourseInstance course)
   {
  int x=jtemp.update("insert into courseinstances values(?,?,?,?)",course.getId(),course.getTitle(),course.getCourseId(),course.getYear(),course.getSemester());
  if(x>=1)
	  return new ResponseEntity<>("Course is inserted successfully", HttpStatus.CREATED);
  else
	  return new ResponseEntity<>("Course is not inserted", HttpStatus.CREATED);
   }   
   
   @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
   public ResponseEntity<Object> getCourseInstance(@PathVariable("id") String id, @RequestBody CourseInstance course) {
   	 jtemp.update("slect * from courseinstances where year=? and semester=?",course.getTitle(),course.getCourseId(),course.getYear(),course.getSemester(),"year","semester");  
      return new ResponseEntity<>("Course instances ", HttpStatus.OK);
      }  
   
   @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
   public ResponseEntity<Object> getCourseDetails(@PathVariable("id") String id, @RequestBody CourseInstance course) {
   	 jtemp.update("slect * from courseinstances where id=? and year=? and semester=?",course.getTitle(),course.getCourseId(),course.getYear(),course.getSemester(),id,"year","semester");  
      return new ResponseEntity<>("Course instances ", HttpStatus.OK);
      }  
   
   @RequestMapping(value = "/courses/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Object> deleteCourseInstance(@PathVariable("id") String id, String year, String semester) { 
	  	jtemp.update("delete from courseinstances where id=? and year=? and semester=?",id,"year","semester");
    return new ResponseEntity<>("Course instance is deleted successsfully", HttpStatus.OK);
   }
   
   
   @RequestMapping(value = "/courses")
   public List<CourseInstance> getProduct() {
	   List<CourseInstance>l=new ArrayList<>();
		jtemp.query("select * from courses", new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				CourseInstance c=new CourseInstance();
				c.setId(rs.getString(1));
				c.setTitle(rs.getString(2));
				c.setCourseId(rs.getString(3));
				c.setYear(rs.getString(4));
				c.setSemester(rs.getString(5));
				l.add(c);
				return c;
				
			}
		});
		return l; 
   }
}

