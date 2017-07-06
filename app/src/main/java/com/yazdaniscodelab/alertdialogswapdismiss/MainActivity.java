package com.yazdaniscodelab.alertdialogswapdismiss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.andreilisun.swipedismissdialog.OnCancelListener;
import com.github.andreilisun.swipedismissdialog.OnSwipeDismissListener;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDirection;

public class MainActivity extends AppCompatActivity {

    Button buttonshowdialog,btnok;

    SwipeDismissDialog swipeDismissDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonshowdialog=(Button)findViewById(R.id.btn_dialog);

        buttonshowdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final View viewdialog= LayoutInflater.from(getBaseContext()).inflate(R.layout.dialog_success,null);


                swipeDismissDialog=new SwipeDismissDialog.Builder(MainActivity.this)

                        .setView(viewdialog)

                        .setOnSwipeDismissListener(new OnSwipeDismissListener() {
                            @Override
                            public void onSwipeDismiss(View view, SwipeDismissDirection direction) {

                                Toast.makeText(getApplicationContext(),"Clicked Direction"+direction,Toast.LENGTH_LONG).show();

                            }
                        })

                        .build()
                        .show();

                btnok=(Button)viewdialog.findViewById(R.id.btnok);

                btnok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        Toast.makeText(getApplicationContext(),"Clicked ok",Toast.LENGTH_LONG).show();

                        startActivity(new Intent(getApplicationContext(),SecondActivity.class));

                        swipeDismissDialog.dismiss();
                    }
                });

            }
        });

    }
}
