package geoLearnBot;

public class Minerals {

	// ============ class attributes ========//
	private String title;

	private String description;

	private String type;

	private String mineralClassification;

	private String chemicalFormula;

	private String streak;

	private String mohsHardness;

	private String crystalSystem;

	private String color;

	private String luster;

	private String fracture;

	private String image;

	// ============ constructor =====//
	public Minerals(String title, String description, String type, String mineralClassification, String chemicalFormula,
			String streak, String mohsHardness, String crystalSystem, String color, String luster, String fracture,
			String image) {
		super();
		this.title = title;
		this.description = description;
		this.type = type;
		this.mineralClassification = mineralClassification;
		this.chemicalFormula = chemicalFormula;
		this.streak = streak;
		this.mohsHardness = mohsHardness;
		this.crystalSystem = crystalSystem;
		this.color = color;
		this.luster = luster;
		this.fracture = fracture;
		this.image = image;
	}

	// =============== Getters ========//
	public String getTitle() {
		return this.title;
	}

	public String getDescription() {
		return this.description;
	}

	public String getType() {
		return this.type;
	}

	public String getMineralClassification() {
		return this.mineralClassification;
	}

	public String getChemicalFormula() {
		return this.chemicalFormula;
	}

	public String getStreak() {
		return this.streak;
	}

	public String getMohsHardness() {
		return this.mohsHardness;
	}

	public String getCrystalSystem() {
		return this.crystalSystem;
	}

	public String getColor() {
		return this.color;
	}

	public String getLuster() {
		return this.luster;
	}

	public String getFracture() {
		return this.fracture;
	}

	public String getImage() {
		return this.image;
	}

	// toString customised for better display
	@Override
	public String toString() {
		return "\n\n<strong>" + this.title.toUpperCase() + "\n</strong>" + "\n" + "<strong>" + "Description :</strong> "
				+ this.description + " \n<strong>Mineral Classification :</strong> " + this.mineralClassification
				+ " \n<strong>Chemical Formula :</strong> " + this.chemicalFormula + " \n<strong>Streak :</strong> "
				+ this.streak + " \n<strong>Mohs Hardness :</strong> " + this.mohsHardness
				+ " \n<strong>Crystal System :</strong> " + this.crystalSystem + " \n<strong>Color :</strong> "
				+ this.color + " \n<strong>Luster :</strong> " + this.luster + " \n<strong>Fracture :</strong> "
				+ this.fracture + "\n" + this.image;
	}

}
