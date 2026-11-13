package com.ejemplo.nba.controller;

import com.ejemplo.nba.model.Jugador;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    private final List<Jugador> jugadores = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(2);

    public JugadorController() {
        jugadores.add(new Jugador(1L, "Michael Jordan", "Chicago Bulls", "Escolta", 30.1));
        jugadores.add(new Jugador(2L, "Kobe Bryant", "Los Angeles Lakers", "Escolta", 25.0));
    }

    @GetMapping
    public List<Jugador> listarJugadores() {
        return jugadores;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jugador registrarJugador(@Valid @RequestBody Jugador nuevoJugador) {
        nuevoJugador.setId(contador.incrementAndGet());
        jugadores.add(nuevoJugador);
        return nuevoJugador;
    }
}
