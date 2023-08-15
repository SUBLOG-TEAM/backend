package whatever.sublog.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import whatever.sublog.common.ApiTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static whatever.sublog.fixture.RegisterFixture.name_길이가_20자리;
import static whatever.sublog.fixture.RegisterFixture.name_길이가_21자리;
import static whatever.sublog.fixture.RegisterFixture.name_띄어쓰기;
import static whatever.sublog.fixture.RegisterFixture.name_특수문자;
import static whatever.sublog.fixture.RegisterFixture.uid_길이가_20자리;
import static whatever.sublog.fixture.RegisterFixture.uid_길이가_21자리;
import static whatever.sublog.fixture.RegisterFixture.uid_띄어쓰기;
import static whatever.sublog.fixture.RegisterFixture.uid에_한글;

public class MemberControllerTest extends ApiTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MemberService memberService;

    private static String url = "/members/register";

    @Test
    public void uid_21자_넘으면_400() throws Exception {
        // Given
        String requestBody = uid_길이가_21자리();

        // When & Then
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void uid_한글_있으면_400() throws Exception {
        // Given
        String requestBody = uid에_한글();

        // When & Then
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void uid_공백_있으면_400() throws Exception {
        // Given
        String requestBody = uid_띄어쓰기();

        // When & Then
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void uid_20자_이내면_200() throws Exception {
        // Given
        String requestBody = uid_길이가_20자리();

        // When & Then
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk());
    }

    @Test
    public void name_20자_넘으면_400() throws Exception {
        // Given
        String requestBody = name_길이가_21자리();

        // When & Then
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void name_특수문자_있으면_400() throws Exception {
        // Given
        String requestBody = name_특수문자();

        // When & Then
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void name_띄어쓰기_있으면_400() throws Exception {
        // Given
        String requestBody = name_띄어쓰기();

        // When & Then
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void name_20자_이내면_200() throws Exception {
        // Given
        String requestBody = name_길이가_20자리();

        // When & Then
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk());
    }
}
