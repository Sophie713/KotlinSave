package com.example.sophie.kotlinsave

import mu.KotlinLogging
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebChromeClient
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.File
import java.nio.charset.Charset

private val logger = KotlinLogging.logger {}


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val dest = applicationContext.getExternalFilesDir(null);
        //adress to the destination = path = cesta + '/' a nazev filu
        val destFile = dest.path.plus(File.pathSeparator).plus("data.txt")
        //check it's working
        var textNumber = 1

        var button2 = findViewById<View>(R.id.myButton) as Button;

        button2.setOnClickListener {
            // your code to perform when the user clicks on the button
            //create a file
            val logToFile = LogToFile(this, findViewById(R.id.textInput))
            logToFile.write()
            //find view

            //save it into the file
            Toast.makeText(this@MainActivity, "noted:", Toast.LENGTH_SHORT).show()

          /*  File(destFile).appendText("$textNumber " + userInput + "\n", Charset.defaultCharset())
                    //printWriter().use { out -> out.println(userInput + "\n") }

            //ID
            textNumber++*/
        }



        //DELETE
        var deleteButton = findViewById<View>(R.id.deleteButton) as Button;

        deleteButton.setOnClickListener {
            File(destFile).delete()
        }

    }





    }
