package com.example.santiagocadavidb.dojokotlin.database

/**
 * Created by santiago.cadavidb on 25/08/18.
 */
class Tables {
    abstract  class Notes {
        companion object {
            val _ID = "_id"
            val TABLE_NAME = "notes"
            val COLUMN_TITLE = "title"
            val COLUMN_BODY = "body"
        }
    }
}