package whatever.sublog.enrollment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import whatever.sublog.enrollment.Enrollment;

@Getter
@NoArgsConstructor
public class EnrollmentEntryResponse {

    @Schema(description = "구독 서비스 ID")
    private Long id;

    @Schema(description = "구독 서비스명")
    private String name;

    @Schema(description = "구독 가격")
    private Integer pay;

    @Schema(description = "구독 결제일")
    private LocalDateTime payAt;

    @Schema(description = "구독 결제 카드사")
    private String productName;

    public EnrollmentEntryResponse(Long id, String name, Integer pay, LocalDateTime payAt, String productName) {
        this.id = id;
        this.name = name;
        this.pay = pay;
        this.payAt = payAt;
        this.productName = productName;
    }

    public EnrollmentEntryResponse(Enrollment enrollment, String productName) {
        id = enrollment.getId();
        name = enrollment.getName();
        pay = enrollment.getPay();
        payAt = enrollment.getPayAt();
        this.productName = productName;
    }
}