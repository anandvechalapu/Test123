·       Logout button should logout the user from the application.
·       After successful logout, user should be redirected to login screen.

Spring Boot Application with Controller, Service and Repository Classes: 

Controller: 
@Controller
public class LogoutController {

    @Autowired
    private LogoutService logoutService;

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(HttpServletRequest request) {
        logoutService.logout(request);
        return "redirect:/login";
    }
}

Service: 
@Service
public class LogoutService {

    @Autowired
    private LogoutRepository logoutRepository;

    public void logout(HttpServletRequest request) {
        logoutRepository.logout(request);
    }
}

Repository: 
@Repository
public class LogoutRepository {

    public void logout(HttpServletRequest request) {
        request.getSession().invalidate();
    }
}