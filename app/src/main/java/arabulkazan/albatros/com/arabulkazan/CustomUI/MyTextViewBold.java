package arabulkazan.albatros.com.arabulkazan.CustomUI;

/**
 * Created by PC on 30.03.2018.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by PC on 30.03.2018.
 */

public class MyTextViewBold extends android.support.v7.widget.AppCompatTextView {

    public MyTextViewBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public MyTextViewBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextViewBold(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(),"Phenomena/font-Bold.otf");
            setTypeface(tf);
        }
    }

}
