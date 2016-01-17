package utils;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.pamela.zeballos.version1.R;

import butterknife.Bind;

/**
 * Created by Pamela on 1/14/16.
 */
public class ListSelectOneOption extends DialogFragment {
    @Bind(R.id.listview_select_one_option)
    ListView listView;

    public ListSelectOneOption(){

    }
    public static ListSelectOneOption newInstance(String title){
        System.out.println("------------ 4");
        ListSelectOneOption frag = new ListSelectOneOption();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        System.out.println("------------ 5");
        return  frag;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("------------ 6");
        return inflater.inflate(R.layout.list_select_one_option, container);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("------------ 7");
        String title = getArguments().getString("title", "Seleccione: ");
        getDialog().setTitle(title);

        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        System.out.println("------------ 8");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

}
