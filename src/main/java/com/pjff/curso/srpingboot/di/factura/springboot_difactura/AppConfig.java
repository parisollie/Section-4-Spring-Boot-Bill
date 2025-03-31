package com.pjff.curso.srpingboot.di.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.pjff.curso.srpingboot.di.factura.springboot_difactura.models.Item;
import com.pjff.curso.srpingboot.di.factura.springboot_difactura.models.Product;

/*Vid 68,paso 10 , anotamos una nueva clase configuration para poder usar el data.properties
 que creamos*/
@Configuration
// paso 11
// Vid 70,Paso 20, para los acentos, value = "classpath:data.properties",
// encoding = "UTF-8"
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    // @Primary
    // este es un bean, ya es un componente
    // paso 24, ponemos el bean por defecto porqie tenemos 2
    @Bean
    // Vid 68,Paso 15 le llamamos itemsInvoice:
    List<Item> itemsInvoice() {
        // Paso 16, creamos los productos
        Product p1 = new Product("Pokedex", 800);
        Product p2 = new Product("Bicicleta", 1200);
        // devuelve una lista de items,pasamos el producto y la cantidad
        return Arrays.asList(new Item(p1, 2), new Item(p2, 4));
    }

    // Vid 72, paso 23
    @Bean("default")
    List<Item> itemsInvoiceOffice() {
        Product p1 = new Product("Monitor Asus 24", 700);
        Product p2 = new Product("Notebook Razer", 2400);
        Product p3 = new Product("Impresora HP", 800);
        Product p4 = new Product("Escritorio Oficina", 900);
        return Arrays.asList(new Item(p1, 4), new Item(p2, 6), new Item(p3, 1), new Item(p4, 4));
    }
}
