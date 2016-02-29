package views.antecedentesEnfermedades;


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
public class AntecedentesFisiologicosFragment extends Fragment {
    @Bind(R.id.btn_accept)
    Button btnAccept;

    @Bind(R.id.btn_cancel)
    Button btnCancel;


    public AntecedentesFisiologicosFragment() {
        // Required empty public constructor
    }
    private void setViewElements() {
        TypeFaceFont.setFontawesome(getActivity(), btnAccept);
        TypeFaceFont.setFontawesome(getActivity(), btnCancel);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_antecedentes_fisiologicos, container, false);
        ButterKnife.bind(this, view);
        setViewElements();
        return view;
    }
    @OnClick(R.id.et_parto)
    public void onParto(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        ListSelectOneOption listOneOption = ListSelectOneOption.newInstance("parto");
        listOneOption.show(fragmentManager, "list_select_one_option");
    }
    @OnClick(R.id.et_tipo_parto)
    public void onTipoParto(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        ListSelectOneOption listOneOption = ListSelectOneOption.newInstance("tipo_parto");
        listOneOption.show(fragmentManager, "list_select_one_option");
    }
    @OnClick(R.id.btn_accept)
    public void onAccept(){
        ViewUtil.showToast(getActivity(), getString(R.string.accept_success));
        closeAll();
    }
    @OnClick(R.id.btn_cancel)
    public void onCancel(){
        closeAll();
    }
    public void showFragmentTwo(){
        getActivity().findViewById(R.id.fragment_one).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_two).setVisibility(View.VISIBLE);
    }
    public void closeAll(){
            getActivity().findViewById(R.id.fragment_one).setVisibility(View.GONE);
            getActivity().findViewById(R.id.fragment_two).setVisibility(View.GONE);
            getActivity().findViewById(R.id.fragment_three).setVisibility(View.GONE);
            getActivity().findViewById(R.id.fragment_four).setVisibility(View.GONE);
    }
}
