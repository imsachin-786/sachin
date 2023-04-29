package com.example.reservationsystem;

public class signup {
    String userText = "9050";
    String passText = "1050";

    public boolean follow(String userText , String passText){
        return this.userText.equals(userText) && this.passText.equals(passText);
    }
}
