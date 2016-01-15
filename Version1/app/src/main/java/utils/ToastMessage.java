package utils;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.pamela.zeballos.version1.R;

import butterknife.Bind;

/**
 * Created by Pamela on 12/30/15.
 */
public class ToastMessage extends Toast{
    @Bind(R.id.toast)
    ViewGroup viewGroup;

    public ToastMessage(Context activityContext, String message, int duration) {
        super(activityContext);
        this.setDuration(duration);
        LayoutInflater inflater = (LayoutInflater) activityContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.toast_message, viewGroup);
        this.setView(view);
        TextView tv = (TextView) view.findViewById(R.id.text);
        tv.setText(message);
    }

}
