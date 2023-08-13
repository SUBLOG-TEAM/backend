package whatever.sublog.fixture;

import whatever.sublog.member.Member;

@SuppressWarnings("NonAsciiCharacters")
public class MemberFixture {

    public static Member 회원_만들기(String uid, String nickname, String password) {
        return new Member(uid, nickname, password);
    }
}
