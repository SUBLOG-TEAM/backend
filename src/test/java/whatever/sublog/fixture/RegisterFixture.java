package whatever.sublog.fixture;

import whatever.sublog.member.dto.MemberRegisterForm;

@SuppressWarnings("NonAsciiCharacters")
public class RegisterFixture {

    public static String uid_길이가_21자리() {
        String uid = "123456789012345678901"; // 21 characters
        String name = "TestNick";
        String password = "password123!";
        return String.format("{\"uid\":\"%s\", \"name\":\"%s\", \"password\":\"%s\"}", uid, name, password);
    }

    public static String uid에_한글() {
        String uid = "12345678901234삑"; // 15 characters
        String name = "TestNick";
        String password = "password123!";
        return String.format("{\"uid\":\"%s\", \"name\":\"%s\", \"password\":\"%s\"}", uid, name, password);
    }

    public static String uid_띄어쓰기() {
        String uid = "abcde1234 abcde"; // 15 characters
        String name = "TestNick";
        String password = "password123!";
        return String.format("{\"uid\":\"%s\", \"name\":\"%s\", \"password\":\"%s\"}", uid, name, password);
    }


    public static String uid_길이가_20자리() {
        String uid = "abcde12345abcde12345"; // 20 characters
        String name = "TestNick";
        String password = "password123!";
        return String.format("{\"uid\":\"%s\", \"name\":\"%s\", \"password\":\"%s\"}", uid, name, password);
    }

    public static String name_길이가_20자리() {
        String uid = "abcde12345abcde";
        String name = "가나다라가나다라가나다라가나다라가나다라"; // 20 characters
        String password = "password123!";
        return String.format("{\"uid\":\"%s\", \"name\":\"%s\", \"password\":\"%s\"}", uid, name, password);
    }

    public static String name_길이가_21자리() {
        String uid = "abcde12345abcde";
        String name = "가나다라가나다라가나다라가나다라가나다라a"; // 21 characters
        String password = "password123!";
        return String.format("{\"uid\":\"%s\", \"name\":\"%s\", \"password\":\"%s\"}", uid, name, password);
    }

    public static String name_특수문자() {
        String uid = "abcde12345abcde";
        String name = "abc123!";
        String password = "password123!";
        return String.format("{\"uid\":\"%s\", \"name\":\"%s\", \"password\":\"%s\"}", uid, name, password);
    }

    public static String name_띄어쓰기() {
        String uid = "abcde12345abcde"; // 10 characters
        String name = "abc 123";
        String password = "password123!";
        return String.format("{\"uid\":\"%s\", \"name\":\"%s\", \"password\":\"%s\"}", uid, name, password);
    }

    public static MemberRegisterForm 폼_객체_만들기(String uid, String name, String password, String passwordConfirm) {
        return new MemberRegisterForm(uid, name, password, passwordConfirm);
    }

    public static String 폼_json_만들기(String uid, String name, String password) {
        return String.format("{\"uid\":\"%s\", \"name\":\"%s\", \"password\":\"%s\"}", uid, name, password);
    }
}
