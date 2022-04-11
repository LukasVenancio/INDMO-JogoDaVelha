package br.senai.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import br.senai.jogodavelha.databinding.ActivityGameMachineBinding
import kotlin.random.Random

class GameMachineActivity : AppCompatActivity() {

    lateinit var binding: ActivityGameMachineBinding
    var vezDeJogada = 1
    var jogadasPlayer = IntArray(10)
    var jogadasMachine = IntArray(10)
    var machineOption = ""

    lateinit var escolhaPlayerOne : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameMachineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent : Intent = getIntent()

        val playerOption = intent.getStringExtra("iconOption").toString()
        val difficultyOption = intent.getStringExtra("difficultyOption").toString()

        if (playerOption == "x"){
            machineOption = "o"
        }else{
            machineOption = "x"
        }

        escolhaPlayerOne = playerOption

        if (playerOption == "x"){
            binding.optionPlacarPlayer.setImageResource(R.drawable.x_placar)
            binding.optionPlacarMachine.setImageResource(R.drawable.o_placar)

        }else{
            binding.optionPlacarPlayer.setImageResource(R.drawable.o_placar)
            binding.optionPlacarMachine.setImageResource(R.drawable.x_placar)
        }

        binding.btn1.setOnClickListener {
            contarJogada(1)
            Jogar(binding.btn1, playerOption)
            determinarVencedor()
            definirPlacar(playerOption)
        }
        binding.btn2.setOnClickListener {
            contarJogada(2)
            Jogar(binding.btn2, playerOption)
            determinarVencedor()
            definirPlacar(playerOption)
        }
        binding.btn3.setOnClickListener {
            contarJogada(3)
            Jogar(binding.btn3, playerOption)
            determinarVencedor()
            definirPlacar(playerOption)
        }
        binding.btn4.setOnClickListener {
            contarJogada(4)
            Jogar(binding.btn4, playerOption)
            determinarVencedor()
            definirPlacar(playerOption)
        }
        binding.btn5.setOnClickListener {
            contarJogada(5)
            Jogar(binding.btn5, playerOption)
            determinarVencedor()
            definirPlacar(playerOption)
        }
        binding.btn6.setOnClickListener {
            contarJogada(6)
            Jogar(binding.btn6, playerOption)
            determinarVencedor()
            definirPlacar(playerOption)
        }
        binding.btn7.setOnClickListener {
            contarJogada(7)
            Jogar(binding.btn7, playerOption)
            determinarVencedor()
            definirPlacar(playerOption)
        }
        binding.btn8.setOnClickListener {
            contarJogada(8)
            Jogar(binding.btn8, playerOption)
            determinarVencedor()
            definirPlacar(playerOption)
        }
        binding.btn9.setOnClickListener {
            contarJogada(9)
            Jogar(binding.btn9, playerOption)
            determinarVencedor()
            definirPlacar(playerOption)
        }
    }

    private fun easyGame(){

        var machineChoice = randomNumber()

        if (vezDeJogada == 2) {

            while (encontrarButtonJogado(machineChoice)){
                machineChoice = randomNumber()
            }
            contarJogada(machineChoice)
            playMachine(machineChoice)
        }

    }

    private fun playMachine(choice: Int){
        val button = findButton(choice)

        if (machineOption == "x"){
            button.setImageResource(R.drawable.x)
            button.isEnabled = false
            vezDeJogada = 1
        }else{
            button.setImageResource(R.drawable.o)
            button.isEnabled = false
            vezDeJogada = 1
        }
    }

    private fun findButton(choice: Int):ImageButton{
        var button = binding.btn1

        if (choice == 1){
            button = binding.btn1
        }else if(choice == 2){
            button = binding.btn2
        }else if(choice == 3){
            button = binding.btn3
        }else if(choice == 4){
            button = binding.btn4
        }else if(choice == 5){
            button = binding.btn5
        }else if(choice == 6){
            button = binding.btn6
        }else if(choice == 7){
            button = binding.btn7
        }else if(choice == 8){
            button = binding.btn8
        }else if(choice == 9){
            button = binding.btn9
        }

        return button
    }

    private fun encontrarButtonJogado(choice : Int): Boolean{
        var index = 0

        var response = false

        while (index < 10){
            if (jogadasPlayer[index] == choice || jogadasMachine[index] == choice){
                response = true
            }
            index++
        }
        return response
    }


    private fun randomNumber():Int{
        val random = Random.nextInt(1, 9)

        return random
    }
    private fun Jogar(button : ImageButton, optionPlayerOne : String){

        if(vezDeJogada == 1){
            if (optionPlayerOne == "x"){
                button.setImageResource(R.drawable.x)
                button.isEnabled = false
                vezDeJogada = 2
                easyGame()
            }else{
                button.setImageResource(R.drawable.o)
                button.isEnabled = false
                vezDeJogada = 2
                easyGame()
            }
        }

    }

    private fun contarJogada(idButton : Int){

        if (vezDeJogada == 1){
            jogadasPlayer[idButton] = idButton

        }else if(vezDeJogada == 2){

            jogadasMachine[idButton] = idButton

        }
    }

    private fun definirPlacar (optionPlayerOne: String){

        if (vezDeJogada == 2){

            if(optionPlayerOne == "x"){
                binding.optionPlacarMachine.background = getDrawable(R.drawable.botao)
                binding.optionPlacarPlayer.background = getDrawable(R.drawable.botao_null)

            }else{
                binding.optionPlacarMachine.background = getDrawable(R.drawable.botao)
                binding.optionPlacarPlayer.background = getDrawable(R.drawable.botao_null)
            }

        }else{
            if (optionPlayerOne == "o"){
                binding.optionPlacarPlayer.background = getDrawable(R.drawable.botao)
                binding.optionPlacarMachine.background = getDrawable(R.drawable.botao_null)

            }else{
                binding.optionPlacarPlayer.background = getDrawable(R.drawable.botao)
                binding.optionPlacarMachine.background = getDrawable(R.drawable.botao_null)
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

        if (jogadasPlayer[3].equals(3) && jogadasPlayer[2].equals(2) && jogadasPlayer[1].equals(1)){
            marcarButtons(binding.btn1, binding.btn2, binding.btn3)
            binding.debug.text = "Player wins!!"
            desabilitarButtons()
            vezDeJogada = 0

        }else if (jogadasPlayer[1].equals(1) && jogadasPlayer[4].equals(4) && jogadasPlayer[7].equals(7)){
            marcarButtons(binding.btn1, binding.btn4, binding.btn7)
            desabilitarButtons()
            binding.debug.text = "Player wins!!"
            vezDeJogada = 0

        }else if (jogadasPlayer[2].equals(2) && jogadasPlayer[5].equals(5) && jogadasPlayer[8].equals(8)){
            marcarButtons(binding.btn2, binding.btn5, binding.btn8)
            desabilitarButtons()
            binding.debug.text = "Player wins!!"
            vezDeJogada = 0

        }else if (jogadasPlayer[3].equals(3) && jogadasPlayer[6].equals(6) && jogadasPlayer[9].equals(9)){
            marcarButtons(binding.btn3, binding.btn6, binding.btn9)
            desabilitarButtons()
            binding.debug.text = "Player wins!!"
            vezDeJogada = 0

        }else if (jogadasPlayer[4].equals(4) && jogadasPlayer[5].equals(5) && jogadasPlayer[6].equals(6)){
            marcarButtons(binding.btn4, binding.btn5, binding.btn6)
            desabilitarButtons()
            binding.debug.text = "Player wins!!"
            vezDeJogada = 0

        }else if (jogadasPlayer[7].equals(7) && jogadasPlayer[8].equals(8) && jogadasPlayer[9].equals(9)){
            marcarButtons(binding.btn7, binding.btn8, binding.btn9)
            desabilitarButtons()
            binding.debug.text = "Player wins!!"
            vezDeJogada = 0

        }else if (jogadasPlayer[5].equals(5) && jogadasPlayer[9].equals(9) && jogadasPlayer[1].equals(1)){
            marcarButtons(binding.btn1, binding.btn5, binding.btn9)
            desabilitarButtons()
            binding.debug.text = "Player wins!!"
            vezDeJogada = 0

        }else if (jogadasPlayer[3].equals(3) && jogadasPlayer[7].equals(7) && jogadasPlayer[5].equals(5)){
            marcarButtons(binding.btn7, binding.btn5, binding.btn3)
            desabilitarButtons()
            binding.debug.text = "Player wins!!"
            vezDeJogada = 0

        }else if (jogadasMachine[3].equals(3) && jogadasMachine[2].equals(2) && jogadasMachine[1].equals(1)){
            marcarButtons(binding.btn1, binding.btn2, binding.btn3)
            desabilitarButtons()
            binding.debug.text = "Machine wins!!"
            vezDeJogada = 0

        }else if (jogadasMachine[1].equals(1) && jogadasMachine[4].equals(4) && jogadasMachine[7].equals(7)){
            marcarButtons(binding.btn1, binding.btn4, binding.btn7)
            desabilitarButtons()
            binding.debug.text = "Machine wins!!"
            vezDeJogada = 0

        }else if (jogadasMachine[2].equals(2) && jogadasMachine[5].equals(5) && jogadasMachine[8].equals(8)){
            marcarButtons(binding.btn5, binding.btn2, binding.btn8)
            desabilitarButtons()
            binding.debug.text = "Machine wins!!"
            vezDeJogada = 0

        }else if (jogadasMachine[3].equals(3) && jogadasMachine[6].equals(6) && jogadasMachine[9].equals(9)){
            marcarButtons(binding.btn6, binding.btn9, binding.btn3)
            desabilitarButtons()
            binding.debug.text = "Machine wins!!"
            vezDeJogada = 0

        }else if (jogadasMachine[4].equals(4) && jogadasMachine[5].equals(5) && jogadasMachine[6].equals(6)){
            marcarButtons(binding.btn5, binding.btn4, binding.btn6)
            desabilitarButtons()
            binding.debug.text = "Machine wins!!"
            vezDeJogada = 0

        }else if (jogadasMachine[7].equals(7) && jogadasMachine[8].equals(8) && jogadasMachine[9].equals(9)){
            marcarButtons(binding.btn7, binding.btn8, binding.btn9)
            desabilitarButtons()
            binding.debug.text = "Machine wins!!"
            vezDeJogada = 0

        }else if (jogadasMachine[5].equals(5) && jogadasMachine[9].equals(9) && jogadasMachine[1].equals(1)){
            marcarButtons(binding.btn5, binding.btn9, binding.btn3)
            desabilitarButtons()
            binding.debug.text = "Machine wins!!"
            vezDeJogada = 0

        }else if (jogadasMachine[3].equals(3) && jogadasMachine[7].equals(7) && jogadasMachine[5].equals(5)){
            marcarButtons(binding.btn5, binding.btn7, binding.btn3)
            desabilitarButtons()
            binding.debug.text = "Machine wins!!"
            vezDeJogada = 0
        }
    }
}