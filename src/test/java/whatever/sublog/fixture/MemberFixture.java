package whatever.sublog.fixture;

import whatever.sublog.member.Member;

@SuppressWarnings("NonAsciiCharacters")
public class MemberFixture {

    public static Member 회원_만들기(String uid, String name, String password) {
        return new Member(uid, name, password);
    }
}
