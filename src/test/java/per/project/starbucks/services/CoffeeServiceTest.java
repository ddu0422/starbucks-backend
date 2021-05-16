package per.project.starbucks.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import per.project.starbucks.domain.Coffee;
import per.project.starbucks.domain.CoffeeRepository;
import per.project.starbucks.services.dto.CoffeeCreationDto;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CoffeeServiceTest {

    @Mock
    private CoffeeCreationDto coffeeCreationDto;

    @Mock
    private CoffeeRepository coffeeRepository;

    @Mock
    private Coffee coffee;

    @Mock
    private List<Coffee> coffees;

    @InjectMocks
    private CoffeeService coffeeService;

    @Test
    @DisplayName("커피 정보 저장 성공")
    void addCoffee() {
        when(coffeeRepository.save(any())).thenReturn(coffee);

        coffeeService.create(coffeeCreationDto);

        verify(coffeeRepository, times(1)).save(any());
    }

    @Test
    @DisplayName("커피 목록 가져오기 성공")
    void getCoffees() {
        when(coffeeRepository.findCoffees()).thenReturn(coffees);

        coffeeService.getCoffees();

        verify(coffeeRepository, times(1)).findCoffees();
    }
}
