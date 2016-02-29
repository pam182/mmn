package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pamela.zeballos.version1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Pamela on 1/17/16.
 */
public class SelectOneOptionAdapter extends BaseAdapter {



    private static String[] content;
    private  LayoutInflater inflater;


    public SelectOneOptionAdapter(Context context, String nameArray){
        inflater = LayoutInflater.from(context);

        content = setContent(nameArray, context);

    }
    public String[] setContent(String nameArray, Context context){
        String[] res = null;
        switch(nameArray) {
            case "estado_civil":
                res = context.getResources().getStringArray(R.array.estado_civil);
                break;
            case "nacionalidad":
                String[] locales = Locale.getISOCountries();
                List<String> countries = new ArrayList<String>();
                res = new String[locales.length];
                for (int i=0; i< locales.length; i++) {
                    Locale obj = new Locale("",locales[i]);
                    res[i] = obj.getDisplayCountry();
                }
                break;
            case "genero":
                res = context.getResources().getStringArray(R.array.genero);
                break;
            case "parto":
                res = context.getResources().getStringArray(R.array.parto);
                break;
            case "tipo_parto":
                res = context.getResources().getStringArray(R.array.tipo_parto);
                break;
            case "lista_enfermedad":
                res = context.getResources().getStringArray(R.array.lista_enfermedades);
                break;
            case "parto_embarazo":
                res = context.getResources().getStringArray(R.array.parto_embarazo);
                break;
            case "tipo_parto_embarazo":
                res = context.getResources().getStringArray(R.array.tipo_parto);
                break;
            case "parentesco":
                res = context.getResources().getStringArray(R.array.parentesco);
                break;
            case "enfermedad_parentesco":
                res = context.getResources().getStringArray(R.array.lista_enfermedades);
                break;
            case "especialidad":
                res = context.getResources().getStringArray(R.array.especialidad);
                break;
            case "sintomas":
                res = context.getResources().getStringArray(R.array.sintomas);
                break;
            case "diagnostico_consulta":
                res = context.getResources().getStringArray(R.array.lista_enfermedades);
                break;
        }
    return  res;
    }
    @Override
    public int getCount() {
        return content.length;
    }

    @Override
    public Object getItem(int position) {
        return content[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;

        if(view != null){
            holder = (ViewHolder) view.getTag();
        }else{
            view = inflater.inflate(R.layout.item_select_one_choice,parent,false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        String text = (String) getItem(position);
        holder.textOneOption.setText(text);

        return view;
    }

    static class ViewHolder{

        @Bind(R.id.text_one_option)
        TextView textOneOption;

        ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}
