package View.usuario;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
//import com.parse.ParseAnalytics;
import com.parse.ParseObject;

import com.pamela.zeballos.version1.R;

import butterknife.Bind;
import model.DatosPersonalesModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatosPersonalesFragment extends Fragment{

    @Bind(R.id.datos_nombre)
    EditText datosNombre;
    @Bind(R.id.datos_edad)
    EditText datosEdad;
    @Bind(R.id.datos_estado_civil)
    EditText datosEstadoCivil;
    @Bind(R.id.datos_nacionalidad)
    EditText datosNacionalidad;
    @Bind(R.id.datos_ocupacion)
    EditText datosOcupacion;
    @Bind(R.id.datos_domicilio)
    EditText datosDomicilio;
    @Bind(R.id.datos_responsable)
    EditText datosResponsable;
    @Bind(R.id.datos_sexo)
    EditText datosSexo;

    public DatosPersonalesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

//        ParseAnalytics.trackAppOpenedInBackground(getActivity().getIntent());
//
//        ParseObject testObject = new ParseObject("TestObject");
//        testObject.put("foo", "bar");
//        testObject.saveInBackground();
        setActions();

        return inflater.inflate(R.layout.fragment_datos_personales, container, false);
    }

    private void setActions() {
        final DatosPersonalesModel model = new DatosPersonalesModel();

        datosNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
             model.setDatosNombre(datosNombre.getText().toString());
                model.saveEventually();
            }
        });

//        datosEdad.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                model.setDatosNombre(datosEdad.getText().toString());
//                model.saveEventually();
//            }
//        });
//
//
//        datosEstadoCivil.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                model.setDatosNombre(datosEstadoCivil.getText().toString());
//                model.saveEventually();
//            }
//        });
//        datosNacionalidad.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                model.setDatosNombre(datosNacionalidad.getText().toString());
//                model.saveEventually();
//            }
//        });
//
//
//
//        datosOcupacion.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                model.setDatosNombre(datosOcupacion.getText().toString());
//                model.saveEventually();
//            }
//        });
//        datosDomicilio.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                model.setDatosNombre(datosDomicilio.getText().toString());
//                model.saveEventually();
//            }
//        });
//
//        datosResponsable.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                model.setDatosNombre(datosResponsable.getText().toString());
//                model.saveEventually();
//            }
//        });
//        datosSexo.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                model.setDatosNombre(datosSexo.getText().toString());
//                model.saveEventually();
//            }
//        });
   }


}
