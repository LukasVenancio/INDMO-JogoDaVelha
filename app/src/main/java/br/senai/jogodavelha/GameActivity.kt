package br.senai.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import br.senai.jogodavelha.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    lateinit var binding: ActivityGameBinding
    var vezDeJogada = 1
    var jogadasPlayerOne = ""
    var jogadasPlayerTwo = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent : Intent = getIntent()

        val optionPlayerOne = intent.getStringExtra("optionPlayerOne").toString()
        val optionPlayerTwo = intent.getStringExtra("optionPlayerTwo").toString()

        if (optionPlayerOne == "x"){
            binding.optionPlacarPlayerOne.background = getDrawable(R.drawable.x)
            binding.optionPlacarPlayerTwo.background = getDrawable(R.drawable.o)

        }else{
            binding.optionPlacarPlayerOne.background = getDrawable(R.drawable.o)
            binding.optionPlacarPlayerTwo.background = getDrawable(R.drawable.x)
        }

        binding.btn1.setOnClickListener {
            Jogar(binding.btn1, optionPlayerOne)
            contarJogada("1")
        }
        binding.btn2.setOnClickListener {
            Jogar(binding.btn2, optionPlayerOne)
            contarJogada("2")
        }
        binding.btn3.setOnClickListener {
            Jogar(binding.btn3, optionPlayerOne)
            contarJogada("3")
            determinarVencedor()
        }
        binding.btn4.setOnClickListener {
            Jogar(binding.btn4, optionPlayerOne)
            contarJogada("4")
        }
        binding.btn5.setOnClickListener {
            Jogar(binding.btn5, optionPlayerOne)
            contarJogada("5")
        }
        binding.btn6.setOnClickListener {
            Jogar(binding.btn6, optionPlayerOne)
            contarJogada("6")
        }
        binding.btn7.setOnClickListener {
            Jogar(binding.btn7, optionPlayerOne)
            contarJogada("7")
        }
        binding.btn8.setOnClickListener {
            Jogar(binding.btn8, optionPlayerOne)
            contarJogada("8")
        }
        binding.btn9.setOnClickListener {
            Jogar(binding.btn9, optionPlayerOne)
            contarJogada("9")
        }
    }

    private fun Jogar(button : ImageButton, optionPlayerOne : String){

        if(vezDeJogada == 1){

            binding.debug.text = vezDeJogada.toString()
            if (optionPlayerOne == "x"){
                button.background = getDrawable(R.drawable.x)
                button.isEnabled = false
                vezDeJogada = 2
            }else{
                button.background = getDrawable(R.drawable.o)
                button.isEnabled = false
                vezDeJogada = 2
            }

        }else if(vezDeJogada == 2){

            binding.debug.text = vezDeJogada.toString()
            if (optionPlayerOne == "x"){
                button.background = getDrawable(R.drawable.o)
                button.isEnabled = false
                vezDeJogada = 1

            }else{
                button.background = getDrawable(R.drawable.x)
                button.isEnabled = false
                vezDeJogada = 1
            }

        }
    }

    private fun contarJogada(idButton : String){

        if (vezDeJogada == 2){
            jogadasPlayerOne += idButton
//            binding.debug.text = jogadasPlayerOne

        }else if(vezDeJogada == 1){

            jogadasPlayerTwo += idButton

        }
    }

    private fun determinarVencedor(){
        if (jogadasPlayerOne == "123"){
            finish()
        }else{

        }
    }
}