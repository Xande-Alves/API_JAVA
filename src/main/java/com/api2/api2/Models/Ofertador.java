package com.api2.api2.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/* @Data Notação responsável por gerar os Gets e Sets */
@Entity
@Table(name="UsuarioOfertador")
@Data
public class Ofertador {

    /*
     * @Column notação responsável por configurar o tipo e nome da coluna.
     */
    @Column(name = "nome", columnDefinition = "VARCHAR(20)", nullable = false)
    private String nome;
    @Column(name = "logradouro", columnDefinition = "VARCHAR(60)", nullable = false)
    private String logradouro;
    @Column(name = "numero", columnDefinition = "VARCHAR(10)", nullable = false)
    private String numero;
    @Column(name = "complemento", columnDefinition = "VARCHAR(30)")
    private String complemento;
    @Column(name = "bairro", columnDefinition = "VARCHAR(20)", nullable = false)
    private String bairro;
    @Column(name = "cidade", columnDefinition = "VARCHAR(20)", nullable = false)
    private String cidade;
    @Column(name = "estado", columnDefinition = "VARCHAR(15)", nullable = false)
    private String estado;
    @Column(name = "email", columnDefinition = "VARCHAR(30)", nullable = false)
    private String email;
    @Column(name = "telefone", columnDefinition = "VARCHAR(14)", nullable = false)
    private String telefone;
    @Column(name = "senha", columnDefinition = "VARCHAR(20)", nullable = false)
    private String senha;

    /*
     * @Id responsável por tornar a matrícula como chave primária
     */
    @Id
    /* @GeneratedValue notação para definir a coluna como auto incremento */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

}


