package arabulkazan.albatros.com.arabulkazan;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class AlarmSoundService extends Service {
    private MediaPlayer mediaPlayer;
    private  Ringtone ringtone;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //Start media player
     /*   mediaPlayer = MediaPlayer.create(this, R.raw.alarm_sound);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);//set looping true to run it infinitely*/


        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null)
        {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
         ringtone = RingtoneManager.getRingtone(getApplicationContext(), alarmUri);
        ringtone.play();



    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //On destory stop and release the media player
      /*  if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();
        }*/
if(ringtone!=null && ringtone.isPlaying()){
    ringtone.stop();
}



    }
}
