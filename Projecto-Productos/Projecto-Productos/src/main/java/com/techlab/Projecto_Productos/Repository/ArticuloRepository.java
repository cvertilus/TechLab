package com.techlab.Projecto_Productos.Repository;

import com.techlab.Projecto_Productos.Model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Integer> {
    // No additional methods are needed as JpaRepository provides basic CRUD operations
}
