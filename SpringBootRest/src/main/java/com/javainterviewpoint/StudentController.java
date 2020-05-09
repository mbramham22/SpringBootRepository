package com.javainterviewpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController
{
       @Autowired
    StudentRepository studentRepository;
    //Create
    @RequestMapping(value = "/insertStudent", method = RequestMethod.POST)
    public Student createStudent(@RequestBody Student student)
    {
        return studentRepository.save(student);
    }
    
    //Read
    @RequestMapping(value="/getStudent/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable long id)
    {
		System.out.println("id :"+id);
        return studentRepository.findOne(id);
    }
    
    @RequestMapping(value="/getAllStudent", method = RequestMethod.GET)
    public List<Student> getAllStudents()
    {
        return (List<Student>)studentRepository.findAll();
    }
    
    //Update
    @RequestMapping(value = "/upStudent", method = RequestMethod.PUT)
    public Student updateStudent(@RequestBody Student student)
    {
        return studentRepository.save(student);
    }
    
    //Delete
    @RequestMapping(value = "/delStudent/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable long id)
    {
        studentRepository.delete(id);
    }
}
