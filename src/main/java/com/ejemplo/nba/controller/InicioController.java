package com.ejemplo.nba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InicioController {

    @GetMapping("/")
    public Map<String, String> inicio() {
        return Map.of(
                "aplicacion", "NBA Jugadores API",
                "estado", "La aplicacion esta funcionando correctamente",
                "get", "GET /api/jugadores - Lista todos los jugadores",
                "post", "POST /api/jugadores - Registra un nuevo jugador"
        );
    }
}
