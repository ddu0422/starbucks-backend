package per.project.starbucks.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.project.starbucks.domain.Coffee;
import per.project.starbucks.domain.CoffeeRepository;
import per.project.starbucks.services.dto.CoffeeCreationDto;
import per.project.starbucks.services.dto.CoffeeResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    @Transactional
    public CoffeeResponseDto create(CoffeeCreationDto coffeeCreationDto) {
        Coffee coffee = coffeeRepository.save(
                Coffee.builder()
                        .name(coffeeCreationDto.getName())
                        .englishName(coffeeCreationDto.getEnglishName())
                        .description(coffeeCreationDto.getDescription())
                        .imageUrl(coffeeCreationDto.getImageUrl())
                        .price(coffeeCreationDto.getPrice())
                        .build()
        );

        return CoffeeResponseDto.builder()
                .name(coffee.getName())
                .englishName(coffee.getEnglishName())
                .description(coffee.getDescription())
                .imageUrl(coffee.getImageUrl())
                .price(coffee.getPrice())
                .build();
    }

    public List<CoffeeResponseDto> getCoffees() {
        return coffeeRepository.findCoffees().stream().map(
                coffee -> CoffeeResponseDto.builder()
                        .name(coffee.getName())
                        .englishName(coffee.getEnglishName())
                        .description(coffee.getDescription())
                        .imageUrl(coffee.getImageUrl())
                        .price(coffee.getPrice())
                        .build()
        ).collect(Collectors.toUnmodifiableList());
    }
}
