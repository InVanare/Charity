package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.repository.entity.Donation;
import pl.coderslab.charity.repository.entity.User;
import pl.coderslab.charity.utility.SecurityContext;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import java.util.List;

@Service
public class DashboardService {

    private final DonationRepository donationRepository;
    private final UserRepository userRepository;
    private final SecurityContext securityContext;
    private final EntityManager entityManager;
    private final static Integer PAGE_SIZE = 5;

    @Autowired
    public DashboardService(DonationRepository donationRepository, UserRepository userRepository, EntityManager entityManager, SecurityContext securityContext) {
        this.donationRepository = donationRepository;
        this.userRepository = userRepository;
        this.entityManager = entityManager;
        this.securityContext = securityContext;
    }

    public void viewInitData(Model model, String pageString) {
        String username = securityContext.getName();
        User user = userRepository.findByUsername(username).orElseThrow(() -> new EntityExistsException("User " + username + " doesn't exist"));
        Integer page = parseStringToInt(pageString);
        Integer maxResults = donationRepository.countAllByUser(username);
        Pageable pageable = PageRequest.of(page, PAGE_SIZE, Sort.by("id").descending());

        List<Donation> donationList = donationRepository.findAllByUser(user, pageable);
        model.addAttribute("maxResult", maxResults);
        model.addAttribute("presentPage", page);
        model.addAttribute("pageList", donationList);
    }

    public Integer parseStringToInt(final String str) {
        String trimStr = str.trim();
        int result;
        try {
            result = Integer.parseInt(trimStr);
        } catch (NumberFormatException e) {
            System.out.println("Zły string: " + str);
            result = 0;
        }
        return result;
    }
}
