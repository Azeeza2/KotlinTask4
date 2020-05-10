package com.example.kotlintask4

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login_page.*


class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private val radioSexGroup: RadioGroup? = findViewById(R.id.radioGrp)
    private var radioSexButton: RadioButton? = findViewById(R.id.radioM)
    private val btnDisplay: Button? = null


    protected var loginButton: Button? = findViewById(R.id.button)
    var b2: Button? = null
    private val username: EditText? = findViewById(R.id.username_edittext)
    private val password: EditText? = findViewById(R.id.password_edittext)

    var tx1: TextView? = null
    var counter = 3

    /*  b2 = (Button)findViewById(R.id.button2);
           tx1 = (TextView)findViewById(R.id.textView3);
           tx1.setVisibility(View.GONE);*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        loginButton?.setOnClickListener(this)
        addListenerOnButton()
        registerButton?.setOnClickListener(this)

    }

    override fun onClick(view: View) {

        if (!(!username?.getText().toString().equals("admin")) || !(!password?.getText().toString()
                .equals("admin"))
        ) {
            //correcct password
            Toast.makeText(applicationContext, "Redirecting......", Toast.LENGTH_SHORT).show()
        } else {
            //wrong password
            Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show()
            username?.setVisibility(View.VISIBLE)
            username?.setBackgroundColor(Color.RED)
            counter--
            username?.setText(counter.toString())

            if (counter == 0) {
                loginButton?.setEnabled(false)
            }
        }
    }

    fun openSignupPage(view: View) {
        var signup: TextView? = findViewById(R.id.sign_up)
        signup?.setOnClickListener(View.OnClickListener() {
            intent = findViewById(R.id.login_page)
            startActivity(intent)
        })

    }

    fun addListenerOnButton() {

        radioSexGroup?.setOnClickListener(View.OnClickListener() {
            @Override
            fun onClick(view: View) {
                // get selected radio button from radioGroup
                var selectedId = radioSexGroup.checkedRadioButtonId
                // find the radiobutton by returned id
                radioSexButton = findViewById(selectedId)

                /*Toast.makeText(this,radioSexButton, Toast.LENGTH_SHORT).show()*/
            }
        });
    }

    fun register(view: View) {
        finish()
    }
}



       /* b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/

    /*private fun onClick(any: Any, function: () -> Unit): Any {

    }*/



    /*fun login(view: View) {
        var username = (EditText) findViewById (R.id.username_edittext)
        var password = this.findViewById(R.id.password_edittext)

        if (username.getText().toString().equals("admin") && password.getText().toString()
                .equals("admin")
        ) {

            //correcct password
        } else {
            //wrong password
        }

        counter = 3;
        counter--;

        if(counter==0){
            //disble the button, close the application e.t.c
        }
    }*/

