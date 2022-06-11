package pl.coderslab.charity.dto.user;

import pl.coderslab.charity.repository.entity.User;

public class MapperUser {

    public UserDto toUserDto(User user) {
        return new UserDto();
    }

    public User toUser(UserCreationDto userCreationDto) {
        User user = new User();
        user.setUsername(userCreationDto.getName());
        user.setPassword(userCreationDto.getPass());
        user.setMail(userCreationDto.getMail());
        user.setRoles(userCreationDto.getRole());
        user.setActive(userCreationDto.getActive());
        user.setCreated(userCreationDto.getCreated());
        user.setLastLogin(userCreationDto.getLastLogin());
        return user;
    }
}
