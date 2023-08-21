package whatever.sublog.enrollment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import whatever.sublog.global.BaseTimeEntity;

@Getter
@Entity
public class Enrollment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private Long paymentMethodId;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false)
    private Integer pay;

    @Column(nullable = false)
    private LocalDateTime payAt;

    @Builder
    public Enrollment(Long memberId, Long paymentMethodId, String name, Integer pay, LocalDateTime payAt) {
        this.memberId = memberId;
        this.paymentMethodId = paymentMethodId;
        this.name = name;
        this.pay = pay;
        this.payAt = payAt;
    }
}
