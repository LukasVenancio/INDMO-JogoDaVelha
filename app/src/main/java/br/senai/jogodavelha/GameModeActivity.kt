package br.senai.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.jogodavelha.databinding.ActivityGameModeBinding

class GameModeActivity : AppCompatActivity() {

    lateinit var binding: ActivityGameModeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameModeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.player.setOnClickListener(){

            binding.machine.background = getDrawable(R.drawable.botao_sem_preenchimento)

            val intent = Intent(this, SelectIconActivity::class.java)
            startActivity(intent)

        }

        binding.machine.setOnClickListener(){

        }
    }
}