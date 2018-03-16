package pe.edu.tecsup.pizzeria;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private Spinner spinner1;
    private CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        radioGroup = findViewById(R.id.radioGroup);
        spinner1 = findViewById(R.id.spinner);
        checkBox = findViewById(R.id.checkBox);
        checkBox.setChecked(true);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Toast.makeText(parent.getContext(),
                        "You have selected : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg) {

            }

        });
    }
    public void send(View view) {
        String item = (String) spinner1.getSelectedItem();
        Toast.makeText(this, "Has escogido: " + item, Toast.LENGTH_SHORT).show();
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setMessage("Su pedido de "+findViewById()  +" con "+  +" a "+  +"IGV esta en proceso de envio");
        // Custom Android Allert Dialog Title
        dialog.setTitle("Confirmación de pedido");
        dialog.show();
        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        if (radioButtonId == -1) {
            Toast.makeText(this, "Este campo es obligatorio", Toast.LENGTH_LONG).show();

        }
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        // Notification
        Notification notification = new NotificationCompat.Builder(this , "alerts")
                .setContentTitle("Delivery's Papa Jhon")
                .setContentText("Tu pedido está en camino")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        // Notification manager
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
        new Handler().postDelayed(new Runnable() {
            public void run() {

            }
        }, 000);
    }

    public void radioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // This check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButton1:
                if (checked)
                    //Do something when radio button is clicked
                    Toast.makeText(getApplicationContext(), "Buena elección!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radioButton2:
                //Do something when radio button is clicked
                Toast.makeText(getApplicationContext(), "Buena elección!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radioButton3:
                //Do something when radio button is clicked
                Toast.makeText(getApplicationContext(), "Buena elección!", Toast.LENGTH_SHORT).show();
                break;
        }

    }
    public void androidCheckBoxClicked(View view) {
        // action for checkbox click
        switch (view.getId()) {
            case R.id.checkBox:
                CheckBox checkBox = (CheckBox) view;
                if(checkBox.isChecked())
                    Toast.makeText(this, checkBox.getText() + " añadido!", Toast.LENGTH_LONG).show();
                break;
            case R.id.checkBox2:
                CheckBox checkBox2 = (CheckBox) view;
                if(checkBox2.isChecked())
                    Toast.makeText(this, checkBox2.getText() + " añadido!", Toast.LENGTH_LONG).show();
                break;
        }
    }

}



