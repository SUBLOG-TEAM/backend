package whatever.sublog.enrollment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
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
    private Integer price;

    @Column(nullable = false)
    private LocalDateTime payAt;

}
