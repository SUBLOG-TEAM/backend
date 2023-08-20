package whatever.sublog.enrollment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/enrollments")
@CrossOrigin("*")
@RestController
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

}
