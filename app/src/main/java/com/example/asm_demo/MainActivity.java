package com.example.asm_demo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testLog();
                testString("","");
            }
        });
    }

    public void testLog() {
        Log.d("TAG","dsw");
        Log.i("TAG","dsw");
        Log.v("TAG","dsw");
        Log.w("TAG","dsw");
        Log.e("TAG","dsw");
    }

    public String testString(String a, String b) {
        int result = 5 / 0;
        return "HelloWorld";
    }

    public Object getObject() {
        return null;
    }

    public char getObjectChar() {
        return 0;
    }

    public short getObjectShort() {
        return 0;
    }

    public byte getObjectByte() {
        return 0;
    }
}