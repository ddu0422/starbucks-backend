package per.project.starbucks.interfaces;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import per.project.starbucks.services.UserService;
import per.project.starbucks.services.dto.UserCreationDto;
import per.project.starbucks.services.dto.UserResponseDto;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/sign-up", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDto signUp(@RequestBody UserCreationDto userCreationDto) {
        return userService.create(userCreationDto);
    }
}
