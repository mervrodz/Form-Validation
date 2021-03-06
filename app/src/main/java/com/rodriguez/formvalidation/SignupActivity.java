package com.rodriguez.formvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText etUsername, etPassword, etConfirmPassword, etEnterFullname;
    String username, password, confirmpassword, enterfullname;
    int formsuccess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etEnterFullname = findViewById(R.id.etEnterFullname);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_cancel, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnSave:

                formsuccess = 5;

                username = etUsername.getText().toString();
                password = etPassword.getText().toString();
                confirmpassword = etConfirmPassword.getText().toString();
                enterfullname = etEnterFullname.getText().toString();

                if (username.equals("")) {
                    etUsername.setError("This field is required");
                    formsuccess--;
                }
                if (password.equals("")) {
                    etPassword.setError("This field is required");
                    formsuccess--;
                }

                if (confirmpassword.equals("")) {
                    etConfirmPassword.setError("This field is required");
                    formsuccess--;
                }

                if (!confirmpassword.equals(password)){
                    etConfirmPassword.setError("Password Mismatch");
                    formsuccess --;
                }

                if (enterfullname.equals("")) {
                    etEnterFullname.setError("This field is required");
                    formsuccess--;
                }

                Toast.makeText(this, "Validate Form Test", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnCancel:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}