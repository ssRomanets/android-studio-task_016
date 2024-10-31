package com.example.task_016

import android.os.Bundle
import android.view.View
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    private lateinit var toolbarMain: Toolbar

    var numberStr1: String = ""
    var numberStr2: String = ""
    var operand:    String = "#"
    var result:     Double = 0.0;

    private lateinit var inputET: EditText
    private lateinit var resultTV: TextView

    private lateinit var buttonSumBTN: Button
    private lateinit var buttonDifBTN: Button
    private lateinit var buttonMultBTN: Button
    private lateinit var buttonDivBTN: Button

    private lateinit var buttonEqBTN: Button
    private lateinit var buttonResetBTN: Button

    private lateinit var button0BTN: Button
    private lateinit var button1BTN: Button
    private lateinit var button2BTN: Button
    private lateinit var button3BTN: Button
    private lateinit var button4BTN: Button
    private lateinit var button5BTN: Button
    private lateinit var button6BTN: Button
    private lateinit var button7BTN: Button
    private lateinit var button8BTN: Button
    private lateinit var button9BTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ////
        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title = "Калькулятор"

        //
        inputET  = findViewById(R.id.inputET)
        resultTV = findViewById(R.id.resultTV)

        //
        buttonSumBTN   = findViewById(R.id.buttonSumBTN)
        buttonDifBTN   = findViewById(R.id.buttonDifBTN)
        buttonMultBTN  = findViewById(R.id.buttonMultBTN)
        buttonDivBTN   = findViewById(R.id.buttonDivBTN)
        buttonEqBTN    = findViewById(R.id.buttonEqBTN)
        buttonResetBTN = findViewById(R.id.buttonResetBTN)

        //
        button0BTN = findViewById(R.id.button0BTN)
        button1BTN = findViewById(R.id.button1BTN)
        button2BTN = findViewById(R.id.button2BTN)
        button3BTN = findViewById(R.id.button3BTN)
        button4BTN = findViewById(R.id.button4BTN)
        button5BTN = findViewById(R.id.button5BTN)
        button6BTN = findViewById(R.id.button6BTN)
        button7BTN = findViewById(R.id.button7BTN)
        button8BTN = findViewById(R.id.button8BTN)
        button9BTN = findViewById(R.id.button9BTN)
    }

    fun resetParams() {
        operand = "#"
        numberStr1 = ""
        numberStr2 = ""
        inputET.text.clear()
    }

    fun onButtonActionClick(v: View) {
        inputET.text.clear()

        var button: Button = findViewById(v.id)
        operand = button.text.toString();

        if (operand == "=") {
            resultTV.setText(result.toString())
            result = 0.0
            resetParams()
        } else if (numberStr2 != "")
        {
            numberStr1 = result.toString()
            numberStr2 = ""
        }
    }

    fun onButtonResetClick(v: View)
    {
        resetParams()
        result = 0.0
        resultTV.setText(result.toString())
    }

    fun onButtonDigitClick(v: View) {
        var button: Button = findViewById(v.id)
        var digit: String = button.text.toString();

        if (operand == "#") {
            numberStr1 = numberStr1+digit;
            inputET.setText(numberStr1)
        } else if (operand != "=") {
            numberStr2 = numberStr2+digit;
            inputET.setText(numberStr2)

            if (numberStr1 != "" && numberStr2 != "")
            {
                when (operand) {
                    "+" -> result = Operation(numberStr1.toDouble(),numberStr2.toDouble()).sum()
                    "-" -> result = Operation(numberStr1.toDouble(),numberStr2.toDouble()).dif()
                    "*" -> result = Operation(numberStr1.toDouble(),numberStr2.toDouble()).mult()
                    "/" -> result = Operation(numberStr1.toDouble(),numberStr2.toDouble()).div()
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return  true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exitMenuMain->{
                Toast.makeText(
                    applicationContext,
                    "Работа завершена",
                    Toast.LENGTH_LONG
                ).show()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}