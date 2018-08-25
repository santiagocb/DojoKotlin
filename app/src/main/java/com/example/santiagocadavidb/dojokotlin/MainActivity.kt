package com.example.santiagocadavidb.dojokotlin

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.santiagocadavidb.dojokotlin.database.DBHelper
import com.example.santiagocadavidb.dojokotlin.model.Note

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    internal var lvsLista: ListView? = null
    private var notes: MutableList<Note> = ArrayList()
    private var dataBase: DBHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(toolbar)
        lvsLista = findViewById(R.id.lista)

        fab.setOnClickListener { view ->
            val openNewNote = Intent(this, NewNote::class.java)
            startActivity(openNewNote)
        }

        dataBase = DBHelper(this)
        notes = dataBase!!.getNotes()
        refresh()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun refresh() {
        notes = dataBase!!.getNotes()
        var adapter = ArrayAdapter<Note>(this, android.R.layout.simple_list_item_1, notes)
        lvsLista!!.adapter = adapter
    }
}
