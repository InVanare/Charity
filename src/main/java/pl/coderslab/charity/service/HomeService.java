package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.repository.entity.Institution;

@Service
public class HomeService {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    @Autowired
    public HomeService(InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    public void displayInitData(Model model) {
        Iterable<Institution> institutionList = institutionRepository.findAll();
        model.addAttribute("countBags", donationRepository.sumAllQuantity());
        model.addAttribute("countDonations", donationRepository.countAll());
        model.addAttribute("institutions", institutionList);
    }
}
