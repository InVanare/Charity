package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.repository.entity.Institution;

@Service
public class HomeService {

    private final InstitutionRepository institutionRepository;

    @Autowired
    public HomeService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public void viewInstitutions(Model model) {
        Iterable<Institution> institutionList = institutionRepository.findAll();
        model.addAttribute("institutions", institutionList);
    }
}
