package com.example.springboot.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//controller class have all  resources for our api
//api layer
@RestController
@RequestMapping(path = "api/v1/student")
//make this class to get rest end point
public class StudentController {


    //we have to say that this StudentService is has to be spring bean
    // the StudentController has a dependency on a StudentService
    private final StudentService studentService;

    @Autowired
    //in here we are saying that this StudentService should be auto wired for us
    //so this will be magically instancite for us
    //and inject to this constructor
    //Autowiring feature of spring framework enables you to inject the object dependency implicitly. It internally uses setter or constructor injection. Autowiring can't be used to inject primitive and string values. It works with reference only.
// a constructor so that the Spring container can inject a studentService
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    //get the requestbody and map in to the student
    @PostMapping
    public void registerNewStudent(@RequestBody  Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void  deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
        @PathVariable("studentId") Long studentId,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String email){
            studentService.updateStudent(studentId,name,email);
        }
}
