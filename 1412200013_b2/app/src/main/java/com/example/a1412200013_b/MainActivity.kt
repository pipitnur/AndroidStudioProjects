package com.example.a1412200013_b

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
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

.1412200013_bTheme

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding;
    private lateinit var nameEntered: EditText
    private lateinit var emailEntered: EditText
    private lateinit var phoneNumberEntered: EditText
    private lateinit var BPJSEntered: EditText
    private lateinit var usernameEntered: EditText
    private lateinit var passwordEntered: EditText
    private lateinit var alertImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        var isAppNeedUpdated = false;

        var binding: MainActivityBinding = MainActivityBinding.inflate(layoutInflater)

        nameEntered = binding.editTextNamaLengkap;
        emailEntered = binding.editTextEmail;
        phoneNumberEntered = binding.editTextNomorPonsel;
        BPJSEntered = binding.editTextBPJS;
        usernameEntered = binding.editTextUsername
        passwordEntered = binding.editTextPassword
        alertImage = binding.alert

        val sharedPreferences = this.getSharedPreferences("user", MODE_PRIVATE)


        nameEntered.setText(sharedPreferences.getString("name", ""))
        emailEntered.setText(sharedPreferences.getString("email", ""))
        phoneNumberEntered.setText(sharedPreferences.getString("phone", ""))
        BPJSEntered.setText(sharedPreferences.getString("bpjs", ""))
        usernameEntered.setText(sharedPreferences.getString("username", ""))
        passwordEntered.setText(sharedPreferences.getString("password", ""))



        val remoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 10 // Waktu minimum antara dua pengambilan konfigurasi (dalam detik)
        }
        remoteConfig.setConfigSettingsAsync(configSettings)

        remoteConfig.fetchAndActivate()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val updated = task.result
                    Log.d("MASUK","Config params updated: $updated")
                } else {
                    Log.e("Error", "Fetching config params failed")
                }
                // Lanjutkan menggunakan konfigurasi yang diambil
                val isUpdate = remoteConfig.getBoolean("is_update");

                if(isUpdate){
                    val update_on = R.drawable.update_on
                    alertImage.setImageResource(update_on)
                    isAppNeedUpdated = true;
                }else{
                    isAppNeedUpdated = false;
                }
            }

        alertImage.setOnClickListener {
            // Membuat dialog builder
            val builder = AlertDialog.Builder(this)

            // Mengatur judul dialog
            builder.setTitle("Info Update")

            // Mengatur pesan dialog
            if(isAppNeedUpdated){
                builder.setMessage("Selamat sekarang update tersedia!!")
            }else{
                builder.setMessage("Maaf sekarang belum ada update tersedia")
            }

            // Membuat instance dialog dari builder
            val dialog: AlertDialog = builder.create()

            // Menampilkan dialog
            dialog.show()

        }

        setContentView(binding.root);

    }
}