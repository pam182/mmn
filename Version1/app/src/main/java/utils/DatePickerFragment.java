package utils;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.app.DatePickerDialog.OnDateSetListener;

import java.util.Date;

/**
 * Created by Pamela on 2/13/16.
 */
public class DatePickerFragment extends DialogFragment
{
    OnDateSetListener ondateSet;
    private int year, month, day;
    private String opcion = "";

    public DatePickerFragment() {
    }

    public void setCallBack(OnDateSetListener ondate) {
        ondateSet = ondate;
    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        year = args.getInt("year");
        month = args.getInt("month");
        day = args.getInt("day");
        if(args.getString("opcion") != null){
            opcion = args.getString("opcion");
        }

    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),DatePickerDialog.THEME_DEVICE_DEFAULT_DARK,ondateSet, year, month, day);
        if(opcion.equals("mostrar_todo")){

        }else{
            datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
        }

        return datePickerDialog;
    }
}
