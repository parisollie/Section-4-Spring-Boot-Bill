package com.pjff.curso.srpingboot.di.factura.springboot_difactura.models;

public class Product {
    // Paso 7, Propiedades del producto
    private String name;

    private Integer price;

    /*----------------------------------------------------------------------------- */

    // Paso 16, creamos los constructores.

    // Constructor vacío
    public Product() {
    }

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    /*-------------------------------GETTERS AND SETTERS--------------------------------------*/
    // Paso 8
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
