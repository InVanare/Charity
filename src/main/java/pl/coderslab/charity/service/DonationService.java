package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.repository.entity.Category;
import pl.coderslab.charity.repository.entity.Donation;
import pl.coderslab.charity.repository.entity.Institution;

@Service
public class DonationService {

    private final DonationRepository donationRepository;
    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;

    @Autowired
    public DonationService(DonationRepository donationRepository, CategoryRepository categoryRepository, InstitutionRepository institutionRepository) {
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
    }

    public void displayInitData(Model model) {
        Iterable<Category> categoryIterable = categoryRepository.findAll();
        Iterable<Institution> institutionIterable = institutionRepository.findAll();
        model.addAttribute("categories", categoryIterable);
        model.addAttribute("institutions", institutionIterable);
    }

    public void save(Donation donation) {
        donationRepository.save(donation);
    }
}
