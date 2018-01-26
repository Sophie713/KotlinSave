package com.example.sophie.kotlinsave

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.io.File
import java.io.IOException
import java.util.logging.FileHandler
import java.util.logging.Logger
import java.util.logging.SimpleFormatter

class LogToFile(val context: Context, val view: View){



    fun write() {

        val logger = Logger.getLogger("MyLog")
        val fh: FileHandler

        try {
            val dest = context.applicationContext.getExternalFilesDir(null);
            // This block configure the logger with handler and formatter
            fh = FileHandler(dest.path.plus(File.pathSeparator).plus("data.txt"))
            logger.addHandler(fh)
            val formatter = SimpleFormatter()
            fh.formatter = formatter
            //find view
            var input = view.findViewById(R.id.textInput) as EditText
            //get user input
            var userInput = input.text.toString()
            // the following statement is used to log any messages
            logger.info(userInput)

        } catch (e: SecurityException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}