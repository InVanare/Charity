package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.coderslab.charity.dto.UserCreationDto;

@Service
public class RegistrationService {

    public void savaData(UserCreationDto userCreationDto, Model model) {
        System.out.println(userCreationDto.getName());
        System.out.println(userCreationDto.getPass());
        System.out.println(userCreationDto.getMail());
        System.out.println(userCreationDto.getActive());
        System.out.println(userCreationDto.getCreated());
        System.out.println(userCreationDto.getLastLogin());
        userCreationDto.getRole().stream().forEach(System.out::println);
    }
}
