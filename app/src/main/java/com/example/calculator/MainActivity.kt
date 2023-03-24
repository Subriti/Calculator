package com.example.calculator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        outputView.isVisible = false
        Functionalities()

    }

    private fun Functionalities() {
        val textInput = findViewById<TextView>(R.id.textInput)
        var text = textInput.text.toString()
        text= 0.toString()
        println("Initial Text value is: $text")
        //var value=0

        lateinit var last: String

        btnOne.setOnClickListener {
            text += 1
            textInput.text = text
            println(text)
        }
        btnTwo.setOnClickListener {
            text += 2
            textInput.text = text
            println(text)
        }
        btnThree.setOnClickListener {
            text += 3
            textInput.text = text
            println(text)
        }
        btnFour.setOnClickListener {
            text += 4
            textInput.text = text
            println(text)
        }
        btnFive.setOnClickListener {
            text += 5
            textInput.text = text
            println(text)
        }
        btnSix.setOnClickListener {
            text += 6
            textInput.text = text
            println(text)
        }
        btnSeven.setOnClickListener {
            text += 7
            textInput.text = text
            println(text)
        }
        btnEight.setOnClickListener {
            text += 8
            textInput.text = text
            println(text)
        }
        btnNine.setOnClickListener {
            text += 9
            textInput.text = text
            println(text)
        }
        btnZero.setOnClickListener {
            text += 0
            textInput.text = text
            println(text)
        }


        btnDot.setOnClickListener {
            last = text.last().toString()
            if (last == ".") {
                text = text.dropLast(1)
                text += "."
                textInput.text = text
            } else {
                text += "."
                textInput.text = text
                println(text)
            }
        }

        btnPlus.setOnClickListener {
            last = text.last().toString()
            if (text != "") {
                if (last == "*" || last == "/" || last == "%" || last == "-") {
                    text = text.dropLast(1)
                    text += "+"
                    textInput.text = text
                } else if (last == "+") {
                    text = text.dropLast(1)
                    textInput.text = text
                } else {
                    text += "+"
                    textInput.text = text
                }
            } else {
                textInput.text = "0+"
            }
            println(text)
        }

        btnMinus.setOnClickListener {
            last = text.last().toString()
            println(text)
            if (text != "") {
                if (last == "*" || last == "/" || last == "%" || last == "+") {
                    text = text.dropLast(1)
                    text += "-"
                    textInput.text = text
                } else if (last == "-") {
                    text = text.dropLast(1)
                    textInput.text = text
                } else {
                    text += "-"
                    textInput.text = text
                }
            } else {
                println(text)
                textInput.text = "0-"
            }
            println(text)
        }

        btnMul.setOnClickListener {
            last = text.last().toString()
            if (text != "") {
                if (last == "-" || last == "/" || last == "%" || last == "+") {
                    text = text.dropLast(1)
                    text += "*"
                    textInput.text = text
                } else if (last == "*") {
                    text = text.dropLast(1)
                    textInput.text = text
                } else {
                    text += "*"
                    textInput.text = text
                }
            } else {
                textInput.text = "0x"
            }
            println(text)
        }

        btnDiv.setOnClickListener {
            last = text.last().toString()
            if (text != "") {
                if (last == "*" || last == "-" || last == "%" || last == "+") {
                    text = text.dropLast(1)
                    text += "/"
                    textInput.text = text
                } else if (last == "x") {
                    text = text.dropLast(1)
                    textInput.text = text
                } else {
                    text += "/"
                    textInput.text = text
                }
            } else {
                textInput.text = "0/"
            }
            println(text)
        }
        btnMod.setOnClickListener {
            if (text != "") {
                text += "%"
                textInput.text = text
                println(text)
            } else {
                text += "0%"
                textInput.text = text
            }
        }

            btnBack.setOnClickListener {
                text = text.dropLast(1)
                textInput.text = text
                outputView.text = ""
                outputView.isVisible = false

                println(text)
            }
            btnClear.setOnClickListener {
                textInput.text = ""
                text = ""
                outputView.text = ""
                outputView.isVisible = false

            }
            btnPlusMinus.setOnClickListener {
                println(text)
                if (text != "") {
                    if (text.toDouble() < 0) {
                        text = abs(text.toDouble()).toString()
                        textInput.text = text
                    } else {
                        text = (text.toDouble() * -1).toString()
                        textInput.text = text
                    }

                } else {
                    println(text)
                    text += "-0"
                    textInput.text = text
                    println(text)
                }
            }

                btnEqual.setOnClickListener {

                    /*
                    var sum= 0
                    var diff=0
                    var mul=0
                    var div=0.0

                    var splitList1= text.split("+")
                    lateinit var splitList2:  ArrayList<List<String>>
                    var splitList3= text.split("x")
                    var splitList4= text.split("/")

                    var splitListSub: List<String>
                    var splitListMul: List<String>
                    var splitListDiv: List<String>

                    println("Split by Addition $splitList1")
                    for (each in splitList1){
                            splitListSub= each.split("-")
                            println("Split by Subtraction $splitListSub")

                            splitList2.add(splitListSub)
        //                    sum+=each.toInt()
        //                    println("Difference is $sum")
        println("SubList2 $splitList2")
                        for (each in splitListSub){
                            splitListMul= each.split("x")
                            println("Split by Multiplication $splitListMul")
        //                    diff-=each.toInt()
        //                    println("Difference is $diff")

                            for (each in splitListMul){
                                splitListDiv= each.split("/")
                                println("Split by Division $splitListDiv")
        //                        mul*= each.toInt()
        //                        println("Multiplication is $mul")
                                for (each in splitListDiv)
                                    print("Division each $each")
                                    //div/= each.toDouble()
                                    //println("Division is $div")
                            }
                        }

                    }
        //            for (each in splitList){
        //                sum += each.toInt()
        //                println(sum)
                    //var split1= text.split("-")
                          //var splitList1=  splitList.split("-")
                    //            }
                    /*
                    if (text.contains("+")){
                        var split= text.split("+")
                        println(split)
                        for (each in split)
                            sum += each.toInt()
                            println(sum)
                }
                    if (text.contains("x")){
                        var split= text.split("x")
                        println(split)
                    }
                    if (text.contains("-")){
                        var split= text.split("-")
                        println(split)
                    }
                    if (text.contains("/")){
                        var split= text.split("/")
                        println(split)
                    }

                     */

                     */

                    val output = findViewById<TextView>(R.id.outputView)
                    var outputtext = "0"
                    val expression = ExpressionBuilder(text).build()

                    last = text.last().toString()
                    println("Last in equal is: $last")
                    if (last == "*" || last == "-" || last == "%" || last == "+") {
                        text = text.dropLast(1)
                        textInput.text = text
                    } else {
                        val result = expression.evaluate()
                        val longResult = result.toLong()
                        if (result == longResult.toDouble()) {
                            output.text = longResult.toString()
                            outputtext = output.text.toString()
                            text = outputtext
                            textInput.text = text
                            println("Output is $outputtext")
                        } else {
                            output.text = result.toString()
                            outputtext = output.text.toString()
                            text = outputtext
                            textInput.text = text
                            println("Output is $outputtext")
                        }

                        outputView.isVisible = true
                    }
                }
            }
            /*
            fun evaluateExpression(string: String, clear: Boolean) {
                if(clear) {
                    Result.text = ""
                    Expression.append(string)
                } else {
                    Expression.append(Result.text)
                    Expression.append(string)
                    Result.text = ""
                }
            }

             */

    }

