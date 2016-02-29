package views.usuario;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pamela.zeballos.version1.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import utils.NumberFragment;
import utils.TypeFaceFont;
import utils.ViewUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateDatosFisicosFragment extends Fragment {
    @Bind(R.id.btn_accept)
    Button btnAccept;

    @Bind(R.id.btn_cancel)
    Button btnCancel;


    public CreateDatosFisicosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_datos_fisicos, container, false);
        ButterKnife.bind(this, view);
        setViewElements();
        return view;
    }
    @OnClick(R.id.btn_accept)
    public void onAceptar(){
        ViewUtil.showToast(getActivity(), getString(R.string.accept_success));
        showFragmentOne();
    }
    @OnClick(R.id.btn_cancel)
    public void onCancelar(){
        showFragmentOne();
    }
    public void showFragmentOne(){
        getActivity().findViewById(R.id.fragment_one).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.fragment_two).setVisibility(View.GONE);
    }
    private void setViewElements() {
        TypeFaceFont.setFontawesome(getActivity(), btnAccept);
        TypeFaceFont.setFontawesome(getActivity(), btnCancel);
    }
//    @OnClick(R.id.et_altura)
//    public void onAltura(){
//        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//        FragmentTransaction ft = fragmentManager.beginTransaction();
//        NumberFragment numberFragment = new NumberFragment();
//        Bundle args = new Bundle();
//        args.putString("opcion", "altura");
//        numberFragment.setArguments(args);
//        numberFragment.show(ft, "");
//    }
}
