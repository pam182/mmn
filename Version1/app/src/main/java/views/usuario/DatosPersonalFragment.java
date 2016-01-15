package views.usuario;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.pamela.zeballos.version1.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import utils.TypeFaceFont;
import utils.ViewUtil;

/**
 * Created by Pamela on 12/29/15.
 */
public class DatosPersonalFragment extends Fragment {
    @Bind(R.id.et_nombre)
    EditText etNombre;

    @Bind(R.id.btn_accept)
    Button btnAccept;

    @Bind(R.id.btn_cancel)
    Button btnCancel;

    private void setViewElements(){
        TypeFaceFont.setFontawesome(getActivity(), btnAccept);
        TypeFaceFont.setFontawesome(getActivity(), btnCancel);
    }

    private boolean saveData(){
        boolean res = false;
        
        if(!etNombre.getText().toString().isEmpty());
        return res;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_datos_personales, container, false);
        ButterKnife.bind(this, view);
        setViewElements();
        return view;
    }

    @OnClick(R.id.et_estado_civil)
    public void onEstadoCivil(){
        System.out.println("------------ 1");
        ViewUtil.showSelectOneOption(getActivity());
    }

    @OnClick(R.id.btn_accept)
    public void aceptAction(){
        ViewUtil.showToast(getActivity(),getString(R.string.accept_success));
    }

    @OnClick(R.id.btn_cancel)
    public void cancelAction()  {
        ViewUtil.goHome(getActivity());
    }

}



