package arabulkazan.albatros.com.arabulkazan.Fragments;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.dpro.widgets.WeekdaysPicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import arabulkazan.albatros.com.arabulkazan.AlarmNotificationService;
import arabulkazan.albatros.com.arabulkazan.AlarmReceiver;
import arabulkazan.albatros.com.arabulkazan.AlarmSoundService;
import arabulkazan.albatros.com.arabulkazan.MainActivity;
import arabulkazan.albatros.com.arabulkazan.R;

public class NotificationRemember extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    Spinner kacdk, hangisaat;
    Button btn;
    static CheckBox hergun, herhafta, heray, heryil;
    //Pending intent instance
    private PendingIntent pendingIntent;
    private AlarmManager alarmMgr;
   private static ArrayAdapter<String> dataAdapter;
   private Button pztesi,sali,cars,pers,cuma,ctesi,pzr;


    public static final int REQUEST_CODE = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notificationremember, container, false);

        kacdk = root.findViewById(R.id.kacdkhatirlatspinner);

        btn = root.findViewById(R.id.recurchooserbtn);

        hergun = new CheckBox(NotificationRemember.this.getContext());
        herhafta = new CheckBox(NotificationRemember.this.getContext());
        heray = new CheckBox(NotificationRemember.this.getContext());
        heryil = new CheckBox(NotificationRemember.this.getContext());

        pztesi=root.findViewById(R.id.pztesibtn);
        sali=root.findViewById(R.id.salibtn);
     cars=root.findViewById(R.id.carsbtn);
     pers=root.findViewById(R.id.persbtn);
     cuma=root.findViewById(R.id.cumabtn);
     ctesi=root.findViewById(R.id.ctesibtn);
     pzr=root.findViewById(R.id.pzrbtn);

     pztesi.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

             if(pztesi.getcolor)
             
         }
     });

     sali.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

         }
     });

     cars.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

         }
     });

     pers.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

         }
     });

     cuma.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

         }
     });


     ctesi.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {


         }
     });


     pzr.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

         }
     });




       // kacdk.setOnItemSelectedListener(this);


       // hangisaat.setOnItemSelectedListener(this);

        final List<String> kacdklist = new ArrayList<String>();

        kacdklist.add("10 dk sonra");
        kacdklist.add("15 dk sonra");
        kacdklist.add("20 dk sonra");
        kacdklist.add("25 dk sonra");
        kacdklist.add("30 dk sonra");
        kacdklist.add("1 saat sonra");
        kacdklist.add("2 saat sonra");
        kacdklist.add("3 saat sonra");
        kacdklist.add("5 saat sonra");
        kacdklist.add("10 saat sonra");
        kacdklist.add("1  gün sonra");
        kacdklist.add("2 gün sonra");
        kacdklist.add("1 hafta sonra");




        // Creating adapter for spinner
        dataAdapter = new ArrayAdapter<String>(NotificationRemember.this.getContext(), android.R.layout.simple_spinner_item, kacdklist);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        kacdk.setAdapter(dataAdapter);

        WeekdaysPicker widget = root.findViewById(R.id.weekdays);



btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

                String item=  kacdk.getSelectedItem().toString();

               String[] mktar_dk_saat_gun_hafta= item.split(" ");

            if(   mktar_dk_saat_gun_hafta[1].equals("dk") ){
                startAlarm(Integer.valueOf(mktar_dk_saat_gun_hafta[0]),"dk");
            }
            else if(  mktar_dk_saat_gun_hafta[1].equals("saat")  ){
                startAlarm(Integer.valueOf(mktar_dk_saat_gun_hafta[0]),"saat");
            }

            else if(      mktar_dk_saat_gun_hafta[1].equals("gün")          ){
                startAlarm(Integer.valueOf(mktar_dk_saat_gun_hafta[0]),"gün");
            }

            else if(        mktar_dk_saat_gun_hafta[1].equals("hafta")                ){
                startAlarm(Integer.valueOf(mktar_dk_saat_gun_hafta[0]),"hafta");
            }



       // startAlarm(Integer.valueOf(mktar_dk_saat_gun_hafta[0]));  //Elapsed

      //  startRTCAlarm(); // RTC



      /*  Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.setAction(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), REQUEST_CODE,
                intent, 0);
        int alarmType = AlarmManager.ELAPSED_REALTIME;
        final int FIFTEEN_SEC_MILLIS = 3000;
        AlarmManager alarmManager = (AlarmManager)
                getActivity().getSystemService(getActivity().ALARM_SERVICE);
        alarmManager.setRepeating(alarmType, SystemClock.elapsedRealtime() + FIFTEEN_SEC_MILLIS,
                FIFTEEN_SEC_MILLIS, pendingIntent);
        // END_INCLUDE (configure_alarm_manager);
        Log.i("RepeatingAlarmFragment", "Alarm set.");*/

        //triggerAlarmManager(1);
    }
});



