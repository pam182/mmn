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
public class ExamenesComplementariosFragment extends Fragment{

    View view;

    public ExamenesComplementariosFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_examenes_complementarios, container, false);
        ButterKnife.bind(this, view);
        return view;
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

    @OnClick(R.id.goBack)
    public void onBack(){
        cerrarFragment();
    }

    @OnClick(R.id.finish)
    public void onFinish(){
        cerrarFragment();
    }

}
