package org.otus.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Cources {
    private List<Cource> cources;

    @Data
    @AllArgsConstructor
    public static class Cource {
        private String name;
        private Integer price;
    }
}
