package com.example.meuappnovo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtSenha: EditText
    private lateinit var btnEntrar: Button
    private lateinit var btnIrRegistro: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        // Inicializar os componentes
        edtEmail = findViewById(R.id.edtEmail)
        edtSenha = findViewById(R.id.edtSenha)
        btnEntrar = findViewById(R.id.btnEntrar)
        btnIrRegistro = findViewById(R.id.btnIrRegistro)

        // Botão Entrar
        btnEntrar.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val senha = edtSenha.text.toString().trim()

            if (email.isEmpty()) {
                edtEmail.error = "Digite seu e-mail"
                return@setOnClickListener
            }

            if (senha.isEmpty()) {
                edtSenha.error = "Digite sua senha"
                return@setOnClickListener
            }

            // Aqui você pode adicionar lógica de autenticação
            Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()

            // Voltar para tela principal ou abrir tela principal do app
            // finish() // Descomente se quiser fechar a tela de login
        }

        // Ir para tela de registro
        btnIrRegistro.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}