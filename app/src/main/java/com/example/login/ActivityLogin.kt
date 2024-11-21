package com.example.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityLogin : AppCompatActivity() {

    var txtUsu: EditText? = null
    var txtPas: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtUsu = findViewById(R.id.etUser)
        txtPas = findViewById(R.id.etPassword)
    }

    fun login(view: View){
        var pref = getSharedPreferences(txtUsu?.text.toString(), Context.MODE_PRIVATE)
        var pass = pref.getString("pass","")
        if(pass == txtPas?.text.toString()) {
            Toast.makeText(this, "El usuario se ha logueado", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "El usuario no está registrado", Toast.LENGTH_LONG).show()
        }
        txtUsu?.setText("")
        txtPas?.setText("")
    }
    fun atras(view: View){
        val  mainActivity = Intent(this,MainActivity::class.java)
        startActivity(mainActivity)
    }


}