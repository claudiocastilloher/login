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

class MainActivity : AppCompatActivity() {

    var txtUsu:EditText? = null
    var txtPas:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtUsu = findViewById(R.id.etUser)
        txtPas = findViewById(R.id.etPassword)
    }

    fun guardar(view:View){
        var pref = getSharedPreferences(txtUsu?.text.toString(),Context.MODE_PRIVATE)
        var  editor=pref.edit()
        editor.putString("pass",txtPas?.text.toString())
        editor.commit()
        Toast.makeText(this,"El usuario se ha guardado exitosamente",Toast.LENGTH_LONG).show()
        txtUsu?.setText("")
        txtPas?.setText("")

    }


    fun irLogin(view: View){
        val login = Intent(this,ActivityLogin::class.java)
        startActivity(login)
    }
}