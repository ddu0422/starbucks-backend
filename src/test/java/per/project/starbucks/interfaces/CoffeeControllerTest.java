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

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("SD 브라질 사케라또 아포카토"))
                .andExpect(jsonPath("$.englishName").value("SD Brazil Shakerato Affogato"))
                .andExpect(jsonPath("$.description").value("황설탕, 파인애플..."))
                .andExpect(jsonPath("$.imageUrl").value("https://cdn.starbucks.com/a1235k2hn15"))
                .andExpect(jsonPath("$.price").value(7500));
    }

    @Test
    @DisplayName("커피 목록을 가져온다.")
    void getCoffees() throws Exception {
        when(coffeeService.getCoffees()).thenReturn(
                Arrays.asList(CoffeeResponseDto.builder()
                                .id(1L)
                                .name("SD 브라질 사케라또 아포카토")
                                .englishName("SD Brazil Shakerato Affogato")
                                .description("황설탕, 파인애플...")
                                .imageUrl("https://cdn.starbucks.com/a1235k2hn15")
                                .price(7500)
                                .build(),
                        CoffeeResponseDto.builder()
                                .id(2L)
                                .name("SD 브라질 사케라또 아포카토 2")
                                .englishName("SD Brazil Shakerato Affogato 2")
                                .description("황설탕, 파인애플... 2")
                                .imageUrl("https://cdn.starbucks.com/a1235k2hn6")
                                .price(7600)
                                .build()
                )
        );

        ResultActions actions = mockMvc.perform(get("/coffees"));

        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    @DisplayName("커피 정보를 수정한다. (전부 수정하는 경우)")
    void modifyCoffee() throws Exception {
        when(coffeeService.modify(anyLong(), any())).thenReturn(
                CoffeeResponseDto.builder()
                        .id(1L)
                        .name("[수정] SD 브라질 사케라또 아포카토")
                        .englishName("[수정] SD Brazil Shakerato Affogato")
                        .description("[수정] 황설탕, 파인애플...")
                        .imageUrl("[수정] https://cdn.starbucks.com/a1235k2hn15")
                        .price(8000)
                        .build()
        );

        String content = objectMapper.writeValueAsString(
                CoffeeModificationDto.builder()
                        .name("[수정] SD 브라질 사케라또 아포카토")
                        .englishName("[수정] SD Brazil Shakerato Affogato")
                        .description("[수정] 황설탕, 파인애플...")
                        .imageUrl("[수정] https://cdn.starbucks.com/a1235k2hn15")
                        .price(8000)
                        .build()
        );

        ResultActions actions = mockMvc.perform(
                patch("/coffees/1")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
        );

        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("[수정] SD 브라질 사케라또 아포카토"))
                .andExpect(jsonPath("$.englishName").value("[수정] SD Brazil Shakerato Affogato"))
                .andExpect(jsonPath("$.description").value("[수정] 황설탕, 파인애플..."))
                .andExpect(jsonPath("$.imageUrl").value("[수정] https://cdn.starbucks.com/a1235k2hn15"))
                .andExpect(jsonPath("$.price").value(8000));
    }
}
