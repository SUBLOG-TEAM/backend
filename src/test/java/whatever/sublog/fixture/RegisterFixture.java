package whatever.sublog.fixture;

import whatever.sublog.member.dto.MemberRegisterForm;

@SuppressWarnings("NonAsciiCharacters")
public class RegisterFixture {

    public static String uid_길이가_16자리() {
        String uid = "1234567890123456"; // 16 characters
        String nickname = "TestNick";
        String password = "password123!";
        String requestBody = String.format("{\"uid\":\"%s\", \"nickname\":\"%s\", \"password\":\"%s\"}", uid, nickname, password);
        return requestBody;
    }

    public static String uid에_한글() {
        String uid = "12345678901234삑"; // 15 characters
        String nickname = "TestNick";
        String password = "password123!";
        String requestBody = String.format("{\"uid\":\"%s\", \"nickname\":\"%s\", \"password\":\"%s\"}", uid, nickname, password);
        return requestBody;
    }

    public static String uid_띄어쓰기() {
        String uid = "abcde1234 abcde"; // 15 characters
        String nickname = "TestNick";
        String password = "password123!";
        String requestBody = String.format("{\"uid\":\"%s\", \"nickname\":\"%s\", \"password\":\"%s\"}", uid, nickname, password);
        return requestBody;
    }


    public static String uid_길이가_15자리() {
        String uid = "abcde12345abcde"; // 15 characters
        String nickname = "TestNick";
        String password = "password123!";
        String requestBody = String.format("{\"uid\":\"%s\", \"nickname\":\"%s\", \"password\":\"%s\"}", uid, nickname, password);
        return requestBody;
    }

    public static String nickname_길이가_10자리() {
        String uid = "abcde12345abcde"; // 10 characters
        String nickname = "하나abcd1234";
        String password = "password123!";
        String requestBody = String.format("{\"uid\":\"%s\", \"nickname\":\"%s\", \"password\":\"%s\"}", uid, nickname, password);
        return requestBody;
    }

    public static String nickname_길이가_11자리() {
        String uid = "abcde12345abcde"; // 11 characters
        String nickname = "하나둘abcd1234";
        String password = "password123!";
        String requestBody = String.format("{\"uid\":\"%s\", \"nickname\":\"%s\", \"password\":\"%s\"}", uid, nickname, password);
        return requestBody;
    }

    public static String nickname_특수문자() {
        String uid = "abcde12345abcde"; // 10 characters
        String nickname = "abc123!";
        String password = "password123!";
        String requestBody = String.format("{\"uid\":\"%s\", \"nickname\":\"%s\", \"password\":\"%s\"}", uid, nickname, password);
        return requestBody;
    }

    public static String nickname_중국어() {
        String uid = "abcde12345abcde"; // 10 characters
        String nickname = "abc123喝";
        String password = "password123!";
        String requestBody = String.format("{\"uid\":\"%s\", \"nickname\":\"%s\", \"password\":\"%s\"}", uid, nickname, password);
        return requestBody;
    }

    public static String nickname_띄어쓰기() {
        String uid = "abcde12345abcde"; // 10 characters
        String nickname = "abc 123";
        String password = "password123!";
        String requestBody = String.format("{\"uid\":\"%s\", \"nickname\":\"%s\", \"password\":\"%s\"}", uid, nickname, password);
        return requestBody;
    }

    public static MemberRegisterForm 폼_만들기(String uid, String nickname, String password) {
        return new MemberRegisterForm("test1", "testName", "password123!");
    }
}
