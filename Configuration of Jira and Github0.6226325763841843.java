
Controller

@Controller
public class ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;

    @RequestMapping("/configuration")
    public String getConfiguration(Model model) {
        model.addAttribute("services", configurationService.getAvailableServices());
        return "configuration";
    }

    @RequestMapping("/configure")
    public String configureService(@RequestParam("service") String service, @RequestParam("jira") String jira, @RequestParam("github") String github, Model model) {
        configurationService.configureService(service, jira, github);
        model.addAttribute("message", "Configuration successful!");
        return "configuration";
    }
}

Service

@Service
public class ConfigurationService {

    private Map<String, String> configuration = new HashMap<>();

    public List<String> getAvailableServices() {
        // Return list of available services
    }

    public void configureService(String service, String jira, String github) {
        configuration.put("service", service);
        configuration.put("jira", jira);
        configuration.put("github", github);
    }
}

Repository

@Repository
public class ConfigurationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveConfiguration(Map<String, String> configuration) {
        // Save configuration to database
    }

    public Map<String, String> getConfiguration(String service) {
        // Return configuration data from database
    }
}