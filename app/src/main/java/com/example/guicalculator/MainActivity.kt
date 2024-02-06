package com.example.guicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.*
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var resultView: TextView
    private lateinit var buttonDot: Button
    private lateinit var buttonDivide: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var buttonMultiple: Button
    private lateinit var button4: Button
    private lateinit var button6: Button
    private lateinit var buttonSubtraction: Button
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var buttonAdd: Button
    private lateinit var button0: Button
    private lateinit var button5: Button
    private lateinit var buttonSqrt: Button
    private lateinit var buttonEqual: Button
    private lateinit var buttonC: Button

    private var result: Float? = null
    private var currentInput = ""
    private var currentOperator: String? = null
    private var storedInput: Double = 0.0
    private var newValue: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultView = findViewById(R.id.result)

        buttonC = findViewById(R.id.buttonC)
        buttonDot = findViewById(R.id.buttonDot)
        buttonDivide = findViewById(R.id.buttonDivide)
        buttonMultiple = findViewById(R.id.buttonMultiple)
        buttonSubtraction = findViewById(R.id.buttonSubtraction)
        buttonAdd = findViewById(R.id.buttonAdd)
        button0 = findViewById(R.id.button0)
        buttonSqrt = findViewById(R.id.buttonSqrt)
        buttonEqual = findViewById(R.id.buttonEqual)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        button1.setOnClickListener {
            currentInput = button1.text.toString()
            if (resultView.text == "0" || newValue) {
                resultView.text = currentInput
                newValue = false
            } else {
                resultView.text = "${resultView.text}$currentInput"
            }
        }
        button2.setOnClickListener {
            currentInput = button2.text.toString()
            if (resultView.text == "0" || newValue) {
                resultView.text = currentInput
                newValue = false
            } else {
                resultView.text = "${resultView.text}$currentInput"
            }
        }
        button3.setOnClickListener {
            currentInput = button3.text.toString()
            if (resultView.text == "0" || newValue) {
                resultView.text = currentInput
                newValue = false
            } else {
                resultView.text = "${resultView.text}$currentInput"
            }
        }
        button4.setOnClickListener {
            currentInput = button4.text.toString()
            if (resultView.text == "0" || newValue) {
                resultView.text = currentInput
                newValue = false
            } else {
                resultView.text = "${resultView.text}$currentInput"
            }
        }
        button5.setOnClickListener {
            currentInput = button5.text.toString()
            if (resultView.text == "0" || newValue) {
                resultView.text = currentInput
                newValue = false
            } else {
                resultView.text = "${resultView.text}$currentInput"
            }
        }
        button6.setOnClickListener {
            currentInput = button6.text.toString()
            if (resultView.text == "0" || newValue) {
                resultView.text = currentInput
                newValue = false
            } else {
                resultView.text = "${resultView.text}$currentInput"
            }
        }
        button7.setOnClickListener {
            currentInput = button7.text.toString()
            if (resultView.text == "0" || newValue) {
                resultView.text = currentInput
                newValue = false
            } else {
                resultView.text = "${resultView.text}$currentInput"
            }
        }
        button8.setOnClickListener {
            currentInput = button8.text.toString()
            if (resultView.text == "0" || newValue) {
                resultView.text = currentInput
                newValue = false
            } else {
                resultView.text = "${resultView.text}$currentInput"
            }
        }
        button9.setOnClickListener {
            currentInput = button9.text.toString()
            if (resultView.text == "0" || newValue) {
                resultView.text = currentInput
                newValue = false
            } else {
                resultView.text = "${resultView.text}$currentInput"
            }
        }
        button0.setOnClickListener {
            currentInput = "0"
            if (resultView.text == "0" || newValue) {
                resultView.text = currentInput
                newValue = false
            } else {
                resultView.text = "${resultView.text}$currentInput"
            }
        }
        buttonDot.setOnClickListener {
            currentInput = buttonDot.text.toString()
            if (resultView.text != "0") {
                if(!resultView.text.contains(".")) {
                    resultView.text = "${resultView.text}$currentInput"
                }
            } else {
                resultView.text = "0."
            }
        }

        var lastClickTime: Long = 0
        buttonC.setOnClickListener {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastClickTime < 500) {
                currentInput = ""
                resultView.text = "0"
            } else {
                currentInput = ""
                resultView.text = "0"
                storedInput = 0.0
                currentOperator = null
            }
            lastClickTime = currentTime
            newValue = true
        }

        buttonDivide.setOnClickListener {
            if (currentOperator != null) {
                var currentInputValue = currentInput.toFloat()
                var storedInputValue = storedInput.toFloat()
                when (currentOperator) {
                    "+" -> result = storedInputValue + currentInputValue
                    "-" -> result = storedInputValue - currentInputValue
                    "x" -> result = storedInputValue * currentInputValue
                    "\\u00F7" -> if (currentInputValue != 0.0.toFloat()) {
                        result = storedInputValue / currentInputValue
                    } else {
                        result = null
                    }
                }
                if (result != null) {
                    resultView.text = result.toString()
                } else {
                    resultView.text = "ERROR"
                }
            } else {
                storedInput = currentInput.toDouble()
                resultView.text = "0"
            }
            currentOperator = "\u00F7"
            newValue = true
        }

        buttonAdd.setOnClickListener {
            if (currentOperator != null) {
                var currentInputValue = currentInput.toFloat()
                var storedInputValue = storedInput.toFloat()
                when (currentOperator) {
                    "+" -> result = storedInputValue + currentInputValue
                    "-" -> result = storedInputValue - currentInputValue
                    "x" -> result = storedInputValue * currentInputValue
                    "\\u00F7" -> if (currentInputValue != 0.0.toFloat()) {
                        result = storedInputValue / currentInputValue
                    } else {
                        result = null
                    }
                }
                if (result != null) {
                    resultView.text = result.toString()
                } else {
                    resultView.text = "ERROR"
                }
            } else {
                storedInput = currentInput.toDouble()
                resultView.text = "0"
            }
            currentOperator = buttonAdd.text.toString()
            newValue = true
        }

        buttonSubtraction.setOnClickListener {
            if (currentOperator != null) {
                var currentInputValue = currentInput.toFloat()
                var storedInputValue = storedInput.toFloat()
                when (currentOperator) {
                    "+" -> result = storedInputValue + currentInputValue
                    "-" -> result = storedInputValue - currentInputValue
                    "x" -> result = storedInputValue * currentInputValue
                    "\\u00F7" -> if (currentInputValue != 0.0.toFloat()) {
                        result = storedInputValue / currentInputValue
                    } else {
                        result = null
                    }
                }
                if (result != null) {
                    resultView.text = result.toString()
                } else {
                    resultView.text = "ERROR"
                }
            } else {
                storedInput = currentInput.toDouble()
                resultView.text = "0"
            }
            currentOperator = buttonSubtraction.text.toString()
            newValue = true
        }

        buttonMultiple.setOnClickListener {
            if (currentOperator != null) {
                var currentInputValue = currentInput.toFloat()
                var storedInputValue = storedInput.toFloat()
                when (currentOperator) {
                    "+" -> result = storedInputValue + currentInputValue
                    "-" -> result = storedInputValue - currentInputValue
                    "x" -> result = storedInputValue * currentInputValue
                    "\u00F7" -> if (currentInputValue != 0.0.toFloat()) {
                        result = storedInputValue / currentInputValue
                    } else {
                        result = null
                    }
                }
                if (result != null) {
                    resultView.text = result.toString()
                } else {
                    resultView.text = "ERROR"
                }
                currentInput = ""
                currentOperator = null
                storedInput = result?.toDouble() ?: 0.0
            } else {
                storedInput = currentInput.toDouble()
                resultView.text = "0"
            }
            currentOperator = buttonMultiple.text.toString()
            newValue = true
        }

        buttonSqrt.setOnClickListener {
            val currentInputValue =  currentInput.toDouble()
            if (currentInputValue >= 0) {
                result = sqrt(currentInputValue.toFloat())
                resultView.text = result.toString()
                currentInput = result.toString()
                storedInput = 0.0
            } else {
                resultView.text = "ERROR"
            }
            currentOperator = null
            newValue = true
        }

        buttonEqual.setOnClickListener {
            if (currentOperator != null) {
                val currentInputValue = currentInput.toFloat()
                val storedInputValue = storedInput.toFloat()

                when (currentOperator) {
                    "+" -> result = storedInputValue + currentInputValue
                    "-" -> result = storedInputValue - currentInputValue
                    "x" -> result = storedInputValue * currentInputValue
                    "\u00F7" -> {
                        if (currentInputValue != 0.0.toFloat()) {
                            result = storedInputValue / currentInputValue
                        } else {
                            result = null
                        }
                    }
                }

                if (result != null) {
                    resultView.text = result.toString()
                } else {
                    resultView.text = "ERROR"
                }
                currentInput = resultView.text.toString()
                newValue = true
                currentOperator = null
                storedInput = 0.0
            }
        }
    }
}