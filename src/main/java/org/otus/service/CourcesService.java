package org.otus.service;

import org.otus.model.Cources;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CourcesService implements ICourceService {
    private final Map<String, Integer> mapCourses = Map.of("QA", 65000, "DevOps", 60000, "Developer", 93000, "SQL", 80000);

    @Override
    public Cources getCources() {
        return new Cources(mapCourses.entrySet().stream()
                .map(x -> new Cources.Cource(x.getKey(), x.getValue()))
                .collect(Collectors.toList()));
    }

    @Override
    public Cources.Cource getCource(String id) {
        if (id.equalsIgnoreCase("mock")) {
            return new Cources.Cource("Заглушка", 555555);
        } else {
            return mapCourses.entrySet().stream()
                    .map(x -> new Cources.Cource(x.getKey(), x.getValue()))
                    .filter(x -> x.getName().equalsIgnoreCase(id))
                    .findFirst().orElseThrow(() -> new AssertionError("указанный курс отсутствует"));
        }
    }
}
