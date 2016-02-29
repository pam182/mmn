package views.antecedentesEnfermedades;


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

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateAntecedentesFamiliaresFragment extends Fragment {
    View view;
    @Bind(R.id.btn_accept)
    Button btnAccept;

    @Bind(R.id.btn_cancel)
    Button btnCancel;

    @Bind(R.id.et_fecha)
    EditText etFecha;

    public CreateAntecedentesFamiliaresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_create_antecedentes_familiares, container, false);
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
        showFragmentOne();
    }

    @OnClick(R.id.btn_cancel)
    public void cancelAction() {
   showFragmentOne();
    }

    public void showFragmentOne(){
        getActivity().findViewById(R.id.fragment_two_embarazo).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_one_embarazo).setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.et_parentesco)
    public void onParentesco() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        ListSelectOneOption listOneOption = ListSelectOneOption.newInstance("parentesco");
        listOneOption.show(fragmentManager, "list_select_one_option");
    }

    @OnClick(R.id.et_enfermedad_parentesco)
    public void onEnfermedad() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        ListSelectOneOption listOneOption = ListSelectOneOption.newInstance("enfermedad_parentesco");
        listOneOption.show(fragmentManager, "list_select_one_option");
    }
    @OnClick(R.id.et_fecha)
    public void onFecha() {
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
            etFecha.setText(date);
        }
    };

}
