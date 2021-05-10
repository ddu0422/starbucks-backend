package per.project.starbucks.interfaces;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import per.project.starbucks.services.UserService;
import per.project.starbucks.services.dto.UserCreationDto;
import per.project.starbucks.services.dto.UserLoginDto;
import per.project.starbucks.services.dto.UserResponseDto;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/sign-up")
    public UserResponseDto signUp(@RequestBody UserCreationDto userCreationDto) {
        return userService.create(userCreationDto);
    }

    @PostMapping(value = "/login")
    public UserResponseDto login(@RequestBody UserLoginDto userLoginDto) {
        return userService.login(userLoginDto);
    }
}
