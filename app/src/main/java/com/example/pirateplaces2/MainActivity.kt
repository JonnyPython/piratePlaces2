package com.example.pirateplaces2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.sax.Element
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var checkinButton: Button
    private lateinit var checkoutButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView
    private lateinit var backButton: Button
    private lateinit var nameTextView: TextView

    private val questionBank = listOf(
        Question(R.string.p1 , true),
        Question(R.string.p2, true),
        Question(R.string.p3, false),
        Question(R.string.p4, false),
        Question(R.string.p5, true),
        Question(R.string.p6, true))
    private var currentIndex = 0

    private val nameBank = listOf(
        names(R.string.n1,true),
        names(R.string.n2, true),
        names(R.string.n3, false),
        names(R.string.n4, false),
        names(R.string.n5, true),
        names(R.string.n6, true))
    private var currentnameIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkinButton = findViewById(R.id.true_button)
        checkoutButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)
        backButton = findViewById(R.id.back_button)
        nameTextView = findViewById(R.id.name_text_view)

        checkinButton.setOnClickListener { view: View ->
            Toast.makeText(
                this,
                R.string.correct_toast,
                Toast.LENGTH_SHORT)
                .show()

            val x =",Me"

                nameTextView.append(x.toString())


        }



        checkoutButton.setOnClickListener { view: View ->

        Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show()
            val x =' '
            nameTextView.append(x.toString())
        }

        nextButton.setOnClickListener {

            if (currentIndex>4){
                Toast.makeText(
                    this,
                    R.string.next_toast,
                    Toast.LENGTH_SHORT)
                    .show()
        }else {
                currentIndex = (currentIndex + 1) % questionBank.size
                val questionTextResId = questionBank[currentIndex].textResId
                questionTextView.setText(questionTextResId)
                currentnameIndex = (currentnameIndex + 1) % nameBank.size
                val nametextResId = nameBank[currentnameIndex].nametextResId
                nameTextView.setText(nametextResId)
            }

        }

        backButton.setOnClickListener {
            if (currentIndex<1){
                Toast.makeText(
                    this,
                    R.string.back_toast,
                    Toast.LENGTH_SHORT)
                    .show()
            }else {
                currentIndex = (currentIndex - 1) % questionBank.size
                val questionTextResId = questionBank[currentIndex].textResId
                questionTextView.setText(questionTextResId)
                currentnameIndex = (currentnameIndex - 1) % nameBank.size
                val nametextResId = nameBank[currentnameIndex].nametextResId
                nameTextView.setText(nametextResId)
            }
        }
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
///////
        val nametextResId = nameBank[currentnameIndex].nametextResId
        nameTextView.setText(nametextResId)
    }



}
