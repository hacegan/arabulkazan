package arabulkazan.albatros.com.arabulkazan;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import arabulkazan.albatros.com.arabulkazan.Fragments.NotificationRemember;
import arabulkazan.albatros.com.arabulkazan.Fragments.Revenues;
import arabulkazan.albatros.com.arabulkazan.Helpers.Constants;

import static android.support.v4.content.WakefulBroadcastReceiver.startWakefulService;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(NotificationRemember.bastv==null){
            return;
        }

        int bas_zmn = Integer.valueOf(NotificationRemember.bastv.getText().toString());
        int bit_zmn = Integer.valueOf(NotificationRemember.bastv.getText().toString());

        Calendar calendar = Calendar.getInstance();

        String strDate = Constants.dateFormat.format(calendar.getTime()).split(" ")[1].split(":")[0];
        int nmbr_Date = Integer.valueOf(strDate);

        if (nmbr_Date >= bas_zmn && nmbr_Date < bit_zmn) {
            return;
        }

        System.out.println("Alarm Receiver girddi");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        Intent myIntent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                0,
                myIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setAutoCancel(true).
                setDefaults(Notification.
                        DEFAULT_ALL).
                setWhen(System.currentTimeMillis()).
                setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Alarm Activated")
                .setContentText("This is my alarm")
                .setContentIntent(pendingIntent)
                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND)
                .setContentInfo("Info");

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(1, builder.build());



      /*  Toast.makeText(context, "ALARM!! ALARM!!", Toast.LENGTH_SHORT).show();

        //Stop sound service to play sound for alarm
        context.startService(new Intent(context, AlarmSoundService.class));

        //This will send a notification message and show notification in notification tray
        ComponentName comp = new ComponentName(context.getPackageName(),
                AlarmNotificationService.class.getName());
        startWakefulService(context, (intent.setComponent(comp)));*/


    }


}