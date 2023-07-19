package org.otus.controller;

import org.otus.model.Cources;
import org.otus.service.ICourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cource")
public class CourceController {

    ICourceService iCourceService;

    public CourceController(ICourceService iCourceService) {
        this.iCourceService = iCourceService;
    }

    @GetMapping("/all")
    public List<Cources.Cource> getAllCources() {
        return iCourceService.getCources();
    }
}
