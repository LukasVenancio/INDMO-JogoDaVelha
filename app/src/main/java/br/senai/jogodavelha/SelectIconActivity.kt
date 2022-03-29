package br.senai.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.jogodavelha.databinding.ActivitySelectIconBinding

class SelectIconActivity : AppCompatActivity() {

    lateinit var binding: ActivitySelectIconBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectIconBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playerOneX.setOnClickListener {
            binding.playerOneX.background = getDrawable(R.drawable.botao)
            binding.playerOneO.background = getDrawable(R.drawable.botao_sem_preenchimento)
            binding.playerTwoO.background = getDrawable(R.drawable.botao)
            binding.playerTwoX.background = getDrawable(R.drawable.botao_sem_preenchimento)

            val intent = Intent(this, GameActivity::class.java)

            intent.putExtra("optionPlayerOne", "x")
            intent.putExtra("optionPlayerTwo", "o")

            startActivity(intent)
        }

        binding.playerOneO.setOnClickListener {
            binding.playerOneO.background = getDrawable(R.drawable.botao)
            binding.playerOneX.background = getDrawable(R.drawable.botao_sem_preenchimento)
            binding.playerTwoX.background = getDrawable(R.drawable.botao)
            binding.playerTwoO.background = getDrawable(R.drawable.botao_sem_preenchimento)

            val intent = Intent(this, GameActivity::class.java)

            intent.putExtra("optionPlayerOne", "o")
            intent.putExtra("optionPlayerTwo", "x")

            startActivity(intent)
        }

        binding.playerTwoX.setOnClickListener {
            binding.playerTwoX.background = getDrawable(R.drawable.botao)
            binding.playerTwoO.background = getDrawable(R.drawable.botao_sem_preenchimento)
            binding.playerOneO.background = getDrawable(R.drawable.botao)
            binding.playerOneX.background = getDrawable(R.drawable.botao_sem_preenchimento)

            val intent = Intent(this, GameActivity::class.java)

            intent.putExtra("optionPlayerOne", "o")
            intent.putExtra("optionPlayerTwo", "x")

            startActivity(intent)
        }

        binding.playerTwoO.setOnClickListener {
            binding.playerTwoO.background = getDrawable(R.drawable.botao)
            binding.playerTwoX.background = getDrawable(R.drawable.botao_sem_preenchimento)
            binding.playerOneX.background = getDrawable(R.drawable.botao)
            binding.playerOneO.background = getDrawable(R.drawable.botao_sem_preenchimento)

            val intent = Intent(this, GameActivity::class.java)

            intent.putExtra("optionPlayerOne", "x")
            intent.putExtra("optionPlayerTwo", "o")

            startActivity(intent)
        }
    }
}