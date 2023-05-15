package f105854.ready_for_nvo_math.services;

import f105854.ready_for_nvo_math.model.Teacher;
import f105854.ready_for_nvo_math.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> findAll(Model model) {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers;
    }

    public void addTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherRepository.save(teacher);
    }


    public Teacher findTeacherById(@PathVariable("id") int id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid teacher ID:" + id));
        return teacher;
    }


    public void updateTeacher(@ModelAttribute Teacher teacher) throws Exception {
        Teacher teacherInDB = teacherRepository.findById(teacher.getId()).orElse(null);
        if (teacherInDB != null) {
            teacherInDB.setUser(teacher.getUser());
            teacherRepository.save(teacher);
        } else {
            throw new Exception("Teacher not found!");
        }
    }


    public void deleteTeacher(@PathVariable("id") int id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher ID:" + id));
        teacherRepository.delete(teacher);
    }
}
