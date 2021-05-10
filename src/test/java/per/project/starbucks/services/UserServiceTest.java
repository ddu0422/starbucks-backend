package per.project.starbucks.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import per.project.starbucks.domain.User;
import per.project.starbucks.domain.UserRepository;
import per.project.starbucks.services.dto.UserCreationDto;
import per.project.starbucks.services.dto.UserLoginDto;
import per.project.starbucks.services.exception.NotFoundUserException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("회원가입을 할 경우 성공한다.")
    void createUser() {
        when(userRepository.save(any())).thenReturn(mock(User.class));

        userService.create(mock(UserCreationDto.class));

        verify(userRepository, times(1)).save(any());
    }

    @Test
    @DisplayName("올바른 정보로 로그인 시 성공한다.")
    void succeedLogin() {
        when(userRepository.find(nullable(String.class), nullable(String.class))).thenReturn(Optional.of(mock(User.class)));

        userService.login(mock(UserLoginDto.class));

        verify(userRepository, times(1)).find(nullable(String.class), nullable(String.class));
    }

    @Test
    @DisplayName("올바르지 않은 정보로 로그인 시 실패한다.")
    void name() {
        when(userRepository.find(nullable(String.class), nullable(String.class))).thenThrow(NotFoundUserException.class);

        assertThrows(NotFoundUserException.class, () -> userService.login(mock(UserLoginDto.class)));
    }
}
