package com.lycansoft.database

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        try {
            val myDatabase=this.openOrCreateDatabase("Singers",Context.MODE_PRIVATE,null)
            //myDatabase.execSQL("CREATE TABLE IF NOT EXISTS singers (name VARCHAR,age INT(2))")
            //myDatabase.execSQL("INSERT INTO singers (name,age) VALUES ('Arijit',30)")
            val cursor=myDatabase.rawQuery("SELECT * FROM singers",null)
            val nameIndex=cursor.getColumnIndex("name")
            val ageIndex=cursor.getColumnIndex("age")

            cursor.moveToFirst()

            while (cursor!=null) {
                println("Name: "+cursor.getString(nameIndex))
                println("Age: "+cursor.getString(ageIndex))

                cursor.moveToNext()
            }

            if (cursor!=null){
                cursor!!.close()
            }
        }
        catch (e:Exception){
            e.printStackTrace()
        }
    }
}
