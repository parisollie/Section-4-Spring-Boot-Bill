package com.pjff.curso.srpingboot.di.factura.springboot_difactura.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Le ponemos component porque será componente ,vid 67
@Component
@RequestScope
// @JsonIgnoreProperties({"targetSource", "advisors"})
// Vid 67, paso 1, creamos al cliente
public class Client {

    // Paso 2, creamos sus atributos name y lastname.
    // Paso 12, inyectamos el Value y este dato vendra del archivo data.properties
    @Value("${client.name}")
    private String name;

    // Paso 13 ,inyectamos el Value y este dato vendra del archivo data.properties
    @Value("${client.lastname}")
    private String lastname;

    /*------------------------------------GETTERS AND SETTERS --------------------------------------- */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}
