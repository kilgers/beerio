package beerio;

public class Round {
	public int roundId;
	public int playerNum;
	public int player1Score;
	public int player2Score;
	public int player3Score;
	public int player4Score;
	public int player5Score;
	public int player6Score;
	public String map;
	public Round() {
		
	}
	public int getRoundId() {
		return roundId;
	}
	public void setRoundId(int roundId) {
		this.roundId = roundId;
	}
	public int getPlayerNum() {
		return playerNum;
	}
	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}
	public int getPlayer1Score() {
		return player1Score;
	}
	public void setPlayer1Score(int player1Score) {
		this.player1Score = player1Score;
	}
	public int getPlayer2Score() {
		return player2Score;
	}
	public void setPlayer2Score(int player2Score) {
		this.player2Score = player2Score;
	}
	public int getPlayer3Score() {
		return player3Score;
	}
	public void setPlayer3Score(int player3Score) {
		this.player3Score = player3Score;
	}
	public int getPlayer4Score() {
		return player4Score;
	}
	public void setPlayer4Score(int player4Score) {
		this.player4Score = player4Score;
	}
	public int getPlayer5Score() {
		return player5Score;
	}
	public void setPlayer5Score(int player5Score) {
		this.player5Score = player5Score;
	}
	public int getPlayer6Score() {
		return player6Score;
	}
	public void setPlayer6Score(int player6Score) {
		this.player6Score = player6Score;
	}
	public String getMap() {
		return map;
	}
	public void setMap(String map) {
		this.map = map;
	}
	public String toJson() {
		return "{ \"roundId\" : "+roundId + " , \"playerNum\" : " + playerNum +" ,  \"player1Score\" : " + player1Score +" ,  \"player2Score\" : " + player2Score +" ,  \"player3Score\" : " + player3Score +" ,  \"player4Score\" : " + player4Score +" ,  \"player5Score\" : " + player5Score +" ,  \"player6Score\" : " + player6Score +" ,  \"map\" : \"" + map +"\" }";
	}
}
