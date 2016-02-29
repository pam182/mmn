package views.visitaMedica;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pamela.zeballos.version1.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import utils.ListSelectOneOption;
import utils.TypeFaceFont;
import utils.ViewUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateSintomasFragment extends Fragment {
    @Bind(R.id.btn_accept)
    Button btnAccept;

    @Bind(R.id.btn_cancel)
    Button btnCancel;

    public CreateSintomasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_sintomas, container, false);
        ButterKnife.bind(this, view);
        setViewElements();
        return view;
    }

    private void setViewElements() {
        TypeFaceFont.setFontawesome(getActivity(), btnAccept);
        TypeFaceFont.setFontawesome(getActivity(), btnCancel);
    }

    @OnClick(R.id.btn_accept)
    public void aceptAction() {
        ViewUtil.showToast(getActivity(), getString(R.string.accept_success));
        closeFragment();
    }

    @OnClick(R.id.btn_cancel)
    public void cancelAction() {
closeFragment();
    }

public void closeFragment() {
    getActivity().findViewById(R.id.fragment_two_sintomas).setVisibility(View.GONE);
    getActivity().findViewById(R.id.fragment_one_sintomas).setVisibility(View.VISIBLE);
}
    @OnClick(R.id.et_sintomas)
    public void onGenero(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        ListSelectOneOption listOneOption = ListSelectOneOption.newInstance("sintomas");
        listOneOption.show(fragmentManager, "list_select_one_option");
    }
}
