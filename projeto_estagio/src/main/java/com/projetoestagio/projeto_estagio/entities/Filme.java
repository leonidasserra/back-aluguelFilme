package com.projetoestagio.projeto_estagio.entities;
//
////import java.util.ArrayList;
////import java.util.List;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name ="tb_filme")
public class Filme {
    private Long id;
    private String title;
    private String name;
    private int ano;
//    
//    
//    //private List<Nota> notas = new ArrayList<>(); // armazena várias notas
//
    // Getters e Setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
//    
}