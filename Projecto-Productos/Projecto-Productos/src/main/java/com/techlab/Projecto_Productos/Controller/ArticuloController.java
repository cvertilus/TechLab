package com.techlab.Projecto_Productos.Controller;

import com.techlab.Projecto_Productos.Model.Articulo;
import com.techlab.Projecto_Productos.Model.ArticuloRequest;
import com.techlab.Projecto_Productos.Service.ArticuloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articulos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @Operation(summary = "Obtener todos los artículos" , description = "Este endpoint permite obtener una lista de todos los artículos disponibles.")
    @ApiResponse(responseCode = "200", description = "Lista de artículos obtenida correctamente")
    @GetMapping("")
    public ResponseEntity<List<Articulo>> obtenerArticulos() {
        List<Articulo> articulos = articuloService.obtenerArticulos();
        return ResponseEntity.ok(articulos);
    }

    @Operation(summary = "Buscar artículos por categoría", description = "Este endpoint permite buscar artículos por su categoría.")
    @ApiResponse(responseCode = "200", description = "Lista de artículos obtenida correctamente")
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Articulo>> buscarArticulosPorCategoria(@PathVariable String categoria) {
        List<Articulo> articulos = articuloService.buscarArticulosPorCategoria(categoria);
        return ResponseEntity.ok(articulos);
    }

    @Operation(summary = "Buscar artículos por nombre", description = "Este endpoint permite buscar artículos por su nombre.")
    @ApiResponse(responseCode = "200", description = "Lista de artículos obtenida correctamente")
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Articulo>> buscarArticulosPorNombre(@PathVariable String nombre) {
        List<Articulo> articulos = articuloService.buscarArticulosPorNombre(nombre);
        return ResponseEntity.ok(articulos);
    }

    @Operation(summary = "Obtener artículo por ID", description = "Este endpoint permite obtener un artículo específico por su ID.")
    @ApiResponse(responseCode = "200", description = "Artículo obtenido correctamente")
    @ApiResponse(responseCode = "404", description = "Artículo no encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<Articulo> obtenerArticuloPorId(@PathVariable Integer id) {
        Articulo articulo = articuloService.obtenerArticuloPorId(id);
        if (articulo != null) {
            return ResponseEntity.ok(articulo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Crear un nuevo artículo", description = "Este endpoint permite crear un nuevo artículo.")
    @ApiResponse(responseCode = "200", description = "Artículo creado correctamente")
    @ApiResponse (responseCode = "400", description = "Error al crear el artículo")
    @PostMapping("")
    public ResponseEntity<Articulo> crearArticulo( @RequestBody ArticuloRequest articulo) {
        Articulo nuevoArticulo = articuloService.crearArticulo(articulo);
        return ResponseEntity.ok(nuevoArticulo);
    }

    @Operation(summary = "Actualizar un artículo", description = "Este endpoint permite actualizar un artículo existente por su ID.")
    @ApiResponse(responseCode = "200", description = "Artículo actualizado correctamente")
    @ApiResponse(responseCode = "404", description = "Artículo no encontrado")
    @ApiResponse(responseCode = "400", description = "Error al actualizar el artículo")
    @PutMapping("/{id}")
    public ResponseEntity<Articulo> actualizarArticulo(@PathVariable Integer id, @RequestBody Articulo articulo) {
        Articulo articuloActualizado = articuloService.actualizarArticulo(id, articulo);
        if (articuloActualizado != null) {
            return ResponseEntity.ok(articuloActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Eliminar un artículo", description = "Este endpoint permite eliminar un artículo por su ID.")
    @ApiResponse(responseCode = "204", description = "Artículo eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "Artículo no encontrado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarArticulo(@PathVariable Integer id) {
        articuloService.eliminarArticulo(id);
        return ResponseEntity.noContent().build();
    }

}
