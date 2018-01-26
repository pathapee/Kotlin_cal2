package com.example.pathapee.myapplication

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.Scene
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var name : EditText
    lateinit var lastname : EditText
    lateinit var save : Button
    lateinit var red : Button
    lateinit var green : Button
    var setColor : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        lastname = findViewById(R.id.lastname)
        save = findViewById(R.id.save)
        red = findViewById(R.id.red)
        green = findViewById(R.id.green)
        red.setText("xxxxxxx")
        readInfo()

        save.setOnClickListener {
            saveInfo()
        }
        red.setOnClickListener {
            Setcolor("RED")
        }
        green.setOnClickListener {
            Setcolor("GREEN")
        }


        var inputText1 : String? = null
        var inputText2 : String? = null
        var ans : Double = 0.0
        var ans_1 : Double = 0.0
        var ans_2 : Double = 0.0
        var ch : Int = 0
        but_num0.setOnClickListener {
            var num0 :String = Edit_text.text.toString()
            Edit_text.setText(num0+"0")

        }
        but_num1.setOnClickListener {
            var num1 :String = Edit_text.text.toString()
            Edit_text.setText(num1+"1")

        }
        but_num2.setOnClickListener {
            var num2 :String = Edit_text.text.toString()
            Edit_text.setText(num2+"2")

        }
        but_num3.setOnClickListener {
            var num3 :String = Edit_text.text.toString()
            Edit_text.setText(num3+"3")

        }
        but_num4.setOnClickListener {
            var num4 :String = Edit_text.text.toString()
            Edit_text.setText(num4+"4")

        }
        but_num5.setOnClickListener {
            var num5 :String = Edit_text.text.toString()
            Edit_text.setText(num5+"5")

        }
        but_num6.setOnClickListener {
            var num6 :String = Edit_text.text.toString()
            Edit_text.setText(num6+"6")

        }
        but_num7.setOnClickListener {
            var num7 :String = Edit_text.text.toString()
            Edit_text.setText(num7+"7")

        }
        but_num8.setOnClickListener {
            var num8 :String = Edit_text.text.toString()
            Edit_text.setText(num8+"8")

        }
        but_num9.setOnClickListener {
            var num9 :String = Edit_text.text.toString()
            Edit_text.setText(num9+"9")

        }
        but_point.setOnClickListener {
            var point :String = Edit_text.text.toString()
            Edit_text.setText(point+".")
        }

        clear.setOnClickListener {
            Edit_text.setText(null)
        }

        but_ans.setOnClickListener {
            inputText2 = Edit_text.text.toString()
            ans_2 = inputText2!!.toDouble()

            println(ans_2)

            if (ch == 1)
                ans = ans_1+ans_2
            else if (ch == 2)
                ans = ans_1-ans_2
            else if (ch == 3)
                ans = ans_1*ans_2
            else if (ch == 4)
                ans = ans_1/ans_2

            Edit_text.setText(""+ans)

        }

        but_plus.setOnClickListener {
            inputText1 = Edit_text.text.toString()
            ans_1 = inputText1!!.toDouble()

            println(ans_1)

            Edit_text.setText(null)

            ch = 1

        }
        but_sub.setOnClickListener {
            inputText1 = Edit_text.text.toString()
            ans_1 = inputText1!!.toDouble()
            Edit_text.setText(null)
            ch = 2
        }
        but_mul.setOnClickListener {
            inputText1 = Edit_text.text.toString()
            ans_1 = inputText1!!.toDouble()
            Edit_text.setText(null)
            ch = 3
        }
        but_div.setOnClickListener {
            inputText1 = Edit_text.text.toString()
            ans_1 = inputText1!!.toDouble()
            Edit_text.setText(null)
            ch = 4
        }
    }

    private fun readInfo(){
        val sp = getSharedPreferences("sp", Context.MODE_PRIVATE)
        val nameSet = sp.getString("name", "not found")
        val lastnameSet = sp.getString("lastname", "not found")
        name.setText(nameSet)
        lastname.setText(lastnameSet)

        val cl = getSharedPreferences("color", Context.MODE_PRIVATE)
        val xx = cl.getString("color_test", "not found")
        color.setBackgroundColor(Color.parseColor(xx))

    }

    private fun saveInfo(){
        if (name.text.isEmpty()){
            name.error = "Please your name"
        }
        if (lastname.text.isEmpty()){
            name.error = "Please your lastname"
        }
        val sp = getSharedPreferences("sp", Context.MODE_PRIVATE)
        val editSp = sp.edit()
        editSp.putString("name" , name.text.toString())
        editSp.putString("lastname" , lastname.text.toString())
        editSp.apply()
        Toast.makeText(this , "Save " , Toast.LENGTH_LONG).show()
    }

    private fun Setcolor(colorXX:String){
        setColor = colorXX
        val cl = getSharedPreferences("color", Context.MODE_PRIVATE)
        val editColor = cl.edit()
        color.setBackgroundColor(Color.parseColor(colorXX))
        editColor.putString("color_test" , setColor)
        editColor.apply()
        //Toast.makeText(this , "SetBG: "+setColor , Toast.LENGTH_LONG).show()

    }
}
