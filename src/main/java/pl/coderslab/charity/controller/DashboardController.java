package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.service.DashboardService;

@Controller
public class DashboardController {

    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/my_donations")
    public String viewMyDonations(Model model, @RequestParam(defaultValue = "0") String page) {
        dashboardService.viewInitData(model, page);
        return "myDonations";
    }

    @GetMapping("/profile")
    public String viewProfile() {
        return "profile";
    }

    @GetMapping("/admin/dashboard")
    public String viewDashboard() {
        return "dashboard";
    }
}