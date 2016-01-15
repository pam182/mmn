package utils;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;

/**
 * Created by Pamela on 1/2/16.
 */
public class TypeFaceFont {
    public static void setFontawesome(Context context,View view){

        Typeface font = Typeface.createFromAsset(context.getAssets(), "fontawesome-webfont.ttf");
        if (view instanceof Button){
            Button button = (Button)view;
            button.setTypeface(font);
        }

    }
}



