package com.mahmutalperenunal.okeypuantablosu.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import com.mahmutalperenunal.okeypuantablosu.R
import com.mahmutalperenunal.okeypuantablosu.activity.scoreboard.Scoreboard2Player
import com.mahmutalperenunal.okeypuantablosu.activity.scoreboard.Scoreboard3Player
import com.mahmutalperenunal.okeypuantablosu.activity.scoreboard.Scoreboard4Player
import com.mahmutalperenunal.okeypuantablosu.databinding.ActivityTeamOperationsBinding

class TeamOperations : AppCompatActivity() {

    private lateinit var binding: ActivityTeamOperationsBinding

    private var player1Name: EditText? = null
    private var player2Name: EditText? = null
    private var player3Name: EditText? = null
    private var player4Name: EditText? = null

    private var gameName: EditText? = null

    private var redValue: Int = 0
    private var blueValue: Int = 0
    private var yellowValue: Int = 0
    private var blackValue: Int = 0

    private var isColorsValueEntered: Boolean = false

    private var gameType: String = "Add Score"

    private var firstNumber: EditText? = null


    @SuppressLint("VisibleForTests", "SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamOperationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //set screen orientation to portrait
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        //set player names
        player1Name = binding.teamOperationsPlayer1NameEditText
        player2Name = binding.teamOperationsPlayer2NameEditText
        player3Name = binding.teamOperationsPlayer3NameEditText
        player4Name = binding.teamOperationsPlayer4NameEditText

        //set game name
        gameName = binding.teamOperationsGameNameEditText

        //set first number
        firstNumber = binding.teamOperationsNumberOfStartsEditText

        playerNumber()
        playerType()
        gameType()

        setPlayerNumberRadioButtonsClickable()
        setPlayerTypeRadioButtonsClickable()

        //navigate Scoreboard Activity with number of player
        binding.teamOperationsStartButton.setOnClickListener { controlUsernames() }


        //on back pressed turn back to main menu
        binding.teamOperationsBackButton.setOnClickListener {
            val intentMain = Intent(applicationContext, MainMenu::class.java)
            startActivity(intentMain)
            finish()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

    }


    //check usernames
    private fun controlUsernames() {

        if (playerNumber() == 2) {

            if (binding.teamOperationsPlayer1NameEditText.text!!.isEmpty()) {
                binding.teamOperationsPlayer1NameEditTextLayout.error =
                    getString(R.string.compulsory_text)
                Toast.makeText(
                    applicationContext,
                    R.string.enter_player_name_text,
                    Toast.LENGTH_SHORT
                ).show()
            } else if (binding.teamOperationsPlayer2NameEditText.text!!.isEmpty()) {
                binding.teamOperationsPlayer2NameEditTextLayout.error =
                    getString(R.string.compulsory_text)
                Toast.makeText(
                    applicationContext,
                    R.string.enter_player_name_text,
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (gameType == "Deduct from the number") {
                    if (firstNumber!!.text.toString() == "") {
                        binding.teamOperationsNumberOfStartsEditTextLayout.error =
                            getString(R.string.compulsory_text)
                        Toast.makeText(
                            applicationContext,
                            R.string.enter_player_name_text,
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        setColorValue()
                    }
                } else {
                    setColorValue()
                }
            }

        } else if (playerNumber() == 3) {

            if (binding.teamOperationsPlayer1NameEditText.text!!.isEmpty()) {
                binding.teamOperationsPlayer1NameEditTextLayout.error =
                    getString(R.string.compulsory_text)
                Toast.makeText(
                    applicationContext,
                    R.string.enter_player_name_text,
                    Toast.LENGTH_SHORT
                ).show()
            } else if (binding.teamOperationsPlayer2NameEditText.text!!.isEmpty()) {
                binding.teamOperationsPlayer2NameEditTextLayout.error =
                    getString(R.string.compulsory_text)
                Toast.makeText(
                    applicationContext,
                    R.string.enter_player_name_text,
                    Toast.LENGTH_SHORT
                ).show()
            } else if (binding.teamOperationsPlayer3NameEditText.text!!.isEmpty()) {
                binding.teamOperationsPlayer3NameEditTextLayout.error =
                    getString(R.string.compulsory_text)
                Toast.makeText(
                    applicationContext,
                    R.string.enter_player_name_text,
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (gameType == "Deduct from the number") {
                    if (firstNumber!!.text.toString() == "") {
                        binding.teamOperationsNumberOfStartsEditTextLayout.error =
                            getString(R.string.compulsory_text)
                        Toast.makeText(
                            applicationContext,
                            R.string.enter_player_name_text,
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        setColorValue()
                    }
                } else {
                    setColorValue()
                }
            }

        } else if (playerNumber() == 4) {

            if (binding.teamOperationsPlayer1NameEditText.text!!.isEmpty()) {
                binding.teamOperationsPlayer1NameEditTextLayout.error =
                    getString(R.string.compulsory_text)
                Toast.makeText(
                    applicationContext,
                    R.string.enter_player_name_text,
                    Toast.LENGTH_SHORT
                ).show()
            } else if (binding.teamOperationsPlayer2NameEditText.text!!.isEmpty()) {
                binding.teamOperationsPlayer2NameEditTextLayout.error =
                    getString(R.string.compulsory_text)
                Toast.makeText(
                    applicationContext,
                    R.string.enter_player_name_text,
                    Toast.LENGTH_SHORT
                ).show()
            } else if (binding.teamOperationsPlayer3NameEditText.text!!.isEmpty()) {
                binding.teamOperationsPlayer3NameEditTextLayout.error =
                    getString(R.string.compulsory_text)
                Toast.makeText(
                    applicationContext,
                    R.string.enter_player_name_text,
                    Toast.LENGTH_SHORT
                ).show()
            } else if (binding.teamOperationsPlayer4NameEditText.text!!.isEmpty()) {
                binding.teamOperationsPlayer4NameEditTextLayout.error =
                    getString(R.string.compulsory_text)
                Toast.makeText(
                    applicationContext,
                    R.string.enter_player_name_text,
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (gameType == "Deduct from the number") {
                    if (firstNumber!!.text.toString() == "") {
                        binding.teamOperationsNumberOfStartsEditTextLayout.error =
                            getString(R.string.compulsory_text)
                        Toast.makeText(
                            applicationContext,
                            R.string.enter_player_name_text,
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        setColorValue()
                    }
                } else {
                    setColorValue()
                }
            }

        }
    }


    //set colors value
    @SuppressLint("InflateParams")
    private fun setColorValue() {
        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.add_color_value, null)

        //set values
        val redEditText = view.findViewById<EditText>(R.id.addColorValue_red_editText)
        val blueEditText = view.findViewById<EditText>(R.id.addColorValue_blue_editText)
        val yellowEditText = view.findViewById<EditText>(R.id.addColorValue_yellow_editText)
        val blackEditText = view.findViewById<EditText>(R.id.addColorValue_black_editText)

        val redEditTextLayout =
            view.findViewById<TextInputLayout>(R.id.addColorValue_red_editTextLayout)
        val blueEditTextLayout =
            view.findViewById<TextInputLayout>(R.id.addColorValue_blue_editTextLayout)
        val yellowEditTextLayout =
            view.findViewById<TextInputLayout>(R.id.addColorValue_yellow_editTextLayout)
        val blackEditTextLayout =
            view.findViewById<TextInputLayout>(R.id.addColorValue_black_editTextLayout)

        val addDialog = AlertDialog.Builder(this, R.style.CustomAlertDialog)

        addDialog.setView(view)
        addDialog.setPositiveButton(
            R.string.start_text
        ) { dialog, _ ->
            if (redEditText.text.isEmpty()) {

                redEditTextLayout.error = getString(R.string.compulsory_text)
                Toast.makeText(applicationContext, R.string.enter_color_values, Toast.LENGTH_SHORT)
                    .show()
                isColorsValueEntered = false

            } else if (blueEditText.text.isEmpty()) {

                blueEditTextLayout.error = getString(R.string.compulsory_text)
                Toast.makeText(applicationContext, R.string.enter_color_values, Toast.LENGTH_SHORT)
                    .show()
                isColorsValueEntered = false

            } else if (yellowEditText.text.isEmpty()) {

                yellowEditTextLayout.error = getString(R.string.compulsory_text)
                Toast.makeText(applicationContext, R.string.enter_color_values, Toast.LENGTH_SHORT)
                    .show()
                isColorsValueEntered = false

            } else if (blackEditText.text.isEmpty()) {

                blackEditTextLayout.error = getString(R.string.compulsory_text)
                Toast.makeText(applicationContext, R.string.enter_color_values, Toast.LENGTH_SHORT)
                    .show()
                isColorsValueEntered = false

            } else {

                redValue = redEditText.text.toString().toInt()
                blueValue = blueEditText.text.toString().toInt()
                yellowValue = yellowEditText.text.toString().toInt()
                blackValue = blackEditText.text.toString().toInt()

                isColorsValueEntered = true

                startGame()

                dialog.dismiss()
            }
        }
        addDialog.setNegativeButton(
            R.string.skip_text
        ) { dialog, _ ->
            redValue = 1
            blueValue = 1
            yellowValue = 1
            blackValue = 1

            isColorsValueEntered = true

            startGame()

            dialog.dismiss()
        }
        addDialog.setNeutralButton(
            R.string.cancel_text
        ) { dialog, _ ->
            isColorsValueEntered = true
            dialog.dismiss()
        }
        addDialog.setCancelable(false)
        addDialog.show()
    }


    //start game
    private fun startGame() {

        val intentScoreboard2 = Intent(applicationContext, Scoreboard2Player::class.java)
        val intentScoreboard3 = Intent(applicationContext, Scoreboard3Player::class.java)
        val intentScoreboard4 = Intent(applicationContext, Scoreboard4Player::class.java)

        if (playerNumber() == 2) {

            //player name must be entered
            if (binding.teamOperationsPlayer1NameEditText.text!!.isEmpty() || binding.teamOperationsPlayer2NameEditText.text!!.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    R.string.enter_player_name_text,
                    Toast.LENGTH_SHORT
                ).show()
            } else {

                if (isColorsValueEntered) {

                    //send game name to ScoreboardActivity
                    intentScoreboard2.putExtra("Game Name", gameName!!.text.toString())

                    //send player names to ScoreboardActivity
                    intentScoreboard2.putExtra("Player-1 Name", player1Name!!.text.toString())
                    intentScoreboard2.putExtra("Player-2 Name", player2Name!!.text.toString())

                    //send colors value to ScoreboardActivity
                    intentScoreboard2.putExtra("Red Value", redValue)
                    intentScoreboard2.putExtra("Blue Value", blueValue)
                    intentScoreboard2.putExtra("Yellow Value", yellowValue)
                    intentScoreboard2.putExtra("Black Value", blackValue)

                    //send game type and first number
                    intentScoreboard2.putExtra("Game Type", gameType)
                    intentScoreboard2.putExtra("Number of Starts", firstNumber!!.text.toString())

                    startActivity(intentScoreboard2)
                    finish()
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

                }

            }

        } else if (playerNumber() == 3) {

            //player name must be entered
            if (binding.teamOperationsPlayer1NameEditText.text!!.isEmpty() || binding.teamOperationsPlayer2NameEditText.text!!.isEmpty() || binding.teamOperationsPlayer3NameEditText.text!!.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    R.string.enter_player_name_text,
                    Toast.LENGTH_SHORT
                ).show()
            } else {

                if (isColorsValueEntered) {

                    //send game name to ScoreboardActivity
                    intentScoreboard3.putExtra("Game Name", gameName!!.text.toString())

                    //send player names to ScoreboardActivity
                    intentScoreboard3.putExtra("Player-1 Name", player1Name!!.text.toString())
                    intentScoreboard3.putExtra("Player-2 Name", player2Name!!.text.toString())
                    intentScoreboard3.putExtra("Player-3 Name", player3Name!!.text.toString())

                    //send colors value to ScoreboardActivity
                    intentScoreboard3.putExtra("Red Value", redValue)
                    intentScoreboard3.putExtra("Blue Value", blueValue)
                    intentScoreboard3.putExtra("Yellow Value", yellowValue)
                    intentScoreboard3.putExtra("Black Value", blackValue)

                    //send game type and first number
                    intentScoreboard3.putExtra("Game Type", gameType)
                    intentScoreboard3.putExtra("Number of Starts", firstNumber!!.text.toString())

                    startActivity(intentScoreboard3)
                    finish()
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

                }

            }

        } else if (playerNumber() == 4) {

            //player name must be entered
            if (binding.teamOperationsPlayer1NameEditText.text!!.isEmpty() || binding.teamOperationsPlayer2NameEditText.text!!.isEmpty() || binding.teamOperationsPlayer3NameEditText.text!!.isEmpty() || binding.teamOperationsPlayer4NameEditText.text!!.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    R.string.enter_player_name_text,
                    Toast.LENGTH_SHORT
                ).show()
            } else {

                if (isColorsValueEntered) {

                    if (playerType() == "Multiple") {

                        //send game name to ScoreboardActivity
                        intentScoreboard2.putExtra("Game Name", gameName!!.text.toString())

                        //send player names to ScoreboardActivity
                        intentScoreboard2.putExtra("Player-1 Name", player1Name!!.text.toString())
                        intentScoreboard2.putExtra("Player-2 Name", player2Name!!.text.toString())

                        //send colors value to ScoreboardActivity
                        intentScoreboard2.putExtra("Red Value", redValue)
                        intentScoreboard2.putExtra("Blue Value", blueValue)
                        intentScoreboard2.putExtra("Yellow Value", yellowValue)
                        intentScoreboard2.putExtra("Black Value", blackValue)

                        //send game type and first number
                        intentScoreboard2.putExtra("Game Type", gameType)
                        intentScoreboard2.putExtra(
                            "Number of Starts",
                            firstNumber!!.text.toString()
                        )

                        startActivity(intentScoreboard2)
                        finish()
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

                    } else {

                        //send game name to ScoreboardActivity
                        intentScoreboard4.putExtra("Game Name", gameName!!.text.toString())

                        //send player names to ScoreboardActivity
                        intentScoreboard4.putExtra("Player-1 Name", player1Name!!.text.toString())
                        intentScoreboard4.putExtra("Player-2 Name", player2Name!!.text.toString())
                        intentScoreboard4.putExtra("Player-3 Name", player3Name!!.text.toString())
                        intentScoreboard4.putExtra("Player-4 Name", player4Name!!.text.toString())

                        //send colors value to ScoreboardActivity
                        intentScoreboard4.putExtra("Red Value", redValue)
                        intentScoreboard4.putExtra("Blue Value", blueValue)
                        intentScoreboard4.putExtra("Yellow Value", yellowValue)
                        intentScoreboard4.putExtra("Black Value", blackValue)

                        //send game type and first number
                        intentScoreboard4.putExtra("Game Type", gameType)
                        intentScoreboard4.putExtra(
                            "Number of Starts",
                            firstNumber!!.text.toString()
                        )

                        startActivity(intentScoreboard4)
                        finish()
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

                    }

                }
            }

        }

    }


    //control of player number
    private fun playerNumber(): Int {
        return when {
            binding.teamOperations2PlayerRadioButton.isChecked -> 2
            binding.teamOperations3PlayerRadioButton.isChecked -> 3
            else -> 4
        }
    }


    //control of game type
    private fun playerType(): String {
        return if (binding.teamOperationsSingleRadioButton.isChecked) {
            "Single"
        } else {
            "Multiple"
        }
    }


    //set clickable radio buttons
    private fun setPlayerNumberRadioButtonsClickable() {

        binding.teamOperations2PlayerRadioButton.setOnClickListener {
            binding.teamOperationsPlayer1NameEditTextLayout.hint = getString(R.string.player1_text)
            binding.teamOperationsPlayer2NameEditTextLayout.hint = getString(R.string.player2_text)

            binding.teamOperations2PlayerRadioButton.isClickable = false
            binding.teamOperations3PlayerRadioButton.isClickable = true
            binding.teamOperations4PlayerRadioButton.isClickable = true

            binding.teamOperationsPlayer3NameEditTextLayout.visibility = View.GONE
            binding.teamOperationsPlayer4NameEditTextLayout.visibility = View.GONE

            binding.teamOperationsMultipleRadioButton.visibility = View.GONE

            binding.teamOperationsSingleRadioButton.isChecked = true
            binding.teamOperationsMultipleRadioButton.isChecked = false

            playerNumber()
        }

        binding.teamOperations3PlayerRadioButton.setOnClickListener {
            binding.teamOperationsPlayer1NameEditTextLayout.hint = getString(R.string.player1_text)
            binding.teamOperationsPlayer2NameEditTextLayout.hint = getString(R.string.player2_text)
            binding.teamOperationsPlayer3NameEditTextLayout.hint = getString(R.string.player3_text)

            binding.teamOperations2PlayerRadioButton.isClickable = true
            binding.teamOperations3PlayerRadioButton.isClickable = false
            binding.teamOperations4PlayerRadioButton.isClickable = true

            binding.teamOperationsPlayer3NameEditTextLayout.visibility = View.VISIBLE
            binding.teamOperationsPlayer4NameEditTextLayout.visibility = View.GONE

            binding.teamOperationsMultipleRadioButton.visibility = View.GONE

            binding.teamOperationsSingleRadioButton.isChecked = true
            binding.teamOperationsMultipleRadioButton.isChecked = false

            playerNumber()
        }

        binding.teamOperations4PlayerRadioButton.setOnClickListener {
            binding.teamOperations2PlayerRadioButton.isClickable = true
            binding.teamOperations3PlayerRadioButton.isClickable = true
            binding.teamOperations4PlayerRadioButton.isClickable = false

            if (playerType() == "Single"){
                binding.teamOperationsPlayer1NameEditTextLayout.hint = getString(R.string.player1_text)
                binding.teamOperationsPlayer2NameEditTextLayout.hint = getString(R.string.player2_text)
                binding.teamOperationsPlayer3NameEditTextLayout.hint = getString(R.string.player3_text)
                binding.teamOperationsPlayer4NameEditTextLayout.hint = getString(R.string.player4_text)

                binding.teamOperationsPlayer3NameEditTextLayout.visibility = View.VISIBLE
                binding.teamOperationsPlayer4NameEditTextLayout.visibility = View.VISIBLE

                binding.teamOperationsMultipleRadioButton.visibility = View.VISIBLE

                binding.teamOperationsSingleRadioButton.isChecked = true
                binding.teamOperationsMultipleRadioButton.isChecked = false
            } else {
                binding.teamOperationsPlayer1NameEditTextLayout.hint = getString(R.string.team1_text)
                binding.teamOperationsPlayer2NameEditTextLayout.hint = getString(R.string.team2_text)

                binding.teamOperationsPlayer3NameEditTextLayout.visibility = View.GONE
                binding.teamOperationsPlayer4NameEditTextLayout.visibility = View.GONE

                binding.teamOperationsMultipleRadioButton.visibility = View.VISIBLE

                binding.teamOperationsSingleRadioButton.isChecked = false
                binding.teamOperationsMultipleRadioButton.isChecked = true
            }

            playerNumber()
        }

    }

    private fun setPlayerTypeRadioButtonsClickable() {

        binding.teamOperationsSingleRadioButton.setOnClickListener {
            binding.teamOperationsSingleRadioButton.isClickable = false
            binding.teamOperationsMultipleRadioButton.isClickable = true

            if (playerNumber() == 2) {

                binding.teamOperationsPlayer1NameEditTextLayout.hint = getString(R.string.player1_text)
                binding.teamOperationsPlayer2NameEditTextLayout.hint = getString(R.string.player2_text)
                binding.teamOperationsPlayer1NameEditTextLayout.visibility = View.VISIBLE
                binding.teamOperationsPlayer2NameEditTextLayout.visibility = View.VISIBLE
                binding.teamOperationsPlayer3NameEditTextLayout.visibility = View.GONE
                binding.teamOperationsPlayer4NameEditTextLayout.visibility = View.GONE

            } else if (playerNumber() == 3) {

                binding.teamOperationsPlayer1NameEditTextLayout.hint = getString(R.string.player1_text)
                binding.teamOperationsPlayer2NameEditTextLayout.hint = getString(R.string.player2_text)
                binding.teamOperationsPlayer3NameEditTextLayout.hint = getString(R.string.player3_text)
                binding.teamOperationsPlayer1NameEditTextLayout.visibility = View.VISIBLE
                binding.teamOperationsPlayer2NameEditTextLayout.visibility = View.VISIBLE
                binding.teamOperationsPlayer3NameEditTextLayout.visibility = View.VISIBLE
                binding.teamOperationsPlayer4NameEditTextLayout.visibility = View.GONE

            } else {

                binding.teamOperationsPlayer1NameEditTextLayout.hint = getString(R.string.player1_text)
                binding.teamOperationsPlayer2NameEditTextLayout.hint = getString(R.string.player2_text)
                binding.teamOperationsPlayer3NameEditTextLayout.hint = getString(R.string.player3_text)
                binding.teamOperationsPlayer4NameEditTextLayout.hint = getString(R.string.player4_text)
                binding.teamOperationsPlayer1NameEditTextLayout.visibility = View.VISIBLE
                binding.teamOperationsPlayer2NameEditTextLayout.visibility = View.VISIBLE
                binding.teamOperationsPlayer3NameEditTextLayout.visibility = View.VISIBLE
                binding.teamOperationsPlayer4NameEditTextLayout.visibility = View.VISIBLE

            }

            playerType()
        }

        binding.teamOperationsMultipleRadioButton.setOnClickListener {
            binding.teamOperationsSingleRadioButton.isClickable = true
            binding.teamOperationsMultipleRadioButton.isClickable = false

            if (playerNumber() == 2) {

                binding.teamOperationsPlayer1NameEditTextLayout.hint = getString(R.string.player1_text)
                binding.teamOperationsPlayer2NameEditTextLayout.hint = getString(R.string.player2_text)
                binding.teamOperationsPlayer1NameEditTextLayout.visibility = View.VISIBLE
                binding.teamOperationsPlayer2NameEditTextLayout.visibility = View.VISIBLE
                binding.teamOperationsPlayer3NameEditTextLayout.visibility = View.GONE
                binding.teamOperationsPlayer4NameEditTextLayout.visibility = View.GONE

            } else if (playerNumber() == 3) {

                binding.teamOperationsPlayer1NameEditTextLayout.hint = getString(R.string.player1_text)
                binding.teamOperationsPlayer2NameEditTextLayout.hint = getString(R.string.player2_text)
                binding.teamOperationsPlayer3NameEditTextLayout.hint = getString(R.string.player3_text)
                binding.teamOperationsPlayer1NameEditTextLayout.visibility = View.VISIBLE
                binding.teamOperationsPlayer2NameEditTextLayout.visibility = View.VISIBLE
                binding.teamOperationsPlayer3NameEditTextLayout.visibility = View.VISIBLE
                binding.teamOperationsPlayer4NameEditTextLayout.visibility = View.GONE

            } else {

                binding.teamOperationsPlayer1NameEditTextLayout.hint = getString(R.string.team1_text)
                binding.teamOperationsPlayer2NameEditTextLayout.hint = getString(R.string.team2_text)
                binding.teamOperationsPlayer1NameEditTextLayout.visibility = View.VISIBLE
                binding.teamOperationsPlayer2NameEditTextLayout.visibility = View.VISIBLE
                binding.teamOperationsPlayer3NameEditTextLayout.visibility = View.GONE
                binding.teamOperationsPlayer4NameEditTextLayout.visibility = View.GONE

            }

            playerType()
        }

    }


    //set game type
    @SuppressLint("SetTextI18n")
    private fun gameType() {
        binding.teamOperationsDeductFromNumberRadioButton.setOnClickListener {
            gameType = "Deduct from the number"
            binding.teamOperationsNumberOfStartsEditTextLayout.visibility = View.VISIBLE
            firstNumber!!.setText("")
        }

        binding.teamOperationsAddScoreRadioButton.setOnClickListener {
            gameType = "Add Score"
            binding.teamOperationsNumberOfStartsEditTextLayout.visibility = View.GONE
            firstNumber!!.setText("0000")
        }
    }


    //on back pressed turn back to main menu
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val intentMain = Intent(applicationContext, MainMenu::class.java)
        startActivity(intentMain)
        finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}