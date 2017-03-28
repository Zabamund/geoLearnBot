package geoLearnBot;

import java.util.List;
import java.util.Map;

public class Chat {

	private Long id;

	private Map<String, Minerals> seenMinerals;

	private Map<String, Minerals> favoriteMinerals;

	private List<Minerals> mineralQuizList;

	private List<Integer> hintsSeenThisRound;

	private int gameScore;

	private int highScore;

	public Chat(Long id, Map<String, Minerals> seenMinerals, Map<String, Minerals> favoriteMinerals,
			List<Minerals> mineralQuizList, List<Integer> hintsSeenThisRound) {
		super();
		this.id = id;
		this.seenMinerals = seenMinerals;
		this.favoriteMinerals = favoriteMinerals;
		this.mineralQuizList = mineralQuizList;
		this.hintsSeenThisRound = hintsSeenThisRound;
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

	public List<Minerals> getMineralQuizList() {
		return this.mineralQuizList;
	}

	public void setMineralQuizList(List<Minerals> mineralQuizList) {
		this.mineralQuizList = mineralQuizList;
	}

	public List<Integer> getHintsSeenThisRound() {
		return this.hintsSeenThisRound;
	}

	public void setHintsSeenThisRound(List<Integer> hintsSeenThisRound) {
		this.hintsSeenThisRound = hintsSeenThisRound;
	}

	public int getGameScore() {
		return this.gameScore;
	}

	public void setGameScore(int gameScore) {
		this.gameScore = gameScore;
	}

	public int getHighScore() {
		return this.highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	@Override
	public String toString() {
		return "Chat \n*id:* " + this.id + "\n*Seen Minerals:* " + this.seenMinerals + "\n*Favorite Minerals:* "
				+ this.favoriteMinerals + "\n*Game score:" + this.gameScore + "\n*High score:" + this.highScore;
	}

}
