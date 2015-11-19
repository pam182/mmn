package View.visitaMedica;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pamela.zeballos.version1.HomeFragment;
import com.pamela.zeballos.version1.MainActivity;
import com.pamela.zeballos.version1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VisitaMedicaFragment extends Fragment implements View.OnClickListener{
    private static final String ARG_SECTION_NUMBER = "section_number";
    View view;
    Button boton;

    public VisitaMedicaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_visita_medica, container, false);

        boton = (Button) view.findViewById(R.id.button);
        boton.setOnClickListener(this);
        return view;
    }
    public static VisitaMedicaFragment newInstance(int sectionNumber) {
        VisitaMedicaFragment fragment = new VisitaMedicaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();

        ft.replace(R.id.container, new CreateVisitaMedicaFragment())
                .commit();
    }
}
