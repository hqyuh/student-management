package comhqyuh.backend.service;

import comhqyuh.backend.exception.UserNotFoundException;
import comhqyuh.backend.model.Student;
import comhqyuh.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    public final StudentRepository repo;

    @Autowired
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student addStudent(Student student){
        student.setStudentCode(UUID.randomUUID().toString());
        return repo.save(student);
    }

    public List<Student> findAllStudent(){
        return repo.findAll();
    }

    public Student updateStudent(Student student){
        return repo.save(student);
    }

    public Student findStudentById(Long id){
        return repo.findStudentById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteStudent(Long id){
        repo.deleteById(id);
    }

}
