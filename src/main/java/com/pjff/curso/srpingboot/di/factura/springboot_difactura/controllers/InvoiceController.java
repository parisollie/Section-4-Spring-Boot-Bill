package com.pjff.curso.srpingboot.di.factura.springboot_difactura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pjff.curso.srpingboot.di.factura.springboot_difactura.models.Client;
import com.pjff.curso.srpingboot.di.factura.springboot_difactura.models.Invoice;

//Prueba 
//http://localhost:8080/invoices/show

//Vid 70 ponemos el @RestController
@RestController
// le damos una ruta por defecto
@RequestMapping("/invoices")
public class InvoiceController {

    // Paso 18, Inyectamos
    @Autowired
    // Paso 19, ponemos el atributo de la factura
    private Invoice invoice;

    // es un metódo handler con getMapping y le ponemos la ruta
    @GetMapping("/show")

    // Paso 17,Metódo Invoice que devuelve una factura.
    public Invoice show() {
        // Vid 76, creo mi instancia
        Invoice i = new Invoice();

        Client c = new Client();
        c.setLastname(invoice.getClient().getLastname());
        c.setName(invoice.getClient().getName());

        i.setClient(c);
        i.setDescription(invoice.getDescription());
        i.setItems(invoice.getItems());

        return i;
    }
}
