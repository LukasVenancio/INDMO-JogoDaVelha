package br.senai.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import br.senai.jogodavelha.databinding.ActivityGameBinding
import java.lang.reflect.Array

class GameActivity : AppCompatActivity() {

    lateinit var binding: ActivityGameBinding
    var vezDeJogada = 1
    var jogadasPlayerOne = IntArray(10)
    var jogadasPlayerTwo = IntArray(10)

    lateinit var escolhaPlayerOne : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent : Intent = getIntent()

        val optionPlayerOne = intent.getStringExtra("optionPlayerOne").toString()
        val optionPlayerTwo = intent.getStringExtra("optionPlayerTwo").toString()

        escolhaPlayerOne = optionPlayerOne

        if (optionPlayerOne == "x"){
            binding.optionPlacarPlayerOne.setImageResource(R.drawable.x_placar)
            binding.optionPlacarPlayerTwo.setImageResource(R.drawable.o_placar)

        }else{
            binding.optionPlacarPlayerOne.setImageResource(R.drawable.o_placar)
            binding.optionPlacarPlayerTwo.setImageResource(R.drawable.x_placar)
        }

        binding.btn1.setOnClickListener {
            contarJogada(1)
            Jogar(binding.btn1, optionPlayerOne)
            determinarVencedor()
            definirPlacar(optionPlayerOne)
        }
        binding.btn2.setOnClickListener {
            contarJogada(2)
            Jogar(binding.btn2, optionPlayerOne)
            determinarVencedor()
            definirPlacar(optionPlayerOne)
        }
        binding.btn3.setOnClickListener {
            contarJogada(3)
            Jogar(binding.btn3, optionPlayerOne)
            determinarVencedor()
            definirPlacar(optionPlayerOne)
        }
        binding.btn4.setOnClickListener {
            contarJogada(4)
            Jogar(binding.btn4, optionPlayerOne)
            determinarVencedor()
            definirPlacar(optionPlayerOne)
        }
        binding.btn5.setOnClickListener {
            contarJogada(5)
            Jogar(binding.btn5, optionPlayerOne)
            determinarVencedor()
            definirPlacar(optionPlayerOne)
        }
        binding.btn6.setOnClickListener {
            contarJogada(6)
            Jogar(binding.btn6, optionPlayerOne)
            determinarVencedor()
            definirPlacar(optionPlayerOne)
        }
        binding.btn7.setOnClickListener {
            contarJogada(7)
            Jogar(binding.btn7, optionPlayerOne)
            determinarVencedor()
            definirPlacar(optionPlayerOne)
        }
        binding.btn8.setOnClickListener {
            contarJogada(8)
            Jogar(binding.btn8, optionPlayerOne)
            determinarVencedor()
            definirPlacar(optionPlayerOne)
        }
        binding.btn9.setOnClickListener {
            contarJogada(9)
            Jogar(binding.btn9, optionPlayerOne)
            determinarVencedor()
            definirPlacar(optionPlayerOne)
        }
    }

    private fun Jogar(button : ImageButton, optionPlayerOne : String){

        if(vezDeJogada == 1){

            //binding.debug.text = vezDeJogada.toString()
            if (optionPlayerOne == "x"){
                button.setImageResource(R.drawable.x)
                button.isEnabled = false
                vezDeJogada = 2
            }else{
                button.setImageResource(R.drawable.o)
                button.isEnabled = false
                vezDeJogada = 2
            }

        }else if(vezDeJogada == 2){

            //binding.debug.text = vezDeJogada.toString()
            if (optionPlayerOne == "x"){
                button.setImageResource(R.drawable.o)
                button.isEnabled = false
                vezDeJogada = 1

            }else{
                button.setImageResource(R.drawable.x)
                button.isEnabled = false
                vezDeJogada = 1
            }
        }
    }

    private fun contarJogada(idButton : Int){

        if (vezDeJogada == 1){
            jogadasPlayerOne[idButton] = idButton

        }else if(vezDeJogada == 2){

            jogadasPlayerTwo[idButton] = idButton

        }
    }

    private fun definirPlacar (optionPlayerOne: String){

        if (vezDeJogada == 2){

            if(optionPlayerOne == "x"){
                binding.optionPlacarPlayerTwo.background = getDrawable(R.drawable.botao)
                binding.optionPlacarPlayerOne.background = getDrawable(R.drawable.botao_null)

            }else{
                binding.optionPlacarPlayerTwo.background = getDrawable(R.drawable.botao)
                binding.optionPlacarPlayerOne.background = getDrawable(R.drawable.botao_null)
            }

        }else{
            if (optionPlayerOne == "o"){
                binding.optionPlacarPlayerOne.background = getDrawable(R.drawable.botao)
                binding.optionPlacarPlayerTwo.background = getDrawable(R.drawable.botao_null)

            }else{
                binding.optionPlacarPlayerOne.background = getDrawable(R.drawable.botao)
                binding.optionPlacarPlayerTwo.background = getDrawable(R.drawable.botao_null)
            }
        }
    }

    private fun desabilitarButtons(){
        binding.btn1.isEnabled = false
        binding.btn2.isEnabled = false
        binding.btn3.isEnabled = false
        binding.btn4.isEnabled = false
        binding.btn5.isEnabled = false
        binding.btn6.isEnabled = false
        binding.btn7.isEnabled = false
        binding.btn8.isEnabled = false
        binding.btn9.isEnabled = false
    }

    private fun marcarButtons(btn1 : ImageButton, btn2 : ImageButton, btn3 : ImageButton){
        btn1.background = getDrawable(R.drawable.botao)
        btn2.background = getDrawable(R.drawable.botao)
        btn3.background = getDrawable(R.drawable.botao)
    }

    private fun determinarVencedor(){

            if (jogadasPlayerOne[3].equals(3) && jogadasPlayerOne[2].equals(2) && jogadasPlayerOne[1].equals(1)){
                marcarButtons(binding.btn1, binding.btn2, binding.btn3)
                binding.debug.text = "Player 1 wins!!"
                desabilitarButtons()

            }else if (jogadasPlayerOne[1].equals(1) && jogadasPlayerOne[4].equals(4) && jogadasPlayerOne[7].equals(7)){
                marcarButtons(binding.btn1, binding.btn4, binding.btn7)
                desabilitarButtons()
                binding.debug.text = "Player 1 wins!!"

            }else if (jogadasPlayerOne[2].equals(2) && jogadasPlayerOne[5].equals(5) && jogadasPlayerOne[8].equals(8)){
                marcarButtons(binding.btn2, binding.btn5, binding.btn8)
                desabilitarButtons()
                binding.debug.text = "Player 1 wins!!"

            }else if (jogadasPlayerOne[3].equals(3) && jogadasPlayerOne[6].equals(6) && jogadasPlayerOne[9].equals(9)){
                marcarButtons(binding.btn3, binding.btn6, binding.btn9)
                desabilitarButtons()
                binding.debug.text = "Player 1 wins!!"

            }else if (jogadasPlayerOne[4].equals(4) && jogadasPlayerOne[5].equals(5) && jogadasPlayerOne[6].equals(6)){
                marcarButtons(binding.btn4, binding.btn5, binding.btn6)
                desabilitarButtons()
                binding.debug.text = "Player 1 wins!!"

            }else if (jogadasPlayerOne[7].equals(7) && jogadasPlayerOne[8].equals(8) && jogadasPlayerOne[9].equals(9)){
                marcarButtons(binding.btn7, binding.btn8, binding.btn9)
                desabilitarButtons()
                binding.debug.text = "Player 1 wins!!"

            }else if (jogadasPlayerOne[5].equals(5) && jogadasPlayerOne[9].equals(9) && jogadasPlayerOne[1].equals(1)){
                marcarButtons(binding.btn1, binding.btn5, binding.btn9)
                desabilitarButtons()
                binding.debug.text = "Player 1 wins!!"

            }else if (jogadasPlayerOne[3].equals(3) && jogadasPlayerOne[7].equals(7) && jogadasPlayerOne[5].equals(5)){
                marcarButtons(binding.btn7, binding.btn5, binding.btn3)
                desabilitarButtons()
                binding.debug.text = "Player 1 wins!!"

            }else if (jogadasPlayerTwo[3].equals(3) && jogadasPlayerTwo[2].equals(2) && jogadasPlayerTwo[1].equals(1)){
                marcarButtons(binding.btn1, binding.btn2, binding.btn3)
                desabilitarButtons()
                binding.debug.text = "Player 2 wins!!"

            }else if (jogadasPlayerTwo[1].equals(1) && jogadasPlayerTwo[4].equals(4) && jogadasPlayerTwo[7].equals(7)){
                marcarButtons(binding.btn1, binding.btn4, binding.btn7)
                desabilitarButtons()
                binding.debug.text = "Player 2 wins!!"

            }else if (jogadasPlayerTwo[2].equals(2) && jogadasPlayerTwo[5].equals(5) && jogadasPlayerTwo[8].equals(8)){
                marcarButtons(binding.btn5, binding.btn2, binding.btn8)
                desabilitarButtons()
                binding.debug.text = "Player 2 wins!!"

            }else if (jogadasPlayerTwo[3].equals(3) && jogadasPlayerTwo[6].equals(6) && jogadasPlayerTwo[9].equals(9)){
                marcarButtons(binding.btn6, binding.btn9, binding.btn3)
                desabilitarButtons()
                binding.debug.text = "Player 2 wins!!"

            }else if (jogadasPlayerTwo[4].equals(4) && jogadasPlayerTwo[5].equals(5) && jogadasPlayerTwo[6].equals(6)){
                marcarButtons(binding.btn5, binding.btn4, binding.btn6)
                desabilitarButtons()
                binding.debug.text = "Player 2 wins!!"

            }else if (jogadasPlayerTwo[7].equals(7) && jogadasPlayerTwo[8].equals(8) && jogadasPlayerTwo[9].equals(9)){
                marcarButtons(binding.btn7, binding.btn8, binding.btn9)
                desabilitarButtons()
                binding.debug.text = "Player 2 wins!!"

            }else if (jogadasPlayerTwo[5].equals(5) && jogadasPlayerTwo[9].equals(9) && jogadasPlayerTwo[1].equals(1)){
                marcarButtons(binding.btn5, binding.btn9, binding.btn3)
                desabilitarButtons()
                binding.debug.text = "Player 2 wins!!"

            }else if (jogadasPlayerTwo[3].equals(3) && jogadasPlayerTwo[7].equals(7) && jogadasPlayerTwo[5].equals(5)){
                marcarButtons(binding.btn5, binding.btn7, binding.btn3)
                desabilitarButtons()
                binding.debug.text = "Player 2 wins!!"
            }
    }
}