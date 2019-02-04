package com.dubinosTech.shoppinglistManager.Login_register;
/**
 * @author DubinosTeck
 * Emmanuel Asinyo
 * Brahim Kanouche
 */
 import com.dubinosTech.shoppinglistManager.activity.MainActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
 import android.text.SpannableString;
 import android.text.style.UnderlineSpan;
 import android.view.View;
import android.widget.Button;
import android.widget.EditText;
 import android.widget.TextView;
 import android.widget.Toast;

import com.dubinosTech.shoppinglistManager.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Button login, register;
    private EditText etEmail, etPass;
    private DataBaseHelper db;
    private Session session;
    private TextView txtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DataBaseHelper(this);
        session = new Session(this);
        login = (Button)findViewById(R.id.btnLogin);
        register = (Button)findViewById(R.id.btnReg);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPass = (EditText)findViewById(R.id.etPass);
        txtv = (TextView) findViewById(R.id.forgotPassword);
        SpannableString content = new SpannableString("Forgot Password ?");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        txtv.setText(content);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
        txtv.setOnClickListener(this);

        if(session.loggedin()){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnLogin:
                login();//lkkgef
                break;
            case R.id.btnReg:
                register();

                break;
            default:

        }
    }

    private void login(){
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();
        Contact c =new Contact();

       /* if(db.getUser(email,pass)){
            session.setLoggedin(true);
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();*/
       if(c.getPassword(pass)&&c.getEmail(email)){
           session.setLoggedin(true);
           startActivity(new Intent(LoginActivity.this, MainActivity.class));
           finish();

        }else{
            Toast.makeText(getApplicationContext(), "Wrong email/password",Toast.LENGTH_SHORT).show();
        }
    }

    private void register(){
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();

        if(email.isEmpty())
        {
            displayToast("Name  field empty");
        }
        else if(!email.contains("@"))
        {
            displayToast("Wrong email");

        }

        else if( pass.isEmpty()){
            displayToast("password field empty");
        }


        else{
            Contact c =new Contact();

            c.setEmail(email);
            c.setPassword(pass);



            db.insertContact(c);
            displayToast("Thank you for register with us , Shopping List Manager");
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            //finish();
        }
    }

    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void forgotPassword(View view) {
        //textview.setOnClickListener();
    }
}