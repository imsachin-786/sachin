package com.example.reservationsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reservationsystem.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Button b1, b2;
    EditText userId, password;
    database g;

    //Call SignIn() function when the button of Sign in is clicked
    public void signIn(View view) {

        userId = findViewById(R.id.userText);         //To access the user Id field
        password = findViewById(R.id.password);
        b1 = findViewById(R.id.b1);//To access the password Field

        String userText = userId.getText().toString();
        String passText = password.getText().toString();

        g = new database(this);
        Intent intent = new Intent(this, First_Interface.class);  // To set Intent to Category Activity


        Boolean i = g.insert_data("Gulshan Sharma", userText, passText);
        if (i == true) {
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(MainActivity.this, "NOt Successful", Toast.LENGTH_SHORT).show();
        }

        public void signup(View view){

            userId = findViewById(R.id.userText);         //To access the user Id field
            password = findViewById(R.id.password);
            b2 = findViewById(R.id.b2);//To access the password Field

            String userText1 = userId.getText().toString();
            String passText1 = password.getText().toString();

            g = new database(this);
            Intent intent1 = new Intent(this, First_Interface.class);  // To set Intent to Category Activity


            Boolean j = g.insert_data("Gulshan Sharma", userText, passText);
            if (j == true) {
                startActivity(intent1);
                Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(MainActivity.this, "NOt Successful", Toast.LENGTH_SHORT).show();
            }


//        Intent intent = new Intent(this , First_Interface.class);  // To set Intent to Category Activity

//        if(new SignIn().follow(userText , passText)) {
//            startActivity(intent);
//            Toast.makeText(this, "You are Successfully Logged In", Toast.LENGTH_SHORT).show();
        }
    }
}