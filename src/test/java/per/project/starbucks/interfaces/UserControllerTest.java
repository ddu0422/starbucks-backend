package per.project.starbucks.interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import per.project.starbucks.services.UserService;
import per.project.starbucks.services.dto.UserCreationDto;
import per.project.starbucks.services.dto.UserLoginDto;
import per.project.starbucks.services.dto.UserResponseDto;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("사용자 생성에 성공한다.")
    void createUser() throws Exception {
        when(userService.create(any())).thenReturn(
                UserResponseDto.builder()
                        .id(1L)
                        .email("ddu0422@kakao.com")
                        .build()
        );

        String content = objectMapper.writeValueAsString(
                UserCreationDto.builder()
                        .email("ddu0422@kakao.com")
                        .password("12345678")
                        .build()
        );

        ResultActions action = mockMvc.perform(
                post("/sign-up")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
        );

        action.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.email").value("ddu0422@kakao.com"));
    }

    @Test
    @DisplayName("로그인에 성공한다.")
    void succeedLogin() throws Exception {
        when(userService.login(any())).thenReturn(
                UserResponseDto.builder()
                        .id(1L)
                        .email("ddu0422@kakao.com")
                        .build()
        );

        String content = objectMapper.writeValueAsString(UserLoginDto.builder()
                .email("ddu0422@kakao.com")
                .password("12345678")
                .build()
        );

        ResultActions actions = mockMvc.perform(
                post("/login")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
        );

        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.email").value("ddu0422@kakao.com"));
    }
}
