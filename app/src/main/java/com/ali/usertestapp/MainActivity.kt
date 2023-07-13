package com.ali.usertestapp

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textInputLayoutName = findViewById<TextInputLayout>(R.id.et_name)
        val etName = textInputLayoutName.editText

        val textInputLayout = findViewById<TextInputLayout>(R.id.et_palindrome)
        val etPalindrome = textInputLayout.editText

        val checkButton = findViewById<Button>(R.id.btn_check)
        val nextButton = findViewById<Button>(R.id.btn_next)

        checkButton.setOnClickListener {
            val palindrome = etPalindrome?.text.toString()

            if (palindromeChecker(palindrome)) {
                showDialog(getString(R.string.txt_palindrome))
            } else {
                showDialog(getString(R.string.txt_not_palindrome))
            }
        }

        nextButton.setOnClickListener {
            val name = etName?.text.toString()

            if (name.isNotEmpty()) {
                val intent = Intent(this, SecondScreenActivity::class.java)
                intent.putExtra("name", name)
                startActivity(intent)
            } else {
                showDialog("Name is required")
            }
        }
    }

    private fun palindromeChecker(text: String): Boolean {
        val cleanText = text.replace("\\s".toRegex(), "") // Menghapus semua spasi
        val reverseString = cleanText.reversed().toString()
        return cleanText.equals(reverseString, ignoreCase = true)
    }

    private fun showDialog(message: String) {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setMessage(message)
        alertDialogBuilder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}
