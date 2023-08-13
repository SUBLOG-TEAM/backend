package whatever.sublog.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import whatever.sublog.global.BaseTimeEntity;

@Getter
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 15)
    private String uid;

    @Column(nullable = false, length = 10)
    private String nickname;

    @Column(nullable = false)
    private String password;

    public Member(String uid, String nickname, String password) {
        this.uid = uid;
        this.nickname = nickname;
        this.password = password;
    }

    protected Member() {

    }
}
