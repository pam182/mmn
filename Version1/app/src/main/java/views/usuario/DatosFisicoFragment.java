package views.usuario;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pamela.zeballos.version1.R;

import utils.FragmentCustomAdapter;
import butterknife.ButterKnife;
import model.DatosFisicosModel;

/**
 * Created by Pamela on 12/29/15.
 */
public class DatosFisicoFragment extends Fragment implements View.OnClickListener {
    Button showDialogButton;
    Button aceptarButton;
    Button cancelarButton;
    FragmentCustomAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;


    public DatosFisicoFragment() {
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

        ButterKnife.bind(this, view);


        return view;
    }

    @Override
    public void onClick(View v) {

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
//                break;
//
            default:


                break;

        }
    }

    public void guardarDatosFisicos(){
        final DatosFisicosModel model = new DatosFisicosModel();


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




