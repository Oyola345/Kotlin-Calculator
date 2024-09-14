package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var cButton: Button
    private lateinit var percentageButton: Button
    private lateinit var splitButton: Button
    private lateinit var deleteButton: ImageButton
    private lateinit var sevenButton: Button
    private lateinit var eightButton: Button
    private lateinit var nineButton: Button
    private lateinit var multiplyButton: ImageButton
    private lateinit var fourButton: Button
    private lateinit var fiveButton: Button
    private lateinit var sixButton: Button
    private lateinit var plusButton: ImageButton
    private lateinit var oneButton: Button
    private lateinit var twoButton: Button
    private lateinit var threeButton: Button
    private lateinit var minusButton: Button
    private lateinit var zeroButton: Button
    private lateinit var commaButton: Button
    private lateinit var equalButton: Button
    private var number1 = 0.0
    private var number2 = 0.0
    private var result = 0.0
    private var numbersArray = mutableListOf<Double>()
    private var operationsArray = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()
        initListeners()
    }

    private fun initComponents() {
        cButton = binding.btnC
        percentageButton = binding.btnPercentage
        splitButton = binding.btnSplit
        deleteButton = binding.btnDelete
        sevenButton = binding.btn7
        eightButton = binding.btn8
        nineButton = binding.btn9
        multiplyButton = binding.btnMultiply
        fourButton = binding.btn4
        fiveButton = binding.btn5
        sixButton = binding.btn6
        plusButton = binding.btnSum
        oneButton = binding.btn1
        twoButton = binding.btn2
        threeButton = binding.btn3
        minusButton = binding.btnMinus
        zeroButton = binding.btn0
        commaButton = binding.btnComma
        equalButton = binding.btnEqual
    }

    private fun initListeners() {
        var number = ""
        var operation = ""

        cButton.setOnClickListener {
            binding.tvResults.text = "0"
            number = ""
            number1 = 0.0
            number2 = 0.0
            numbersArray.clear()
            operation = ""
        }

        percentageButton.setOnClickListener {
            if (result != 0.0) {
                number = binding.tvResults.text.toString()
            }

            result = 0.0
            number1 = number.toDouble()
            binding.tvResults.text = (number1 / 100).toString()
            operation = "percentage"
            Log.i("log calculator", "Operacion: $operation")
            Log.i("log calculator", "Numeros arrays: $numbersArray")
            number = ""
            number1 = 0.0
        }

        splitButton.setOnClickListener {
            if (result != 0.0) {
                number = binding.tvResults.text.toString()
            }

            result = 0.0

            numbersArray.add(number.toDouble())
            operationsArray.add("split")
            Log.i("log calculator", "Operacion: $operation")
            Log.i("log calculator", "Numeros arrays: $numbersArray")
            number = ""

            binding.tvResults.text = showCalculation().toString()

        }

        multiplyButton.setOnClickListener {
            if (result != 0.0) {
                number = binding.tvResults.text.toString()
            }

            result = 0.0

            numbersArray.add(number.toDouble())
            operationsArray.add("multiply")
            Log.i("log calculator", "Operacion: $operation")
            Log.i("log calculator", "Numeros arrays: $numbersArray")
            number = ""

            binding.tvResults.text = showCalculation().toString()
        }

        deleteButton.setOnClickListener {
            if (result != 0.0) {
                number = binding.tvResults.text.toString()
            }

            result = 0.0

            number = number.dropLast(1)
            binding.tvResults.text = showCalculation().toString() + number
        }

        minusButton.setOnClickListener {
            if (result != 0.0) {
                number = binding.tvResults.text.toString()
            }

            result = 0.0
            numbersArray.add(number.toDouble())
            operationsArray.add("minus")
            Log.i("log calculator", "Operacion: $operation")
            Log.i("log calculator", "Numeros arrays: $numbersArray")
            number = ""

            binding.tvResults.text = showCalculation().toString()
        }

        plusButton.setOnClickListener {
            if (result != 0.0) {
                number = binding.tvResults.text.toString()
            }

            result = 0.0
            numbersArray.add(number.toDouble())
            operationsArray.add("plus")
            Log.i("log calculator", "Operacion: $operation")
            Log.i("log calculator", "Numeros arrays: $numbersArray")
            number = ""

            binding.tvResults.text = showCalculation().toString()
        }

        sevenButton.setOnClickListener {
            if (result != 0.0) {
                number = binding.tvResults.text.toString()
            }

            result = 0.0
            number = number + "7"
            val numberToShow = showCalculation().toString() + number
            binding.tvResults.text = numberToShow
        }

        eightButton.setOnClickListener {
            if (result != 0.0) {
                number = binding.tvResults.text.toString()
            }

            result = 0.0
            number = number + "8"
            val numberToShow = showCalculation().toString() + number
            binding.tvResults.text = numberToShow
        }

        nineButton.setOnClickListener {
            if (result != 0.0) {
                number = binding.tvResults.text.toString()
            }

            result = 0.0
            number = number + "9"
            val numberToShow = showCalculation().toString() + number
            binding.tvResults.text = numberToShow
        }

        fourButton.setOnClickListener {
            if (result != 0.0) {
                number = binding.tvResults.text.toString()
            }

            result = 0.0
            number = number + "4"
            val numberToShow = showCalculation().toString() + number
            binding.tvResults.text = numberToShow
        }

        fiveButton.setOnClickListener {
            if (result != 0.0) {
                number = binding.tvResults.text.toString()
            }

            result = 0.0
            number = number + "5"
            val numberToShow = showCalculation().toString() + number
            binding.tvResults.text = numberToShow
        }

        sixButton.setOnClickListener {
            if (result != 0.0) {
                number = binding.tvResults.text.toString()
            }

            result = 0.0
            number = number + "6"
            val numberToShow = showCalculation().toString() + number
            binding.tvResults.text = numberToShow
        }


        oneButton.setOnClickListener {
            if (result != 0.0) {
                number = binding.tvResults.text.toString()
            }

            result = 0.0
            number = number + "1"
            val numberToShow = showCalculation().toString() + number
            binding.tvResults.text = numberToShow
        }

        twoButton.setOnClickListener {
            if (result != 0.0) {
                number = binding.tvResults.text.toString()
            }

            result = 0.0
            number = number + "2"
            val numberToShow = showCalculation().toString() + number
            binding.tvResults.text = numberToShow
        }

        threeButton.setOnClickListener {
            if (result != 0.0) {
                number = binding.tvResults.text.toString()
            }

            result = 0.0
            number = number + "3"
            val numberToShow = showCalculation().toString() + number
            binding.tvResults.text = numberToShow
        }


        zeroButton.setOnClickListener {
            if (result != 0.0) {
                number = binding.tvResults.text.toString()
            }

            result = 0.0
            number = number + "0"
            val numberToShow = showCalculation().toString() + number
            binding.tvResults.text = numberToShow
        }

        commaButton.setOnClickListener {
            if (result != 0.0) {
                number = binding.tvResults.text.toString()
            }

            if (!number.contains(".")) {
                number = "$number."
            }

            result = 0.0
            val numberToShow = showCalculation().toString() + number
            binding.tvResults.text = numberToShow
        }

        equalButton.setOnClickListener {
            numbersArray.add(number.toDouble())
            Log.i("log calculator", "Numeros arrays: $numbersArray")
            operateNumbers(numbersArray, operationsArray)

            number1 = 0.0
            number2 = 0.0
            operation = ""
            number = ""
            numbersArray.clear()
            operationsArray.clear()
        }

    }

    private fun showCalculation(): StringBuilder {
        val strBuilder = StringBuilder()

        val interleaved = numbersArray.zip(operationsArray) { num, op ->
            if (num.toString().contains(".0")) {
                Log.i("log calculator", "Num: $num")
                val numFormatted = String.format("%.0f", num)
                Log.i("log calculator", "Resultado: $numFormatted")
                strBuilder.append(numFormatted)
            } else {
                strBuilder.append(num.toString())
            }

            when (op) {
                "multiply" -> strBuilder.append(" x ")
                "split" -> strBuilder.append(" / ")
                "plus" -> strBuilder.append(" + ")
                "minus" -> strBuilder.append(" - ")
                else -> strBuilder.append(" ")
            }
        }

        return strBuilder
    }

    private fun operateNumbers(
        numbersArray: MutableList<Double>,
        operationsArray: MutableList<String>
    ) {

        while (numbersArray.size > 1) {
            if (operationsArray.contains("multiply") || operationsArray.contains("split")) {
                val indexMult = operationsArray.indexOf("multiply")
                val indexSplit = operationsArray.indexOf("split")
                Log.i("log calculator", "Index mult: $indexMult")
                Log.i("log calculator", "Index split: $indexSplit")

                if (operationsArray.contains("multiply") && operationsArray.contains("split")) {

                    if (indexMult < indexSplit) {
                        operationsArray.removeAt(indexMult)
                        number1 = numbersArray[indexMult]
                        number2 = numbersArray[indexMult + 1]
                        result = number1 * number2

                        numbersArray.removeAt(indexMult)
                        numbersArray.removeAt(indexMult + 1)
                        numbersArray.add(indexMult, result)
                    } else {
                        operationsArray.removeAt(indexSplit)
                        number1 = numbersArray[indexSplit]
                        number2 = numbersArray[indexSplit + 1]
                        result = number1 / number2

                        numbersArray.removeAt(indexSplit)
                        numbersArray.removeAt(indexSplit + 1)
                        numbersArray.add(indexSplit, result)
                    }

                } else if (operationsArray.contains("multiply") && !operationsArray.contains("split")) {

                    operationsArray.removeAt(indexMult)
                    number1 = numbersArray[indexMult]
                    number2 = numbersArray[indexMult + 1]
                    result = number1 * number2
                    Log.i("log calculator", "Resultado: $result")

                    numbersArray.removeAt(indexMult)
                    numbersArray.removeAt(indexMult)
                    numbersArray.add(indexMult, result)
                    Log.i("log calculator", "numbers array: $numbersArray")
                    Log.i("log calculator", "numbers array size: ${numbersArray.size}")

                } else if (operationsArray.contains("split") && !operationsArray.contains("multiply")) {

                    operationsArray.removeAt(indexSplit)
                    number1 = numbersArray[indexSplit]
                    number2 = numbersArray[indexSplit + 1]
                    result = number1 / number2
                    Log.i("log calculator", "Resultado: $result")

                    numbersArray.removeAt(indexSplit)
                    numbersArray.removeAt(indexSplit)
                    numbersArray.add(indexSplit, result)
                    Log.i("log calculator", "numbers array: $numbersArray")
                    Log.i("log calculator", "numbers array size: ${numbersArray.size}")
                }
            } else {
                number1 = numbersArray[0]
                number2 = numbersArray[1]
                val operation = operationsArray[0]
                Log.i("log calculator", "Operacion: $operation")
                Log.i("log calculator", "Numeros por operar: $number1 y $number2")

                if (operation == "plus") {
                    result = number1 + number2
                    numbersArray.removeAt(1)
                    numbersArray.removeAt(0)
                    numbersArray.add(0, result)
                    operationsArray.removeAt(0)
                    Log.i("log calculator", "numbers array: $numbersArray")

                } else if (operation == "minus") {
                    result = number1 - number2
                    numbersArray.removeAt(1)
                    numbersArray.removeAt(0)
                    numbersArray.add(0, result)
                    operationsArray.removeAt(0)
                    Log.i("log calculator", "numbers array: $numbersArray")
                }

                Log.i("log calculator", "Resultado: $result")
            }
        }
        Log.i("log calculator", "numbers size < 1: ${numbersArray.size}")

        if (result.toString().contains(".0")) {
            Log.i("log calculator", "Resultado: $result")
            val resultFormatted = String.format("%.0f", result)
            Log.i("log calculator", "Resultado: $resultFormatted")
            binding.tvResults.text = resultFormatted
        } else {
            binding.tvResults.text = result.toString()
        }
    }
}