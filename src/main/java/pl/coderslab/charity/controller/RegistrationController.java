package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dto.user.UserCreationDto;
import pl.coderslab.charity.service.RegistrationService;

@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/registration")
    public String userRegister(UserCreationDto userCreationDto) {
        return "registration";
    }

    @PostMapping("/registration")
    public String sendUserData(UserCreationDto userCreationDto, Model model) {
        registrationService.savaData(userCreationDto, model);
        return "registration-confirmation";
    }
}
