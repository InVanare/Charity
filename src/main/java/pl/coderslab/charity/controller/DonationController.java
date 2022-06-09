package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.repository.entity.Donation;
import pl.coderslab.charity.service.DonationService;

@Controller
@RequestMapping("/donation")
public class DonationController {

    private final DonationService donationService;

    @Autowired
    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @GetMapping("")
    public String donationAction(Donation donation, Model model) {
        donationService.displayInitData(model);
        return "donation";
    }

    @PostMapping("")
    public String donationFormSave(Donation donation) {
        donationService.save(donation);
        return "form-confirmation";
    }

}
