package whatever.sublog.enrollment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EnrollmentsResponse {

    @Schema(description = "이전 위치")
    private Integer prevCursor;

    @Schema(description = "이번 달 결제 금액")
    private Integer totalPayment;

    @Schema(description = "구독 리스트")
    private List<EnrollmentEntryResponse> entries;

    @Schema(description = "다음 위치")
    private Integer nextCursor;
}
