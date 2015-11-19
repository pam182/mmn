package item_list;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pamela.zeballos.version1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemVisitaMedicaFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    public ItemVisitaMedicaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_visita_medica, container, false);
    }
    public static ItemVisitaMedicaFragment newInstance(int sectionNumber) {
        ItemVisitaMedicaFragment fragment = new ItemVisitaMedicaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;

    }


}
