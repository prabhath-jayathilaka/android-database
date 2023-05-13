package com.example.android_database

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHelper = DBHelper(this)

        dbHelper.insertData("002","Code Jay",26)
        dbHelper.insertData("003","Code three",3)
        dbHelper.insertData("004","Code four",4)

        dbHelper.queryData()
//        val values = ContentValues().apply {
//            put(DBHelper.COLUMN_INDEX_NUMBER, "001")
//            put(DBHelper.COLUMN_NAME, "John Doe")
//            put(DBHelper.COLUMN_AGE, 25)
//        }
//        val db = dbHelper.writableDatabase
//        db.insert(DBHelper.TABLE_NAME, null, values)

        // Query the database
//        val projection = arrayOf(DBHelper.COLUMN_INDEX_NUMBER, DBHelper.COLUMN_NAME, DBHelper.COLUMN_AGE)
//        val selection = "${DBHelper.COLUMN_AGE} = ?"
//        val selectionArgs = arrayOf("25")
//        val cursor = db.query(DBHelper.TABLE_NAME, projection, selection, selectionArgs, null, null, null)
//        cursor.use { // Use the cursor to access the query results
//            while (it.moveToNext()) {
//                val indexNumber = it.getString(it.getColumnIndex(DBHelper.COLUMN_INDEX_NUMBER))
//                val name = it.getString(it.getColumnIndex(DBHelper.COLUMN_NAME))
//                val age = it.getInt(it.getColumnIndex(DBHelper.COLUMN_AGE))
//                Log.d("mydb", "Record found: $indexNumber, $name, $age")
//            }
//        }
    }


}