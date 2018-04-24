package br.usjt.ads.desmob.listarpaises;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import listarpaises.desmob.ads.usjt.br.listapaises.R;

/**
 * Created by Matheus Ribeiro on 20/04/2018.
 * RA 816117912
 */

public class DetalhePaisActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pais);
        TextView txtPais = (TextView)findViewById(R.id.txtPais);
        Intent intent = getIntent();
        br.usjt.ads.desmob.listarpaises.Pais pais = (br.usjt.ads.desmob.listarpaises.Pais)intent.getSerializableExtra(br.usjt.ads.desmob.listarpaises.ListaPaisesActivity.PAIS);
        txtPais.setText(pais.toString());
    }
}
