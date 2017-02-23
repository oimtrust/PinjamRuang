package customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Oim on 2/19/2017.
 */

public class MyEditText extends EditText {
    public MyEditText(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        init();
    }

    public MyEditText(Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }

    public MyEditText(Context context){
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()){
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Lato-Light.ttf");
            setTypeface(tf);
        }
    }
}
