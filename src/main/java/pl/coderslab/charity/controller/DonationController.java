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
        System.out.println("Data: ----------> " + donation.getId());
        System.out.println("Data: ----------> " + donation.getQuantity());
        donation.getCategories().stream().forEach(s-> System.out.println("Data: ----------> "
                + s.getId() + " : " + s.getName()));
        System.out.println("Data: ----------> " + donation.getInstitution().getId()
                + " : " + donation.getInstitution().getName() + " : " + donation.getInstitution().getDescription());
        System.out.println("Data: ----------> " + donation.getStreet());
        System.out.println("Data: ----------> " + donation.getCity());
        System.out.println("Data: ----------> " + donation.getZipCode());
        System.out.println("Data: ----------> " + donation.getPickUpDate());
        System.out.println("Data: ----------> " + donation.getPickUpTime());
        System.out.println("Data: ----------> " + donation.getPickUpComment());
        System.out.println("Data: ----------> " + donation.getPhone());
        return "donation";
    }

}
