package whatever.sublog.member;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUid(String uid);

    Optional<Member> findByUidAndPassword(String uid, String password);
}
