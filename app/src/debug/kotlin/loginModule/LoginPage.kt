package loginModule

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.eduhub.R
import loginModule.registrationModule.RegistrationPage

class LoginPage : AppCompatActivity() {

    lateinit var tv_title: TextView
    lateinit var imageView2: ImageView
    lateinit var et_id: EditText
    lateinit var et_password: EditText
    lateinit var ll_login: LinearLayout
    lateinit var ll_register: LinearLayout
    lateinit var dialog: Dialog
    lateinit var selected_Role: String
    lateinit var user_code: String

    var id: String = ""
    var password: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        initView()
        }

    private fun initView() {
        tv_title = findViewById(R.id.tv_title)
        imageView2 = findViewById(R.id.imageView2)
        et_id = findViewById(R.id.et_id)
        et_password = findViewById(R.id.et_password)
        ll_login = findViewById(R.id.ll_login)
        ll_register = findViewById(R.id.ll_register)

        user_code = ""
        selected_Role = ""
        id = et_id.text.toString()
        password = et_password.text.toString()

        ll_login.setOnClickListener{

                }

        ll_register.setOnClickListener{

            dialog = Dialog(this)
            dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog!!.setContentView(R.layout.role_dialog_layout)
            dialog!!.window!!.decorView.setBackgroundResource(android.R.color.transparent)
            val params: ViewGroup.LayoutParams =
                dialog!!.window!!.attributes
            params.width = ViewGroup.LayoutParams.MATCH_PARENT
            dialog!!.window!!.attributes = params as WindowManager.LayoutParams
            params.gravity = Gravity.BOTTOM;
            val tv_student = dialog.findViewById<TextView>(R.id.tv_student)
            val tv_teacher = dialog.findViewById<TextView>(R.id.tv_teacher)
            val tv_other = dialog.findViewById<TextView>(R.id.tv_other)
            val et_code = dialog.findViewById<EditText>(R.id.et_code)
            val ll_enter = dialog.findViewById<LinearLayout>(R.id.ll_enter)

            tv_student.setOnClickListener {
                tv_student.setBackgroundResource(R.drawable.edit_text_bg_selected)
                tv_teacher.setBackgroundResource(R.drawable.edit_text_bg)
                tv_other.setBackgroundResource(R.drawable.edit_text_bg)
                selected_Role = "student"
            }

            tv_teacher.setOnClickListener {
                tv_student.setBackgroundResource(R.drawable.edit_text_bg)
                tv_teacher.setBackgroundResource(R.drawable.edit_text_bg_selected)
                tv_other.setBackgroundResource(R.drawable.edit_text_bg)
                selected_Role = "teacher"
            }

            tv_other.setOnClickListener {
                tv_student.setBackgroundResource(R.drawable.edit_text_bg)
                tv_teacher.setBackgroundResource(R.drawable.edit_text_bg)
                tv_other.setBackgroundResource(R.drawable.edit_text_bg_selected)
                selected_Role = "other"
            }

            ll_enter.setOnClickListener {
                user_code = et_code.text.toString()
                if (selected_Role != ""){
                    if (user_code != ""){
                        if (selected_Role == "student"){
                            if (user_code == "1234"){
                                val intent = Intent(this@LoginPage, RegistrationPage::class.java)
                                intent.putExtra("selected_role",selected_Role)
                                startActivity(intent)
                                dialog.dismiss()
                            }
                            else{
                                Toast.makeText(this, "Invalid Code!", Toast.LENGTH_SHORT).show()
                            }
                        }
                        else if (selected_Role == "teacher"){
                            if (user_code == "1234"){
                                val intent = Intent(this@LoginPage, RegistrationPage::class.java)
                                intent.putExtra("selected_role",selected_Role)
                                startActivity(intent)
                                dialog.dismiss()
                            }
                            else{
                                Toast.makeText(this, "Invalid Code!", Toast.LENGTH_SHORT).show()
                            }
                        }
                        else if (selected_Role == "other"){
                            if (user_code == "1234"){
                                val intent = Intent(this@LoginPage, RegistrationPage::class.java)
                                intent.putExtra("selected_role",selected_Role)
                                startActivity(intent)
                            }
                            else{
                                Toast.makeText(this, "Invalid Code!", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    else{
                        Toast.makeText(this, "Please Enter Code", Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(this, "Please Select Category", Toast.LENGTH_SHORT).show()
                }
            }
            dialog.show()
            }
        }
    }