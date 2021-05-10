package per.project.starbucks.services.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Builder
@RequiredArgsConstructor
@Getter
@ToString
public class UserResponseDto {

    private final Long id;
    private final String email;
}
