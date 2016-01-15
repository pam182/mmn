package views.antecedentesEnfermedades;


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
public class AntecedentesPersonalesFragment extends Fragment implements View.OnClickListener {
    Button showAntecedentesFisiologicos;
    Button showAntecedentesGinoobstetricos;
    Button showAntecedentesPatologicos;
    Button showEmbarazos;
    Boolean primeroCerrado = true;
    Boolean segundoCerrado = true;
    Boolean terceroCerrado = true;
    Boolean cuartoCerrado = true;

    public AntecedentesPersonalesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_antecedentes_personales, container, false);
        showAntecedentesFisiologicos = (Button) view.findViewById(R.id.showAntecedentesFisiologicos);
        showAntecedentesFisiologicos.setOnClickListener(this);
        showAntecedentesGinoobstetricos = (Button) view.findViewById(R.id.showAntecedentesGinoobstetricos);
        showAntecedentesGinoobstetricos.setOnClickListener(this);
        showAntecedentesPatologicos = (Button) view.findViewById(R.id.showAntecedentesPatologicos);
        showAntecedentesPatologicos.setOnClickListener(this);
        showEmbarazos = (Button) view.findViewById(R.id.showEmbarazos);
        showEmbarazos.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.showAntecedentesFisiologicos:
                if(primeroCerrado){
                    showFragmentOne();
                }else
                cerrarTodo();
                break;
            case R.id.showAntecedentesGinoobstetricos:
                if(segundoCerrado){
                    showFragmentTwo();
                }else
                cerrarTodo();

                break;
            case R.id.showAntecedentesPatologicos:
                if(terceroCerrado){
                    showFragmentThree();
                }else
                cerrarTodo();

                break;
            case R.id.showEmbarazos:
                if(cuartoCerrado){
                    showFragmentFour();
                }else
                cerrarTodo();

                break;
            default:

                break;

        }
    }
    public void showFragmentOne(){
        getActivity().findViewById(R.id.fragment_one).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.fragment_two).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_three).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_four).setVisibility(View.GONE);
        this.primeroCerrado = false;
    }
    public void showFragmentTwo(){
        getActivity().findViewById(R.id.fragment_one).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_two).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.fragment_three).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_four).setVisibility(View.GONE);
        this.segundoCerrado = false;
    }
    public void showFragmentThree(){
        getActivity().findViewById(R.id.fragment_one).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_two).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_three).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.fragment_four).setVisibility(View.GONE);
        this.terceroCerrado = false;
    }
    public void showFragmentFour(){
        getActivity().findViewById(R.id.fragment_one).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_two).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_three).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_four).setVisibility(View.VISIBLE);
        this.cuartoCerrado = false;
    }
    public void cerrarTodo(){
        getActivity().findViewById(R.id.fragment_one).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_two).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_three).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_four).setVisibility(View.GONE);
        this.primeroCerrado = true;
        this.segundoCerrado = true;
        this.terceroCerrado = true;
        this.cuartoCerrado = true;
    }
}
