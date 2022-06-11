package pl.coderslab.charity.dto;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.dto.user.MapperUser;
import pl.coderslab.charity.dto.user.UserCreationDto;
import pl.coderslab.charity.dto.user.UserDto;
import pl.coderslab.charity.repository.entity.User;

@Component
public class Mapper {

    private final MapperUser mapperUser;

    public Mapper() {
        this.mapperUser = new MapperUser();
    }

    public UserDto toUserDto(User user) {
        return mapperUser.toUserDto(user);
    }

    public User toUser(UserCreationDto userCreationDto) {
        return mapperUser.toUser(userCreationDto);
    }
}
