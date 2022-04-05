package br.senai.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.jogodavelha.databinding.ActivitySettingsMachineBinding

class SettingsMachineActivity : AppCompatActivity() {

    lateinit var binding: ActivitySettingsMachineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsMachineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, GameMachineActivity::class.java)

        binding.btnEasy.setOnClickListener{
            binding.btnEasy.background = getDrawable(R.drawable.botao)
            binding.btnMedium.background = getDrawable(R.drawable.botao_sem_preenchimento)
            binding.btnHard.background = getDrawable(R.drawable.botao_sem_preenchimento)
            intent.putExtra("difficultyOption", "easy")
        }

        binding.btnMedium.setOnClickListener{
            binding.btnMedium.background = getDrawable(R.drawable.botao)
            binding.btnEasy.background = getDrawable(R.drawable.botao_sem_preenchimento)
            binding.btnHard.background = getDrawable(R.drawable.botao_sem_preenchimento)
            intent.putExtra("difficultyOption", "medium")
        }

        binding.btnHard.setOnClickListener{
            binding.btnHard.background = getDrawable(R.drawable.botao)
            binding.btnMedium.background = getDrawable(R.drawable.botao_sem_preenchimento)
            binding.btnEasy.background = getDrawable(R.drawable.botao_sem_preenchimento)
            intent.putExtra("difficultyOption", "hard")
        }

        binding.playerIconX.setOnClickListener {
            binding.playerIconX.background = getDrawable(R.drawable.botao)
            binding.playerIconO.background = getDrawable(R.drawable.botao_sem_preenchimento)
            intent.putExtra("iconOption", "x")
            startActivity(intent)
        }

        binding.playerIconO.setOnClickListener {
            binding.playerIconO.background = getDrawable(R.drawable.botao)
            binding.playerIconX.background = getDrawable(R.drawable.botao_sem_preenchimento)
            intent.putExtra("iconOption", "o")
            startActivity(intent)
        }




    }
}