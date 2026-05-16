package com.example.meuappnovo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class Novasenha : AppCompatActivity() {   // ← Nome da classe igual ao arquivo

    private lateinit var etNovaSenha: TextInputEditText
    private lateinit var etConfirmarSenha: TextInputEditText
    private lateinit var btnSalvarSenha: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novasenha)

        inicializarComponentes()
        configurarBotao()
    }

    private fun inicializarComponentes() {
        etNovaSenha = findViewById(R.id.etNovaSenha)
        etConfirmarSenha = findViewById(R.id.etConfirmarSenha)
        btnSalvarSenha = findViewById(R.id.btnSalvarSenha)
    }

    private fun configurarBotao() {
        btnSalvarSenha.setOnClickListener {
            val novaSenha = etNovaSenha.text.toString().trim()
            val confirmarSenha = etConfirmarSenha.text.toString().trim()

            if (novaSenha.isEmpty()) {
                etNovaSenha.error = "Digite a nova senha"
                return@setOnClickListener
            }

            if (confirmarSenha.isEmpty()) {
                etConfirmarSenha.error = "Confirme a senha"
                return@setOnClickListener
            }

            if (novaSenha != confirmarSenha) {
                etConfirmarSenha.error = "As senhas não coincidem"
                return@setOnClickListener
            }

            if (novaSenha.length < 6) {
                etNovaSenha.error = "A senha deve ter no mínimo 6 caracteres"
                return@setOnClickListener
            }

            Toast.makeText(this, "Senha alterada com sucesso!", Toast.LENGTH_SHORT).show()

            // Volta para Login
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finishAffinity()
        }
    }
}