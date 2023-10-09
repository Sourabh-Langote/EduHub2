package loginModule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.eduhub.R
import com.example.eduhub.RegistrationPage

class LoginPage : AppCompatActivity() {

    lateinit var tv_title: TextView
    lateinit var imageView2: ImageView
    lateinit var et_id: EditText
    lateinit var et_password: EditText
    lateinit var ll_login: LinearLayout
    lateinit var ll_register: LinearLayout

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

        id = et_id.text.toString()
        password = et_password.text.toString()

        ll_login.setOnClickListener{

        }

        ll_register.setOnClickListener{
            val intent = Intent(this@LoginPage, RegistrationPage::class.java)
            startActivity(intent)
        }
    }
}