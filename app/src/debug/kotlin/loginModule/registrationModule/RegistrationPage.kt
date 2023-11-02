package loginModule.registrationModule

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.example.eduhub.R
import java.util.Calendar

class RegistrationPage : AppCompatActivity() {
    lateinit var et_first_name: EditText
    lateinit var et_last_name: EditText
    lateinit var et_date_of_birth: EditText
    lateinit var tv_class_category: TextView
    lateinit var tv_subject_category: TextView
    lateinit var et_phone: EditText
    lateinit var et_parent_first_name: EditText
    lateinit var et_parent_last_name: EditText
    lateinit var et_parent_phone: EditText
    lateinit var datepicker: DatePicker
    lateinit var ll_submit: LinearLayout
    lateinit var rg_gender: RadioGroup
    lateinit var rb_male: RadioButton
    lateinit var rb_female: RadioButton
    lateinit var et_password: EditText
    lateinit var et_re_password: EditText
    lateinit var ll_parent_info: LinearLayout
    lateinit var ll_subject_contaoner: LinearLayout
    lateinit var rl_class_dropdown: RelativeLayout
    lateinit var rl_subject_dropdown: RelativeLayout
    lateinit var rv_class: RecyclerView
    lateinit var rv_subject: RecyclerView
    var gender: String =""
    var selectedType: String = ""
    var selecteDob: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_page)

        fetchIntentData()
        initView()
    }

    private fun fetchIntentData() {
        val intentDate = intent
        if (intentDate != null){
            selectedType = intentDate.getStringExtra("selected_role").toString()
        }
    }

    private fun initView() {
        et_first_name = findViewById(R.id.et_first_name)
        et_last_name = findViewById(R.id.et_last_name)
        et_date_of_birth = findViewById(R.id.et_date_of_birth)
        tv_class_category = findViewById(R.id.tv_class_category)
        tv_subject_category = findViewById(R.id.tv_subject_category)
        et_phone = findViewById(R.id.et_phone)
        et_parent_first_name = findViewById(R.id.et_parent_first_name)
        et_parent_last_name = findViewById(R.id.et_parent_last_name)
        et_parent_phone = findViewById(R.id.et_parent_phone)
        datepicker = findViewById(R.id.datepicker)
        ll_submit = findViewById(R.id.ll_submit)
        rg_gender = findViewById(R.id.rg_gender)
        rb_male = findViewById(R.id.rb_male)
        rb_female = findViewById(R.id.rb_female)
        et_password = findViewById(R.id.et_password)
        et_re_password = findViewById(R.id.et_re_password)
        ll_parent_info = findViewById(R.id.ll_parent_info)
        ll_subject_contaoner = findViewById(R.id.ll_subject_contaoner)
        rv_class = findViewById(R.id.rv_class)
        rv_subject = findViewById(R.id.rv_subject)

        if (selectedType == "student"){
            ll_parent_info.visibility = View.VISIBLE
            ll_subject_contaoner.visibility = View.GONE
        }
        else if (selectedType == "teacher"){
            ll_parent_info.visibility = View.GONE
            ll_subject_contaoner.visibility = View.VISIBLE
        }

        et_date_of_birth.setOnClickListener {
            showDatePickerDialog()
        }

        rl_class_dropdown.setOnClickListener {
            rv_class.visibility = View.VISIBLE
        }

        rl_subject_dropdown.setOnClickListener {
            rv_subject.visibility = View.VISIBLE
        }

        ll_submit.setOnClickListener {
            val first_name = et_first_name.text.toString()
            val last_name = et_last_name.text.toString()
            val dob = et_date_of_birth.text.toString()
            val class_category = tv_class_category.text.toString()
            val subject = tv_subject_category.text.toString()
            val phone = et_phone.text.toString()
            val p_firstName = et_parent_first_name.text.toString()
            val p_lastName = et_parent_last_name.text.toString()
            val p_phone = et_parent_phone.text.toString()
            var selected_gender = rg_gender.checkedRadioButtonId.toString()
            val password = et_password.text.toString()
            val re_password = et_re_password.text.toString()

            if (selected_gender == "rb_male"){
                gender = "male"
            }
            else if (selected_gender == "rb_female"){
                gender = "female"
            }

            if (validation(first_name,last_name,dob,class_category,subject,phone,p_firstName,p_lastName,p_phone,gender,password,re_password)){

            }
        }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { view, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "$selectedYear-${selectedMonth + 1}-$selectedDay"
                et_date_of_birth.setText(selectedDate)
            },
            year, month, day
        )
        datePickerDialog.show()
    }

    private fun validation(
        firstName: String,
        lastName: String,
        dob: String,
        classCategory: String,
        subject: String,
        phone: String,
        pFirstname: String,
        pLastname: String,
        pPhone: String,
        gender: String,
        password: String,
        re_password: String
    ):Boolean {
        val nameRegex = Regex("^[A-Za-z ]+\$")
        val mobileRegex = Regex("^[0-9]{10}\$")
        val genderRegex = Regex("^(male|female)\$", RegexOption.IGNORE_CASE)
        val dateOfBirthRegex = Regex("^\\d{4}-\\d{2}-\\d{2}\$")
        val passwordRegex = Regex("^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[@#$%^&!])[A-Za-z\\d@#$%^&!]{8,}\$")

        val isFirstNameValid = nameRegex.matches(firstName)
        val isLastNameValid = nameRegex.matches(lastName)
        val isclassCategoryValid = nameRegex.matches(classCategory)
        val isSubjectValid = nameRegex.matches(subject)
        val ispFirstnameValid = nameRegex.matches(pFirstname)
        val ispLastnameValid = nameRegex.matches(pLastname)
        val isMobileNumberValid = mobileRegex.matches(phone)
        val ispPhoneValid = mobileRegex.matches(pPhone)
        val isGenderValid = genderRegex.matches(gender)
        val isDateOfBirthValid = dateOfBirthRegex.matches(dob)
        val isPasswordValid = passwordRegex.matches(password)

        if (firstName == "" || firstName == null){
            Toast.makeText(this, "Enter First Name", Toast.LENGTH_SHORT).show()
        }else if (!isFirstNameValid) {
            Toast.makeText(this, "Invalid First Name", Toast.LENGTH_SHORT).show()
        }else if (lastName == "" || lastName == null){
            Toast.makeText(this, "Enter Last Name", Toast.LENGTH_SHORT).show()
        }else if (!isLastNameValid) {
            Toast.makeText(this, "Invalid Last Name", Toast.LENGTH_SHORT).show()
        }else if (dob == "" || dob == null){
            Toast.makeText(this, "Enter Date Of Birth", Toast.LENGTH_SHORT).show()
        }else if (!isDateOfBirthValid) {
            Toast.makeText(this, "Invalid Date Of Birth", Toast.LENGTH_SHORT).show()
        }else if (classCategory == "" || classCategory == null){
            Toast.makeText(this, "Enter Date Of Birth", Toast.LENGTH_SHORT).show()
        }else if (!isclassCategoryValid) {
            Toast.makeText(this, "Invalid Date Of Birth", Toast.LENGTH_SHORT).show()
        } else if (selectedType == "teacher"){
            if (subject == "" || subject == null){
                Toast.makeText(this, "Enter Date Of Birth", Toast.LENGTH_SHORT).show()
            }else if (!isSubjectValid) {
                Toast.makeText(this, "Invalid Date Of Birth", Toast.LENGTH_SHORT).show()
            }
        }else if (phone == "" || phone == null){
            Toast.makeText(this, "Enter Date Of Birth", Toast.LENGTH_SHORT).show()
        }else if (!isMobileNumberValid) {
            Toast.makeText(this, "Invalid Date Of Birth", Toast.LENGTH_SHORT).show()
        }
        else  if (selectedType == "student") {
            if (pFirstname == "" || pFirstname == null){
                Toast.makeText(this, "Enter Date Of Birth", Toast.LENGTH_SHORT).show()
            }else if (!ispFirstnameValid) {
                Toast.makeText(this, "Invalid Date Of Birth", Toast.LENGTH_SHORT).show()
            }else if (pLastname == "" || pLastname == null){
                Toast.makeText(this, "Enter Date Of Birth", Toast.LENGTH_SHORT).show()
            }else if (!ispLastnameValid) {
                Toast.makeText(this, "Invalid Date Of Birth", Toast.LENGTH_SHORT).show()
            }else if (pPhone == "" || pPhone == null){
                Toast.makeText(this, "Enter Date Of Birth", Toast.LENGTH_SHORT).show()
            }else if (!ispPhoneValid) {
                Toast.makeText(this, "Invalid Date Of Birth", Toast.LENGTH_SHORT).show()
            }
        }else if (gender == "" || gender == null){
            Toast.makeText(this, "Enter Date Of Birth", Toast.LENGTH_SHORT).show()
        }else if (!isGenderValid) {
            Toast.makeText(this, "Invalid Date Of Birth", Toast.LENGTH_SHORT).show()
        }else if (password == "" || password == null){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show()
        }else if (!isPasswordValid){
            Toast.makeText(this, "Enter Strong Password", Toast.LENGTH_SHORT).show()
        }
        else if (re_password == "" || re_password == null){
            Toast.makeText(this, "Re-Enter Password", Toast.LENGTH_SHORT).show()
        }
        else if (password != re_password){
            Toast.makeText(this, "Password Does Not Match", Toast.LENGTH_SHORT).show()
        }
        return true
    }

}