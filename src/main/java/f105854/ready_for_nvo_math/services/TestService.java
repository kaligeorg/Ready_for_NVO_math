package f105854.ready_for_nvo_math.services;

import f105854.ready_for_nvo_math.model.Lesson;
import f105854.ready_for_nvo_math.model.Test;
import f105854.ready_for_nvo_math.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    public List<Test> findAll() {
        List<Test> tests = testRepository.findAll();
        return tests;
    }

    public void addTest(@ModelAttribute Test test) {
        testRepository.save(test);
    }

    public Test findTestById(@PathVariable("id") int id) {
        Test test = testRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid test ID: " + id));
        return test;
    }

    public List<Test> findTestsByTopic(@PathVariable("id") int id){
        List<Test> tests = testRepository.findAll();
        List<Test> testsInTopic = new ArrayList<Test>();
        for(Test test : tests){
            if(test.getTestsTopic().getId() == id)
                testsInTopic.add(test);
        }
        return testsInTopic;
    }

    public void updateTest(@ModelAttribute Test test) throws Exception {
        Test testInDB = testRepository.findById(test.getId()).orElse(null);
        if (testInDB != null) {
            testInDB.setTitle(test.getTitle());
            testInDB.setTestsTopic(test.getTestsTopic());
            testInDB.setTasks(test.getTasks());
            testRepository.save(testInDB);
        } else {
            throw new Exception("Test not found!");
        }
    }


    public void deleteTest(@PathVariable("id") int id) {
        Test test = testRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid test ID: " + id));
        testRepository.delete(test);
    }
}
