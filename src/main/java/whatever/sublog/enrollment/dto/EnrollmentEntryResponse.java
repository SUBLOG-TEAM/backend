package whatever.sublog.enrollment.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import whatever.sublog.enrollment.Enrollment;

@Getter
@NoArgsConstructor
public class EnrollmentEntryResponse {

    private Long id;

    private String name;

    private Integer pay;

    private LocalDateTime payAt;

    private String productName;

    public EnrollmentEntryResponse(Long id, String name, Integer pay, LocalDateTime payAt, String productName) {
        this.id = id;
        this.name = name;
        this.pay = pay;
        this.payAt = payAt;
        this.productName = productName;
    }

    public EnrollmentEntryResponse(Enrollment enrollment, String productName) {
        this.id = enrollment.getId();
        this.name = enrollment.getName();
        this.pay = enrollment.getPay();
        this.payAt = enrollment.getPayAt();
        this.productName = productName;
    }
}
