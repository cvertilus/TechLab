package com.techlab.Projecto_Productos.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
@Schema(
        description = "Modelo de solicitud para crear",
        title = "ArticuloRequest")
public class ArticuloRequest {
    @NotNull(message = "El nombre del artículo no puede ser nulo")
    private String nombre;

    @Positive(message = "El precio del artículo debe ser un número positivo")
    private Double precio;

    @NotNull(message = "La categoría del artículo no puede ser nula")
    private String categoria;

    @Positive(message = "El stock del artículo debe ser un número positivo")
    private Integer stock;
}
