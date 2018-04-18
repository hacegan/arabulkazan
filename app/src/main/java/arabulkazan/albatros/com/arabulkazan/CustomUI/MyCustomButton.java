package arabulkazan.albatros.com.arabulkazan.CustomUI;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by PC on 30.03.2018.
 */

public class MyCustomButton extends android.support.v7.widget.AppCompatButton {

    public MyCustomButton(Context context) {
        super(context);
    }

    public MyCustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }

    public MyCustomButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }
}
