package beerio;

public class Player {
	public int playerId;
	public String fName;
	public String lName;
	public int weight;
	public String gender;
	
	public Player(int userId, String fName, String lName, int weight, String gender) {
		this.playerId = userId;
		this.fName = fName;
		this.lName = lName;
		this.weight = weight;
		this.gender = gender;
	}
	public Player() {
	}
		public int getPlayerId() {
			return playerId;
		}
		public void setPlayerId(int playerId) {
			this.playerId = playerId;
		}
		public String getfName() {
			return fName;
		}
		public void setfName(String fName) {
			this.fName = fName;
		}
		public String getlName() {
			return lName;
		}
		public void setlName(String lName) {
			this.lName = lName;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String toJson() {
			return "{ \"playerId\" : "+playerId+" , \"fName\" : \""+fName+"\" , \"lName\" : \""+lName+"\" , \"weight\" : "+weight+" , \"gender\" : \""+gender+"\" }";
		}
		@Override
		public String toString() {
			return "Player [playerId=" + playerId + ", fName=" + fName + ", lName=" + lName + ", weight=" + weight
					+ ", gender=" + gender + "]";
		}
	
	}