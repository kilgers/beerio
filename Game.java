package beerio;

public class Game {
	public int numPlayers;
	public Player player1;
	public Player player2;
	public Player player3;
	public Player player4;
	public Player player5;
	public Player player6;
	public Drink player1Drink;
	public Drink player2Drink;
	public Drink player3Drink;
	public Drink player4Drink;
	public Drink player5Drink;
	public Drink player6Drink;
	public Round round1;
	public Round round2;
	public Round round3;
	public Round round4;
	public int getNumPlayers() {
		return numPlayers;
	}
	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}
	public Player getPlayer1() {
		return player1;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	public Player getPlayer3() {
		return player3;
	}
	public void setPlayer3(Player player3) {
		this.player3 = player3;
	}
	public Player getPlayer4() {
		return player4;
	}
	public void setPlayer4(Player player4) {
		this.player4 = player4;
	}
	public Player getPlayer5() {
		return player5;
	}
	public void setPlayer5(Player player5) {
		this.player5 = player5;
	}
	public Player getPlayer6() {
		return player6;
	}
	public void setPlayer6(Player player6) {
		this.player6 = player6;
	}
	public Drink getPlayer1Drink() {
		return player1Drink;
	}
	public void setPlayer1Drink(Drink player1Drink) {
		this.player1Drink = player1Drink;
	}
	public Drink getPlayer2Drink() {
		return player2Drink;
	}
	public void setPlayer2Drink(Drink player2Drink) {
		this.player2Drink = player2Drink;
	}
	public Drink getPlayer3Drink() {
		return player3Drink;
	}
	public void setPlayer3Drink(Drink player3Drink) {
		this.player3Drink = player3Drink;
	}
	public Drink getPlayer4Drink() {
		return player4Drink;
	}
	public void setPlayer4Drink(Drink player4Drink) {
		this.player4Drink = player4Drink;
	}
	public Drink getPlayer5Drink() {
		return player5Drink;
	}
	public void setPlayer5Drink(Drink player5Drink) {
		this.player5Drink = player5Drink;
	}
	public Drink getPlayer6Drink() {
		return player6Drink;
	}
	public void setPlayer6Drink(Drink player6Drink) {
		this.player6Drink = player6Drink;
	}
	public Round getRound1() {
		return round1;
	}
	public void setRound1(Round round1) {
		this.round1 = round1;
	}
	public Round getRound2() {
		return round2;
	}
	public void setRound2(Round round2) {
		this.round2 = round2;
	}
	public Round getRound3() {
		return round3;
	}
	public void setRound3(Round round3) {
		this.round3 = round3;
	}
	public Round getRound4() {
		return round4;
	}
	public void setRound4(Round round4) {
		this.round4 = round4;
	}
	@Override
	public String toString() {
		return "Game [numPlayers=" + numPlayers + ", player1=" + player1 + ", player2=" + player2 + ", player3="
				+ player3 + ", player4=" + player4 + ", player5=" + player5 + ", player6=" + player6 + ", player1Drink="
				+ player1Drink + ", player2Drink=" + player2Drink + ", player3Drink=" + player3Drink + ", player4Drink="
				+ player4Drink + ", player5Drink=" + player5Drink + ", player6Drink=" + player6Drink + ", round1="
				+ round1 + ", round2=" + round2 + ", round3=" + round3 + ", round4=" + round4 + "]";
	}
	
}
