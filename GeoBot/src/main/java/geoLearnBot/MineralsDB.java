package geoLearnBot;

import java.util.ArrayList;
import java.util.List;

public class MineralsDB {

	public static List<Minerals> main(String[] args) {
		// create an empty list to which we'll add the mineral attributes
		List<Minerals> mineralsList = new ArrayList<>();

		// all properties of the minerals arranged as individual arrays
		String[] titleArray = { "Biotite", "Zeolites", "Fluorite", "Colemanite", "Augite", "Barium", "Gold", "Diamond",
				"Graphite", "Silver", "Beryllium", "Corundum", "Gypsum", "Chlorite", "Aragonite", "Pyrite", "Calcite",
				"Autunite", "Aurichalcite", "Feldspar", "Asbestos", "Garnet", "Salt/Halite", "Quartz", "Kaolinite",
				"Talc" };
		String[] descriptionArray = {
				"Biotite is black magnesium/iron- based mica of low commercial value. It appears in the form of thin sheets which generally range from 0.003 mm to 0.1 mm in thickness.",
				"Zeolites are a group of silicate minerals with unusual properties with industrial importance.  They usually form beautiful well-formed crystals with pale colors, and are relatively soft and can be crushed and powdered. They are found in geologically young volcanic fields.  Most common zeolite minerals are analcime, chabazite, clinoptilite and mordenite. natrolite, analcime, chabazite, heulandite, phillipsite, and stilbite.  Zeolites appear in many different minerals, such as chabazite, natrolite.",
				"Fluorite is commercially named fluorspar composed of calcium fluoride (CaF2).  It is the principal source of fluorine. The same is used in production of hydrofluoric acid, which is used in a wide variety of industrial applications including glass etching. Fluorite tends to occur in well-formed isometric crystals, forming cubes and octahedrons. It also occurs in both massive and earthy forms, and as crusts or globular aggregates with radial fibrous texture.",
				"Colemanite is a hydrated calcium borate, an altered variation of borax. Over 200 minerals contain boron, but colemanite is one of only a few which is commercially important. It contains 50% B2O3. It forms at a lower pH and warmer temperature than other borates including ulexite.",
				"Augite is a rock-forming mineral of the pyroxene group commonly found within igneous and metamorphic rocks. Because its chemical structure is highly variable, augite might be considered by some to be its own group of minerals rather than an individual mineral. It is also known for its remarkable luster (shine off of a reflective surface).",
				"Barium (Ba) is obtained chiefly from the mineral barite. Barium is a soft, silvery, reactive metal. Because barium is so dense it is commonly used in some alloys, for example in spark plugs and ball bearings. As of 2013, China, India and Morocco were the world’s largest producers of barium. In the U.S, barite is mined primarily in Nevada and Georgia.",
				"Gold (element #79, symbol Au) is a heavy, shiny yellow metal.  It is probably the oldest precious metal known to man.  Wars have been fought over it and countless numbers have died trying to gain it or protect it.  Its physical and chemical properties make it ideal for a number of applications. It is used in dentistry and medicine, in jewelry and arts, in medallions and coins, in ingots as a store of value, for scientific and electronic instruments, and as an electrolyte in the electro-plating industry. South Africa has about half of the world’s gold resources. Significant quantities are also present in the U.S., Australia, Brazil, Canada, China, and Russia.",
				"Diamond is an extraordinary mineral with extreme hardness and inherent beauty that is sought for personal adornment and industrial use. Because the genesis of this unique mineral requires extreme temperature and pressure, natural diamond is so rare that some diamonds are the most valuable commodity on earth, based on weight.",
				"Pure graphite is a mineral form of the element carbon (element #6, symbol C).  It forms as veins and disseminations in metamorphic rocks as the result of the metamorphism of organic material included in limestone deposits.  It is an extremely soft mineral and it breaks into minute, flexible flakes that easily slide over one another.  This feature accounts for graphite’s distinctive greasy feel.  This greasy characteristic makes graphite a good lubricant. Because it is a solid material, it is known as a dry lubricant.  This is useful in applications where “wet” lubricants, such as oil, cannot be used.  Graphite is the only non-metal element that is a good conductor of electricity.  Natural graphite is used mostly in what are called refractory applications. Refractory applications are those that involve extremely high heat and therefore demand materials that will not melt or disintegrate under such extreme conditions. One example of this use is in the crucibles used in the steel industry. Such refractory applications account for the majority of the usage of graphite.",
				"Silver (Ag) has a bright, metallic luster, and when untarnished, has a white color. It is rarely found in its native form. Silver can be found combined with a number of different elements such as sulfur, arsenic, antimony or chlorine to form a variety of minerals and ores, such as argentite, chlorargyrite, and galena. It is also found in very small amounts in gold, lead, zinc and copper ores. Silver is malleable which means it can be hammered into thin sheets. It is also ductile, meaning it can be drawn into wire.",
				"Beryllium (Be) is a silver-white and very light metal. It has a very high melting point at 2349 °F (1287 °C).  It is found in nature primarily as bertrandite, which is mined in Utah, or as beryl. The combination of its light weight and high melting point makes it valuable for making metal alloys which are used in electronic and electrical components, aerospace, automobiles, computers, oil and gas drilling equipment, and telecommunications.",
				"Corundum is a crystalline form of aluminum oxide (Al2O3) with traces of iron, titanium and chromium. It is a rock-forming mineral. It is one of the naturally transparent materials, but can have different colors when impurities are present. Transparent specimens are used as gems such as sapphires rubies.",
				"Gypsum is found in nature in mineral and rock form.  It is a very soft mineral and it can form very pretty, and sometimes extremely large colored crystals.  As a rock, gypsum is a sedimentary rock, typically found in thick beds or layers.  It forms in lagoons where ocean waters high in calcium and sulfate content can slowly evaporate and be regularly replenished with new sources of water.  The result is the accumulation of large beds of sedimentary gypsum.  Gypsum is commonly associated with rock salt and sulfur deposits. It is processed and used as prefabricated wallboard or as industrial or building plaster, used in cement manufacture, agriculture and other uses.",
				"Chlorite is the name given to a group of minerals with a similar silicate lattice.  The chemical formulas of chlorites vary based on the combinations of the elements Zn, Li, Ca, Mg, Fe, Ni and Mn within.",
				"Aragonite is a carbonate mineral, one of the two common, naturally occurring polymorphs of calcium carbonate, CaCO3. The other polymorph is the mineral calcite. Aragonite’s crystal lattice differs from that of calcite, resulting in a different crystal shape, an orthorhombic system with acicular crystals. Repeated twinning results in pseudo-hexagonal forms.",
				"Commonly called fool’s gold, pyrite is the earth’s most abundant sulfide mineral. Recognized for its brass-yellow color which resembles that of gold, pyrite is a source of iron and sulfur and is used for the production of sulfuric acid.",
				"Calcite is the principal mineral of the rock group known as carbonates.  Calcite is a major component in limestone and dolomite.",
				"Autunite is a radioactive orthorhombic mineral which results from the hydrothermal alteration of uranium minerals.  Used as a uranium ore, it was first discovered in France in 1852.",
				"Aurichalcite is soft, monoclinic, copper and zinc bearing mineral. It forms a soft, scaly, greenish-blue crust in oxidized zones of copper-zinc ore deposits. It is considered to be a guide or indicator of zinc ore.",
				"Feldspar is the name given to a group of minerals distinguished by the presence of alumina and silica (SiO2) in their chemistry.  This group includes aluminum silicates of soda, potassium, or lime. It is the single most abundant mineral group on Earth.  They account for an estimated 60% of exposed rocks, as well as soils, clays, and other unconsolidated sediments, and are principal components in rock classification schemes. The minerals included in this group are the orthoclase, microcline and plagioclase feldspars.",
				"Asbestos is a commercial term that includes six regulated asbestiform silicate (silicon + oxygen) minerals. Because this group of silicate minerals can be readily separated into thin, strong fibers that are flexible, heat resistant, and chemically inert, asbestos minerals were once used in a wide variety of products. However, due to adverse health effects, the use of asbestos in the U.S. has been significantly decreased. In 2013, for example, the total amount used was only 950 tons, all of which was chrysotile, and was mined in Brazil. Many other countries still mine and use asbestos in insulation products due to less stringent health and safety regulations.",
				"Garnet is usually thought of as a gemstone but most garnet is mined for industrial uses. A very small number of garnets are pure and flawless enough to be cut as gemstones. The majority of garnet mining is for massive garnet that is crushed and used to make abrasives.  Garnet is a silicate mineral group; in other words, garnet’s complex chemical formula includes the silicate molecule (SiO4).  The different varieties of garnet have different metal ions, such as iron, aluminum, magnesium and chromium.  Some varieties also have calcium.",
				"Halite, commonly known as table salt or rock salt, is composed of sodium chloride (NaCl).  It is essential for life of humans and animals. Salt is used in food preparation across the globe.",
				"Quartz is one of the most common minerals in the Earth’s crust. As a mineral name, quartz refers to a specific chemical compound (silicon dioxide, or silica, SiO2), having a specific crystalline form (hexagonal). It is found is all forms of rock: igneous, metamorphic and sedimentary. Quartz is physically and chemically resistant to weathering. When quartz-bearing rocks become weathered and eroded, the grains of resistant quartz are concentrated in the soil, in rivers, and on beaches. The white sands typically found in river beds and on beaches are usually composed mainly of quartz, with some white or pink feldspar as well.",
				"Kaolinite is a layered silicate clay mineral which forms from the chemical weathering of feldspar or other aluminum silicate minerals. It is usually white, with occasionally a red color impurity due to iron oxide, or blue or brown from other minerals. Kaolinite has a low shrink–swell capacity and a low cation-exchange capacity, making it ideal for many industrial applications.",
				"The term talc refers both to the pure mineral and a wide variety of soft, talc-containing rocks that are mined and utilized for a variety of applications. Talc forms mica-like flakes. Talc is the softest mineral on the Mohs’ hardness scale at 1 and can be easily cut and crushed. Talc has perfect cleavage in one direction. This means that it breaks into thin sheets. As a result, it feels greasy to the touch (which is why talc is used as a lubricant)" };
		String[] typeArray = { "Mineral", "Mineral", "Mineral", "Mineral", "Mineral", "Mineral", "Element, Mineral",
				"Mineral", "Mineral", "Element, Mineral", "Mineral", "Mineral", "Mineral", "Mineral", "Mineral",
				"Mineral", "Mineral", "Mineral", "Mineral", "Mineral", "Mineral", "Mineral", "Mineral", "Mineral",
				"Mineral", "Mineral" };
		String[] mineralClassificationArray = { "Mica", "Silicate", "Halide", "Inoborates", "Pyroxene", "Sulfates",
				"Native", "Native element", "Native", "Native", "Silicate", "Hematite", "Sulfate", "Phyllosilicates",
				"Carbonate", "Sulfide", "Carbonate", "Autunite", "Carbonate", "Silicate", "Silicate", "Silicate",
				"Halide", "Silicate", "Phyllosilicates", "Silicate" };
		String[] chemicalFormulaArray = { "K(Mg,Fe)3(AlSi3O10)(F,OH)2", "(Ca,K2,Na2)2[Al2Si4O12]2·12H2O", "CaF2",
				"CaB3O4(OH)3·H2O", "8[(Ca,Na)(Mg,Fe,Al,Ti)(Si,Al)2O6]", "BaSO4", "Au", "C", "C", "Ag",
				"Be4Si2O7(OH)2 (bertrandite), Be3Al2(SiO3)6 (beryl)", "Al2O3", "CaSO4·2H2O", "Variable", "CaCO3",
				"FeS2", "CaCO3", "2[Ca(UO2)2(PO4)2·10-12H2O]", "4[(Zn,Cu)5(CO3)2(OH)6]",
				"KAlSi3O8 – NaAlSi3O8 – CaAl2Si2O8",
				"Mg3(Si2O5)(OH)4  - Chrysotile; Fe7Si8O22(OH)2 – Amosite; Na2Fe2+3Fe3+2Si8O22(OH)2 – Crocidolite; Ca2Mg5Si8O22(OH)2 – Tremolite asbestos; Ca2(Mg, Fe)5(Si8O22)(OH)2 – Actinolite asbestos; (Mg, Fe)7Si8O22(OH)2 – anthophyllite asbestos",
				"X3Y2(SiO4)3   (Where X is often Ca or Mg, and Y is often Al or Fe)", "NaCl", "SiO2", "Al2Si2O5(OH)4",
				"Mg3Si4O10(OH)2" };
		String[] streakArray = { "White", "white", "White", "White", "Light green to colorless", "White",
				"Shining yellow", "Colorless", "Black", "silver white", "White", "White", "White", "Green to gray",
				"White", "Black or Brown", "White", "Pale Yellow", "very light blue-green", "White", "White", "White",
				"White", "White", "White", "White, pearl black" };
		String[] mohsHardnessArray = { "2.5-3", "4-5", "4", "4.5", "5-6", "3-3.5", "2.5-3", "10", "1–2", "2.5-3",
				"6 – 7 (bertrandite), 7.5–8 (beryl)", "9.0", "1.5–2", "2-2.5", "3.5-4", "6-6.5", "3", "2-2.5", "2-2.5",
				"6-6.5", "2.5-3", "6.5-7.5", "2-2.5", "7", "2–2.5", "1" };
		String[] crystalSystemArray = { "Monoclinic", "triclinic", "Isometric", "Monoclinic", "Monoclinic",
				"Orthorhombic", "Isometric", "Isometric", "Hexagonal", "Isometric",
				"Orthorhombic (bertrandite), Hexagonal (beryl)", "Trigonal", "Monoclinic", "Monoclinic and triclinic",
				"Orthorhombic", "Isometric", "Hexagonal", "Tetragonal, Orthorhombic", "Monoclinic",
				"triclinic, monoclinic", "Monoclinic, Orthorhombic",
				"Isometric (meaning equality in dimension. For example, a cube, octahedron, or dodecahedron)",
				"Isometric", "trigonal", "Triclinic", "monoclinic, triclinic" };
		String[] colorArray = { "Black", "Colourless, white, yellow, pink, red",
				"Colorless. Samples are often deeply colored owing to impurities", "White, clear, colorless, gray",
				"Black, brown, greenish, violet-brown; in thin section, colorless to gray",
				"Colorless, white, light shades of blue, yellow, grey, brown", "Gold",
				"Typically yellow, brown or gray to colorless. Less often blue, green, black, translucent white, pink, violet, orange, purple and red.",
				"Iron-black to steel-gray; deep blue in transmitted light", "Silver",
				"Colorless to pale yellow( bertrandite); green, blue, yellow, colorless, pink and others (beryl)",
				"Variable; colorless, yellow, red, blue, violet, golden-brown &c.", "Colorless, white",
				"Green, rarely red, yellow or white", "White, red, yellow, orange, green, purple, grey, blue and brown",
				"golden brass-yellow", "Colorless or white, but may take on other colors due to impurities",
				"Yellow, greenish-yellow, pale green; dark green, greenish black", "blue-green and light-blue",
				"pink, white, gray, brown", "gray, white, blue, green",
				"Generally brown, virtually all colors, blue very rare",
				"Colorless or white; also blue, purple, red, pink, yellow, orange, or gray",
				"Pure quartz is clear. Color variance due to impurities: purple (amethyst), white (milky quartz), black (smoky quartz), pink (rose quartz) and yellow or orange (citrine)",
				"White, sometimes red, blue or brown tints from impurities", "White, brown, gray, greenish" };
		String[] lusterArray = { "Vitreous, may be pearly", "vitreous", "Vitreous", "Vitreous", "Vitreous and dull",
				"Vitreous, pearly", "Metallic", "Adamantine", "Metallic", "Metallic",
				"Vitreous, pearly (bertrandite), Vitreous, resinous (beryl)", "Adamantine, Vitreous, and/or Pearly",
				"Vitreous", "Vitreous, pearly, dull", "Vitreous, resinous on fracture surfaces", "Metallic",
				"Vitreous and also pearly along cleavage surfaces", "Sub-vitreous, resinous, waxy, pearly",
				"Pearly, silky", "Vitreous", "Silky", "Vitreous, resinous", "vitreous", "vitreous, waxy, dull",
				"Pearly to dull earthy", "Pearly" };
		String[] fractureArray = { "Micaceous", "irregular/uneven", "Subconchoidal, uneven", "Conchoidal",
				"Ranges from splintery to uneven", "Uneven", "Jagged", "Conchoidal", "Flaky", "Jagged", "Conchoidal",
				"Conchoidal", "Conchoidal", "Lamellar", "Subconchoidal", "Very uneven, conchoidal", "Conchoidal",
				"Micaceous", "Uneven", "conchoidal, uneven", "Fibrous", "Conchoidal, uneven", "conchoidal",
				"conchoidal", "Irregular/uneven, conchoidal, sub-conchoidal, micaceous", "uneven" };
		String[] imageArray = {
				"https://mineralseducationcoalition.org/wp-content/uploads/Colemanite_16620532-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Barium1_sulfate_138425783-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Autunite_173744783-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Calcite_crystalMineral_312933338-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Aragonite1_Crystals_148090799-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Kaolinite1_141265540-1-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Talc_380238223-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Gold1_90782147-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Quartz1_natural_222926188-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Beryllium_323719931-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/stock-photo-luxury-diamond-in-tweezers-closeup-with-dark-background-307889945-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Gypsum1_323719829-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Aurichalcite_364315322-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Augite_125449619-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Silver1_galena_16620550-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Chlorite_schist_299193245-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Corundum1_Rock_338930951-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Pyrite_147327494-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Salt_halite_307822916-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Graphite_56068858-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Garnet1-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Feldspar1_309985529-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Biotite-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Zeolite_136257968-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Asbestos1_Chrysotile1_297924608-150x150.jpg",
				"https://mineralseducationcoalition.org/wp-content/uploads/Flourite_364713614-150x150.jpg" };

		// create and return a List of all minerals
		for (int i = 0; i < 25; i++) {
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

			Minerals mineral = new Minerals(title, description, type, mineralClassification, chemicalFormula, streak,
					mohsHardness, crystalSystem, color, luster, fracture, image);

			mineralsList.add(mineral);
		}

		return mineralsList;

	}

}
