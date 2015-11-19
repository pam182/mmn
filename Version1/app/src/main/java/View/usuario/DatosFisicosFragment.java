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

import com.pamela.zeballos.version1.R;

import Util.FragmentCustomAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatosFisicosFragment extends Fragment implements OnClickListener {
    Button showDialogButton;
    Button aceptarButton;
    Button cancelarButton;
    FragmentCustomAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

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
                showFragmentOne();
                break;
            case R.id.cancelarButton:
                showFragmentOne();
                break;

            default:

                break;

        }
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




