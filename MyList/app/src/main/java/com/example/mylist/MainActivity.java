package com.example.mylist;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylist.dao.SerieDAO;
import com.example.mylist.modelo.Serie;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testeInsert();
        testeRecuperar();
    }
private void testeInsert(){
        Serie originals= new Serie("Originals","drama","familia de vampiros","EUA","45min","92");
        SerieDAO dao = new SerieDAO(MainActivity.this);
        dao.inserirSerie(originals);
}
private void testeRecuperar(){
        SerieDAO dao=new SerieDAO(MainActivity.this);
        Serie originals=dao.buscaSerie(id:2);
    if(originals!=null){
        Log.d("Main",originals.getNome());
    }

}
}