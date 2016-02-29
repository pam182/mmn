package views.antecedentesEnfermedades;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import utils.NumberFragment;
import utils.TypeFaceFont;
import utils.ViewUtil;


public class AntecedentesGinoobstetricosFragment extends Fragment {
    @Bind(R.id.btn_accept)
    Button btnAccept;

    @Bind(R.id.btn_cancel)
    Button btnCancel;

    @Bind(R.id.et_fecha_menstruacion)
    EditText etFechaMenstruacion;

    public AntecedentesGinoobstetricosFragment() {
        // Required empty public constructor
    }

    private void setViewElements() {
        TypeFaceFont.setFontawesome(getActivity(), btnAccept);
        TypeFaceFont.setFontawesome(getActivity(), btnCancel);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_antecedentes_ginoobstetricos, container, false);
        ButterKnife.bind(this, view);
        setViewElements();
        return view;
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

    @OnClick(R.id.et_menarquia)
         public void onMenarquia(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        NumberFragment numberFragment = new NumberFragment();
        Bundle args = new Bundle();
        args.putString("opcion", "menarquia");
        numberFragment.setArguments(args);
        numberFragment.show(ft, "");
    }

    @OnClick(R.id.et_menopausia)
    public void onMenopausia(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        NumberFragment numberFragment = new NumberFragment();
        Bundle args = new Bundle();
        args.putString("opcion", "menopausia");
        numberFragment.setArguments(args);
        numberFragment.show(ft, "");
    }

    @OnClick(R.id.et_frecuencia)
    public void onFrecuencia(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        NumberFragment numberFragment = new NumberFragment();
        Bundle args = new Bundle();
        args.putString("opcion", "duracion_menstruacion");
        numberFragment.setArguments(args);
        numberFragment.show(ft, "");
    }


    @OnClick(R.id.et_fecha_menstruacion)
    public void onFechaMenstruacion(){
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
            etFechaMenstruacion.setText(date);
        }
    };
    public void closeAll(){
        getActivity().findViewById(R.id.fragment_one).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_two).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_three).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_four).setVisibility(View.GONE);
    }
}
