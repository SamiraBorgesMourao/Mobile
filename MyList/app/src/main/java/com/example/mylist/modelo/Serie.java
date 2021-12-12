package com.example.mylist.modelo;

public class Serie {
    private String nome ;
    private String genero;
    private String sinopse;
    private String  país;
    private String duracao;
    private  int numEpisodios;
    private  int id;

    public Serie(int tuplasInt, String s, String tuplasString, String string, String nome, String genero, int anInt) {
        this.nome = nome;
        this.genero = genero;
        this.sinopse = sinopse;
        this.país = país;
        this.duracao = duracao;
        this.numEpisodios = numEpisodios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getPaís() {
        return país;
    }

    public void setPaís(String país) {
        this.país = país;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public int getNumEpisodios() {
        return numEpisodios;
    }

    public void setNumEpisodios(int numEpisodios) {
        this.numEpisodios = numEpisodios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Serie(String nome, String genero, String sinopse, String país, String duracao, String numEpisodios, int id) {
        this.nome = nome;
        this.genero = genero;
        this.sinopse = sinopse;
        this.país = país;
        this.duracao = duracao;
        this.numEpisodios = numEpisodios;
        this.id = id;
    }

    public String getStatus() {
        return null;
    }
}
