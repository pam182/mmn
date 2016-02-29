package utils;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.pamela.zeballos.version1.R;

import adapter.SelectOneOptionAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by Pamela on 1/14/16.
 */
public class ListSelectOneOption extends DialogFragment {
    private SelectOneOptionAdapter adapter;
    String data;
    private static String array;

    @Bind(R.id.listview_select_one_option)
    ListView listView;



    public ListSelectOneOption(){
    }

    public static ListSelectOneOption newInstance(String arrayOption){
        array = arrayOption;
        ListSelectOneOption frag = new ListSelectOneOption();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return  frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_select_one_option, container);
        ButterKnife.bind(this, view);

        adapter = new SelectOneOptionAdapter(getActivity(), array);
        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }



    @OnItemClick(R.id.listview_select_one_option)
    public void onItemClick(int position) {
        data = adapter.getItem(position).toString();
        switch (array) {
            case "estado_civil":
                TextView textView = (TextView)(getActivity().findViewById(R.id.et_estado_civil));
                textView.setText(data);
                dismiss();
                break;
            case "nacionalidad":
                setTextData(R.id.et_nacionalidad);
                break;
            case "genero":
                setTextData(R.id.et_genero);
                break;
            case "parto":
                setTextData(R.id.et_parto);
                break;
            case "tipo_parto":
                setTextData(R.id.et_tipo_parto);
                break;
            case "lista_enfermedad":
                EditText etEnfermedad = (EditText)(getActivity().findViewById(R.id.et_enfermedad));
                System.out.println("====== " + data);
                if(data.equals("Otro:")){
                    System.out.println("====== true");
                    etEnfermedad.setFocusable(true);
                    dismiss();
                }else{
                    System.out.println("====== false");
                   etEnfermedad.setText(data);
                    dismiss();
                }
                break;
            case "parto_embarazo":
                setTextData(R.id.et_parto_embarazo);
                break;
            case "tipo_parto_embarazo":
                setTextData(R.id.et_tipo_parto_embarazo);
                break;
            case "parentesco":
                setTextData(R.id.et_parentesco);
                break;
            case "enfermedad_parentesco":
                EditText etEnfermedadParentesco = (EditText)(getActivity().findViewById(R.id.et_enfermedad_parentesco));
                System.out.println("====== " + data);
                if(data.equals("Otro:")){
                    System.out.println("====== true");
                    etEnfermedadParentesco.setFocusable(true);
                    dismiss();
                }else{
                    System.out.println("====== false");
                    etEnfermedadParentesco.setText(data);
                    dismiss();
                }
                break;
            case "especialidad":
                setTextData(R.id.et_especialidad);
                break;
            case "sintomas":
                setTextData(R.id.et_sintomas);
                break;
            case "diagnostico_consulta":
                EditText diagnostico = (EditText)(getActivity().findViewById(R.id.et_diagnostico_consulta));
                System.out.println("====== " + data);
                if(data.equals("Otro:")){
                    System.out.println("====== true");
                    diagnostico.setFocusable(true);
                    dismiss();
                }else{
                    System.out.println("====== false");
                    diagnostico.setText(data);
                    dismiss();
                }
                break;
        }
    }
    public void setTextData(int id){
        EditText editText =(EditText) (getActivity().findViewById(id));
        editText.setText(data);
        dismiss();
    }
}
