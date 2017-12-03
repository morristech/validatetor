package com.github.nisrulz.validatetorproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

  private RelativeLayout rootView;
  private Button btn_validate;
  private EditText edt_email;
  private EditText edt_password;
  private EditText edt_creditcard;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    setUpUiWidgets();
  }

  private void setUpUiWidgets() {
    rootView = findViewById(R.id.rootView);
    edt_email = findViewById(R.id.edt_email);
    edt_password = findViewById(R.id.edt_password);
    edt_creditcard = findViewById(R.id.edt_creditcard);

    btn_validate = findViewById(R.id.btn_validate);
    btn_validate.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        validateEmailField(edt_email);
        validatePasswordField(edt_password);
        validateCreditCardField(edt_creditcard);
      }
    });
  }

  private void validateCreditCardField(EditText editText) {
    String str = editText.getText().toString();
    // TODO: Validate Credit Card Number Field
  }

  private void validatePasswordField(EditText editText) {
    String str = editText.getText().toString();
    // TODO: Validate Password Field

  }

  private void validateEmailField(EditText editText) {
    String str = editText.getText().toString();
    // TODO: Validate Email Field
  }
}
