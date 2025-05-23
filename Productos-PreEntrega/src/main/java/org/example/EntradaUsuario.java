package org.example;

import java.util.Scanner;

public class EntradaUsuario {
    private Scanner entrada = new Scanner(System.in);
    private String pedido ;
    public EntradaUsuario(){
    }

    public String pedirEntradaUsuarioString(String pedido) {
        this.pedido = pedido;
        String entradaDelUsuario = "";

        try {
            do {
                System.out.println(pedido);
                entradaDelUsuario = entrada.next(); // usamos nextLine() y trim() para leer toda la línea y quitar espacios
            } while (entradaDelUsuario.isEmpty()); // mientras esté vacía, sigue pidiendo
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return entradaDelUsuario;
    }

    public int pedirEntradaUsuarioInt(String pedido){
        this.pedido = pedido;
        int entradaDelUsuario = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.println(pedido);
            String input = entrada.next();
            if(input.isEmpty()){
                System.out.println("la entrada no puede estar vacia");
                continue;
            }
            try {
                entradaDelUsuario = Integer.parseInt(input);
                entradaValida = true;
            }catch (NumberFormatException e){
                System.out.println("Hay que ingresar un numero ");

            }
        }
        return  entradaDelUsuario;

    }
    public Double pedirEntradaUsuarioDouble(String pedido){
        this.pedido = pedido;
        Double entradaDelUsuario = 0.0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.println(pedido);
            String input = entrada.next();
            if(input.isEmpty()){
                System.out.println("la entrada no puede esta  vacia");
                continue;
            }
            try {
                entradaDelUsuario = Double.parseDouble(input);
                entradaValida = true;
            }catch (NumberFormatException e){
                System.out.println("Hay que ingresar un Double , ejemplo 1.0 ");

            }
        }
        return  entradaDelUsuario;

    }



}
