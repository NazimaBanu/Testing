package com.example.rania.donation_part3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rania.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   DBHandler handler;
   public static DabaBaseMethods  dbMethods;
    Button btn_donation;
    ProgressBar progress_bar;
    NumberPicker picker;
    EditText donation_amount;
    RadioButton payment_method1;
    RadioButton payment_method2;
    TextView total_donation;
    int target = 10000;
   static int totalDonation = 0;
   static int numberofDonation = 0;
    public static List<DonationClass> allDonation = new ArrayList<DonationClass>();
    String Tag = "name";
    static String payment_method ="Paypal";
    int amount_entered = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepare();


        dbMethods = new DabaBaseMethods(this);
        dbMethods.open();

        dbMethods.getTotalDonaionAmount();
        dbMethods.getTotalDonationNumber();


        picker.setValue(numberofDonation);
        progress_bar.setProgress(totalDonation);

    }

    private void prepare(){
        btn_donation = findViewById(R.id.Donation);
        btn_donation.setOnClickListener(this);
        progress_bar = findViewById(R.id.progress_bar);
        picker = findViewById(R.id.numberPicker);
        donation_amount = findViewById(R.id.amount);
        payment_method2 = findViewById(R.id.radioButton2);
        payment_method1 = findViewById(R.id.radioButton1);
        total_donation = findViewById(R.id.total);
        picker.setMaxValue(1000);
        picker.setMinValue(0);
        progress_bar.setMax(target);


    }

    @Override
    public void onClick(View v) {

        amount_entered = Integer.parseInt(donation_amount.getText().toString());
        if(payment_method1.isChecked()){
            payment_method = payment_method1.getText().toString();
        } else {
            payment_method = payment_method2.getText().toString();
        }
        totalDonation += amount_entered;
        if(totalDonation >= target) {
            numberofDonation = picker.getValue()+1;
            picker.setValue(numberofDonation);
            progress_bar.setProgress(target);
            Toast.makeText(v.getContext(), "You have exceeded the target",
                    Toast.LENGTH_LONG).show();
            DonationClass newDonation = new DonationClass(payment_method,amount_entered);
       //     allDonation.add(newDonation);

            dbMethods.add(newDonation);

        } else {
            //how many persons donated to reach the target
            numberofDonation = picker.getValue()+1;

            picker.setValue(numberofDonation);
            progress_bar.setProgress(totalDonation);
            String process = "Donation number is " + picker.getValue() +
                    " using " + payment_method + " with amount of $" +
                    amount_entered;
            total_donation.setText(process);
            DonationClass newDonation = new DonationClass(payment_method,amount_entered);
           // allDonation.add(newDonation);
            dbMethods.add(newDonation);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.report_menu,menu);
    return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu){
        super.onPrepareOptionsMenu(menu);
        MenuItem reset = (MenuItem)menu.findItem(R.id.reset);
        MenuItem reprot = (MenuItem)menu.findItem(R.id.report);
        if (dbMethods.getAll().isEmpty()) {
            reprot.setEnabled(false);
            reset.setEnabled(false);
        }
        else {
            reprot.setEnabled(true);
            reset.setEnabled(true);
        }
return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){


        switch (item.getItemId()) {
            case R.id.report:
                Intent intent = new Intent(this, reportClass.class);
                startActivity(intent);
                break;
            case R.id.reset:
                dbMethods.reset();
                dbMethods.getTotalDonaionAmount();
                dbMethods.getTotalDonationNumber();
                picker.setValue(numberofDonation);
                progress_bar.setProgress(totalDonation);

                break;

            case R.id.map:
                Intent intent1 = new Intent(this,MapsActivity.class);
                startActivity(intent1);
        }
        return super.onOptionsItemSelected(item);

    }


}
