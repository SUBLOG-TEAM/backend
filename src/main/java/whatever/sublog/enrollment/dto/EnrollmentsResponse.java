package whatever.sublog.enrollment.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EnrollmentsResponse {

    private Integer prevCursor;

    private List<EnrollmentEntryResponse> entries;

    private Integer nextCursor;
}
