package com.example.meuappnovo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtNumero: EditText
    private lateinit var edtSenha: EditText
    private lateinit var edtConfirmarSenha: EditText
    private lateinit var btnCadastrar: Button
    private lateinit var btnIrLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        // Inicializar os componentes
        edtEmail = findViewById(R.id.edtEmail)
        edtNumero = findViewById(R.id.edtNumero)
        edtSenha = findViewById(R.id.edtSenha)
        edtConfirmarSenha = findViewById(R.id.edtConfirmarSenha)
        btnCadastrar = findViewById(R.id.btnCadastrar)
        btnIrLogin = findViewById(R.id.btnIrLogin)

        // Botão Cadastrar
        btnCadastrar.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val numero = edtNumero.text.toString().trim()
            val senha = edtSenha.text.toString().trim()
            val confirmarSenha = edtConfirmarSenha.text.toString().trim()

            // Validações
            if (email.isEmpty()) {
                edtEmail.error = "Digite seu e-mail"
                return@setOnClickListener
            }

            if (numero.isEmpty()) {
                edtNumero.error = "Digite seu número de telefone"
                return@setOnClickListener
            }

            if (senha.isEmpty()) {
                edtSenha.error = "Digite sua senha"
                return@setOnClickListener
            }

            if (confirmarSenha.isEmpty()) {
                edtConfirmarSenha.error = "Confirme sua senha"
                return@setOnClickListener
            }

            if (senha != confirmarSenha) {
                Toast.makeText(this, "As senhas não coincidem!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (senha.length < 6) {
                Toast.makeText(this, "A senha deve ter pelo menos 6 caracteres", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Aqui você pode adicionar lógica de cadastro (salvar no banco, API, etc)
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show()

            // Voltar para tela de login
            btnIrLogin.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        // Ir para tela de login
        btnIrLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
    }
}