package f105854.ready_for_nvo_math.services;

import f105854.ready_for_nvo_math.model.Massage;
import f105854.ready_for_nvo_math.repository.MassageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class MassageService {
    @Autowired
    private MassageRepository massageRepository;

    @Autowired UserService userService;
    
    public List<Massage> findAll(){
        return massageRepository.findAll();
    }

    public List<Massage> getUnansweredForms(@PathVariable("adminID") int adminID){
        return null;
    }

    public Massage findById(@PathVariable("id") int id){
        return massageRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid massage Id:" + id));
    }

    public void answerMassage(@ModelAttribute Massage form) {
        Massage massage = findById(form.getId());
        massage.setAnswered(true);
        massage.setAnswer(form.getAnswer());
        massageRepository.save(massage);
    }

    public void addMassage(@ModelAttribute Massage massage) {
        massageRepository.save(massage);
    }

    public void deleteMassage(@PathVariable("id") int id) {
        Massage massage = massageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer form Id:" + id));
        massageRepository.delete(massage);
    }
}
