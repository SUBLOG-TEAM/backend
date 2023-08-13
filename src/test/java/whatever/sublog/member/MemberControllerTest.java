package whatever.sublog.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import whatever.sublog.common.ApiTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static whatever.sublog.fixture.RegisterFixture.nickname_길이가_10자리;
import static whatever.sublog.fixture.RegisterFixture.nickname_길이가_11자리;
import static whatever.sublog.fixture.RegisterFixture.nickname_띄어쓰기;
import static whatever.sublog.fixture.RegisterFixture.nickname_중국어;
import static whatever.sublog.fixture.RegisterFixture.nickname_특수문자;
import static whatever.sublog.fixture.RegisterFixture.uid_길이가_15자리;
import static whatever.sublog.fixture.RegisterFixture.uid_길이가_16자리;
import static whatever.sublog.fixture.RegisterFixture.uid_띄어쓰기;
import static whatever.sublog.fixture.RegisterFixture.uid에_한글;

public class MemberControllerTest extends ApiTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MemberService memberService;

    @Test
    public void uid_16자_넘으면_400() throws Exception {
        // Given
        String requestBody = uid_길이가_16자리();

        // When & Then
        mvc.perform(post("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void uid_한글_있으면_400() throws Exception {
        // Given
        String requestBody = uid에_한글();

        // When & Then
        mvc.perform(post("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void uid_공백_있으면_400() throws Exception {
        // Given
        String requestBody = uid_띄어쓰기();

        // When & Then
        mvc.perform(post("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void uid_15자_이내면_200() throws Exception {
        // Given
        String requestBody = uid_길이가_15자리();

        // When & Then
        mvc.perform(post("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk());
    }

    @Test
    public void nickname_10자_넘으면_400() throws Exception {
        // Given
        String requestBody = nickname_길이가_11자리();

        // When & Then
        mvc.perform(post("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void nickname_특수문자_있으면_400() throws Exception {
        // Given
        String requestBody = nickname_특수문자();

        // When & Then
        mvc.perform(post("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void nickname_중국어_있으면_400() throws Exception {
        // Given
        String requestBody = nickname_중국어();

        // When & Then
        mvc.perform(post("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void nickname_띄어쓰기_있으면_400() throws Exception {
        // Given
        String requestBody = nickname_띄어쓰기();

        // When & Then
        mvc.perform(post("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void nickname_10자_이내면_200() throws Exception {
        // Given
        String requestBody = nickname_길이가_10자리();

        // When & Then
        mvc.perform(post("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk());
    }
}
