package br.usjt.ads.desmob.listarpaises;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.Hashtable;

import listarpaises.desmob.ads.usjt.br.listapaises.R;

import static br.usjt.ads.desmob.listarpaises.R.drawable.bandeira;

/**
 * Created by Matheus Ribeiro on 18/03/2018.
 * RA 816117880
 */
public class PaisAdapter extends BaseAdapter implements SectionIndexer {
    private br.usjt.ads.desmob.listarpaises.Pais[] paises;
    private Activity activity;
    Object[] sectionHeaders;
    Hashtable<Integer, Integer> positionForSectionMap;
    Hashtable<Integer, Integer> sectionForPositionMap;

    public PaisAdapter(br.usjt.ads.desmob.listarpaises.Pais[] paises, Activity activity) {
        this.paises = paises;
        this.activity = activity;
        sectionHeaders = br.usjt.ads.desmob.listarpaises.SectionIndexBuilder.buildSectionHeaders(paises);
        positionForSectionMap = br.usjt.ads.desmob.listarpaises.SectionIndexBuilder.buildPositionForSectionMap(paises);
        sectionForPositionMap = br.usjt.ads.desmob.listarpaises.SectionIndexBuilder.buildSectionForPositionMap(paises);
    }

    @Override
    public int getCount() {
        return paises.length;
    }

    @Override
    public Object getItem(int position) {
        return paises[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_pais, parent, false);
            ImageView bandeira = (ImageView) view.findViewById(R.id.foto_pais);
            TextView nome = (TextView) view.findViewById(R.id.texto_nome_pais);
            TextView detalhe = (TextView) view.findViewById(R.id.texto_detalhe_pais);
            br.usjt.ads.desmob.listarpaises.ViewHolder viewHolder = new br.usjt.ads.desmob.listarpaises.ViewHolder(bandeira, nome, detalhe);
            view.setTag(viewHolder);

        }

        br.usjt.ads.desmob.listarpaises.ViewHolder viewHolder = (br.usjt.ads.desmob.listarpaises.ViewHolder)view.getTag();
        viewHolder.getNome().setText(paises[position].getNome());
        viewHolder.getDetalhe().setText(String.format("região: %s - capital: %s",
                paises[position].getRegiao(),
                paises[position].getCapital()));
        Drawable drawable = Util.getDrawable(activity, paises[position].getCodigo3().toLowerCase());
        if(drawable == null){
            drawable = activity.getDrawable(bandeira);
        }
        System.out.println(paises[position].getNome());
        viewHolder.getBandeira().setImageDrawable(drawable);

        return view;
    }


    @Override
    public Object[] getSections() {
        return sectionHeaders;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return positionForSectionMap.get(sectionIndex).intValue();
    }

    @Override
    public int getSectionForPosition(int position) {
        return sectionForPositionMap.get(position).intValue();
    }
}