package org.otus.service;

import org.otus.model.Cources;

public interface ICourceService {
    Cources getCources();

    Cources.Cource getCource(String id);
}
