package com.example.androidarchitecture

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NewWordActivity : AppCompatActivity(){
    private lateinit var editWordvar: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newword)
        editWordvar = findViewById(R.id.edit_word)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener{
            val replyIntent = Intent();
            if(TextUtils.isEmpty(editWordvar.text))
            {
                setResult(Activity.RESULT_CANCELED,replyIntent)
            }
            else{
                val word = editWordvar.text.toString()
                replyIntent.putExtra(EXTRA_REPLY,word)
                setResult(Activity.RESULT_OK,replyIntent)
            }
            finish()
        }
        }
    companion object{
        const val EXTRA_REPLY = "com.example.androidarchitecture.REPLY"
    }
}