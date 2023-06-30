package f105854.ready_for_nvo_math.services;

import f105854.ready_for_nvo_math.repository.TestRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestServiceTest {
    @Autowired
    TestService testService;
    @Autowired
    TestRepository testRepository;
    @Autowired
    TopicService topicService;

    @Test
    void addTest() {
        f105854.ready_for_nvo_math.model.Test test = new f105854.ready_for_nvo_math.model.Test(0, "Пирамида", null, null);
        testService.addTest(test);
        Assertions.assertEquals(testService.findAll().size(), 3);
    }

    @Test
    void updateTest() throws Exception{
        f105854.ready_for_nvo_math.model.Test test = new f105854.ready_for_nvo_math.model.Test(2, "Пирамида", topicService.findTopicById(2), null);
        testService.updateTest(test);
        Assertions.assertEquals("Пирамида", testService.findTestById(2).getTitle());
    }

    @Test
    void deleteTest() {
        f105854.ready_for_nvo_math.model.Test test = testRepository.save(new f105854.ready_for_nvo_math.model.Test(2, "Пирамида", topicService.findTopicById(2), null));
        testService.deleteTest(test.getId());
        Assertions.assertFalse(testService.findAll().contains(test));
    }
}