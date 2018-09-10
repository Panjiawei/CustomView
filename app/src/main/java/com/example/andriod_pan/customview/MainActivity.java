package com.example.andriod_pan.customview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.andriod_pan.customview.iu.RippleView;
import com.example.andriod_pan.customview.iu.TitlebarView;

public class MainActivity extends AppCompatActivity {
    TitlebarView tbv;
    RippleView rippleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tbv = findViewById(R.id.tbv);
        tbv.setOnViewClick(new TitlebarView.onViewClick() {
            @Override
            public void leftClick() {
               // finish();
                startActivity(new Intent(getApplicationContext(),Main3Activity.class));
            }

            @Override
            public void rightClick() {
                //Toast.makeText(getApplicationContext(), "dianjianlewo", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Main2Activity.class));
            }
        });
        rippleView = findViewById(R.id.rv_pan);

        rippleView.startAnim();
    }


}
