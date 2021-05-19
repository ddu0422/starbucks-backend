package per.project.starbucks.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeTest {

    @Test
    @DisplayName("커피 전체 정보 수정")
    void name() {
        Coffee coffee = Coffee.builder()
                .name("기존 이름")
                .englishName("before name")
                .description("기존 설명")
                .imageUrl("기존 url")
                .price(10000)
                .build();

        Coffee modificationCoffee = coffee.change(Coffee.builder()
                .name("수정 이름")
                .englishName("after name")
                .description("수정 설명")
                .imageUrl("수정 url")
                .price(20000)
                .build()
        );

        assertEquals("수정 이름", modificationCoffee.getName());
        assertEquals("after name", modificationCoffee.getEnglishName());
        assertEquals("수정 설명", modificationCoffee.getDescription());
        assertEquals("수정 url", modificationCoffee.getImageUrl());
        assertEquals(20000, modificationCoffee.getPrice());
    }

    @Test
    @DisplayName("커피 이름만 수정")
    void name1() {
        Coffee coffee = Coffee.builder()
                .name("기존 이름")
                .englishName("before name")
                .description("기존 설명")
                .imageUrl("기존 url")
                .price(10000)
                .build();

        Coffee modificationCoffee = coffee.change(
                Coffee.builder()
                        .name("수정 이름")
                        .englishName("after name")
                        .build()
        );

        assertEquals("수정 이름", modificationCoffee.getName());
        assertEquals("after name", modificationCoffee.getEnglishName());
        assertEquals("기존 설명", modificationCoffee.getDescription());
        assertEquals("기존 url", modificationCoffee.getImageUrl());
        assertEquals(10000, modificationCoffee.getPrice());
    }
}
