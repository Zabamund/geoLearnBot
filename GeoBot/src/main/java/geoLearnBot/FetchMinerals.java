package geoLearnBot;

import java.util.ArrayList;
import java.util.List;

public class FetchMinerals {

	public static List<Minerals> fetchMinerals() {

		// create an empty list to which we'll add the mineral attributes
		List<Minerals> mineralsList = new ArrayList<>();

		// all properties of the minerals arranged as individual arrays
		String[] titleArray = { "Chlorite", "Aurichalcite", "Calcite", "Kaolinite", "Biotite", "Colemanite", "Quartz",
				"Augite", "Asbestos", "Silver", "Zeolites", "Graphite", "Salt/Halite", "Gold", "Pyrite", "Garnet",
				"Talc", "Fluorite", "Feldspar", "Diamond", "Beryllium", "Gypsum", "Corundum", "Barium", "Aragonite",
				"Autunite" };
		String[] descriptionArray = {
				"Chlorite is the name given to a group of minerals with a similar silicate lattice.  The chemical formulas of chlorites vary based on the combinations of the elements Zn, Li, Ca, Mg, Fe, Ni and Mn within.",
				"Aurichalcite is soft, monoclinic, copper and zinc bearing mineral. It forms a soft, scaly, greenish-blue crust in oxidized zones of copper-zinc ore deposits. It is considered to be a guide or indicator of zinc ore.",
				"Calcite is the principal mineral of the rock group known as carbonates.  Calcite is a major component in limestone and dolomite.",
				"Kaolinite is a layered silicate clay mineral which forms from the chemical weathering of feldspar or other aluminum silicate minerals. It is usually white, with occasionally a red color impurity due to iron oxide, or blue or brown from other minerals. Kaolinite has a low shrink–swell capacity and a low cation-exchange capacity, making it ideal for many industrial applications.",
				"Biotite is black magnesium/iron- based mica of low commercial value. It appears in the form of thin sheets which generally range from 0.003 mm to 0.1 mm in thickness.",
				"Colemanite is a hydrated calcium borate, an altered variation of borax. Over 200 minerals contain boron, but colemanite is one of only a few which is commercially important. It contains 50% B2O3. It forms at a lower pH and warmer temperature than other borates including ulexite.",
				"Quartz is one of the most common minerals in the Earth’s crust. As a mineral name, quartz refers to a specific chemical compound (silicon dioxide, or silica, SiO2), having a specific crystalline form (hexagonal). It is found is all forms of rock: igneous, metamorphic and sedimentary. Quartz is physically and chemically resistant to weathering. When quartz-bearing rocks become weathered and eroded, the grains of resistant quartz are concentrated in the soil, in rivers, and on beaches. The white sands typically found in river beds and on beaches are usually composed mainly of quartz, with some white or pink feldspar as well.",
				"Augite is a rock-forming mineral of the pyroxene group commonly found within igneous and metamorphic rocks. Because its chemical structure is highly variable, augite might be considered by some to be its own group of minerals rather than an individual mineral. It is also known for its remarkable luster (shine off of a reflective surface).",
				"Asbestos is a commercial term that includes six regulated asbestiform silicate (silicon + oxygen) minerals. Because this group of silicate minerals can be readily separated into thin, strong fibers that are flexible, heat resistant, and chemically inert, asbestos minerals were once used in a wide variety of products. However, due to adverse health effects, the use of asbestos in the U.S. has been significantly decreased. In 2013, for example, the total amount used was only 950 tons, all of which was chrysotile, and was mined in Brazil. Many other countries still mine and use asbestos in insulation products due to less stringent health and safety regulations.",
				"Silver (Ag) has a bright, metallic luster, and when untarnished, has a white color. It is rarely found in its native form. Silver can be found combined with a number of different elements such as sulfur, arsenic, antimony or chlorine to form a variety of minerals and ores, such as argentite, chlorargyrite, and galena. It is also found in very small amounts in gold, lead, zinc and copper ores. Silver is malleable which means it can be hammered into thin sheets. It is also ductile, meaning it can be drawn into wire.",
				"Zeolites are a group of silicate minerals with unusual properties with industrial importance.  They usually form beautiful well-formed crystals with pale colors, and are relatively soft and can be crushed and powdered. They are found in geologically young volcanic fields.  Most common zeolite minerals are analcime, chabazite, clinoptilite and mordenite. natrolite, analcime, chabazite, heulandite, phillipsite, and stilbite.  Zeolites appear in many different minerals, such as chabazite, natrolite.",
				"Pure graphite is a mineral form of the element carbon (element #6, symbol C).  It forms as veins and disseminations in metamorphic rocks as the result of the metamorphism of organic material included in limestone deposits.  It is an extremely soft mineral and it breaks into minute, flexible flakes that easily slide over one another.  This feature accounts for graphite’s distinctive greasy feel.  This greasy characteristic makes graphite a good lubricant. Because it is a solid material, it is known as a dry lubricant.  This is useful in applications where “wet” lubricants, such as oil, cannot be used.  Graphite is the only non-metal element that is a good conductor of electricity.  Natural graphite is used mostly in what are called refractory applications. Refractory applications are those that involve extremely high heat and therefore demand materials that will not melt or disintegrate under such extreme conditions. One example of this use is in the crucibles used in the steel industry. Such refractory applications account for the majority of the usage of graphite.",
				"Halite, commonly known as table salt or rock salt, is composed of sodium chloride (NaCl).  It is essential for life of humans and animals. Salt is used in food preparation across the globe.",
				"Gold (element #79, symbol Au) is a heavy, shiny yellow metal.  It is probably the oldest precious metal known to man.  Wars have been fought over it and countless numbers have died trying to gain it or protect it.  Its physical and chemical properties make it ideal for a number of applications. It is used in dentistry and medicine, in jewelry and arts, in medallions and coins, in ingots as a store of value, for scientific and electronic instruments, and as an electrolyte in the electro-plating industry. South Africa has about half of the world’s gold resources. Significant quantities are also present in the U.S., Australia, Brazil, Canada, China, and Russia.",
				"Commonly called fool’s gold, pyrite is the earth’s most abundant sulfide mineral. Recognized for its brass-yellow color which resembles that of gold, pyrite is a source of iron and sulfur and is used for the production of sulfuric acid.",
				"Garnet is usually thought of as a gemstone but most garnet is mined for industrial uses. A very small number of garnets are pure and flawless enough to be cut as gemstones. The majority of garnet mining is for massive garnet that is crushed and used to make abrasives.  Garnet is a silicate mineral group; in other words, garnet’s complex chemical formula includes the silicate molecule (SiO4).  The different varieties of garnet have different metal ions, such as iron, aluminum, magnesium and chromium.  Some varieties also have calcium.",
				"The term talc refers both to the pure mineral and a wide variety of soft, talc-containing rocks that are mined and utilized for a variety of applications. Talc forms mica-like flakes. Talc is the softest mineral on the Mohs’ hardness scale at 1 and can be easily cut and crushed. Talc has perfect cleavage in one direction. This means that it breaks into thin sheets. As a result, it feels greasy to the touch (which is why talc is used as a lubricant)",
				"Fluorite is commercially named fluorspar composed of calcium fluoride (CaF2).  It is the principal source of fluorine. The same is used in production of hydrofluoric acid, which is used in a wide variety of industrial applications including glass etching. Fluorite tends to occur in well-formed isometric crystals, forming cubes and octahedrons. It also occurs in both massive and earthy forms, and as crusts or globular aggregates with radial fibrous texture.",
				"Feldspar is the name given to a group of minerals distinguished by the presence of alumina and silica (SiO2) in their chemistry.  This group includes aluminum silicates of soda, potassium, or lime. It is the single most abundant mineral group on Earth.  They account for an estimated 60% of exposed rocks, as well as soils, clays, and other unconsolidated sediments, and are principal components in rock classification schemes. The minerals included in this group are the orthoclase, microcline and plagioclase feldspars.",
				"Diamond is an extraordinary mineral with extreme hardness and inherent beauty that is sought for personal adornment and industrial use. Because the genesis of this unique mineral requires extreme temperature and pressure, natural diamond is so rare that some diamonds are the most valuable commodity on earth, based on weight.",
				"Beryllium (Be) is a silver-white and very light metal. It has a very high melting point at 2349 °F (1287 °C).  It is found in nature primarily as bertrandite, which is mined in Utah, or as beryl. The combination of its light weight and high melting point makes it valuable for making metal alloys which are used in electronic and electrical components, aerospace, automobiles, computers, oil and gas drilling equipment, and telecommunications.",
				"Gypsum is found in nature in mineral and rock form.  It is a very soft mineral and it can form very pretty, and sometimes extremely large colored crystals.  As a rock, gypsum is a sedimentary rock, typically found in thick beds or layers.  It forms in lagoons where ocean waters high in calcium and sulfate content can slowly evaporate and be regularly replenished with new sources of water.  The result is the accumulation of large beds of sedimentary gypsum.  Gypsum is commonly associated with rock salt and sulfur deposits. It is processed and used as prefabricated wallboard or as industrial or building plaster, used in cement manufacture, agriculture and other uses.",
				"Corundum is a crystalline form of aluminum oxide (Al2O3) with traces of iron, titanium and chromium. It is a rock-forming mineral. It is one of the naturally transparent materials, but can have different colors when impurities are present. Transparent specimens are used as gems such as sapphires rubies.",
				"Barium (Ba) is obtained chiefly from the mineral barite. Barium is a soft, silvery, reactive metal. Because barium is so dense it is commonly used in some alloys, for example in spark plugs and ball bearings. As of 2013, China, India and Morocco were the world’s largest producers of barium. In the U.S, barite is mined primarily in Nevada and Georgia.",
				"Aragonite is a carbonate mineral, one of the two common, naturally occurring polymorphs of calcium carbonate, CaCO3. The other polymorph is the mineral calcite. Aragonite’s crystal lattice differs from that of calcite, resulting in a different crystal shape, an orthorhombic system with acicular crystals. Repeated twinning results in pseudo-hexagonal forms.",
				"Autunite is a radioactive orthorhombic mineral which results from the hydrothermal alteration of uranium minerals.  Used as a uranium ore, it was first discovered in France in 1852." };
		String[] typeArray = { "Mineral", "Mineral", "Mineral", "Mineral", "Mineral", "Mineral", "Mineral", "Mineral",
				"Mineral", "Element, Mineral", "Mineral", "Mineral", "Mineral", "Element, Mineral", "Mineral",
				"Mineral", "Mineral", "Mineral", "Mineral", "Mineral", "Mineral", "Mineral", "Mineral", "Mineral",
				"Mineral", "Mineral" };
		String[] mineralClassificationArray = { "Phyllosilicates", "Carbonate", "Carbonate", "Phyllosilicates", "Mica",
				"Inoborates", "Silicate", "Pyroxene", "Silicate", "Native", "Silicate", "Native", "Halide", "Native",
				"Sulfide", "Silicate", "Silicate", "Halide", "Silicate", "Native element", "Silicate", "Sulfate",
				"Hematite", "Sulfates", "Carbonate", "Autunite" };
		String[] chemicalFormulaArray = { "Variable", "4[(Zn,Cu)5(CO3)2(OH)6]", "CaCO3", "Al2Si2O5(OH)4",
				"K(Mg,Fe)3(AlSi3O10)(F,OH)2", "CaB3O4(OH)3·H2O", "SiO2", "8[(Ca,Na)(Mg,Fe,Al,Ti)(Si,Al)2O6]",
				"Mg3(Si2O5)(OH)4  - Chrysotile; Fe7Si8O22(OH)2 – Amosite; Na2Fe2+3Fe3+2Si8O22(OH)2 – Crocidolite; Ca2Mg5Si8O22(OH)2 – Tremolite asbestos; Ca2(Mg, Fe)5(Si8O22)(OH)2 – Actinolite asbestos; (Mg, Fe)7Si8O22(OH)2 – anthophyllite asbestos",
				"Ag", "(Ca,K2,Na2)2[Al2Si4O12]2·12H2O", "C", "NaCl", "Au", "FeS2",
				"X3Y2(SiO4)3   (Where X is often Ca or Mg, and Y is often Al or Fe)", "Mg3Si4O10(OH)2", "CaF2",
				"KAlSi3O8 – NaAlSi3O8 – CaAl2Si2O8", "C", "Be4Si2O7(OH)2 (bertrandite), Be3Al2(SiO3)6 (beryl)",
				"CaSO4·2H2O", "Al2O3", "BaSO4", "CaCO3", "2[Ca(UO2)2(PO4)2·10-12H2O]" };
		String[] streakArray = { "Green to gray", "very light blue-green", "White", "White", "White", "White", "White",
				"Light green to colorless", "White", "silver white", "white", "Black", "White", "Shining yellow",
				"Black or Brown", "White", "White, pearl black", "White", "White", "Colorless", "White", "White",
				"White", "White", "White", "Pale Yellow" };
		String[] mohsHardnessArray = { "2-2.5", "2-2.5", "3", "2–2.5", "2.5-3", "4.5", "7", "5-6", "2.5-3", "2.5-3",
				"4-5", "1–2", "2-2.5", "2.5-3", "6-6.5", "6.5-7.5", "1", "4", "6-6.5", "10",
				"6 – 7 (bertrandite), 7.5–8 (beryl)", "1.5–2", "9.0", "3-3.5", "3.5-4", "2-2.5" };
		String[] crystalSystemArray = { "Monoclinic and triclinic", "Monoclinic", "Hexagonal", "Triclinic",
				"Monoclinic", "Monoclinic", "trigonal", "Monoclinic", "Monoclinic, Orthorhombic", "Isometric",
				"triclinic", "Hexagonal", "Isometric", "Isometric", "Isometric",
				"Isometric (meaning equality in dimension. For example, a cube, octahedron, or dodecahedron)",
				"monoclinic, triclinic", "Isometric", "triclinic, monoclinic", "Isometric",
				"Orthorhombic (bertrandite), Hexagonal (beryl)", "Monoclinic", "Trigonal", "Orthorhombic",
				"Orthorhombic", "Tetragonal, Orthorhombic" };
		String[] colorArray = { "Green, rarely red, yellow or white", "blue-green and light-blue",
				"Colorless or white, but may take on other colors due to impurities",
				"White, sometimes red, blue or brown tints from impurities", "Black", "White, clear, colorless, gray",
				"Pure quartz is clear. Color variance due to impurities: purple (amethyst), white (milky quartz), black (smoky quartz), pink (rose quartz) and yellow or orange (citrine)",
				"Black, brown, greenish, violet-brown; in thin section, colorless to gray", "gray, white, blue, green",
				"Silver", "Colourless, white, yellow, pink, red",
				"Iron-black to steel-gray; deep blue in transmitted light",
				"Colorless or white; also blue, purple, red, pink, yellow, orange, or gray", "Gold",
				"golden brass-yellow", "Generally brown, virtually all colors, blue very rare",
				"White, brown, gray, greenish", "Colorless. Samples are often deeply colored owing to impurities",
				"pink, white, gray, brown",
				"Typically yellow, brown or gray to colorless. Less often blue, green, black, translucent white, pink, violet, orange, purple and red.",
				"Colorless to pale yellow( bertrandite); green, blue, yellow, colorless, pink and others (beryl)",
				"Colorless, white", "Variable; colorless, yellow, red, blue, violet, golden-brown &c.",
				"Colorless, white, light shades of blue, yellow, grey, brown",
				"White, red, yellow, orange, green, purple, grey, blue and brown",
				"Yellow, greenish-yellow, pale green; dark green, greenish black" };
		String[] lusterArray = { "Vitreous, pearly, dull", "Pearly, silky",
				"Vitreous and also pearly along cleavage surfaces", "Pearly to dull earthy", "Vitreous, may be pearly",
				"Vitreous", "vitreous, waxy, dull", "Vitreous and dull", "Silky", "Metallic", "vitreous", "Metallic",
				"vitreous", "Metallic", "Metallic", "Vitreous, resinous", "Pearly", "Vitreous", "Vitreous",
				"Adamantine", "Vitreous, pearly (bertrandite), Vitreous, resinous (beryl)", "Vitreous",
				"Adamantine, Vitreous, and/or Pearly", "Vitreous, pearly", "Vitreous, resinous on fracture surfaces",
				"Sub-vitreous, resinous, waxy, pearly" };
		String[] fractureArray = { "Lamellar", "Uneven", "Conchoidal",
				"Irregular/uneven, conchoidal, sub-conchoidal, micaceous", "Micaceous", "Conchoidal", "conchoidal",
				"Ranges from splintery to uneven", "Fibrous", "Jagged", "irregular/uneven", "Flaky", "conchoidal",
				"Jagged", "Very uneven, conchoidal", "Conchoidal, uneven", "uneven", "Subconchoidal, uneven",
				"conchoidal, uneven", "Conchoidal", "Conchoidal", "Conchoidal", "Conchoidal", "Uneven", "Subconchoidal",
				"Micaceous" };
		// String[] imageArray = {
		// "https://mineralseducationcoalition.org/wp-content/uploads/Chlorite_schist_299193245-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Aurichalcite_364315322-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Calcite_crystalMineral_312933338-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Kaolinite1_141265540-1-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Biotite-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Colemanite_16620532-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Quartz1_natural_222926188-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Augite_125449619-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Asbestos1_Chrysotile1_297924608-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Silver1_galena_16620550-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Zeolite_136257968-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Graphite_56068858-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Salt_halite_307822916-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Gold1_90782147-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Pyrite_147327494-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Garnet1-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Talc_380238223-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Flourite_364713614-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Feldspar1_309985529-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/stock-photo-luxury-diamond-in-tweezers-closeup-with-dark-background-307889945-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Beryllium_323719931-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Gypsum1_323719829-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Corundum1_Rock_338930951-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Barium1_sulfate_138425783-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Aragonite1_Crystals_148090799-150x150.jpg",
		// "https://mineralseducationcoalition.org/wp-content/uploads/Autunite_173744783-150x150.jpg"
		// };

		// shortened url from Google to make it more user-friendly in display
		String[] imageArray = { "https://goo.gl/ctdEey", "https://goo.gl/WDyKc9", "https://goo.gl/lDHs3A",
				"https://goo.gl/QE8nTs", "https://goo.gl/eNvoLc", "https://goo.gl/3Pmejy", "https://goo.gl/LvS0uD",
				"https://goo.gl/QPaOa4", "https://goo.gl/iaZobs", "https://goo.gl/Vjng7h", "https://goo.gl/nnWVTL",
				"https://goo.gl/aG9DKY", "https://goo.gl/YFDrld", "https://goo.gl/gk5BYF", "https://goo.gl/sLRi8e",
				"https://goo.gl/mLzJfK", "https://goo.gl/J8gqSV", "https://goo.gl/kTsvLY", "https://goo.gl/D2D2Rf",
				"https://goo.gl/R5nBOI", "https://goo.gl/tKZyJU", "https://goo.gl/5TWzeP", "https://goo.gl/G3Plv5",
				"https://goo.gl/cKHJOU", "https://goo.gl/p69t7L", "https://goo.gl/wmHqQw" };

		// create a List of all minerals
		for (int i = 0; i < 26; i++) {
			String title = titleArray[i];
			String description = descriptionArray[i];
			String type = typeArray[i];
			String mineralClassification = mineralClassificationArray[i];
			String chemicalFormula = chemicalFormulaArray[i];
			String streak = streakArray[i];
			String mohsHardness = mohsHardnessArray[i];
			String crystalSystem = crystalSystemArray[i];
			String color = colorArray[i];
			String luster = lusterArray[i];
			String fracture = fractureArray[i];
			String image = imageArray[i];
			String seenMinerals = null;
			String favoriteMinerals = null;

			Minerals mineral = new Minerals(title, description, type, mineralClassification, chemicalFormula, streak,
					mohsHardness, crystalSystem, color, luster, fracture, image, seenMinerals, favoriteMinerals, null);

			// add each mineral to the list
			mineralsList.add(mineral);
		}

		// return the list for usage in the Package
		return mineralsList;
	}
}
