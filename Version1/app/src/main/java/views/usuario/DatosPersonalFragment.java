package views.usuario;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pamela.zeballos.version1.MainActivity;
import com.pamela.zeballos.version1.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import utils.DatePickerFragment;
import utils.DateUtil;
import utils.ListSelectOneOption;
import utils.OnButtonPressedListener;
import utils.TypeFaceFont;
import utils.ViewUtil;
import android.app.DatePickerDialog.OnDateSetListener;
import android.support.v4.app.FragmentActivity;
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

    @Bind(R.id.et_edad)
    EditText etEdad;


    private void setViewElements() {
        TypeFaceFont.setFontawesome(getActivity(), btnAccept);
        TypeFaceFont.setFontawesome(getActivity(), btnCancel);
    }

    private boolean saveData() {
        boolean res = false;

        if (!etNombre.getText().toString().isEmpty()) ;
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
    public void onEstadoCivil() {

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        ListSelectOneOption listOneOption = ListSelectOneOption.newInstance("estado_civil");
        listOneOption.show(fragmentManager, "list_select_one_option");
    }

    @OnClick(R.id.btn_accept)
    public void aceptAction() {
        ViewUtil.showToast(getActivity(), getString(R.string.accept_success));
    }

    @OnClick(R.id.btn_cancel)
    public void cancelAction() {
        ViewUtil.goHome(getActivity());
    }



    @OnClick(R.id.et_edad)
    public void onEdad() {
        showDatePicker();
    }

    private void showDatePicker() {
        DatePickerFragment date = new DatePickerFragment();

        Calendar calender = Calendar.getInstance();
        Bundle args = new Bundle();
        args.putInt("year", calender.get(Calendar.YEAR));
        args.putInt("month", calender.get(Calendar.MONTH));
        args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
        date.setArguments(args);

        date.setCallBack(ondate);
        date.show(getActivity().getSupportFragmentManager(), "Date Picker");
    }

    OnDateSetListener ondate = new OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            String date = String.valueOf(dayOfMonth)+"/"+String.valueOf(monthOfYear)+"/"+String.valueOf(year);
//            int age = DateUtil.calculateAge(date);
            int age = DateUtil.calcularEdad(date);
            etEdad.setText(age+" años");
        }
    };

    @OnClick(R.id.et_nacionalidad)
    public void onNacionalidad(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        ListSelectOneOption listOneOption = ListSelectOneOption.newInstance("nacionalidad");
        listOneOption.show(fragmentManager, "list_select_one_option");
    }
    @OnClick(R.id.et_genero)
    public void onGenero(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        ListSelectOneOption listOneOption = ListSelectOneOption.newInstance("genero");
        listOneOption.show(fragmentManager, "list_select_one_option");
    }
}












