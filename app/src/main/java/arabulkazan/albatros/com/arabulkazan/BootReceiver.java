package arabulkazan.albatros.com.arabulkazan;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;

import arabulkazan.albatros.com.arabulkazan.Fragments.NotificationRemember;
import arabulkazan.albatros.com.arabulkazan.Helpers.Constants;

public class BootReceiver extends BroadcastReceiver {
    private PendingIntent pendingIntent;
    private AlarmManager alarmMgr;
    @Override
    public void onReceive(Context context, Intent intent) {

      //  Log.w("boot_broadcast_poc", "starting service...");

        Log.w("action_type", intent.getAction());
        if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            Log.w("boot_broadcast_poc", "starting service...");
            //Toast.makeText(context,"Boot copmleted",Toast.LENGTH_SHORT);

            Calendar c = Calendar.getInstance();
           String[] cur_date= Constants.dateFormat.format(c.getTime()).split(" ")[1].split(":");

         if(   Integer.valueOf(cur_date[0]) >24  &&   Integer.valueOf(cur_date[0]) >8      ){//Rahatsız edilmeme zamanı
return;
         }


            try{
               /* NotificationRemember notificationRemember=new NotificationRemember();
                notificationRemember.startAlarm();*/

                alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intnt=new Intent(context,AlarmReceiver.class);
                pendingIntent=PendingIntent.getBroadcast(context,0,intnt,0);


//alarmMgr.setExact(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pendingIntent);
                alarmMgr.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,SystemClock.elapsedRealtime(),5*1000,pendingIntent);

            }
            catch (Exception e){
                System.out.println("Hata"+e.getCause()+"Mesaj"+e.getMessage()+"TRACE"+e.getStackTrace());
            }



        }

      /*  if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {

            // Set the alarm here.

            System.out.println("Girdi buraya");
            NotificationRemember notificationRemember=new NotificationRemember();
            notificationRemember.startAlarm();

            //Aktif etme yeniden başlatmada
         /*   ComponentName receiver = new ComponentName(context, BootReceiver.class);
            PackageManager pm = context.getPackageManager();

            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);*/



            //Deaktif etme kullanıcı iptal ederse
         /*   ComponentName receiver = new ComponentName(context, SampleBootReceiver.class);
            PackageManager pm = context.getPackageManager();

            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                    PackageManager.DONT_KILL_APP);*/


        }



    }
