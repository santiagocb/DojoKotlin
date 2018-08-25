package com.example.santiagocadavidb.dojokotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.santiagocadavidb.dojokotlin.database.DBHelper
import com.example.santiagocadavidb.dojokotlin.model.Note
import kotlinx.android.synthetic.main.activity_new_note.*

class NewNote : AppCompatActivity() {

    private var dataBase: DBHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)

        guardar.setOnClickListener{
            val title = titulo.text.toString()
            val body = texto.text.toString()

            var note = Note(title, body)

            dataBase = DBHelper(this)
            dataBase!!.insertNote(note)
            val openMainActivity = Intent(this, MainActivity::class.java)
            startActivity(openMainActivity)
        }

        salir.setOnClickListener{
            val openMainActivity = Intent(this, MainActivity::class.java)
            startActivity(openMainActivity)
        }
    }
}
