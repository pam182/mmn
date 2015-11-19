package View.visitaMedica;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pamela.zeballos.version1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiagnosticoConsultaFragment extends Fragment implements View.OnClickListener{
    Button fragment_one_button;

    Button goBackButton;
    Button finishButton;
    Boolean primeroCerrado = true;

    View view;

    public DiagnosticoConsultaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_diagnostico_consulta, container, false);
        fragment_one_button = (Button) view.findViewById(R.id.one);
        fragment_one_button.setOnClickListener(this);

        goBackButton = (Button) view.findViewById(R.id.goBack);
        goBackButton.setOnClickListener(this);
        finishButton = (Button) view.findViewById(R.id.finish);
        finishButton.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.one:
                if(primeroCerrado){
                    showFragmentOne();
                }else
                    cerrarTodo();
                break;
            case R.id.goBack:
                cerrarFragment();
                break;
            case R.id.finish:
                cerrarFragment();
                break;
            default:

                break;

        }
    }
    public void showFragmentOne(){
        view.findViewById(R.id.fragment_one).setVisibility(View.VISIBLE);
        this.primeroCerrado = false;
    }
    public void cerrarFragment(){
        try {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.container, new VisitaMedicaFragment().newInstance(3)).commit();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    public void cerrarTodo(){
        view.findViewById(R.id.fragment_one).setVisibility(View.GONE);
        this.primeroCerrado = true;

    }

}
