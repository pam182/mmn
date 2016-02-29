package views.visitaMedica;



import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pamela.zeballos.version1.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import utils.TypeFaceFont;

/**
 * A simple {@link Fragment} subclass.
 */
public class SintomasFragment extends Fragment {
    @Bind(R.id.btn_anadir)
    Button btnAnadir;


    public SintomasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sintomas, container, false);
        ButterKnife.bind(this, view);
        TypeFaceFont.setFontawesome(getActivity(), btnAnadir);
        return view;
    }

    @OnClick(R.id.btn_anadir)
    public void onAnadir(){
        showFragmentTwo();
    }

    public void showFragmentTwo(){
        getActivity().findViewById(R.id.fragment_two_sintomas).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.fragment_one_sintomas).setVisibility(View.GONE);
    }
}
