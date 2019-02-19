package com.example.munawar.customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText jobs;
    EditText payments;
    EditText mans;
    Button buttonadd;

    DatabaseReference databaseCustomers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseCustomers = FirebaseDatabase.getInstance().getReference("jobs");

        jobs = (EditText) findViewById(R.id.job);
        payments = (EditText) findViewById(R.id.payment);
        mans = (EditText) findViewById(R.id.worker);
        buttonadd = (Button) findViewById(R.id.pay);

        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addJobs();

            }
        });
    }

    private void addJobs(){
        String jobname = jobs.getText().toString().trim();
        String payvalue = payments.getText().toString().trim();
        String manname = mans.getText().toString().trim();

        if (!TextUtils.isEmpty(jobname)){

            String id = databaseCustomers.push().getKey();
            Jobs jobs = new Jobs(jobname, payvalue, manname);
            databaseCustomers.child(id).setValue(jobs, payvalue);
            Intent intent= new Intent(MainActivity.this, Done.class);
            startActivity(intent);
            Toast.makeText(this, "Payment added", Toast.LENGTH_LONG).show();


        }else{
            Toast.makeText(this, "You should enter a job name", Toast.LENGTH_LONG).show();
        }

    }

}
