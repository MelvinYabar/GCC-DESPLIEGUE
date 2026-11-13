package com.ejemplo.biblioteca.controller;

import com.ejemplo.biblioteca.model.Libro;
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
@RequestMapping("/api/libros")
public class LibroController {

    private final List<Libro> libros = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(2);

    public LibroController() {
        libros.add(new Libro(1L, "El principito", "Antoine de Saint-Exupery", "Fabula", 1943));
        libros.add(new Libro(2L, "Cien anios de soledad", "Gabriel Garcia Marquez", "Novela", 1967));
    }

    @GetMapping
    public List<Libro> listarLibros() {
        return libros;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Libro registrarLibro(@Valid @RequestBody Libro nuevoLibro) {
        nuevoLibro.setId(contador.incrementAndGet());
        libros.add(nuevoLibro);
        return nuevoLibro;
    }
}
