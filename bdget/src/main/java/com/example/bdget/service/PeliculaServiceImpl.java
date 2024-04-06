package com.example.bdget.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bdget.model.Pelicula;
import com.example.bdget.repository.PeliculaRepository;

@Service
public class PeliculaServiceImpl implements PeliculaService{
     @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> getAllPeliculas() {
        return peliculaRepository.findAll();
    }

    @Override
    public Optional<Pelicula> getPeliculaById(Long id) {
        return peliculaRepository.findById(id);
    }

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public Pelicula actualizarPelicula(Long id, Pelicula pelicula) {
      if (peliculaRepository.existsById(id)) {
        pelicula.setId_pel(id);
        return peliculaRepository.save(pelicula);
      } else {
        return null;
      }
    }

    @Override
    public void eliminarPelicula(Long id) {
        peliculaRepository.deleteById(id);
    }

}
