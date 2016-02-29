package views.antecedentesEnfermedades;


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
import utils.ViewUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmbarazosFragment extends Fragment{
    @Bind(R.id.btn_anadir)
    Button btnAnadir;

    public EmbarazosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_embarazos, container, false);
        ButterKnife.bind(this, view);
        TypeFaceFont.setFontawesome(getActivity(), btnAnadir);
        return view;
    }

    @OnClick(R.id.btn_anadir)
    public void onAnadir() {
        showCreateFragment();
    }

    public void showCreateFragment(){
        getActivity().findViewById(R.id.fragment_create_embarazo).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.fragment_list_embarazo).setVisibility(View.GONE);
    }

}
