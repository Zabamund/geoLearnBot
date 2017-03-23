package geoLearnBot;

import java.util.List;

public class Chat {

	private Long id;

	private List<Integer> seenMineral;

	private List<Integer> favoriteMineral;

	public Chat(Long id, List<Integer> seenMineral, List<Integer> favoriteMineral) {
		super();
		this.id = id;
		this.seenMineral = seenMineral;
		this.favoriteMineral = favoriteMineral;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Integer> getSeenMineral() {
		return this.seenMineral;
	}

	public void setSeenMineral(List<Integer> seenMineral) {
		this.seenMineral = seenMineral;
	}

	public List<Integer> getFavoriteMineral() {
		return this.favoriteMineral;
	}

	public void setFavoriteMineral(List<Integer> favoriteMineral) {
		this.favoriteMineral = favoriteMineral;
	}

	@Override
	public String toString() {
		return "Chat \n*id:* " + this.id + "\n*Seen Minerals:* " + this.seenMineral + "\n*Favorite Minerals:* "
				+ this.favoriteMineral + "\n";
	}

}
