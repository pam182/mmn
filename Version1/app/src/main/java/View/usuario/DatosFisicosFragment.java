package View.usuario;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.pamela.zeballos.version1.R;

import Util.FragmentCustomAdapter;
import butterknife.Bind;
import model.DatosFisicosModel;
import model.DatosPersonalesModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatosFisicosFragment extends Fragment implements OnClickListener {
    Button showDialogButton;
    Button aceptarButton;
    Button cancelarButton;
    FragmentCustomAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;
    @Bind(R.id.et_fecha)
    EditText et_fecha;

    @Bind(R.id.et_altura)
    EditText et_altura;

    @Bind(R.id.et_peso)
    EditText et_peso;

    @Bind(R.id.et_temperatura)
    EditText et_temperatura;

    public DatosFisicosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_datos_fisicos, container, false);
        // Inflate the layout for this fragment
        showDialogButton = (Button) view.findViewById(R.id.showDialog);
        showDialogButton.setOnClickListener(this);
        aceptarButton = (Button) view.findViewById(R.id.aceptarButton);
        aceptarButton.setOnClickListener(this);
        cancelarButton = (Button) view.findViewById(R.id.cancelarButton);
        cancelarButton.setOnClickListener(this);

//        Fragment old = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_one);
//
//
//        Fragment fragment = new CreateDatosFisicosFragment();
//        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//
//
//        transaction.replace(R.id.fragment_one, fragment);
//
//       transaction.commit();
        return view;
    }

    @Override
    public void onClick(View v) {
        //   Fragment fragment = (Fragment) v.findViewById(R.id.fragment_one);
        switch (v.getId()) {

            case R.id.showDialog:
                showFragmentTwo();
                break;
            case R.id.aceptarButton:
                guardarDatosFisicos();
                showFragmentOne();
                break;
            case R.id.cancelarButton:
                showFragmentOne();
                break;

            default:

                break;

        }
    }

    public void guardarDatosFisicos(){
        final DatosFisicosModel model = new DatosFisicosModel();
        model.setAltura(et_altura.getText().toString());
        model.setFecha(et_fecha.getText().toString());
        model.setPeso(et_peso.getText().toString());
        model.setTemperatura(et_temperatura.getText().toString());

    }
    public void showFragmentOne(){
        getActivity().findViewById(R.id.fragment_two).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_one).setVisibility(View.VISIBLE);
    }
    public void showFragmentTwo(){
        getActivity().findViewById(R.id.fragment_one).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_two).setVisibility(View.VISIBLE);
    }
}




