package com.example.saludoschayanne

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var texto = findViewById<TextView>(R.id.txtSaludo)
        var nombre = findViewById<EditText>(R.id.txtboxNombre)
        var btnSaludo = findViewById<Button>(R.id.BtnGenerar)
        var btnReinicio = findViewById<Button>(R.id.BtnReiniciar)
        val audio = MediaPlayer.create(this, R.raw.lodejariatodo)



        btnSaludo.setOnClickListener{
            if(nombre.text.toString().isEmpty()){
                Toast.makeText(this,"Porfavor ingrese un nombre",Toast.LENGTH_LONG).show()
            }else{
                if (audio.isPlaying){
                    audio.seekTo(0)
                }else{
                    audio.start()
                }

                texto.setBackgroundColor(Color.parseColor("#B2FFFFFF"))
                texto.setText("Hola ${nombre.text.toString()}, te dedico esta bella cancion igual que tu corazon. Espero la disfrutes")
            }
        }
        btnReinicio.setOnClickListener{
            texto.setBackgroundColor(Color.TRANSPARENT)
            texto.setText("")
            nombre.setText("")
            audio.stop()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}