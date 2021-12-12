package com.example.mylist.modelo;

import java.util.ArrayList;
import java.util.Date;

public class ListaOrganizacao {
    private String nome;
    private int id;
    private Date dia;
    private ArrayList<SerieLista> serie;

    public ListaOrganizacao(int anInt, String string, long aLong, long tuplasLong) {
        this.nome = nome;
        this.id = id;
        this.dia = dia;
        this.serie= new ArrayList<>();
    }

    public ListaOrganizacao(String nome, Date dia) {
        this.nome = nome;
        this.dia = dia;
        this.serie= new ArrayList<>();
    }

    public ListaOrganizacao(String nome, int id, Date dia) {
        this.nome = nome;
        this.id = id;
        this.dia = dia;
        this.serie = serie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public ArrayList<SerieLista> getSerie() {
        return serie;
    }
    public void addSerie(SerieLista novaSerie){
        this.serie.add(novaSerie);
    }

    public int getInt(int i) {
        return 0;
    }
}