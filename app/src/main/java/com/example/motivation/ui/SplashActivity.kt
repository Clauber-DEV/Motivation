package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.R
import com.example.motivation.infra.MotivationContants
import com.example.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurityPreferences = SecurityPreferences(this)
//código para esconder o nome da app em cima da tela
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        buttonSave.setOnClickListener {
            handleSave()
        }

        val securityPreferences = SecurityPreferences(this)
        securityPreferences.storeString("", "")

//        metodo usad para salvar quantidade pequena de dados
//        val shared = this.getSharedPreferences("motivation", Context.MODE_PRIVATE)
//        shared.edit().putString("key", "value").apply()

    }


    private fun handleSave() {
        val name = editName.text.toString()
// tratamento caso o usuario não preencha o campo informado
        if (name != "") {
            mSecurityPreferences.storeString(MotivationContants.KEY.PERSON_NAME, name)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        } else {
            Toast.makeText(this, "Informe seu nome!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonSave){
            handleSave()
        }
    }
}