package org.example;

import java.net.SocketOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductoService {
    private List<Producto> productos;
    private Pedido pedido = new Pedido();
    private EntradaUsuario entradaUsuario = new EntradaUsuario();

    public ProductoService() {
        this.productos = new ArrayList<>();

    }
    public void productserviceIniciarsistema(){
      int opcion ;
      do {
          mostrarMenu();
          opcion = entradaUsuario.pedirEntradaUsuarioInt("");
          switch (opcion) {
              case 1 -> crearProducto();
              case 2 -> listarProductos();
              case 3 -> buscarProducto();
              case 4 -> actualizarProducto();
              case 5 ->eliminarProducto();
              case 6 -> crearPedido();
              case 7 -> listarPedido();
              case 8 -> finDelPrograma();
              default -> errorDeEntrada();
              
          }
      }while (opcion != 8);
    }

    private void crearProducto() {
        Producto p = new Producto();
        p.setId(productos.size()+1);

        String nombre = entradaUsuario.pedirEntradaUsuarioString("Por favor ingrese el nombre del producto: ");
        Double precio = entradaUsuario.pedirEntradaUsuarioDouble("Por favor Ingrese el precio del producto: ");
        int cantidadDeStock =  entradaUsuario.pedirEntradaUsuarioInt("Por favor ingrese la cantiadad de Stock del producto; ");

        p.setNombre(nombre);
        p.setPrecio(precio);
        p.setCantidadEnStock(cantidadDeStock);
        productos.add(p);
        System.out.println("Producto Creado..");
    }

    private void listarProductos() {
        for(Producto p : productos){
            System.out.println(p);
        }
    }

    private void buscarProducto() {
        Producto p = buscarproducto();
        mostrarProducto(p);

    }
    private Producto buscarproducto(){
        String nombre = entradaUsuario.pedirEntradaUsuarioString("Por favor ingrese el nombre del producto: ");
        List<Producto> p = productos.stream().filter(producto -> producto.getNombre().equals(nombre)).collect(Collectors.toList());
        if(p.isEmpty()) return  null;
        return p.get(0);
    }


    private void mostrarProducto(Producto p){
        if(p == null) System.out.println("el producto no exsite!!1");
        else System.out.println(p);

    }

    private void actualizarProducto() {
        Producto p = buscarproducto();
        if (p == null) {
            System.out.println("El producto no existe ");
            return;
        }
        productos.remove(p);
        System.out.println("Ingrese el nuevo precio del producto: ");
        p.setPrecio(entradaUsuario.pedirEntradaUsuarioDouble("Por favor Ingreese el nuevo  precio del procudto: "));
        p.setCantidadEnStock(entradaUsuario.pedirEntradaUsuarioInt("Por favor ingrese el Nuevo Stock del procduto: "));
        mostrarProducto(p);
        productos.add(p);

    }


    private void eliminarProducto() {
        Producto p = buscarproducto();
        if (p == null) {
            System.out.println("El producto no exite");
            return;
        }
        productos.remove(p);
    }

    private void crearPedido() {
       for (Producto p : productos){
           if (p.getCantidadEnStock() != 0 ) {
               mostrarProducto(p);
           }
        }
       Producto productoPedido = buscarproducto();
       if (productoPedido == null) {
           System.out.println("El producto no existe");
           return;
       }

        if (productoPedido.getCantidadEnStock() != 0  ) {
            productos.remove(productoPedido);
            productoPedido.setCantidadEnStock(productoPedido.getCantidadEnStock()-1);
            productos.add(productoPedido);
            pedido.agregarProducto(productoPedido);
            System.out.println("Producto agregado a tu lista de pedidos");
        }

    }

    private void listarPedido() {
       System.out.println(pedido);
    }

    private void finDelPrograma() {
        System.out.println("fin del programa ...........");
    }

    private void mostrarMenu(){
        System.out.println("\n----------------------- MENU --------------------------- \n" +
                "1) Crear producto\n" +
                "2) Listar productos\n" +
                "3) Buscar Producto\n" +
                "4) Actualizar producto\n" +
                "5) Eliminar producto\n" +
                "6) Crear un pedido\n" +
                "7) Listar pedidos\n" +
                "8) Salir");
    }
    public void errorDeEntrada(){
        System.out.println(" ERROR ");
    }
}
