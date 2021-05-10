package per.project.starbucks.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.project.starbucks.domain.User;
import per.project.starbucks.domain.UserRepository;
import per.project.starbucks.services.dto.UserCreationDto;
import per.project.starbucks.services.dto.UserLoginDto;
import per.project.starbucks.services.dto.UserResponseDto;
import per.project.starbucks.services.exception.NotFoundUserException;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto create(UserCreationDto userCreationDto) {
        User user = userRepository.save(
                User.builder()
                        .email(userCreationDto.getEmail())
                        .password(userCreationDto.getPassword())
                        .build()
        );

        return UserResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }

    @Transactional(readOnly = true)
    public UserResponseDto login(UserLoginDto userLoginDto) {
        User user = userRepository.find(userLoginDto.getEmail(), userLoginDto.getPassword())
                .orElseThrow(NotFoundUserException::new);

        return UserResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}
