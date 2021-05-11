package per.project.starbucks.interfaces;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import per.project.starbucks.services.CoffeeService;
import per.project.starbucks.services.dto.CoffeeCreationDto;
import per.project.starbucks.services.dto.CoffeeResponseDto;

@RestController
@RequiredArgsConstructor
public class CoffeeController {

    private final CoffeeService coffeeService;

    @PostMapping("/coffees")
    public CoffeeResponseDto create(@RequestBody CoffeeCreationDto coffeeCreationDto) {
        return coffeeService.create(coffeeCreationDto);
    }
}
