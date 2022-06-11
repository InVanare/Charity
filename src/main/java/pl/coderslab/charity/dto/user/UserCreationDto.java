package pl.coderslab.charity.dto.user;

import pl.coderslab.charity.repository.entity.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;

public class UserCreationDto {

    @Pattern(regexp = "^(?=.*[A-Za-z])[A-Za-z\\d]{5,20}$")
    private String name;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{5,20}$")
    private String pass;

    @Email
    private String mail;

    private Boolean isActive;
    private LocalDateTime created;
    private LocalDateTime lastLogin;
    private List<Role> role;

    public UserCreationDto(String name, String pass, String mail) {
        LocalDateTime time = LocalDateTime.now();
        this.name = name;
        this.pass = pass;
        this.mail = mail;
        this.isActive = true;
        this.created = time;
        this.lastLogin = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
