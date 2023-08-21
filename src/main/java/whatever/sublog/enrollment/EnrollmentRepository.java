package whatever.sublog.enrollment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import whatever.sublog.enrollment.dto.EnrollmentEntryResponse;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {


    @Query(value = "SELECT new whatever.sublog.enrollment.dto.EnrollmentEntryResponse(" +
        "e.id, e.name, e.pay, e.payAt, p.productName) " +
        "FROM Enrollment e, PaymentMethod p " +
        "WHERE e.paymentMethodId = p.id " +
        "ORDER BY e.createdAt DESC")
    Page<EnrollmentEntryResponse> findEnrollmentPagination(Pageable pageable);

}
