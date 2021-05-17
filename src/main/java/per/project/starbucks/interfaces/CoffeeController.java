package per.project.starbucks.interfaces;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import per.project.starbucks.services.CoffeeService;
import per.project.starbucks.services.dto.CoffeeCreationDto;
import per.project.starbucks.services.dto.CoffeeResponseDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CoffeeController {

    private final CoffeeService coffeeService;

    @PostMapping("/coffees")
    public CoffeeResponseDto create(@RequestBody CoffeeCreationDto coffeeCreationDto) {
        return coffeeService.create(coffeeCreationDto);
    }

    @GetMapping("/coffees")
    public List<CoffeeResponseDto> getCoffees() {
        return coffeeService.getCoffees();
    }

    @PatchMapping("/coffees/{id}")
    public CoffeeResponseDto modify(
            @PathVariable Long id,
            @RequestBody CoffeeModificationDto coffeeModificationDto
    ) {
        return coffeeService.modify(coffeeModificationDto);
    }
}
