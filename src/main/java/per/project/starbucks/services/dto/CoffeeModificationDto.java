package per.project.starbucks.services.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Builder
@RequiredArgsConstructor
@Getter
@ToString
public class CoffeeModificationDto {

    private final String name;
    private final String englishName;
    private final String description;
    private final String imageUrl;
    private final int price;
}
