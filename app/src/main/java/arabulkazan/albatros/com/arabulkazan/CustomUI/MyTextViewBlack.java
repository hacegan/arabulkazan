package arabulkazan.albatros.com.arabulkazan.CustomUI;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by PC on 30.03.2018.
 */


public class MyTextViewBlack extends android.support.v7.widget.AppCompatTextView {

    public MyTextViewBlack(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public MyTextViewBlack(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextViewBlack(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(),"Phenomena/font-Black.otf");
            setTypeface(tf);
        }
    }

}