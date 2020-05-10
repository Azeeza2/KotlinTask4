package com.example.kotlintask4

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.register_page.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    val MyPREFERENCES = "MyPrefs"
    val Name = "nameKey"
    val Phone = "phoneKey"
    val Email = "emailKey"
    val Password = "passwordKey"
    val Gender = "genderKey"
    public var  sharedpreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_page)

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE)

        registerButton?.setOnClickListener(this)

    }

        override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
    fun register(view: View) {
        val nName : EditText? = findViewById(R.id.Name)
        val eEmail: EditText? = findViewById(R.id.Email)
        val cContact: EditText? =findViewById(R.id.Contact)
        val  pPassword : EditText? =findViewById(R.id.Password)

        var register : Button? =findViewById(R.id.button)


        val Name: String = nName?.getText().toString()
        val Email: String = eEmail?.getText().toString()
        val Contact: String = cContact?.getText().toString()
        val Password: String = pPassword?.getText().toString()

        val editor = sharedpreferences!!.edit()

        editor.putString(Name, Name)
        editor.putString(Password, Password)
        editor.putString(Contact, Contact)
        editor.putString(Email, Email)
        editor.commit()
        Toast.makeText(this, "Thank you for registering", Toast.LENGTH_LONG).show()
        finish()
    }
}