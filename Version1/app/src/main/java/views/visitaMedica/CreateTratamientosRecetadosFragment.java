package views.visitaMedica;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
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
import android.widget.ImageView;

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

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateTratamientosRecetadosFragment extends Fragment {
    @Bind(R.id.btn_accept)
    Button btnAccept;

    @Bind(R.id.btn_cancel)
    Button btnCancel;

    @Bind(R.id.et_inicio_tratamiento)
    EditText inicioTratamiento;

    @Bind(R.id.et_fin_tratamiento)
    EditText finTratamiento;

    @Bind(R.id.img_taken)
    ImageView imgTaken;

    public CreateTratamientosRecetadosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_tratamientos_recetados, container, false);
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
        getActivity().findViewById(R.id.fragment_two_tratamientos).setVisibility(View.GONE);
        getActivity().findViewById(R.id.fragment_one_tratamientos).setVisibility(View.VISIBLE);
    }
    @OnClick(R.id.et_inicio_tratamiento)
    public void onInicioTratamiento() {
        showDatePicker();
    }

    private void showDatePicker() {
        DatePickerFragment date = new DatePickerFragment();

        Calendar calender = Calendar.getInstance();
        Bundle args = new Bundle();
        args.putInt("year", calender.get(Calendar.YEAR));
        args.putInt("month", calender.get(Calendar.MONTH));
        args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
        args.putString("opcion", "mostrar_todo");
        date.setArguments(args);

        date.setCallBack(ondate);
        date.show(getActivity().getSupportFragmentManager(), "Date Picker");
    }

    DatePickerDialog.OnDateSetListener ondate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            String date = String.valueOf(dayOfMonth)+"/"+String.valueOf(monthOfYear)+"/"+String.valueOf(year);

            inicioTratamiento.setText(date);
        }
    };
    @OnClick(R.id.et_fin_tratamiento)
    public void onFinTratamiento() {
        showDatePicker2();
    }

    private void showDatePicker2() {
        DatePickerFragment date = new DatePickerFragment();

        Calendar calender = Calendar.getInstance();
        Bundle args = new Bundle();
        args.putInt("year", calender.get(Calendar.YEAR));
        args.putInt("month", calender.get(Calendar.MONTH));
        args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
        args.putString("opcion", "mostrar_todo");
        date.setArguments(args);

        date.setCallBack(ondate2);
        date.show(getActivity().getSupportFragmentManager(), "Date Picker");
    }

    DatePickerDialog.OnDateSetListener ondate2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            String date = String.valueOf(dayOfMonth)+"/"+String.valueOf(monthOfYear)+"/"+String.valueOf(year);
            finTratamiento.setText(date);
        }
    };
    @OnClick(R.id.et_frecuencia_medicamento)
    public void onFrecuencia(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        NumberFragment numberFragment = new NumberFragment();
        Bundle args = new Bundle();
        args.putString("opcion", "frecuencia_medicamento");
        numberFragment.setArguments(args);
        numberFragment.show(ft, "");
    }
    @OnClick(R.id.btn_take_camera)
    public void onTakeCamera(){
        Intent intent = new Intent(getActivity(), CameraPhotoCapture.class);
        startActivity(intent);
    }



    @Override
   public void onDestroy() {
        super.onDestroy();
    }

}






