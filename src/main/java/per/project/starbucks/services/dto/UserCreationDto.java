package per.project.starbucks.services.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Builder
@RequiredArgsConstructor
@Getter
@ToString
public class UserCreationDto {

    private final String email;
    private final String password;
}
