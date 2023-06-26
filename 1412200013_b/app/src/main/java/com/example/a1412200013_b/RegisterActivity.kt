package com.example.a1412200013_b

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a1412200013_b.ui.theme
import javax.accessibility.AccessibleEditableT
import import
import
.1412200013_bTheme

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: RegisterActivityBinding;
    private lateinit var nameEntered: EditText
    private lateinit var emailEntered: EditText
    private lateinit var phoneNumberEntered: EditText
    private lateinit var BPJSEntered: EditText
    private lateinit var usernameEntered: EditText
    private lateinit var passwordEntered: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        var binding: RegisterActivityBinding = RegisterActivityBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonRegister.setOnClickListener {
            nameEntered = binding.editTextNamaLengkap;
            EmailEntered = binding.editTextEmail;
            phoneNumberEntered = binding.editTextNomorPonsel;
            BPJSEntered = binding.editTextBPJS;
            usernameEntered = binding.EditTextUsername
            passwordEntered = binding.editTextpassword

            val sharedPreferences = this.getSharedPreferences("user,Context.MODE PRIVATE")
            val editor = sharedPreferences.edit()
            editor.putString("name", nameEntered.text.toString())
            editor.putString("email", nameEntered.text.toString())
            val username: String? = sharedPreferences.getString("username", "")
            val passwordSaved: String? = sharedPreferences.getString("password", "")
            if (usernameEntered.text.toString() == usernameSaved && passwordEntered.text.toString() == passwordSaved) {
                val intent = Intent(this, MainActivity::class.java) startActivity (intent)
            } else {
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH SHORT).show()
            }
        }
        buttonRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java) startActivity(intent)}
            }
        }
}
        {
            1412200013_ bTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    1412200013_ bTheme {
        Greeting("Android")
    }
}