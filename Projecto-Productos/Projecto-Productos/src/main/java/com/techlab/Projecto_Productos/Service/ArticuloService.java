package com.techlab.Projecto_Productos.Service;

import com.techlab.Projecto_Productos.Model.Articulo;
import com.techlab.Projecto_Productos.Model.ArticuloRequest;
import com.techlab.Projecto_Productos.Repository.ArticuloRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloService {
    @Autowired
    private ArticuloRepository articuloRepository;

    public List<Articulo> obtenerArticulos() {
        return articuloRepository.findAll();
    }

    public Articulo obtenerArticuloPorId(Integer id) {
        return articuloRepository.findById(id).orElseThrow( () -> new EntityNotFoundException("No existe un articulo con el id: " + id));
    }

    public Articulo crearArticulo(ArticuloRequest articulo) {
        Articulo articulo1 = Articulo.builder()
                .nombre(articulo.getNombre())
                .precio(articulo.getPrecio())
                .categoria(articulo.getCategoria())
                .stock(articulo.getStock())
                .build();

        return articuloRepository.save(articulo1);
    }

    public Articulo actualizarArticulo(Integer id, Articulo articulo) {
        if (articuloRepository.existsById(id)) {
            Articulo articulo1 = obtenerArticuloPorId(id);
            articulo1.setNombre(articulo.getNombre());
            articulo1.setPrecio(articulo.getPrecio());
            articulo1.setCategoria(articulo.getCategoria());
            articulo1.setStock(articulo.getStock());
            return articuloRepository.save(articulo1);
        }
        throw (new EntityNotFoundException("No existe un articulo con el id: " + id));
    }
    public void eliminarArticulo(Integer id) {
        if (articuloRepository.existsById(id)) {
            articuloRepository.deleteById(id);
        }
    }

    public List<Articulo> buscarArticulosPorCategoria(String categoria) {
        return articuloRepository.findAll().stream()
                .filter(articulo -> articulo.getCategoria().equalsIgnoreCase(categoria))
                .toList();
    }

    public List<Articulo> buscarArticulosPorNombre(String nombre) {
        return articuloRepository.findAll().stream()
                .filter(articulo -> articulo.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .toList();
    }

}
