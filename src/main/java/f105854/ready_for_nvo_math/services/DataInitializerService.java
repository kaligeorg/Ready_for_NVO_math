package f105854.ready_for_nvo_math.services;

import constant.CorrectAnswer;
import constant.RoleType;
import constant.Topic_Class;
import f105854.ready_for_nvo_math.model.*;
import f105854.ready_for_nvo_math.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataInitializerService {
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private MassageRepository massageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LessonContentRepository lessonContentRepository;

    public DataInitializerService(PasswordEncoder passwordEncoder, TopicRepository topicRepository, TeacherRepository teacherRepository,
                                  StudentRepository studentRepository, TaskRepository taskRepository,
                                  LessonRepository lessonRepository, TestRepository testRepository,
                                  MassageRepository massageRepository, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.topicRepository = topicRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.taskRepository = taskRepository;
        this.lessonRepository = lessonRepository;
        this.testRepository = testRepository;
        this.massageRepository = massageRepository;
        this.userRepository = userRepository;
    }

    @EventListener
    public void eventListener(ApplicationReadyEvent e){
        System.out.println("Data initialization starts.");

        //Creating admin
        userRepository.save(new User(0, "Kalina", "Georgieva", "kaligeorgiewa@gmail.com",
                "kaligeorg", passwordEncoder.encode("password"), true, RoleType.ADMIN,
                null, null));

        //Creating users
        userRepository.save(new User(0, "Maya", "Stoyanova", "m_stoyanova@gmail.com",
                "m_stoyanova", passwordEncoder.encode("password"), true, RoleType.TEACHER,
                null, null));
        userRepository.save(new User(0, "Simeon", "Radev", "s_radev@gmail.com",
                "s_radev", "password", true, RoleType.TEACHER,
                null, null));
        userRepository.save(new User(0, "Tanya", "Peneva", "t_peneva@gmail.com",
                "t_peneva", "password", true, RoleType.TEACHER,
                null, null));
        userRepository.save(new User(0, "Deyan", "Georgiev", "d_georgiev@gmail.com",
                "d_georgiev", "password", true, RoleType.STUDENT,
                null, null));
        userRepository.save(new User(0, "Kamen", "Pavlov", "k_pavlov@gmail.com",
                "k_pavlov", "password", true, RoleType.STUDENT,
                null, null));
        userRepository.save(new User(0, "Maria", "Daskalova", "m_daskalova@gmail.com",
                "m_daskalova", "password", true, RoleType.STUDENT,
                null, null));

        User user1 = userRepository.findById(2).get();
        User user2 = userRepository.findById(3).get();
        User user3 = userRepository.findById(4).get();
        User user4 = userRepository.findById(5).get();
        User user5 = userRepository.findById(6).get();
        User user6 = userRepository.findById(7).get();

        //Creating teachers
        teacherRepository.save(new Teacher(0, user1));
        teacherRepository.save(new Teacher(0, user2));
        teacherRepository.save(new Teacher(0, user3));

        //Creating students
        studentRepository.save(new Student(0, user4));
        studentRepository.save(new Student(0, user5));
        studentRepository.save(new Student(0, user6));

        // Creating topics
        topicRepository.save(new Topic(0, "Statistics", "Statistics is a branch of applied mathematics that involves the " +
                "collection, description, analysis, and inference of conclusions from quantitative data.", Topic_Class.TENTH,
                null, null, null));
        topicRepository.save(new Topic(0, "Stereometry", "Stereomety deals with the measurement of " +
                "volumes and other metrical elements of solid figures.", Topic_Class.TENTH, null,
                null, null));

        Topic topic1 = topicRepository.findById(1).get();
        Topic topic2 = topicRepository.findById(2).get();

        //Creating lessons
        lessonRepository.save(new Lesson(0, "Централни тенденции - мода, медиана и средноаритметично",
                topic2, null, null));
        Lesson lesson1 = lessonRepository.findById(1).get();

        lessonRepository.save(new Lesson(0, "Права призма", topic2, null, null));
        Lesson lesson2 = lessonRepository.findById(2).get();

        lessonRepository.save(new Lesson(0, "Пирамида", topic2, null, null));
        Lesson lesson3 = lessonRepository.findById(3).get();

        //Creating content
        lessonContentRepository.save(new LessonContent(0, "Средната аритметична стойност е " +
                "сумата от индивидуалните значения на всички единици от съвкупността, разделена на техния брой.",
                null, lesson1));
        lessonContentRepository.save(new LessonContent(0, "Медианата е числовата стойност, която разделя " +
                "ранговия ред на две равни части.", null, lesson1));
        lessonContentRepository.save(new LessonContent(0, "Мода е най-често " +
                "срещаното значение на признака в съвкупността.", null, lesson1));

        lessonContentRepository.save(new LessonContent(0, "Многостен, на който две от стените " +
                "са еднакви n-ъгълници, лежащи в успоредни равнини, а останалите му стени са успоредници, се нарича " +
                "призма.", "https://www.geogebra.org/m/napybypn", lesson2));

        lessonContentRepository.save(new LessonContent(0, "Многостен, на който една от стените " +
                "е многоъгълник, а останалите му стени са триъгълници с общ връх и основи страните на многоъгълника, се " +
                "нарича пирамида.", "https://www.geogebra.org/m/hn969gab", lesson3));


        //Creating test
        testRepository.save(new Test(0, "Статистика", topic1, null));
        testRepository.save(new Test(0, "Стереометрия", topic2, null));

        Test test1 = testRepository.findById(1).get();
        Test test2 = testRepository.findById(1).get();

        //Creating tasks
        taskRepository.save(new Task(0, "Намерете средноаритметичната стойност на ред 4, 9, 10, 12, 13, 30.",
                "9", "10", "12", "13", CorrectAnswer.D, null, topic1, lesson1,
                test1));
        taskRepository.save(new Task(0, "Намерете медианата на реда 4, 9, 9, 12, 13, 18, 21.",
                "9", "10", "12", "13", CorrectAnswer.C, null, topic1, lesson1,
                test1));
        taskRepository.save(new Task(0, "Намерете медианата на реда -4, -3, -3, -2, 5, 8, 8, 56.",
                "10", "1,5", "-2", "5", CorrectAnswer.B, null, topic1, lesson1,
                test1));
        taskRepository.save(new Task(0, "Намерете модата на реда -5, -5, -2, 1, 2, 6, 9, 10, 10, 10, 14.",
                "-5", "6", "10", "14", CorrectAnswer.C, null, topic1, lesson1,
                test1));

        taskRepository.save(new Task(0, "Намерете обема на правилна четириъгълна призма с височина 8 и " +
                "повърхнина 210.", "100", "150", "200", "250", CorrectAnswer.C,
                "https://www.geogebra.org/m/mvsyschz", topic2, lesson2, test2));

        taskRepository.save(new Task(0, "Основата на триъгълна прирамида е правоъгълен триъгълник с катети " +
                "12 и 9. Ако всички околни стени сключват равни двустенни ъгли с основата и височината на пирамидата е 4, " +
                "намерете повърхнината ѝ.", "72", "144", "288", "300", CorrectAnswer.B,
                "https://www.geogebra.org/m/h3fkd8nh", topic2, lesson3, test2));
        taskRepository.save(new Task(0, "Основата на триъгълна прирамида е правоъгълен триъгълник с катети " +
                "12 и 9. Ако всички околни стени сключват равни двустенни ъгли с основата и височината на пирамидата е 4, " +
                "намерете обема ѝ.", "72", "144", "288", "300", CorrectAnswer.A,
                "https://www.geogebra.org/m/h3fkd8nh", topic2, lesson3, test2));

        System.out.println("Data initialization ends.");
    }
}
