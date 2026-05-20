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

    private lateinit var edtTelefone: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtSenha: EditText
    private lateinit var btnEntrar: Button
    private lateinit var tvEsqueciSenha: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        inicializarComponentes()
        configurarListeners()
    }

    private fun inicializarComponentes() {
        edtTelefone = findViewById(R.id.etTelefone)
        edtEmail = findViewById(R.id.etEmail)
        edtSenha = findViewById(R.id.etSenha)
        btnEntrar = findViewById(R.id.btnEntrar)
        tvEsqueciSenha = findViewById(R.id.tvEsqueciSenha)
    }

    private fun configurarListeners() {
        // Botão Entrar
        btnEntrar.setOnClickListener {
            realizarLogin()
        }

        // Link "Esqueci senha"
        tvEsqueciSenha.setOnClickListener {
            irParaRedefinirSenha()
        }
    }

    private fun realizarLogin() {
        val telefone = edtTelefone.text.toString().trim()
        val email = edtEmail.text.toString().trim()
        val senha = edtSenha.text.toString().trim()

        // Validações
        if (telefone.isEmpty() && email.isEmpty()) {
            edtTelefone.error = "Informe telefone ou e-mail"
            edtEmail.error = "Informe telefone ou e-mail"
            return
        }

        if (senha.isEmpty()) {
            edtSenha.error = "Digite sua senha"
            return
        }

        // TODO: Implementar autenticação real (Firebase, API, etc.)
        Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()

        // Exemplo: Navegar para tela principal
         startActivity(Intent(this, Menu::class.java))
        // finish()
    }

    private fun irParaRedefinirSenha() {
        startActivity(Intent(this, ForgotPasswordActivity::class.java))
    }
}