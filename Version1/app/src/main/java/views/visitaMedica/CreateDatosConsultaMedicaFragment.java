package views.visitaMedica;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.pamela.zeballos.version1.R;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import utils.DatePickerFragment;
import utils.DateUtil;
import utils.ListSelectOneOption;
import utils.TypeFaceFont;
import utils.ViewUtil;

public class CreateDatosConsultaMedicaFragment extends Fragment {
    @Bind(R.id.btn_accept)
    Button btnAccept;

    @Bind(R.id.btn_cancel)
    Button btnCancel;

    @Bind(R.id.et_fecha_consulta)
     EditText fechaConculta;

    public CreateDatosConsultaMedicaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_datos_consulta_medica, container, false);
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
        closeFragmentOne();
    }

    @OnClick(R.id.btn_cancel)
    public void cancelAction() {
closeFragmentOne();
    }
    public void closeFragmentOne(){
        getActivity().findViewById(R.id.fragment_one_consulta).setVisibility(View.GONE);
//        getActivity().findViewById(R.id.fragment_two_consulta).setVisibility(View.GONE);
    }

    @OnClick(R.id.et_especialidad)
    public void onEspecialidad() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        ListSelectOneOption listOneOption = ListSelectOneOption.newInstance("especialidad");
        listOneOption.show(fragmentManager, "list_select_one_option");
    }

    @OnClick(R.id.et_fecha_consulta)
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

    DatePickerDialog.OnDateSetListener ondate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            String date = String.valueOf(dayOfMonth)+"/"+String.valueOf(monthOfYear)+"/"+String.valueOf(year);
            fechaConculta.setText(date);
        }
    };
}
