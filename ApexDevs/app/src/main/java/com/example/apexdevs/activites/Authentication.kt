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

class Authentication : AppCompatActivity() {

    lateinit var editTextEmail: EditText
    lateinit var editTextPassword: EditText
    lateinit var authButton: Button
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_authentication)
        auth = FirebaseAuth.getInstance()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Getting Input values
        editTextEmail = findViewById(R.id.emailInput)
        editTextPassword = findViewById(R.id.passwordInput)

        // Button to Authenticate User
        authButton = findViewById<Button>(R.id.loginButton)
        authButton.setOnClickListener(){
            var email:String
            var password:String

            // To verify if fields are not empty
            email = editTextEmail.text.toString()
            password = editTextPassword.text.toString()

            if(email.isEmpty() || password.isEmpty()){
                val toast = Toast.makeText(this, "Fill Details", Toast.LENGTH_SHORT)
                toast.show()
            }

            //Firebase authentication process
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = auth.currentUser
                        val intent = Intent(this, HomePage::class.java)
                        startActivity(intent)

                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }

        }

        // NAVIGATION TO SIGNUP PAGE
        val registerLink = findViewById<TextView>(R.id.registerLink)
        registerLink.setOnClickListener(){
            val intent = Intent(this@Authentication, SignUp::class.java)
            startActivity(intent)
        }



    }
}