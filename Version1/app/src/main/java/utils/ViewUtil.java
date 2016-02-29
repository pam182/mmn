package utils;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.widget.Toast;

import com.pamela.zeballos.version1.HomeFragment;
import com.pamela.zeballos.version1.MainActivity;
import com.pamela.zeballos.version1.R;

/**
 * Created by Pamela on 1/1/16.
 */
public class ViewUtil {

    public static void showToast(Context activityContext, String message) {
        ToastMessage toast = new ToastMessage(activityContext, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    public static void goHome(Context context){
        FragmentManager fragmentManager = ((MainActivity)context).getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.container, new HomeFragment().newInstance(0)).commit();
    }


}