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

    private final static String INFO_OK = "Dziękujemy za założenie konta.";
    private final static String INFO_ERROR_USER_EXIST = "Przepraszamy, użytkownik o podanych danych już istnieje.";

    @Autowired
    public RegistrationService(RoleRepository roleRepository, UserRepository userRepository, Mapper mapper) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public void saveData(UserCreationDto userCreationDto, Model model) {
        userCreationDto.setRole(List.of(roleRepository.findByName("ROLE_USER").orElseThrow(RuntimeException::new)));
        if (userRepository.findByUsernameOrMail(userCreationDto.getName(), userCreationDto.getMail()).isEmpty()) {
            userRepository.save(mapper.toUser(userCreationDto));
            model.addAttribute("information", INFO_OK);
        } else {
            model.addAttribute("information", INFO_ERROR_USER_EXIST);
        }
       /* System.out.println(userCreationDto.getName());
        System.out.println(userCreationDto.getPass());
        System.out.println(userCreationDto.getMail());
        System.out.println(userCreationDto.getActive());
        System.out.println(userCreationDto.getCreated());
        System.out.println(userCreationDto.getLastLogin());
        //userCreationDto.getRole().stream().forEach(System.out::println);*/
    }
}
