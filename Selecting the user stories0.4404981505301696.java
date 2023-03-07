
Generated Spring Boot application with controller, service and repository classes:

Controller: 

@RestController
@RequestMapping("/select-user-stories")
public class SelectUserStoriesController {

    private final SelectUserStoriesService selectUserStoriesService;

    @Autowired
    public SelectUserStoriesController(SelectUserStoriesService selectUserStoriesService) {
        this.selectUserStoriesService = selectUserStoriesService;
    }

    @GetMapping
    public ResponseEntity<Projects> getProjects() {
        return ResponseEntity.ok(selectUserStoriesService.getProjects());
    }

    @PostMapping
    public ResponseEntity<Projects> getProjectsByOrganization(@RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(selectUserStoriesService.getProjectsByOrganization(projectRequest));
    }

}

Service:

@Service
public class SelectUserStoriesService {

    private final SelectUserStoriesRepository selectUserStoriesRepository;

    @Autowired
    public SelectUserStoriesService(SelectUserStoriesRepository selectUserStoriesRepository) {
        this.selectUserStoriesRepository = selectUserStoriesRepository;
    }

    public Projects getProjects() {
        return selectUserStoriesRepository.getProjects();
    }

    public Projects getProjectsByOrganization(ProjectRequest projectRequest) {
        return selectUserStoriesRepository.getProjectsByOrganization(projectRequest);
    }

}

Repository:

@Repository
public class SelectUserStoriesRepository {

    private final RestTemplate restTemplate;

    @Autowired
    public SelectUserStoriesRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Projects getProjects() {
        return restTemplate.getForObject("/projects", Projects.class);
    }

    public Projects getProjectsByOrganization(ProjectRequest projectRequest) {
        return restTemplate.postForObject("/projects/organization", projectRequest, Projects.class);
    }

}