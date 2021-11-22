package com.vmakd1916gmail.com.rxjavastudy1

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editTextView = findViewById<EditText>(R.id.exampleTextId)
        Log.d(TAG, "onCreate: ")
        RxTextView.textChanges(editTextView)
            .filter{editTextView.text.length>3}
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{updateSearchResult(editTextView.text.toString())}




    }

    private fun updateSearchResult(search:String){
        Log.d(TAG, "updateSearchResult: ")
        val otherStrings = arrayOf("aaaa", "aaabbb", "caaabbbccc")
        for (i in otherStrings){
            if (i.startsWith(search)){
                Log.d(TAG, "updateSearchResult: $i")
            }

        }
    }

}