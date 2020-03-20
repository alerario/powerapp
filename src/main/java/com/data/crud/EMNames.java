/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.crud;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alexandrelerario
 */
public class EMNames {
    public static final String EMN1 = "PowerAPP_PU";

     public static Map<String, String> getEM1Props() {

        String external_db = System.getenv("JDBC_DATABASE_URL"); // variavel de ambiente criada no ambiente externo
        Map<String, String> properties = new HashMap<>();
        
        if (external_db == null) { //caso nao tenhamos a variavel de ambiente 
            System.out.println("### Acesso local ao banco de dados  ####");
            properties.put("javax.persistence.jdbc.url", "jdbc:postgresql://localhost:5432/teste");
            properties.put("javax.persistence.jdbc.user", "postgres");
            properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
            properties.put("javax.persistence.jdbc.password", "postgres");
            properties.put("javax.persistence.schema-generation.database.action", "create");
        } else { //se a variavel de ambiente foi criada, indica que o projeto está alocado na producao
            System.out.println("### Carregando dados de acesso ao banco ####");
            String jdbc_database_url = System.getenv("JDBC_DATABASE_URL");
            String jdbc_database_username = System.getenv("JDBC_DATABASE_USERNAME");
            String jdbc_database_password = System.getenv("JDBC_DATABASE_PASSWORD");
            properties.put("javax.persistence.jdbc.url", jdbc_database_url );
            properties.put("javax.persistence.jdbc.user", jdbc_database_username);
            properties.put("javax.persistence.jdbc.password", jdbc_database_password);
            properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver"); //configurando driver para postgres        
}
        return properties;
    }
}
