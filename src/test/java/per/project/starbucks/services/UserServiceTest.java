package per.project.starbucks.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import per.project.starbucks.domain.User;
import per.project.starbucks.services.dto.UserCreationDto;

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
}
