package whatever.sublog.enrollment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import whatever.sublog.enrollment.dto.EnrollmentEntryResponse;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {


    @Query(value = "SELECT new whatever.sublog.enrollment.dto.EnrollmentEntryResponse(" +
        "e.id, e.name, e.pay, e.payAt, p.productName) " +
        "FROM Enrollment e, PaymentMethod p " +
        "WHERE e.paymentMethodId = p.id AND e.memberId = :memberId " +
        "ORDER BY e.payAt")
    Page<EnrollmentEntryResponse> findEnrollmentPagination(@Param("memberId") Long memberId, Pageable pageable);

    @Query(value = "SELECT new whatever.sublog.enrollment.dto.EnrollmentEntryResponse(" +
            "e.id, e.name, e.pay, e.payAt, p.productName) " +
            "FROM Enrollment e, PaymentMethod p " +
            "WHERE e.paymentMethodId = p.id AND e.memberId = :memberId " +
            "AND e.payAt = month(current_timestamp()) " +
            "ORDER BY e.payAt")
    List<EnrollmentEntryResponse> findMainInfoPagination(@Param("memberId") Long memberId);

}
