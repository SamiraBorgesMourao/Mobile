package com.example.mylist.modelo;

public class SerieLista {
    private  Serie serieCadastrada;

    public SerieLista(Serie serieCadastrada) {
        this.serieCadastrada = serieCadastrada;
    }

    public SerieLista(int anInt, String string, String string1, String string2, String string3, String string4, int anInt1) {

    }

    public Serie getSerieCadastrada() {
        return serieCadastrada;
    }

    public void setSerieCadastrada(Serie serieCadastrada) {
        this.serieCadastrada = serieCadastrada;
    }
}
