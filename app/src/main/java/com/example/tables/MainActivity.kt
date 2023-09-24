package com.example.tables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)

        val seekBar = findViewById<SeekBar>(R.id.seekBar)

        seekBar.min =2
        seekBar.max = 20
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Toast.makeText(this@MainActivity, "the progress $progress", Toast.LENGTH_LONG)
                    .show()
                populate(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }

    fun populate(num:Int){
        val mulTable :ArrayList<String> = ArrayList()
        for(i in 1..10){
            mulTable.add(" $num "+" X "+ i +" = " +num*i)
        }
        val lsitView = findViewById<ListView>(R.id.listView)
        val arrayAdap : ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_list_item_1,mulTable)
        lsitView.setAdapter(arrayAdap)
    }
}



