package arabulkazan.albatros.com.arabulkazan;

import arabulkazan.albatros.com.arabulkazan.CustomUI.TypefaceUtil;

/**
 * Created by PC on 30.03.2018.
 */

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "Phenomena/font-Regular.otf"); // font from assets: "assets/fonts/Roboto-Regular.ttf


    }
}
