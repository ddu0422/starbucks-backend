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

    @InjectMocks
    private CoffeeService coffeeService;

    @Test
    @DisplayName("커피 정보 저장 성공")
    void name() {
        when(coffeeRepository.save(any())).thenReturn(coffee);

        coffeeService.create(coffeeCreationDto);

        verify(coffeeRepository, times(1)).save(any());
    }
}
