package pl.coderslab.charity.utility;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecurityContext {

    public String getName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public List<GrantedAuthority> getAuthorities() {
        return (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }
}