/*
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog=new Dialog(NotificationRemember.this.getContext());
                dialog.show();


                hergun.setOnClickListener(this);
                herhafta.setOnClickListener(this);
                heray.setOnClickListener(this);
                heryil.setOnClickListener(this);



                dialog.addContentView(hergun,new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

                dialog.addContentView(herhafta,new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

                dialog.addContentView(hergun,new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

                dialog.addContentView(heray,new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

                dialog.addContentView(heryil,new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

                dialog.show();


            }
        });*/


        return root;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
// On selecting a spinner item
        String item = adapterView.getItemAtPosition(i).toString();

        // Showing selected spinner item
        Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {


    }

    public void startRTCAlarm(){


// Set the alarm to start at 8:30 a.m.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 3);
        calendar.set(Calendar.MINUTE, 14);

        alarmMgr = (AlarmManager)NotificationRemember.this.getActivity().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(NotificationRemember.this.getActivity(), AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(NotificationRemember.this.getActivity(), 0, intent, 0);

        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                1000 * 60 * 1,pendingIntent);

    }


    public void startAlarm(int süre,String recurence){
        alarmMgr = (AlarmManager) NotificationRemember.this.getActivity().getSystemService(Context.ALARM_SERVICE);
        Intent intent=new Intent(NotificationRemember.this.getContext(),AlarmReceiver.class);
        pendingIntent=PendingIntent.getBroadcast(NotificationRemember.this.getContext(),0,intent,0);

        if(recurence.equals("dk")){
            System.out.println(süre+"Dakika sonra yeni reklamı izleyebileceksiniz.");
            Toast.makeText(NotificationRemember.this.getContext(),süre+"Dakika sonra yeni reklamı izleyebileceksiniz.",Toast.LENGTH_SHORT).show();
            alarmMgr.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,SystemClock.elapsedRealtime(),süre*60*1000,pendingIntent);

        }
        else if(recurence.equals("saat")){
            alarmMgr.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,SystemClock.elapsedRealtime(),süre*60*60*1000,pendingIntent);


        }

        else if(recurence.equals("gün")){
            alarmMgr.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,SystemClock.elapsedRealtime(),süre*24*60*60*1000,pendingIntent);
        }

        else if(recurence.equals("hafta")){
            alarmMgr.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,SystemClock.elapsedRealtime(),süre*7*24*60*60*1000,pendingIntent);
        }




//alarmMgr.setExact(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pendingIntent);
//alarmMgr.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,SystemClock.elapsedRealtime()+3000,3*1000,pendingIntent);

    }


    //Trigger alarm manager with entered time interval
    public void triggerAlarmManager(int alarmTriggerTime) {
        // get a Calendar object with current time
        Calendar cal = Calendar.getInstance();
        // add alarmTriggerTime seconds to the calendar object
        cal.add(Calendar.SECOND, alarmTriggerTime);

        AlarmManager manager = (AlarmManager) NotificationRemember.this.getActivity().getSystemService(Context.ALARM_SERVICE);//get instance of alarm manager
        manager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);//set alarm manager with entered timer by converting into milliseconds

        Toast.makeText(NotificationRemember.this.getActivity(), "Alarm Set for " + alarmTriggerTime + " seconds.", Toast.LENGTH_SHORT).show();
    }


    //Stop/Cancel alarm manager
    public void stopAlarmManager() {

        AlarmManager manager = (AlarmManager) NotificationRemember.this.getActivity().getSystemService(Context.ALARM_SERVICE);
        manager.cancel(pendingIntent);//cancel the alarm manager of the pending intent


        //Stop the Media Player Service to stop sound
        NotificationRemember.this.getActivity().stopService(new Intent(NotificationRemember.this.getActivity(), AlarmSoundService.class));

        //remove the notification from notification tray
        NotificationManager notificationManager = (NotificationManager) NotificationRemember.this.getActivity()
                .getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(AlarmNotificationService.NOTIFICATION_ID);

        Toast.makeText(NotificationRemember.this.getActivity(), "Alarm Canceled/Stop by User.", Toast.LENGTH_SHORT).show();
    }


}
