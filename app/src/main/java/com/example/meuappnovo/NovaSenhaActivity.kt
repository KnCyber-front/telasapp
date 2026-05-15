package com.example.meuappnovo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class NovaSenhaActivity : AppCompatActivity() {

    private lateinit var etNovaSenha: EditText
    private lateinit var etConfirmarSenha: EditText
    private lateinit var btnSalvarNovaSenha: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nova_senha)

        inicializarComponentes()
        configurarBotao()
    }

    private fun inicializarComponentes() {
        etNovaSenha = findViewById(R.id.etNovaSenha)
        etConfirmarSenha = findViewById(R.id.etConfirmarSenha)
        btnSalvarNovaSenha = findViewById(R.id.btnSalvarNovaSenha)
    }

    private fun configurarBotao() {
        btnSalvarNovaSenha.setOnClickListener {
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

            // TODO: Aqui você atualiza a senha no Firebase ou no seu banco
            Toast.makeText(this, "Senha alterada com sucesso!", Toast.LENGTH_SHORT).show()

            // Voltar para tela de Login ou tela principal
            finishAffinity() // Fecha todas as telas e volta para o início
        }
    }
}