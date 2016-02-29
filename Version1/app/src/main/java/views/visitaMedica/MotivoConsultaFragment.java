package views.visitaMedica;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pamela.zeballos.version1.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MotivoConsultaFragment extends Fragment{
    Boolean primeroCerrado = true;
    Boolean segundoCerrado = true;
    View view;

    public MotivoConsultaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_motivo_consulta, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.one)
    public void onOne(){
        if(primeroCerrado){
            showFragmentOne();
        }else
            cerrarTodo();
    }

    @OnClick(R.id.two)
    public void onTwo(){
        if(segundoCerrado){
            showFragmentTwo();
        }else
            cerrarTodo();
    }
    @OnClick(R.id.goBack)
    public void onBack(){
        cerrarFragment();
    }

    @OnClick(R.id.finish)
    public void onFinish(){
        cerrarFragment();
    }

    public void showFragmentOne(){
        view.findViewById(R.id.fragment_one_consulta).setVisibility(View.VISIBLE);
        view.findViewById(R.id.fragment_two_consulta).setVisibility(View.GONE);
        this.primeroCerrado = false;
    }
    public void showFragmentTwo(){
        view.findViewById(R.id.fragment_one_consulta).setVisibility(View.GONE);
        view.findViewById(R.id.fragment_two_consulta).setVisibility(View.VISIBLE);
        this.segundoCerrado = false;
    }
    public void cerrarTodo(){
        view.findViewById(R.id.fragment_one_consulta).setVisibility(View.GONE);
        view.findViewById(R.id.fragment_two_consulta).setVisibility(View.GONE);
        this.primeroCerrado = true;
        this.segundoCerrado = true;
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
}
