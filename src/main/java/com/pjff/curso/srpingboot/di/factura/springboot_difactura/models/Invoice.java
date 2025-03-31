package com.pjff.curso.srpingboot.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//Le ponemos component porque será componente ,paso 9 Vid 67
@Component
// V-75,paso 2.5 agregamos @RequestScope
@RequestScope
/*
 * Paso 2.6 ignoramos el json, omitimos 2 atributos del proxy: { "targetSource",
 * "advisors" }
 * 
 * @JsonIgnoreProperties({ "targetSource", "advisors" })
 */
public class Invoice {
    /*
     * Paso 3 , creamos las propiedades de factura client , description y lista.
     * Con Autowired, inyectamos el cliente
     */
    @Autowired
    private Client client;

    // Paso 14 ,inyectamos el Value y este dato vendra del archivo data.properties
    @Value("${invoice.description}")
    private String description;

    // Paso 19, vid 69, inyectamos con el Autowired
    @Autowired
    // V-72,paso 2.2 ponemos el @Qualifier("default")
    @Qualifier("default")
    private List<Item> items;

    /*----------------------------------------------------------------------------- */
    public Invoice() {
        System.out.println("Creando el componente de la factura");
        System.out.println(client);
        System.out.println(description);
    }

    /*
     * @PostConstruct, se ejecuta despues de que se haya instanciado y despues de
     * que se haya inyectado
     */
    @PostConstruct
    // V-73,paso 2.3
    public void init() {
        System.out.println("Creando el componente de la factura");
        client.setName(client.getName().concat(" Nick"));
        // concat devuelve una nueva instancia
        description = description.concat(" del cliente: ").concat(client.getName()).concat(" ")
                .concat(client.getLastname());
    }

    /*
     * V-74,paso 2.4, se cierra una conexion o algo así para que no se quede abierta
     */
    @PreDestroy
    public void destroy() {
        System.out.println("Destruyendo el componente o bean invoice!");
    }

    /*-------------------------------GETTERS AND SETTERS--------------------------------------*/
    // Paso 4
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    /*---------------------------------------------------------------------*/
    // V-70,paso 26
    public int getTotal() {

        /*
         * Primera forma
         * int total = 0;
         * for(Item item: items){
         * total +=item.getImporte()
         * }
         * return total;
         */

        return items.stream()
                /*
                 * V-71, Paso 27 , usamos el map,ponemos el item para que nos devuelva el valor
                 * y poner en numero enteros
                 */
                .map(item -> item.getImporte())
                /*
                 * Reduce , primer argumento ponemos el valor inicial 0
                 * el segundo argumento es un call back
                 * recibe una variable que es el acumulador "sum" y el objeto del stream que es
                 * importe.
                 */
                .reduce(0, (sum, importe) -> sum + importe);
    }

}
