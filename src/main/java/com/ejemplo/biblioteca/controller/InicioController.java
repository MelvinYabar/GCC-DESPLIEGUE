package com.ejemplo.biblioteca.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InicioController {

    @GetMapping("/")
    public Map<String, String> inicio() {
        return Map.of(
                "aplicacion", "Biblioteca API",
                "estado", "La aplicacion esta funcionando correctamente",
                "get", "GET /api/libros - Lista todos los libros",
                "post", "POST /api/libros - Registra un nuevo libro"
        );
    }
}
