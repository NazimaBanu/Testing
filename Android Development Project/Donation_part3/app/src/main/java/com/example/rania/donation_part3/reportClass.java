package com.example.rania.donation_part3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rania.myapplication.R;

import java.util.List;

/**
 * Created by Rania on 11/22/2017.
 */

public class reportClass extends AppCompatActivity {
    ListView listView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_layout);
        listView = (ListView)findViewById(R.id.donationList);
        donationListAdapter myAdapter = new donationListAdapter(this,MainActivity.dbMethods.getAll());
        listView.setAdapter(myAdapter);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.report_menu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item){


        switch (item.getItemId()) {
            case R.id.donate:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}

class donationListAdapter extends ArrayAdapter<DonationClass>{

private Context context;
private List<DonationClass> donations;

    public donationListAdapter(@NonNull Context context,  List<DonationClass> donations) {
        super(context, R.layout.row_for_donation, donations);
        this.context = context;
        this.donations = donations;
    }

    public int getCount(){
        return donations.size();

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_for_donation,parent,false);
        DonationClass donation = donations.get(position);
        TextView view_amount = (TextView)view.findViewById(R.id.donationAmount);
        TextView view_paymentMethod = (TextView) view.findViewById(R.id.paymentMethod);
        view_amount.setText(donation.getAmount() + "");
        view_paymentMethod.setText(donation.getPaymentMethod() +"");

        return view;

    }
}