package com.github.nisrulz.validatetorproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.nisrulz.validatetor.ValidateTor;

public class MainActivity extends AppCompatActivity {

  private RelativeLayout rootView;
  private Button btn_validate;
  private EditText edt_email;
  private EditText edt_password;
  private EditText edt_creditcard;

  private ValidateTor mValidateTor;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    setUpUiWidgets();

    mValidateTor = new ValidateTor();
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

    if (mValidateTor.isEmpty(str)) {
      editText.setError("Field is empty!");
    }

    if (!mValidateTor.validateCreditCard(str)) {
      editText.setError("Invalid Credit Card number!");
    } else {
      Toast.makeText(this, "Valid Credit Card Number!", Toast.LENGTH_SHORT).show();
    }
  }

  private void validatePasswordField(EditText editText) {
    String str = editText.getText().toString();

    if (mValidateTor.isEmpty(str)) {
      editText.setError("Field is empty!");
    }

    if (mValidateTor.isAtleastLength(str, 8)
        && mValidateTor.hasAtleastOneDigit(str)
        && mValidateTor.hasAtleastOneUppercaseCharacter(str)
        && mValidateTor.hasAtleastOneSpecialCharacter(str)) {
      Toast.makeText(this, "Valid Password!", Toast.LENGTH_SHORT).show();
    } else {
      editText.setError("Password needs to be of minimum length of 8 characters and should have " +
          "atleast 1 digit, 1 upppercase letter and 1 special character ");
    }

  }

  private void validateEmailField(EditText editText) {
    String str = editText.getText().toString();

    if (mValidateTor.isEmpty(str)) {
      editText.setError("Field is empty!");
    }

    if (!mValidateTor.isEmail(str)) {
      editText.setError("Invalid Email entered!");
    } else {
      Toast.makeText(this, "Valid Email!", Toast.LENGTH_SHORT).show();
    }
  }
}
