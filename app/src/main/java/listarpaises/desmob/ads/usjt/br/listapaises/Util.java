package br.usjt.ads.desmob.listarpaises;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.lang.reflect.Field;

import listarpaises.desmob.ads.usjt.br.listapaises.R;

/**
 * Created by Matheus Ribeiro on 18/03/2018.
 * RA 816117880
 */

public class Util {
    public static Drawable getDrawable(Context context, String nome){

        Class<?> c = R.drawable.class;
        try {
            Field idField = c.getDeclaredField(nome);
            int id = idField.getInt(idField);
            return context.getResources().getDrawable(id, null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}

