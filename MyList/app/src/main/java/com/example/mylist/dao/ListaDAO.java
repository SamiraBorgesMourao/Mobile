package com.example.mylist.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mylist.modelo.ListaOrganizacao;
import com.example.mylist.modelo.SerieLista;
import com.example.mylist.persistencia.BancoListaOrganizacaoSQLite;

import java.util.ArrayList;
import java.util.Date;

public class ListaDAO {
    private final Context contexto;
    private final BancoListaOrganizacaoSQLite sqLiteOpen;
    private SQLiteDatabase banco;
    private Object SerieLista;

    public ListaDAO(Context contexto) {
        this.contexto = contexto;

        this.sqLiteOpen=new BancoListaOrganizacaoSQLite(contexto);
        abrirconexao();
    }
    public void insertLista(ListaOrganizacao novaLista){
        //inserir a lista
        ContentValues valoresAtt= new ContentValues();
        valoresAtt.put("nome",novaLista.getNome());
        valoresAtt.put("dia",novaLista.getDia().getTime());

       long id= banco.insert("lista",null,valoresAtt);
       novaLista.setId((int)id);

        //inserir as series da lista na tabela(match)
        insertSerieLista(novaLista);

    }

    private void insertSerieLista(ListaOrganizacao novaLista) {
        for (SerieLista s : novaLista.getSerie()) {
            ContentValues valoresAtt = new ContentValues();

            //"id_lista INTEGER,id_serie INTEGER"+" primary key(id_lista,id_serie)nome TEXT,status TEXT)" ;
            valoresAtt.put("id_lista", novaLista.getId());
            valoresAtt.put("id_Serie", s.getSerieCadastrada().getId());
            valoresAtt.put("nome", s.getSerieCadastrada().getNome());
            valoresAtt.put("status", s.getSerieCadastrada().getStatus());

            banco.insert("lista_serie", null, valoresAtt);
        }
    }
        public ArrayList<ListaOrganizacao>buscarTodasListas(){


            String[] att = {"id","nome","dia"};
            Cursor tuplas =banco.query("lista",att,null ,null,null,null,null);

           ArrayList<ListaOrganizacao> listas =new ArrayList<>();

           while (tuplas.moveToNext())
           {
               ListaOrganizacao novaLista = new ListaOrganizacao(tuplas.getInt(0),
               tuplas.getString(1),
               tuplas.getLong(2),tuplas.getLong(2));
           }

            return null;
        }

        public ListaOrganizacao buscarLista(int idLista){

        String[] att ={"id","nome","dia"};
        Cursor tuplas =banco.query("lista",att,"id="+idLista,null,null,null,null);

        tuplas.moveToFirst();

        if(!tuplas.isNull(0)){
        ListaOrganizacao lista = new ListaOrganizacao(
                tuplas.getString(1),
                tuplas.getInt(0),
                new Date(tuplas.getLong(2))
                );
        buscarSerieLista();
        return lista;
            }

            return null;
        }
        private void buscarSerieLista(){
            ListaOrganizacao lista = null;
            String sql ="SELECT serie.id.serie, serie.nome, serie.genero ,serie.sinopse ,serie.país ,serie.duracao, serie.numEpisodios"+
        "lista_serie.nome,lista_serie.status "+
        "FROM serie,lista_serie WHERE serie.id=lista_serie.id.serie AND lista_serie.id_lista" + lista.getId();

        Cursor tuplas= banco.rawQuery(sql,null);

        while(tuplas.moveToNext()){
            SerieLista serieLista= new SerieLista(tuplas.getInt(0),
                    tuplas.getString(1),tuplas.getString(2),
                    tuplas.getString(3),tuplas.getString(4),tuplas.getString(5),
            tuplas.getInt(6)
);

    lista.addSerie(serieLista);


        }

        }
        public void finalizarLista(ListaOrganizacao listacompleta){
        atualizaSerieLista(listacompleta);
    }
    private void atualizaSerieLista(ListaOrganizacao lista){
        for (SerieLista s:lista.getSerie()) {
            ContentValues att = new ContentValues();
        }
        }

    

    private void  abrirconexao(){
        banco=sqLiteOpen.getWritableDatabase();


    }
    public void fecharconexao(){
        banco.close();
    }
}
