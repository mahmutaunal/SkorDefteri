package com.mahmutalperenunal.okeypuantablosu.model

//data class for player scores
data class ScoreData3Player(
    var player1_score: String,
    var player2_score: String,
    var player3_score: String,
    var gameNumber: Int,
    var multiplyNumber: Int,
    var color: String,
    var colorValue: Boolean,
    var isSelected: Boolean
)