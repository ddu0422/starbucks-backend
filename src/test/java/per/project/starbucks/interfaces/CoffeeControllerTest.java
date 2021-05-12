package per.project.starbucks.interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import per.project.starbucks.services.CoffeeService;
import per.project.starbucks.services.dto.CoffeeCreationDto;
import per.project.starbucks.services.dto.CoffeeResponseDto;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(CoffeeController.class)
public class CoffeeControllerTest {

    @MockBean
    private CoffeeService coffeeService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("커피 정보 저장에 성공한다.")
    void addCoffee() throws Exception {
        when(coffeeService.create(any())).thenReturn(
                CoffeeResponseDto.builder()
                        .id(1L)
                        .name("SD 브라질 사케라또 아포카토")
                        .englishName("SD Brazil Shakerato Affogato")
                        .description("황설탕, 파인애플...")
                        .imageUrl("https://cdn.starbucks.com/a1235k2hn15")
                        .price(7500)
                        .build()
        );

        String content = objectMapper.writeValueAsString(CoffeeCreationDto.builder()
                .name("SD 브라질 사케라또 아포카토")
                .englishName("SD Brazil Shakerato Affogato")
                .description("황설탕, 파인애플...")
                .imageUrl("https://cdn.starbucks.com/a1235k2hn15")
                .price(7500)
                .build());

        ResultActions actions = mockMvc.perform(
                post("/coffees")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
        );

        actions
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("SD 브라질 사케라또 아포카토"))
                .andExpect(jsonPath("$.englishName").value("SD Brazil Shakerato Affogato"))
                .andExpect(jsonPath("$.description").value("황설탕, 파인애플..."))
                .andExpect(jsonPath("$.imageUrl").value("https://cdn.starbucks.com/a1235k2hn15"))
                .andExpect(jsonPath("$.price").value(7500));
    }
}
