package geoLearnBot;

import java.util.List;

public class Chat {

	private Long id;

	private List<Minerals> seenMineral;

	private List<Minerals> favoriteMineral;

	public Chat(Long id, List<Minerals> seenMineral, List<Minerals> favoriteMineral) {
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

	public List<Minerals> getSeenMineral() {
		return this.seenMineral;
	}

	public void setSeenMineral(List<Minerals> seenMineral) {
		this.seenMineral = seenMineral;
	}

	public List<Minerals> getFavoriteMineral() {
		return this.favoriteMineral;
	}

	public void setFavoriteMineral(List<Minerals> favoriteMineral) {
		this.favoriteMineral = favoriteMineral;
	}

	@Override
	public String toString() {
		return "Chat \n*id:* " + this.id + "\n*Seen Minerals:* " + this.seenMineral + "\n*Favorite Minerals:* "
				+ this.favoriteMineral + "\n";
	}

}
