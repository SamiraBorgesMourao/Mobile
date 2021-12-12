package com.example.mylist.dao;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.example.mylist.modelo.Serie;
import com.example.mylist.persistencia.BancoListaOrganizacaoSQLite;

public class SerieDAO {

    private SQLiteDatabase banco;

    private BancoListaOrganizacaoSQLite sqLiteOpen;
    private Context contexto;


    public SerieDAO(Context contexto) {
        this.contexto = contexto;
        this.sqLiteOpen = new BancoListaOrganizacaoSQLite(contexto);
        abrirconexao();
    }

    public void inserirSerie(Serie novaSerie) {
        ContentValues valoresAtt = new ContentValues();
        valoresAtt.put("nome", novaSerie.getNome());
        valoresAtt.put("genero", novaSerie.getGenero());
        valoresAtt.put("sinopse", novaSerie.getSinopse());
        valoresAtt.put("pais", novaSerie.getPaís());
        valoresAtt.put("Duracao", novaSerie.getDuracao());
        valoresAtt.put("numEpisodios", novaSerie.getNumEpisodios());

        long id = banco.insert("serie", null, valoresAtt);
        Log.d("SerieDao","+id");
        novaSerie.setId((int) id);
        fecharconexao();
    }


    public Serie buscaSerie(int id) {
        Serie resultado = null;
        String atributos[] = {"id ","nome", "genero", "sinopse", "pais", "duração ", "numEpisodios"};


        Cursor tuplas = banco.query("produtos", atributos, "id" + id, null,
                null, null, null);
        tuplas.moveToFirst();


        if (!tuplas.isNull(0)){
            resultado = new Serie(tuplas.getString(0),tuplas.getString(1),
                    tuplas.getString(2), tuplas.getString(3),tuplas.getString(4),
                    tuplas.getString(5),tuplas.getInt(6));

        }
        return resultado;

    }
        private void abrirconexao(){
            banco = sqLiteOpen.getWritableDatabase();

        }
        private void fecharconexao(){
            banco.close();
        }
    }
