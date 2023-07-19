package org.otus.controller;

import org.otus.model.Cources;
import org.otus.service.ICourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/cource")
public class CourceController {

    ICourceService courseService;

    public CourceController(ICourceService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    public Cources.Cource getCource(@PathVariable String id) {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + " Поступил запрос -> /cource/" + id);
        return courseService.getCource(id);
    }

    @GetMapping("/all")
    public Cources getAllCources() {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + " Поступил запрос -> /cource/all");
        return courseService.getCources();
    }
}
