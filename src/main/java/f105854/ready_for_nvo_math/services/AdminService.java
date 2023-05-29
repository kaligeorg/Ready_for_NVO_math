package f105854.ready_for_nvo_math.services;

import f105854.ready_for_nvo_math.model.Admin;
import f105854.ready_for_nvo_math.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> findAll(Model model) {
        List<Admin> admins = adminRepository.findAll();
        return admins;
    }

    public void addAdmin(@ModelAttribute("admin") Admin admin) {
        adminRepository.save(admin);
    }


    public Admin findAdminById(@PathVariable("id") int id) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid admin ID:" + id));
        return admin;
    }


    public void updateAdmin(@ModelAttribute Admin admin) throws Exception {
        Admin adminInDB = adminRepository.findById(admin.getId()).orElse(null);
        if (adminInDB != null) {
            adminInDB.setUser(admin.getUser());
            adminRepository.save(admin);
        } else {
            throw new Exception("Admin not found!");
        }
    }


    public void deleteAdmin(@PathVariable("id") int id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid admin ID:" + id));
        adminRepository.delete(admin);
    }
}
