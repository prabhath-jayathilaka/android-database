package com.example.android_database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.sql.SQLException

class DBHelper(context:Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {

    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "FeedReader.db"

        const val TABLE_NAME = "students"
        const val COLUMN_INDEX_NUMBER = "_index_no"
        const val COLUMN_NAME = "name"
        const val COLUMN_AGE = "age"

      private  const val CREATE_TABLE_SQL = "CREATE TABLE $TABLE_NAME ($COLUMN_INDEX_NUMBER TEXT PRIMARY KEY, $COLUMN_NAME TEXT, $COLUMN_AGE INTEGER);"
      private  const val DROP_TABLE_SQL = "DROP TABLE IF EXISTS $TABLE_NAME;"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        try {
            db?.execSQL(CREATE_TABLE_SQL)
            Log.d("mydb", "Table created successfully")
        } catch (e: SQLException) {
            Log.e("mydb", "Error creating table: ${e.message}")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        try {
            db?.execSQL(DROP_TABLE_SQL)
            onCreate(db)
            Log.d("mydb", "Table upgraded successfully")
        } catch (e: SQLException) {
            Log.e("mydb", "Error upgrading table: ${e.message}")
        }
    }

    fun insertData(index_no:String?,name:String?,age:Int){
        val values = ContentValues().apply {
            put(DBHelper.COLUMN_INDEX_NUMBER, index_no)
            put(DBHelper.COLUMN_NAME, name)
            put(DBHelper.COLUMN_AGE, age)
        }
        val db = this.writableDatabase
        db.insert(DBHelper.TABLE_NAME, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun queryData(){
        val db= this.readableDatabase
        val projection = arrayOf(DBHelper.COLUMN_INDEX_NUMBER,DBHelper.COLUMN_NAME,DBHelper.COLUMN_AGE)
        val cursor = db.query(TABLE_NAME,projection,null,null,null,null,null)

    while (cursor.moveToNext()){
        val index_no = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_INDEX_NUMBER))
        Log.d("res", "Index $index_no")
    }
    }
}