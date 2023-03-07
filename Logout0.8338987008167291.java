·       User should be logged out after clicking on logout button.
·       User should be redirected to login page after logout.

Controller:

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {
    
    @GetMapping
    public String logout() {
        // Code for logging out the user
        return "redirect:/login";
    }
}

Service:

import org.springframework.stereotype.Service;

@Service
public class LogoutService {

    public void logout() {
        // Code for logging out the user
    }
}

Repository:

import org.springframework.data.jpa.repository.JpaRepository;

public interface LogoutRepository extends JpaRepository<Logout, Long> {

}