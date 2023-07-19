package org.otus.service;

import org.otus.model.Cources;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Service
public class CourcesService implements ICourceService {
    @Override
    public List<Cources.Cource> getCources() {
        return LongStream
                .range(0, 5)
                .mapToObj(x -> new Cources.Cource("Cource " + x, 40000 + new Random().nextInt(20000)))
                .collect(Collectors.toList());
    }
}
