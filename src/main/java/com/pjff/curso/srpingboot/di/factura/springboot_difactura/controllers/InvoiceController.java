package com.pjff.curso.srpingboot.di.factura.springboot_difactura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pjff.curso.srpingboot.di.factura.springboot_difactura.models.Client;
import com.pjff.curso.srpingboot.di.factura.springboot_difactura.models.Invoice;

/*
  Prueba 
  http://localhost:8080/invoices/show

  V-70,paso 20 ponemos el @RestController
*/
@RestController
// le damos una ruta por defecto
@RequestMapping("/invoices")
public class InvoiceController {

    // Paso 22, Inyectamos
    @Autowired
    // Paso 2.6, ponemos el atributo de la factura
    private Invoice invoice;

    // Paso 23 es un método handler con getMapping y le ponemos la ruta
    @GetMapping("/show")

    // Paso 21,Metódo Invoice que devuelve una factura.
    public Invoice show() {
        // V-76,paso 2.7 creo mi instancia
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
