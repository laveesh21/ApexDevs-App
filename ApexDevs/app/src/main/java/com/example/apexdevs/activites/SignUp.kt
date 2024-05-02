package com.example.apexdevs.activites

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apexdevs.R
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.sign

class SignUp : AppCompatActivity() {

    lateinit var editTextEmail: EditText
    lateinit var editTextPassword: EditText
    lateinit var confirmPassword: EditText
    lateinit var signupButton: Button
    lateinit var loginLink: TextView
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        auth = FirebaseAuth.getInstance()

        editTextEmail=findViewById<EditText>(R.id.emailInput)
        editTextPassword=findViewById<EditText>(R.id.passwordInput)
        confirmPassword = findViewById<EditText>(R.id.confirmPasswordInput)
        signupButton = findViewById(R.id.signupButton)


        // NAVIGATION TO LOG IN PAGE
        loginLink = findViewById<TextView>(R.id.loginLink)
        loginLink.setOnClickListener(){
            val intent = Intent(this@SignUp, Authentication::class.java)
            startActivity(intent)
        }

        // SIGN UP BUTTON
        signupButton.setOnClickListener(){
            
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            val confirmPassword = confirmPassword.text.toString()

            // Validating credentials
            if(email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() ){
               Toast.makeText(this, "Fill Details", Toast.LENGTH_SHORT).show()
            }else if(password != confirmPassword){
                Toast.makeText(this, "Password Not Same!", Toast.LENGTH_SHORT).show()
            }else{
                // FIREBASE SIGNUP
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){
                    task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "SignUp Successfull", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@SignUp, Authentication::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "SignUp Failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }

    }
}