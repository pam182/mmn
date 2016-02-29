package views.antecedentesEnfermedades;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;
import com.pamela.zeballos.version1.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import utils.TypeFaceFont;

/**
 * A simple {@link Fragment} subclass.
 */
public class AntecedentesFamiliaresFragment extends Fragment  {

    View view;
    @Bind(R.id.btn_anadir)
    Button btnAnadir;

    public AntecedentesFamiliaresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_antecedentes_familiares, container, false);
        ButterKnife.bind(this, view);
        TypeFaceFont.setFontawesome(getActivity(), btnAnadir);
        return view;
    }

    public void showFragmentTwo(){
        view.findViewById(R.id.fragment_one_embarazo).setVisibility(View.GONE);
        view.findViewById(R.id.fragment_two_embarazo).setVisibility(View.VISIBLE);
    }
    @OnClick(R.id.btn_anadir)
    public void onAnadir(){
        showFragmentTwo();
    }

}
