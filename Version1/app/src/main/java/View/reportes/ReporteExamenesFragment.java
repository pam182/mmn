package View.reportes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pamela.zeballos.version1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReporteExamenesFragment extends Fragment {


    public ReporteExamenesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reporte_examenes, container, false);
    }


}
