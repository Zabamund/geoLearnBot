package geoLearnBot;

import java.util.List;
import java.util.Map;

public class Chat {

	private Long id;

	private Map<String, Minerals> seenMinerals;

	private Map<String, Minerals> favoriteMinerals;

	private List<Minerals> mineralQuizList;

	private int highScore;

	public Chat(Long id, Map<String, Minerals> seenMinerals, Map<String, Minerals> favoriteMinerals, int highScore,
			List<Minerals> mineralQuizList) {
		super();
		this.id = id;
		this.seenMinerals = seenMinerals;
		this.favoriteMinerals = favoriteMinerals;
		this.highScore = highScore;
		this.mineralQuizList = mineralQuizList;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<String, Minerals> getSeenMinerals() {
		return this.seenMinerals;
	}

	public void setSeenMinerals(Map<String, Minerals> seenMinerals) {
		this.seenMinerals = seenMinerals;
	}

	public Map<String, Minerals> getFavoriteMinerals() {
		return this.favoriteMinerals;
	}

	public void setFavoriteMinerals(Map<String, Minerals> favoriteMinerals) {
		this.favoriteMinerals = favoriteMinerals;
	}

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	public List<Minerals> getMineralQuizList() {
		return mineralQuizList;
	}

	public void setMineralQuizList(List<Minerals> mineralQuizList) {
		this.mineralQuizList = mineralQuizList;
	}

	@Override
	public String toString() {
		return "Chat \n*id:* " + this.id + "\n*Seen Minerals:* " + this.seenMinerals + "\n*Favorite Minerals:* "
				+ this.favoriteMinerals + "\n*High score:" + this.highScore;
	}

}
