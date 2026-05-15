package com.example.meuappnovo

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var btnVerificar: Button
    private lateinit var tvReenviar: TextView

    private val otpFields = mutableListOf<EditText>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forgot_password)

        inicializarComponentes()
        configurarOtpAutomatico()
        configurarBotoes()
    }

    private fun inicializarComponentes() {
        etEmail = findViewById(R.id.etEmail)
        btnVerificar = findViewById(R.id.btnVerificar)
        tvReenviar = findViewById(R.id.tvReenviar)

        otpFields.add(findViewById(R.id.otp1))
        otpFields.add(findViewById(R.id.otp2))
        otpFields.add(findViewById(R.id.otp3))
        otpFields.add(findViewById(R.id.otp4))
        otpFields.add(findViewById(R.id.otp5))
    }

    private fun configurarOtpAutomatico() {
        for (i in otpFields.indices) {
            otpFields[i].addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (s?.length == 1 && i < otpFields.size - 1) {
                        otpFields[i + 1].requestFocus()
                    }
                }

                override fun afterTextChanged(s: Editable?) {}
            })

            // Voltar com backspace
            otpFields[i].setOnKeyListener { _, keyCode, _ ->
                if (keyCode == android.view.KeyEvent.KEYCODE_DEL &&
                    otpFields[i].text.isEmpty() && i > 0) {
                    otpFields[i - 1].requestFocus()
                }
                false
            }
        }
    }

    private fun configurarBotoes() {
        // Botão Verificar Código
        btnVerificar.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val codigo = getCodigoOTP()

            if (email.isEmpty()) {
                etEmail.error = "Digite seu e-mail"
                return@setOnClickListener
            }

            if (codigo.length != 5) {
                Toast.makeText(this, "Por favor, preencha todos os 5 dígitos do código", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // TODO: Aqui você vai validar o código com Firebase ou sua API
            Toast.makeText(this, "Código verificado com sucesso!", Toast.LENGTH_SHORT).show()

            // Exemplo: Ir para tela de nova senha
            startActivity(Intent(this, NovaSenhaActivity::class.java))
        }

        // Reenviar Código
        tvReenviar.setOnClickListener {
            val email = etEmail.text.toString().trim()

            if (email.isEmpty()) {
                etEmail.error = "Digite seu e-mail primeiro"
                return@setOnClickListener
            }

            Toast.makeText(this, "Código reenviado para $email", Toast.LENGTH_SHORT).show()

            // TODO: Chamar função para reenviar o código por email
        }
    }

    private fun getCodigoOTP(): String {
        return otpFields.joinToString("") { it.text.toString() }
    }
}