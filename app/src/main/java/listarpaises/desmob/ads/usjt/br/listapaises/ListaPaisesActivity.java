package br.usjt.ads.desmob.listarpaises;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import listarpaises.desmob.ads.usjt.br.listapaises.R;


/**
 * Created by Matheus Ribeiro on 18/03/2018.
 * RA 816117880
 */

public class ListaPaisesActivity extends Activity {
    public static final String PAIS = "br.usjt.ads.desmob.listarpaises.pais";
    Activity atividade;
    br.usjt.ads.desmob.listarpaises.Pais[] paises;
    ArrayList<String> nomes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);
        atividade = this;
        Intent intent = getIntent();
        String continente = intent.getStringExtra(br.usjt.ads.desmob.listarpaises.MainActivity.CHAVE);
        paises = br.usjt.ads.desmob.listarpaises.Data.listarPaises(continente);
        nomes = br.usjt.ads.desmob.listarpaises.Data.listarNomes(paises);

        ListView listView = (ListView) findViewById(R.id.lista_paises);
        br.usjt.ads.desmob.listarpaises.PaisAdapter adapter = new br.usjt.ads.desmob.listarpaises.PaisAdapter(paises, this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, br.usjt.ads.desmob.listarpaises.DetalhePaisActivity.class);
                intent.putExtra(PAIS, paises[position]);

                startActivity(intent);

            }

        });
    }
}

