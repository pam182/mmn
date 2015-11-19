package View.antecedentesEnfermedades;


import android.graphics.Typeface;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pamela.zeballos.version1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmbarazosFragment extends Fragment implements View.OnClickListener {
    Button anadirButton;
    Button aceptarCreatePatologicoButton;
    Button cancelarcreatePatologicoButton;

    public EmbarazosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_embarazos, container, false);
        anadirButton = (Button) view.findViewById(R.id.anadir);
        anadirButton.setOnClickListener(this);
        aceptarCreatePatologicoButton = (Button) view.findViewById(R.id.aceptarCreatePatologicoButton);
        aceptarCreatePatologicoButton.setOnClickListener(this);
        cancelarcreatePatologicoButton = (Button) view.findViewById(R.id.cancelarCreatePatologigoButton);
        cancelarcreatePatologicoButton.setOnClickListener(this);


        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fontawesome-webfont.ttf");
        anadirButton.setTypeface(font);
        aceptarCreatePatologicoButton.setTypeface(font);
        cancelarcreatePatologicoButton.setTypeface(font);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.anadir:
                showFragmentTwo();
                break;
            case R.id.aceptarCreatePatologicoButton:
                showFragmentOne();
                break;
            case R.id.cancelarCreatePatologigoButton:
                showFragmentOne();
                break;

            default:

                break;

        }
    }

    public void showFragmentOne(){
        getActivity().findViewById(R.id.fragment_create_embarazo).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_list_embarazo).setVisibility(View.VISIBLE);
    }
    public void showFragmentTwo(){
        getActivity().findViewById(R.id.fragment_list_embarazo).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_create_embarazo).setVisibility(View.VISIBLE);
    }
}
