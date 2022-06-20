package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.repository.entity.Category;
import pl.coderslab.charity.repository.entity.Donation;
import pl.coderslab.charity.repository.entity.Institution;
import pl.coderslab.charity.repository.entity.User;
import pl.coderslab.charity.utility.SecurityContext;

import javax.persistence.EntityExistsException;

@Service
public class DonationService {

    private final DonationRepository donationRepository;
    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final UserRepository userRepository;
    private final SecurityContext securityContext;
    private final EmailService emailService;

    @Autowired
    public DonationService(DonationRepository donationRepository,
                           CategoryRepository categoryRepository,
                           InstitutionRepository institutionRepository,
                           UserRepository userRepository,
                           SecurityContext securityContext,
                           EmailService emailService) {
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.userRepository = userRepository;
        this.securityContext = securityContext;
        this.emailService = emailService;
    }

    public void displayInitData(Model model) {
        Iterable<Category> categoryIterable = categoryRepository.findAll();
        Iterable<Institution> institutionIterable = institutionRepository.findAll();
        model.addAttribute("categories", categoryIterable);
        model.addAttribute("institutions", institutionIterable);
    }

    public void save(Donation donation, Model model) {
        String username = securityContext.getName();
        User user = userRepository.findByUsername(username).orElseThrow(() -> new EntityExistsException("User " + username + " doesn't exist"));
        donation.setUser(user);
        donationRepository.save(donation);
        model.addAttribute("donation", donation);
        model.addAttribute("username", username);
        emailService.sendMessageFromTemplate(user.getMail(),
                "Przekazanie darów",
                "email-donation.ftlh",
                model.asMap());
    }
}
