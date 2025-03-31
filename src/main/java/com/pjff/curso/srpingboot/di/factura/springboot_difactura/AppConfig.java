package com.pjff.curso.srpingboot.di.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.pjff.curso.srpingboot.di.factura.springboot_difactura.models.Item;
import com.pjff.curso.srpingboot.di.factura.springboot_difactura.models.Product;

/*V-68,paso 10 , anotamos una nueva clase configuration para poder usar el data.properties
 que creamos*/
@Configuration
/*
 * Paso 11,ponemos el @PropertySource
 * V-70,Paso 24, para los acentos, value = "classpath:data.properties",
 * encoding = "UTF-8"
 */
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    /*
     * @Primary
     * Este es un bean, ya es un componente
     * Paso, ponemos el bean por defecto porque tenemos 2
     */
    @Bean
    // V-69,Paso 15 le llamamos itemsInvoice:
    List<Item> itemsInvoice() {
        // Paso 16, creamos los productos
        Product p1 = new Product("Pokedex", 800);
        Product p2 = new Product("Bicicleta", 1200);
        // Paso 18,devuelve una lista de items,pasamos el producto y la cantidad
        return Arrays.asList(new Item(p1, 2), new Item(p2, 4));
    }

    // V-72, paso
    @Bean("default")
    List<Item> itemsInvoiceOffice() {
        Product p1 = new Product("Monitor Asus 24", 700);
        Product p2 = new Product("Notebook Razer", 2400);
        Product p3 = new Product("Impresora HP", 800);
        Product p4 = new Product("Escritorio Oficina", 900);
        return Arrays.asList(new Item(p1, 4), new Item(p2, 6), new Item(p3, 1), new Item(p4, 4));
    }
}
