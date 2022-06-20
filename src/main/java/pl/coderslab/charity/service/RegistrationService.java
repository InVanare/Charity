package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.coderslab.charity.dto.Mapper;
import pl.coderslab.charity.dto.user.UserCreationDto;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;

import java.util.List;

@Service
public class RegistrationService {

    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private Mapper mapper;
    private EmailService emailService;

    private final static String INFO_OK = "Dziękujemy za założenie konta.";
    private final static String INFO_ERROR_USER_EXIST = "Przepraszamy, użytkownik o podanych danych już istnieje.";

    @Autowired
    public RegistrationService(RoleRepository roleRepository,
                               UserRepository userRepository,
                               Mapper mapper,
                               EmailService emailService) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.emailService = emailService;
    }

    public void saveData(UserCreationDto userCreationDto, Model model) {
        userCreationDto.setRole(List.of(roleRepository.findByName("ROLE_USER").orElseThrow(RuntimeException::new)));
        if (userRepository.findByUsernameOrMail(userCreationDto.getName(), userCreationDto.getMail()).isEmpty()) {
            userRepository.save(mapper.toUser(userCreationDto));
            model.addAttribute("information", INFO_OK);
            model.addAttribute("username", userCreationDto.getName());
            emailService.sendMessageFromTemplate(userCreationDto.getMail(),
                    "Utworzenie konta w \"Oddam w dobre ręce\"",
                    "email-registration.ftlh",
                    model.asMap());
        } else {
            model.addAttribute("information", INFO_ERROR_USER_EXIST);
        }
    }
}
