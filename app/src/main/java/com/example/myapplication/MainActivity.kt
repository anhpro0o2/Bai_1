package com.example.myapplication

import android.os.Bundle
import android.widget.*
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
    private val userList = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bind views
        val nameInput = findViewById<EditText>(R.id.nameInput)
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val phoneInput = findViewById<EditText>(R.id.phoneInput)
        val genderGroup = findViewById<RadioGroup>(R.id.genderGroup)
        val termsCheckBox = findViewById<CheckBox>(R.id.termsCheckBox)
        val saveButton = findViewById<Button>(R.id.saveButton)

        // Set up RecyclerView
        recyclerView = findViewById(R.id.userRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter(userList)
        recyclerView.adapter = userAdapter

        // Handle button click
        saveButton.setOnClickListener {
            if (termsCheckBox.isChecked) {
                val name = nameInput.text.toString()
                val email = emailInput.text.toString()
                val phone = phoneInput.text.toString()

                // Get selected gender
                val selectedGenderId = genderGroup.checkedRadioButtonId
                val gender = findViewById<RadioButton>(selectedGenderId).text.toString()

                // Add user to the list
                val user = User(name, email, phone, gender)
                userList.add(user)
                userAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Vui lòng đồng ý với điều khoản sử dụng", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


