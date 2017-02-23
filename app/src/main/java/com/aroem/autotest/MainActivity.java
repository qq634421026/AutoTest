package com.aroem.autotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.aroem.autotest.R.id.result;

public class MainActivity extends AppCompatActivity {
  private LinearLayout activityMain;
  private TextView tv;
  private Button btn;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    activityMain = (LinearLayout) findViewById(R.id.activity_main);
    tv = (TextView) findViewById(result);
    btn = (Button) findViewById(R.id.add);
    btn.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        int a = Integer.parseInt(getA().getText().toString());
        int b = Integer.parseInt(getB().getText().toString());
        int s = a + b ;
        tv.setText(s + "");
      }
    });
  }

  private EditText getA() {
    return (EditText) findViewById(R.id.a);
  }

  private EditText getB() {
    return (EditText) findViewById(R.id.b);
  }
}
