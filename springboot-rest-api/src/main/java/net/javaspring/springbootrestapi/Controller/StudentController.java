package net.javaspring.springbootrestapi.Controller;

import net.javaspring.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    //http://localhost:8080/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student =new Student(
                1,
                "Ramesh",
                "Kumar"

        );

        //return new ResponseEntity<>(student, HttpStatus.OK);

        return ResponseEntity.ok()
                .header("custom-header","Kaka")
                .body(student);

    }
    //http://localhost:8080/students

    @GetMapping ("students")
    public List<Student> getStudents(){

        List<Student> students =new ArrayList<>();
        students.add(new Student(1,"Ramesh","kumar"));
        students.add(new Student(2,"Suresh","kumar"));
        students.add(new Student(3,"Rakesh","kumar"));
        students.add(new Student(4,"Prakash","kumar"));
        return students;


    }

    //Spring BOOT REST API path Variable
    //{id} - URI template variable
    //http://localhost:8080/students/1
    @GetMapping("students/{id}")
    public Student StudentPathVariable(@PathVariable int id){
        return new Student(id,"Ramesh", "Kumar");

    }

    //Spring BOOT REST API Request PARAM
    // http://localhost:8080/student/query?id=1

    @GetMapping("student/query")
    public Student StudentRequestVariable(@RequestParam  int id){
         return new Student(id, "Ramesh","Kumar");

    }

// Spring boot REST API that handles HTTP POST Request
    //@PostMapping and @RequestBody

    @PostMapping("Student/Create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){

        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastname());
        return student;
    }

    // Spring boot REST API that handles HTTP PUT Request -updating existing resource
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastname());
        return student;


    }
    // Spring boot REST API that handles HTTP DELETE Request -deleting existing resource
    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
            System.out.println(studentId);
        return "Student deleted successfully";
    }



}
