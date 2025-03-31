package com.pjff.curso.srpingboot.di.factura.springboot_difactura.models;

public class Item {

    // Paso 5, Propiedades del item
    private Product product;
    private Integer quantity;

    /*----------------------------------------------------------------------------- */
    // Paso 17, creamos los constructores.

    // Constructor vacío
    public Item() {
    }

    public Item(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /*-------------------------------GETTERS AND SETTERS--------------------------------------*/
    // Paso 6
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /*----------------------------------------------------------------------------- */
    // Paso 21,vid 70
    public int getImporte() {
        // devolvemos el precio del producto por la cantidad
        return quantity * product.getPrice();
    }

}
