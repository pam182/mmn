package utils;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.pamela.zeballos.version1.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Pamela on 2/24/16.
 */
public class NumberFragment extends DialogFragment {
    @Bind(R.id.btn_accept)
    Button btnAccept;

    @Bind(R.id.btn_cancel)
    Button btnCancel;
    @Bind(R.id.np)
    NumberPicker numberPicker;
    String opcion = null;
    String values[];


    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        opcion = args.getString("opcion");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_number, container,
                false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        ButterKnife.bind(this, view);
        setNumberPicker();
        setViewElements();
        return view;
    }

    private void setViewElements() {
        TypeFaceFont.setFontawesome(getActivity(), btnAccept);
        TypeFaceFont.setFontawesome(getActivity(), btnCancel);
    }
    private void setNumberPicker() {
        switch (opcion){
            case "menarquia":
                setNumberPickerValues(R.array.menarquia);
                break;
            case "menopausia":
                setNumberPickerValues(R.array.menopausia);
                break;
            case "duracion_menstruacion":
                setNumberPickerValues(R.array.duracion_menstruacion);
                break;
            case "tiempo_embarazo":
                setNumberPickerValues(R.array.tiempo_embarazo);
                break;
            case "frecuencia_medicamento":
                setNumberPickerValues(R.array.frecuencia_medicamento);
                break;
        }
    }
    @OnClick(R.id.btn_accept)
    public void onAccept(){
        int id=0;
        switch (opcion){
            case "menarquia":
                id = R.id.et_menarquia;
                break;
            case "menopausia":
                id = R.id.et_menopausia;
                break;
            case "duracion_menstruacion":
                id = R.id.et_frecuencia;
                break;
            case "tiempo_embarazo":
                id = R.id.et_tiempo_embarazo;
                break;
            case "frecuencia_medicamento":
                id = R.id.et_frecuencia_medicamento;
                break;
        }
        if(numberPicker.getValue()> 0){
            EditText etAltura = (EditText)getActivity().findViewById(id);
            etAltura.setText(values[numberPicker.getValue()]);
        }
        dismiss();
    }

    @OnClick(R.id.btn_cancel)
    public void onCancel(){
        dismiss();
    }

    private void setNumberPickerValues(int id) {
        values = getActivity().getResources().getStringArray(id);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(values.length - 1);
        numberPicker.setDisplayedValues(values);
        numberPicker.setWrapSelectorWheel(true);
    }
}
