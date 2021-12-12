package com.example.mylist.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BancoListaOrganizacaoSQLite extends SQLiteOpenHelper{
    private static final String NOME_BANCO = "mylist.db";

    private static final String TABELA_SERIE = "create table if not exists serie(" + "id INTEGER primary key autoincrement, nome TEXT ," +
            "genero TEXT,sinopse TEXT,pais TEXT ,duracao TEXT , numEpisodios INTEGER)";

    private static final String TABELA_LISTA = "create table if not exists LISTA(" + "id INTEGER primary key autoincrement ,nome TEXT,dia BIGINT)";


    private static final String TABELA_LISTA_SERIE = "create table if not exists lista_serie(" + "id_lista INTEGER,id_serie INTEGER"+
            " primary key(id_lista,id_serie),nome TEXT,status TEXT)" ;

    public BancoListaOrganizacaoSQLite(@Nullable Context context) {
        super(context, NOME_BANCO,null ,1);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        //criacao do banco
        bd.execSQL(TABELA_SERIE);
        bd.execSQL(TABELA_LISTA);
        bd.execSQL(TABELA_LISTA_SERIE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // nao  iremos implementar pois nao vamos considerar modificacoes
    }
}