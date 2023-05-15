package f105854.ready_for_nvo_math.services;

import f105854.ready_for_nvo_math.model.Student;
import f105854.ready_for_nvo_math.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        List<Student> students = studentRepository.findAll().stream().
                filter(c -> !c.isDeleted()).collect(Collectors.toList());
        return students;
    }


    public void addStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
    }


    public Student findStudentById(@PathVariable("id") int id) {
        Student student = studentRepository.findById(id).filter(c -> !c.isDeleted()).
                orElseThrow(() -> new IllegalArgumentException("Invalid customer ID: " + id));
        return student;
    }

    public void updateStudent(@ModelAttribute Student student) throws Exception {
        Student studentInDB = studentRepository.findById(student.getId()).filter(c -> !c.isDeleted()).orElse(null);
        if (studentInDB != null) {
            studentInDB.setUser(student.getUser());
            studentRepository.save(studentInDB);
        } else {
            throw new Exception("Student not found!");
        }
    }

    public void deleteStudent(@PathVariable("id") int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID: " + id));
        student.setDeleted(true);
    }
}
