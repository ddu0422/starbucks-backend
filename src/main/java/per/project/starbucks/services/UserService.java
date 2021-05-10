package per.project.starbucks.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import per.project.starbucks.domain.User;
import per.project.starbucks.services.dto.UserCreationDto;
import per.project.starbucks.services.dto.UserResponseDto;

import javax.transaction.Transactional;

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
}
