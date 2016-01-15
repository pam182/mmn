package views.antecedentesEnfermedades;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;
import com.pamela.zeballos.version1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AntecedentesFamiliaresFragment extends Fragment implements OnClickListener {
    Button anadirButton;
    Button aceptarButton;
    Button cancelarButton;
    View view;

    public AntecedentesFamiliaresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_antecedentes_familiares, container, false);
        anadirButton = (Button) view.findViewById(R.id.anadir);
        anadirButton.setOnClickListener(this);
        aceptarButton = (Button) view.findViewById(R.id.aceptar);
        aceptarButton.setOnClickListener(this);
        cancelarButton = (Button) view.findViewById(R.id.cancelar);
        cancelarButton.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.anadir:
                showFragmentTwo();
                break;
            case R.id.aceptar:
                showFragmentOne();
                break;
            case R.id.cancelar:
                showFragmentOne();
                break;

            default:

                break;

        }
    }
    public void showFragmentOne(){

        view.findViewById(R.id.fragment_two).setVisibility(View.GONE);
        view.findViewById(R.id.fragment_one).setVisibility(View.VISIBLE);
    }
    public void showFragmentTwo(){
        view.findViewById(R.id.fragment_one).setVisibility(View.GONE);
        view.findViewById(R.id.fragment_two).setVisibility(View.VISIBLE);
    }
}
