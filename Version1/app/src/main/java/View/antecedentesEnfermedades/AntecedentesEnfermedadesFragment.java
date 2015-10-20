package View.antecedentesEnfermedades;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pamela.zeballos.version1.MainActivity;
import com.pamela.zeballos.version1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AntecedentesEnfermedadesFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";


    public static AntecedentesEnfermedadesFragment newInstance(int sectionNumber) {
        AntecedentesEnfermedadesFragment fragment = new AntecedentesEnfermedadesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    public AntecedentesEnfermedadesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_antecedentes_enfermedades, container, false);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }

}
