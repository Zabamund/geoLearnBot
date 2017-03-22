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

	// ====== Jackson objectMapper TEST ==========//
	// must: "Must define an explicit constructor"

	// ObjectMapper mapper = new ObjectMapper();
	// String jsonInString = //
//			// @formatter:off
//			"[{'TITLE':'Aurichalcite','DESCRIPTION':'Aurichalcite is soft, monoclinic, copper and zinc bearing mineral. It forms a soft, scaly, greenish-blue crust in oxidized zones of copper-zinc ore deposits. It is considered to be a guide or indicator of zinc ore.','TYPE':'Mineral','MINERALCLASSIFICATION':'Carbonate','CHEMICALFORMULA':'4[(Zn,Cu)5(CO3)2(OH)6]','STREAK':'very light blue-green','MOHSHARDNESS':'2-2.5','CRYSTALSYSTEM':'Monoclinic','COLOR':'blue-green and light-blue','LUSTER':'Pearly, silky','FRACTURE':'Uneven','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Aurichalcite_364315322.jpg'}]},{'TITLE':'Corundum','DESCRIPTION':'Corundum is a crystalline form of aluminum oxide (Al2O3) with traces of iron, titanium and chromium. It is a rock-forming mineral. It is one of the naturally transparent materials, but can have different colors when impurities are present. Transparent specimens are used as gems such as sapphires rubies.','TYPE':'Mineral','MINERALCLASSIFICATION':'Hematite','CHEMICALFORMULA':'Al2O3','STREAK':'White','MOHSHARDNESS':'9.0','CRYSTALSYSTEM':'Trigonal','COLOR':'Variable; colorless, yellow, red, blue, violet, golden-brown &c.','LUSTER':'Adamantine, Vitreous, and/or Pearly','FRACTURE':'Conchoidal','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Corundum1_Rock_338930951.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Corundum2_synthetic_163259849.jpg'}]},{'TITLE':'Augite','DESCRIPTION':'Augite is a rock-forming mineral of the pyroxene group commonly found within igneous and metamorphic rocks. Because its chemical structure is highly variable, augite might be considered by some to be its own group of minerals rather than an individual mineral. It is also known for its remarkable luster (shine off of a reflective surface).','TYPE':'Mineral','MINERALCLASSIFICATION':'Pyroxene','CHEMICALFORMULA':'8[(Ca,Na)(Mg,Fe,Al,Ti)(Si,Al)2O6]','STREAK':'Light green to colorless','MOHSHARDNESS':'5-6','CRYSTALSYSTEM':'Monoclinic','COLOR':'Black, brown, greenish, violet-brown; in thin section, colorless to gray','LUSTER':'Vitreous and dull','FRACTURE':'Ranges from splintery to uneven','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Augite_125449619.jpg'}]},{'TITLE':'Aragonite','DESCRIPTION':'Aragonite is a carbonate mineral, one of the two common, naturally occurring polymorphs of calcium carbonate, CaCO3. The other polymorph is the mineral calcite. Aragonite’s crystal lattice differs from that of calcite, resulting in a different crystal shape, an orthorhombic system with acicular crystals. Repeated twinning results in pseudo-hexagonal forms.','TYPE':'Mineral','MINERALCLASSIFICATION':'Carbonate','CHEMICALFORMULA':'CaCO3','STREAK':'White','MOHSHARDNESS':'3.5-4','CRYSTALSYSTEM':'Orthorhombic','COLOR':'White, red, yellow, orange, green, purple, grey, blue and brown','LUSTER':'Vitreous, resinous on fracture surfaces','FRACTURE':'Subconchoidal','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Aragonite1_Crystals_148090799.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Aragonite4_twinned_118886875.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Aragonite3_white_335479139.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Aragonite2_bluish_353601806.jpg'}]},{'TITLE':'Amphibole','DESCRIPTION':'Amphibolite is a dark, heavy, metamorphic rock composed mostly of the mineral amphibole. Amphibolites have very little to no quartz. “Amphibole” refers not to a single mineral, but to a group of minerals. Most belong to the monoclinic crystal system, but some belong to the orthorhombic crystal system. They are silicate minerals containing SiO4 molecules. The SiO4 groups are connected to each other in double chains.','TYPE':'Mineral','MINERALCLASSIFICATION':'Silicate','CHEMICALFORMULA':'Double chain SiO4 with other elements','STREAK':'','MOHSHARDNESS':'Generally dark black, sometimes brown','CRYSTALSYSTEM':'','COLOR':'','LUSTER':'','FRACTURE':'','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/amphibole_56068876.jpg'}]},{'TITLE':'Pyrite','DESCRIPTION':'Commonly called fool’s gold, pyrite is the earth’s most abundant sulfide mineral. Recognized for its brass-yellow color which resembles that of gold, pyrite is a source of iron and sulfur and is used for the production of sulfuric acid.','TYPE':'Mineral','MINERALCLASSIFICATION':'Sulfide','CHEMICALFORMULA':'FeS2','STREAK':'Black or Brown','MOHSHARDNESS':'6-6.5','CRYSTALSYSTEM':'Isometric','COLOR':'golden brass-yellow','LUSTER':'Metallic','FRACTURE':'Very uneven, conchoidal','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Pyrite_147327494.jpg'}]},{'TITLE':'Quartz','DESCRIPTION':'Quartz is one of the most common minerals in the Earth’s crust. As a mineral name, quartz refers to a specific chemical compound (silicon dioxide, or silica, SiO2), having a specific crystalline form (hexagonal). It is found is all forms of rock: igneous, metamorphic and sedimentary. Quartz is physically and chemically resistant to weathering. When quartz-bearing rocks become weathered and eroded, the grains of resistant quartz are concentrated in the soil, in rivers, and on beaches. The white sands typically found in river beds and on beaches are usually composed mainly of quartz, with some white or pink feldspar as well.','TYPE':'Mineral','MINERALCLASSIFICATION':'Silicate','CHEMICALFORMULA':'SiO2','STREAK':'White','MOHSHARDNESS':'7','CRYSTALSYSTEM':'trigonal','COLOR':'Pure quartz is clear. Color variance due to impurities: purple (amethyst), white (milky quartz), black (smoky quartz), pink (rose quartz) and yellow or orange (citrine)','LUSTER':'vitreous, waxy, dull','FRACTURE':'conchoidal','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Quartz1_natural_222926188.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Quartz2_rose_135992198.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Quartz3_crystal_71173609.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Quartzite_299251520.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Rutile2_quartz_152900741.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Silica_quartzite_368487638.jpg'}]},{'TITLE':'Gypsum','DESCRIPTION':'Gypsum is found in nature in mineral and rock form.  It is a very soft mineral and it can form very pretty, and sometimes extremely large colored crystals.  As a rock, gypsum is a sedimentary rock, typically found in thick beds or layers.  It forms in lagoons where ocean waters high in calcium and sulfate content can slowly evaporate and be regularly replenished with new sources of water.  The result is the accumulation of large beds of sedimentary gypsum.  Gypsum is commonly associated with rock salt and sulfur deposits. It is processed and used as prefabricated wallboard or as industrial or building plaster, used in cement manufacture, agriculture and other uses.','TYPE':'Mineral','MINERALCLASSIFICATION':'Sulfate','CHEMICALFORMULA':'CaSO4·2H2O','STREAK':'White','MOHSHARDNESS':'1.5–2','CRYSTALSYSTEM':'Monoclinic','COLOR':'Colorless, white','LUSTER':'Vitreous','FRACTURE':'Conchoidal','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Gypsum1_323719829.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Gypsum2_crystal_175034276.jpg'}]},{'TITLE':'Beryllium','DESCRIPTION':'Beryllium (Be) is a silver-white and very light metal. It has a very high melting point at 2349 °F (1287 °C).  It is found in nature primarily as bertrandite, which is mined in Utah, or as beryl. The combination of its light weight and high melting point makes it valuable for making metal alloys which are used in electronic and electrical components, aerospace, automobiles, computers, oil and gas drilling equipment, and telecommunications.','TYPE':'Mineral','MINERALCLASSIFICATION':'Silicate','CHEMICALFORMULA':'Be4Si2O7(OH)2 (bertrandite), Be3Al2(SiO3)6 (beryl)','STREAK':'White','MOHSHARDNESS':'6 – 7 (bertrandite), 7.5–8 (beryl)','CRYSTALSYSTEM':'Orthorhombic (bertrandite), Hexagonal (beryl)','COLOR':'Colorless to pale yellow( bertrandite); green, blue, yellow, colorless, pink and others (beryl)','LUSTER':'Vitreous, pearly (bertrandite), Vitreous, resinous (beryl)','FRACTURE':'Conchoidal','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Beryllium_323719931.jpg'}]},{'TITLE':'Diamond','DESCRIPTION':'Diamond is an extraordinary mineral with extreme hardness and inherent beauty that is sought for personal adornment and industrial use. Because the genesis of this unique mineral requires extreme temperature and pressure, natural diamond is so rare that some diamonds are the most valuable commodity on earth, based on weight.','TYPE':'Mineral','MINERALCLASSIFICATION':'Native element','CHEMICALFORMULA':'C','STREAK':'Colorless','MOHSHARDNESS':'10','CRYSTALSYSTEM':'Isometric','COLOR':'Typically yellow, brown or gray to colorless. Less often blue, green, black, translucent white, pink, violet, orange, purple and red.','LUSTER':'Adamantine','FRACTURE':'Conchoidal','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/stock-photo-luxury-diamond-in-tweezers-closeup-with-dark-background-307889945.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/diamonds-shutterstock_65189905.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Diamonds_110377613.jpg'}]},{'TITLE':'Fluorite','DESCRIPTION':'Fluorite is commercially named fluorspar composed of calcium fluoride (CaF2).  It is the principal source of fluorine. The same is used in production of hydrofluoric acid, which is used in a wide variety of industrial applications including glass etching. Fluorite tends to occur in well-formed isometric crystals, forming cubes and octahedrons. It also occurs in both massive and earthy forms, and as crusts or globular aggregates with radial fibrous texture.','TYPE':'Mineral','MINERALCLASSIFICATION':'Halide','CHEMICALFORMULA':'CaF2','STREAK':'White','MOHSHARDNESS':'4','CRYSTALSYSTEM':'Isometric','COLOR':'Colorless. Samples are often deeply colored owing to impurities','LUSTER':'Vitreous','FRACTURE':'Subconchoidal, uneven','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Flourite_364713614.jpg'}]},{'TITLE':'Feldspar','DESCRIPTION':'Feldspar is the name given to a group of minerals distinguished by the presence of alumina and silica (SiO2) in their chemistry.  This group includes aluminum silicates of soda, potassium, or lime. It is the single most abundant mineral group on Earth.  They account for an estimated 60% of exposed rocks, as well as soils, clays, and other unconsolidated sediments, and are principal components in rock classification schemes. The minerals included in this group are the orthoclase, microcline and plagioclase feldspars.','TYPE':'Mineral','MINERALCLASSIFICATION':'Silicate','CHEMICALFORMULA':'KAlSi3O8 – NaAlSi3O8 – CaAl2Si2O8','STREAK':'White','MOHSHARDNESS':'6-6.5','CRYSTALSYSTEM':'triclinic, monoclinic','COLOR':'pink, white, gray, brown','LUSTER':'Vitreous','FRACTURE':'conchoidal, uneven','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Feldspar1_309985529.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Feldspar2_353331161.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Plagioclase_feldspar_299193167.jpg'}]},{'TITLE':'Gold','DESCRIPTION':'Gold (element #79, symbol Au) is a heavy, shiny yellow metal.  It is probably the oldest precious metal known to man.  Wars have been fought over it and countless numbers have died trying to gain it or protect it.  Its physical and chemical properties make it ideal for a number of applications. It is used in dentistry and medicine, in jewelry and arts, in medallions and coins, in ingots as a store of value, for scientific and electronic instruments, and as an electrolyte in the electro-plating industry. South Africa has about half of the world’s gold resources. Significant quantities are also present in the U.S., Australia, Brazil, Canada, China, and Russia.','TYPE':'Element, Mineral','MINERALCLASSIFICATION':'Native','CHEMICALFORMULA':'Au','STREAK':'Shining yellow','MOHSHARDNESS':'2.5-3','CRYSTALSYSTEM':'Isometric','COLOR':'Gold','LUSTER':'Metallic','FRACTURE':'Jagged','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Gold1_90782147.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Gold2_Fools_83610928.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Gold3_ore_59934967.jpg'}]},{'TITLE':'Graphite','DESCRIPTION':'Pure graphite is a mineral form of the element carbon (element #6, symbol C).  It forms as veins and disseminations in metamorphic rocks as the result of the metamorphism of organic material included in limestone deposits.  It is an extremely soft mineral and it breaks into minute, flexible flakes that easily slide over one another.  This feature accounts for graphite’s distinctive greasy feel.  This greasy characteristic makes graphite a good lubricant. Because it is a solid material, it is known as a dry lubricant.  This is useful in applications where “wet” lubricants, such as oil, cannot be used.  Graphite is the only non-metal element that is a good conductor of electricity.  Natural graphite is used mostly in what are called refractory applications. Refractory applications are those that involve extremely high heat and therefore demand materials that will not melt or disintegrate under such extreme conditions. One example of this use is in the crucibles used in the steel industry. Such refractory applications account for the majority of the usage of graphite.','TYPE':'Mineral','MINERALCLASSIFICATION':'Native','CHEMICALFORMULA':'C','STREAK':'Black','MOHSHARDNESS':'1–2','CRYSTALSYSTEM':'Hexagonal','COLOR':'Iron-black to steel-gray; deep blue in transmitted light','LUSTER':'Metallic','FRACTURE':'Flaky','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Graphite_56068858.jpg'}]},{'TITLE':'Colemanite','DESCRIPTION':'Colemanite is a hydrated calcium borate, an altered variation of borax. Over 200 minerals contain boron, but colemanite is one of only a few which is commercially important. It contains 50% B2O3. It forms at a lower pH and warmer temperature than other borates including ulexite.','TYPE':'Mineral','MINERALCLASSIFICATION':'Inoborates','CHEMICALFORMULA':'CaB3O4(OH)3·H2O','STREAK':'White','MOHSHARDNESS':'4.5','CRYSTALSYSTEM':'Monoclinic','COLOR':'White, clear, colorless, gray','LUSTER':'Vitreous','FRACTURE':'Conchoidal','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Colemanite_16620532.jpg'}]},{'TITLE':'Autunite','DESCRIPTION':'Autunite is a radioactive orthorhombic mineral which results from the hydrothermal alteration of uranium minerals.  Used as a uranium ore, it was first discovered in France in 1852.','TYPE':'Mineral','MINERALCLASSIFICATION':'Autunite','CHEMICALFORMULA':'2[Ca(UO2)2(PO4)2·10-12H2O]','STREAK':'Pale Yellow','MOHSHARDNESS':'2-2.5','CRYSTALSYSTEM':'Tetragonal, Orthorhombic','COLOR':'Yellow, greenish-yellow, pale green; dark green, greenish black','LUSTER':'Sub-vitreous, resinous, waxy, pearly','FRACTURE':'Micaceous','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Autunite_173744783.jpg'}]},{'TITLE':'Mica','DESCRIPTION':'Mica is a mineral name given to a group of minerals that are physically and chemically similar.  They are all silicate minerals, known as sheet silicates because they form in distinct layers.  Micas are fairly light and relatively soft, and the sheets and flakes of mica are flexible. Mica is heat-resistant and does not conduct electricity.  There are 37 different mica minerals. The most common include: purple lepidolite, black biotite, brown phlogopite and clear muscovite.','TYPE':'Mineral','MINERALCLASSIFICATION':'Silicate','CHEMICALFORMULA':'Lepidolite K(Li,Al)3(AlSi3O10) (O,OH, F)2, ; biotite K(Mg, Fe)3(AlSi3O10) (OH)2; phlogopite KMg3(AlSi3O10) (OH)2; muscovite KAl2(AlSi3O10)(OH)2','STREAK':'2.5-4 (lepidolite); 2.5-3 biotite; 2.5-3 phlogopite; 2-2.5 muscovite','MOHSHARDNESS':'Monoclinic','CRYSTALSYSTEM':'','COLOR':'','LUSTER':'','FRACTURE':'','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/shutterstock_409776232MICA.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Mica_muscovite_146725199.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Mica_phlogopite_22836937.jpg'}]},{'TITLE':'Garnet','DESCRIPTION':'Garnet is usually thought of as a gemstone but most garnet is mined for industrial uses. A very small number of garnets are pure and flawless enough to be cut as gemstones. The majority of garnet mining is for massive garnet that is crushed and used to make abrasives.  Garnet is a silicate mineral group; in other words, garnet’s complex chemical formula includes the silicate molecule (SiO4).  The different varieties of garnet have different metal ions, such as iron, aluminum, magnesium and chromium.  Some varieties also have calcium.','TYPE':'Mineral','MINERALCLASSIFICATION':'Silicate','CHEMICALFORMULA':'X3Y2(SiO4)3   (Where X is often Ca or Mg, and Y is often Al or Fe)','STREAK':'White','MOHSHARDNESS':'6.5-7.5','CRYSTALSYSTEM':'Isometric (meaning equality in dimension. For example, a cube, octahedron, or dodecahedron)','COLOR':'Generally brown, virtually all colors, blue very rare','LUSTER':'Vitreous, resinous','FRACTURE':'Conchoidal, uneven','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Garnet1.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Garnet2_crystal_107397215.jpg'}]},{'TITLE':'Galena','DESCRIPTION':'Galena is a gray, cubic, shiny, dense mineral most commonly associated with lead.  It is one of the earliest minerals used by mankind, and one of the most abundant sulfide minerals on the Earth.','TYPE':'Mineral','MINERALCLASSIFICATION':'Sulfide','CHEMICALFORMULA':'Gray','STREAK':'2.5-2.75','MOHSHARDNESS':'PbS','CRYSTALSYSTEM':'','COLOR':'','LUSTER':'Subconchoidal','FRACTURE':'','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Cadmimum_galenaORE_358695236.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Galena_335479169.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Lead_galenaORE_312950666.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Silver1_galena_16620550.jpg'}]},{'TITLE':'Biotite','DESCRIPTION':'Biotite is black magnesium/iron- based mica of low commercial value. It appears in the form of thin sheets which generally range from 0.003 mm to 0.1 mm in thickness.','TYPE':'Mineral','MINERALCLASSIFICATION':'Mica','CHEMICALFORMULA':'K(Mg,Fe)3(AlSi3O10)(F,OH)2','STREAK':'White','MOHSHARDNESS':'2.5-3','CRYSTALSYSTEM':'Monoclinic','COLOR':'Black','LUSTER':'Vitreous, may be pearly','FRACTURE':'Micaceous','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Biotite.jpg'}]},{'TITLE':'Chlorite','DESCRIPTION':'Chlorite is the name given to a group of minerals with a similar silicate lattice.  The chemical formulas of chlorites vary based on the combinations of the elements Zn, Li, Ca, Mg, Fe, Ni and Mn within.','TYPE':'Mineral','MINERALCLASSIFICATION':'Phyllosilicates','CHEMICALFORMULA':'Variable','STREAK':'Green to gray','MOHSHARDNESS':'2-2.5','CRYSTALSYSTEM':'Monoclinic and triclinic','COLOR':'Green, rarely red, yellow or white','LUSTER':'Vitreous, pearly, dull','FRACTURE':'Lamellar','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Chlorite_schist_299193245.jpg'}]},{'TITLE':'Kaolinite','DESCRIPTION':'Kaolinite is a layered silicate clay mineral which forms from the chemical weathering of feldspar or other aluminum silicate minerals. It is usually white, with occasionally a red color impurity due to iron oxide, or blue or brown from other minerals. Kaolinite has a low shrink–swell capacity and a low cation-exchange capacity, making it ideal for many industrial applications.','TYPE':'Mineral','MINERALCLASSIFICATION':'Phyllosilicates','CHEMICALFORMULA':'Al2Si2O5(OH)4','STREAK':'White','MOHSHARDNESS':'2–2.5','CRYSTALSYSTEM':'Triclinic','COLOR':'White, sometimes red, blue or brown tints from impurities','LUSTER':'Pearly to dull earthy','FRACTURE':'Irregular/uneven, conchoidal, sub-conchoidal, micaceous','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Kaolinite1_141265540-1.jpg'}]},{'TITLE':'Salt/Halite','DESCRIPTION':'Halite, commonly known as table salt or rock salt, is composed of sodium chloride (NaCl).  It is essential for life of humans and animals. Salt is used in food preparation across the globe.','TYPE':'Mineral','MINERALCLASSIFICATION':'Halide','CHEMICALFORMULA':'NaCl','STREAK':'White','MOHSHARDNESS':'2-2.5','CRYSTALSYSTEM':'Isometric','COLOR':'Colorless or white; also blue, purple, red, pink, yellow, orange, or gray','LUSTER':'vitreous','FRACTURE':'conchoidal','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Salt_halite_307822916.jpg'}]},{'TITLE':'Zeolites','DESCRIPTION':'Zeolites are a group of silicate minerals with unusual properties with industrial importance.  They usually form beautiful well-formed crystals with pale colors, and are relatively soft and can be crushed and powdered. They are found in geologically young volcanic fields.  Most common zeolite minerals are analcime, chabazite, clinoptilite and mordenite. natrolite, analcime, chabazite, heulandite, phillipsite, and stilbite.  Zeolites appear in many different minerals, such as chabazite, natrolite.','TYPE':'Mineral','MINERALCLASSIFICATION':'Silicate','CHEMICALFORMULA':'(Ca,K2,Na2)2[Al2Si4O12]2·12H2O','STREAK':'white','MOHSHARDNESS':'4-5','CRYSTALSYSTEM':'triclinic','COLOR':'Colourless, white, yellow, pink, red','LUSTER':'vitreous','FRACTURE':'irregular/uneven','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Zeolite_136257968.jpg'}]},{'TITLE':'Calcite','DESCRIPTION':'Calcite is the principal mineral of the rock group known as carbonates.  Calcite is a major component in limestone and dolomite.','TYPE':'Mineral','MINERALCLASSIFICATION':'Carbonate','CHEMICALFORMULA':'CaCO3','STREAK':'White','MOHSHARDNESS':'3','CRYSTALSYSTEM':'Hexagonal','COLOR':'Colorless or white, but may take on other colors due to impurities','LUSTER':'Vitreous and also pearly along cleavage surfaces','FRACTURE':'Conchoidal','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Calcite_crystalMineral_312933338.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Calcite_WhiteMineral_366329153.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/shutterstock_354451748CALCITE.jpg'}]},{'TITLE':'Silver','DESCRIPTION':'Silver (Ag) has a bright, metallic luster, and when untarnished, has a white color. It is rarely found in its native form. Silver can be found combined with a number of different elements such as sulfur, arsenic, antimony or chlorine to form a variety of minerals and ores, such as argentite, chlorargyrite, and galena. It is also found in very small amounts in gold, lead, zinc and copper ores. Silver is malleable which means it can be hammered into thin sheets. It is also ductile, meaning it can be drawn into wire.','TYPE':'Element, Mineral','MINERALCLASSIFICATION':'Native','CHEMICALFORMULA':'Ag','STREAK':'silver white','MOHSHARDNESS':'2.5-3','CRYSTALSYSTEM':'Isometric','COLOR':'Silver','LUSTER':'Metallic','FRACTURE':'Jagged','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Silver1_galena_16620550.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Silver2_Native_337176206.jpg'}]},{'TITLE':'Asbestos','DESCRIPTION':'Asbestos is a commercial term that includes six regulated asbestiform silicate (silicon + oxygen) minerals. Because this group of silicate minerals can be readily separated into thin, strong fibers that are flexible, heat resistant, and chemically inert, asbestos minerals were once used in a wide variety of products. However, due to adverse health effects, the use of asbestos in the U.S. has been significantly decreased. In 2013, for example, the total amount used was only 950 tons, all of which was chrysotile, and was mined in Brazil. Many other countries still mine and use asbestos in insulation products due to less stringent health and safety regulations.','TYPE':'Mineral','MINERALCLASSIFICATION':'Silicate','CHEMICALFORMULA':'Mg3(Si2O5)(OH)4  - Chrysotile; Fe7Si8O22(OH)2 – Amosite; Na2Fe2+3Fe3+2Si8O22(OH)2 – Crocidolite; Ca2Mg5Si8O22(OH)2 – Tremolite asbestos; Ca2(Mg, Fe)5(Si8O22)(OH)2 – Actinolite asbestos; (Mg, Fe)7Si8O22(OH)2 – anthophyllite asbestos','STREAK':'White','MOHSHARDNESS':'2.5-3','CRYSTALSYSTEM':'Monoclinic, Orthorhombic','COLOR':'gray, white, blue, green','LUSTER':'Silky','FRACTURE':'Fibrous','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Asbestos1_Chrysotile1_297924608.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Asbestos2_chrysotile2_128998904.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Asbestos2_mineral_349469567.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Asbestos5_Actinolite_193131896.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Asbestos6_anthophyllite_131088743.jpg'}]},{'TITLE':'Barium','DESCRIPTION':'Barium (Ba) is obtained chiefly from the mineral barite. Barium is a soft, silvery, reactive metal. Because barium is so dense it is commonly used in some alloys, for example in spark plugs and ball bearings. As of 2013, China, India and Morocco were the world’s largest producers of barium. In the U.S, barite is mined primarily in Nevada and Georgia.','TYPE':'Mineral','MINERALCLASSIFICATION':'Sulfates','CHEMICALFORMULA':'BaSO4','STREAK':'White','MOHSHARDNESS':'3-3.5','CRYSTALSYSTEM':'Orthorhombic','COLOR':'Colorless, white, light shades of blue, yellow, grey, brown','LUSTER':'Vitreous, pearly','FRACTURE':'Uneven','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Barium1_sulfate_138425783.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Barium2_Barite_365581607.jpg'}]},{'TITLE':'Talc','DESCRIPTION':'The term talc refers both to the pure mineral and a wide variety of soft, talc-containing rocks that are mined and utilized for a variety of applications. Talc forms mica-like flakes. Talc is the softest mineral on the Mohs’ hardness scale at 1 and can be easily cut and crushed. Talc has perfect cleavage in one direction. This means that it breaks into thin sheets. As a result, it feels greasy to the touch (which is why talc is used as a lubricant)','TYPE':'Mineral','MINERALCLASSIFICATION':'Silicate','CHEMICALFORMULA':'Mg3Si4O10(OH)2','STREAK':'White, pearl black','MOHSHARDNESS':'1','CRYSTALSYSTEM':'monoclinic, triclinic','COLOR':'White, brown, gray, greenish','LUSTER':'Pearly','FRACTURE':'uneven','IMAGE':[{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/Talc_380238223.jpg'},{'urlLarge':'https://mineralseducationcoalition.org/wp-content/uploads/shutterstock_144775801TALC.jpg'}]}]";
//			// @formatter:on
	//
	// Minerals() {
	// super();
	// try {
	// @SuppressWarnings("unused")
	// Minerals mineral = mapper.readValue(jsonInString, Minerals.class);
	// } catch (Exception e) {
	// throw new RuntimeException(e);
	// }
	// }

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

}
