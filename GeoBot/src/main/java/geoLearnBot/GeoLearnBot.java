package geoLearnBot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class GeoLearnBot extends TelegramLongPollingBot {

	@Override
	public String getBotUsername() {
		return "geoLearnBot";
	}

	@Override
	public String getBotToken() {
		return "342030854:AAHbYQhXVEMNUQ7Pr2RlAT3D0ujWV8D9ztg";
	}

	// List<Minerals> mineralsList = FetchMinerals.fetchMinerals();

	@Override
	public void onUpdateReceived(Update update) {
		// check if the update has a message and the message has text
		if (update.hasMessage() && update.getMessage().hasText()) {

			// /start || 1
			if (update.getMessage().getText().equals("/start") || update.getMessage().getText().equals("1")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId()).setText(
						// @formatter:off
								"*You can discover this Bot by picking a number or with the /menu to the right of your text input*"
								+ "\n\n*1*. Show start menu"
								+ "\n*2*. Need help ?"
								+ "\n*3*. Learn about some minerals"
								+ "\n*4*. Play ! (sorry, nothing here yet...)"
								+ "\n*5*. Acknowledgments"
								+ "\n*6*. Glossary")
								// @formatter:on
						.enableMarkdown(true);
				try {
					sendMessage(message); // Call method to send message
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// /help || 2
			if (update.getMessage().getText().equals("/help") || update.getMessage().getText().equals("2")) {
				String winky = "\ud83d\ude09";
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						.setText(
						// @formatter:off
								"*Here is what this bot can do:*"
								+ "\n\nType \"/\" for main options (start, help, learn, quiz, acknowledgments or glossary)"
								+ "\nOnce inside the main options use 1, 2, 3, 4, 5 and 6 to navigate the bot, have fun !"
								+ "\n\n*Errors:* if you keep asking for more minerals and they're not coming, well...why "
								+ "don't you read the text and wait a little " + winky + " ?")
								// @formatter:on
						.enableMarkdown(true);
				try {
					sendMessage(message); // Call method to send message
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// /learn || 3
			if (update.getMessage().getText().equals("/learn") || update.getMessage().getText().equals("3")) {

				// fetch list of minerals
				List<Minerals> mineralsList = FetchMinerals.fetchMinerals();
				Long chatId = update.getMessage().getChatId();
				List<Minerals> seenArray = new ArrayList<>();
				List<Minerals> favoriteArray = new ArrayList<>();

				// pick random element in the array
				int random = new Random().nextInt(mineralsList.size());
				// check if element is in seenArray
				// if not, add to seen array AND pass to mineralToDisplay
				// yes, pick new random
				if (seenArray.contains(random) == false) {
					seenArray.add(random);
					System.out.println("seenArray: " + seenArray);
				}

				int mineralToDisplay = random;

				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						.setText(
								// @formatter:off
								mineralsList.get(mineralToDisplay).toString())						
								// @formatter:on
						.enableHtml(true);
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}

			// /Play || 4
			if (update.getMessage().getText().equals("/quiz") || update.getMessage().getText().equals("4")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// .setReplyMarkup(ReplyKeyboardMarkup)
						.setText(
								// @formatter:off
								"*Booo ! nothing here yet :-(*")						
								// @formatter:on
						.enableMarkdown(true);
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}

			// /acknowledgments || 5
			if (update.getMessage().getText().equals("/acknowledgements")
					|| update.getMessage().getText().equals("5")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId()).setText(
						// @formatter:off
								"*geoLearnBot Acknowledges and Credits*"
								+ "\n*The Minerals Education Coalition*"
								+ "\n*for all the geological data displayed inside this bot*"
								+ "\n\nThe original material is available at [https://mineralseducationcoalition.org]"
								+ "\nThe Reprint Policy of the Minerals Education Coalition is available at"
								+ " [https://mineralseducationcoalition.org/reprint-policy/]"
								+ "\n\nAdditionally geoLearnBot states that:"
								+ "\nThis bot is in no way affiliated or partnered with nor sponsored by the Minerals Education Coalition")
								// @formatter:on
						.enableMarkdown(true);
				try {
					sendMessage(message); // Call method to send message
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// /Glossary || 6
			if (update.getMessage().getText().equals("/glossary") || update.getMessage().getText().equals("6")) {

				KeyboardRow keyboardRowUpper = new KeyboardRow();
				keyboardRowUpper.add(0, "Mineral Classification");
				keyboardRowUpper.add(1, "Streak");
				keyboardRowUpper.add(2, "Mohs Hardness");

				KeyboardRow keyboardRowLower = new KeyboardRow();
				keyboardRowLower.add(0, "Crystal System");
				keyboardRowLower.add(1, "Luster");
				keyboardRowLower.add(2, "Fracture");

				List<KeyboardRow> keyboard = new ArrayList<>();
				keyboard.add(keyboardRowUpper);
				keyboard.add(keyboardRowLower);

				ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
				replyMarkup.setKeyboard(keyboard).setOneTimeKeyboad(true);

				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"*So you need to learn about some of the terms I use when showing you minerals ?*"
								+ "\nThat's totally cool, I'm all about teaching so just click on the button you want to learn about !")						
						.enableMarkdown(true)
						.setReplyMarkup(replyMarkup);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}

			// /Mineral Classification
			if (update.getMessage().getText().equals("Mineral Classification")) {

				KeyboardRow keyboardRowUpper = new KeyboardRow();
				keyboardRowUpper.add(0, "Carbonate");
				keyboardRowUpper.add(1, "Halide");
				keyboardRowUpper.add(2, "Native");
				keyboardRowUpper.add(3, "Phyllosilicate");

				KeyboardRow keyboardRowLower = new KeyboardRow();
				keyboardRowLower.add(0, "Pyroxene");
				keyboardRowLower.add(1, "Silicate");
				keyboardRowLower.add(2, "Sulfate");
				keyboardRowLower.add(3, "Sulfide");

				List<KeyboardRow> keyboard = new ArrayList<>();
				keyboard.add(keyboardRowUpper);
				keyboard.add(keyboardRowLower);

				ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
				replyMarkup.setKeyboard(keyboard).setOneTimeKeyboad(true);

				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"Ok, which term do you want to learn about ?")
						.enableMarkdown(true)
						.setReplyMarkup(replyMarkup);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// /Carbonate
			if (update.getMessage().getText().equals("Carbonate")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"Carbonate minerals are those minerals containing the carbonate ion: CO3\n_Source: Wikipedia_")
						.enableMarkdown(true);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}

			// /Halide
			if (update.getMessage().getText().equals("Halide")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"The halide mineral class include those minerals with a dominant halide anion (F−, Cl−, Br− and I−)."
								+ "\nComplex halide minerals may also have polyatomic anions in addition to or that include halides."
								+ "\n_Source: Wikipedia_")
						.enableMarkdown(true);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}

			// /Native
			if (update.getMessage().getText().equals("Native")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"Native element minerals are those elements that occur in nature in uncombined form with a "
								+ "distinct mineral structure."
								+ " The elemental class includes metals and intermetallic elements, naturally occurring alloys,"
								+ " semi-metals and non-metals."
								+ "\n_Source: Wikipedia_")
						.enableMarkdown(true);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}

			// /Phyllosilicate
			if (update.getMessage().getText().equals("Phyllosilicate")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"Phyllosilicates are sheet Silicate minerals, formed by parallel sheets of silicate tetrahedra with "
								+ "Si2O5 or a 2:5 ratio."
								+ "\n_Source: Wikipedia_")
						.enableMarkdown(true);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}

			// /Pyroxene
			if (update.getMessage().getText().equals("Pyroxene")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"The pyroxenes (commonly abbreviated to Px) are a group of important rock-forming inosilicate minerals"
								+ " found in many igneous and metamorphic rocks. Pyroxenes are silicon-aluminum oxides with Ca, Na, Fe,"
								+ " Mg, Zn, Mn, Li substituting for Si and Al."
								+ "\n_Source: Wikipedia_")
						.enableMarkdown(true);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}

			// /Silicate
			if (update.getMessage().getText().equals("Silicate")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"Silicate minerals are rock-forming minerals made up of silicate groups. They are the largest"
								+ " and most important class of rock-forming minerals and make up approximately 90 percent of"
								+ " the Earth's crust. They are classified based on the structure of their silicate groups,"
								+ " which contain different ratios of silicon and oxygen."
								+ "\n_Source: Wikipedia_")
						.enableMarkdown(true);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}

			// /Sulfate
			if (update.getMessage().getText().equals("Sulfate")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"The sulfate minerals are a class of minerals which include the sulfate ion (SO42−) within"
								+ " their structure. The sulfate minerals occur commonly in primary evaporite depositional"
								+ " environments, as gangue minerals in hydrothermal veins and as secondary minerals in the"
								+ " oxidizing zone of sulfide mineral deposits."
								+ "\n_Source: Wikipedia_")
						.enableMarkdown(true);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}

			// /Sulfide
			if (update.getMessage().getText().equals("Sulfide")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"The sulfide minerals are a class of minerals containing sulfide (S2−) as the major anion."
								+ " Some sulfide minerals are economically important as metal ores. "
								+ "\n_Source: Wikipedia_")
						.enableMarkdown(true);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}

			// /Streak
			if (update.getMessage().getText().equals("Streak")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"The streak (also called \"powder color\") of a mineral is the color of the powder produced"
								+ " when it is dragged across an un-weathered surface. Unlike the apparent color of a mineral,"
								+ " which for most minerals can vary considerably, the trail of finely ground powder generally"
								+ " has a more consistent characteristic color, and is thus an important diagnostic tool in"
								+ " mineral identification. If no streak seems to be made, the mineral's streak is said to be "
								+ "white or colorless. Streak is particularly important as a diagnostic for opaque and colored "
								+ "materials. It is less useful for silicate minerals, most of which have a white streak or are"
								+ " too hard to powder easily."
								+ "\n_Source: Wikipedia_")
						.enableMarkdown(true);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// /Mohs Hardness
			if (update.getMessage().getText().equals("Mohs Hardness")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"The Mohs scale of mineral hardness is a qualitative ordinal scale characterizing scratch "
								+ "resistance of various minerals through the ability of harder material to scratch softer"
								+ " material."
								+ "\n_Source: Wikipedia_")
						.enableMarkdown(true);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// /Crystal System
			if (update.getMessage().getText().equals("Crystal System")) {

				KeyboardRow keyboardRowUpper = new KeyboardRow();
				keyboardRowUpper.add(0, "Triclinic");
				keyboardRowUpper.add(1, "Monoclinic");
				keyboardRowUpper.add(2, "Orthorhombic");
				keyboardRowUpper.add(3, "Tetragonal");

				KeyboardRow keyboardRowLower = new KeyboardRow();
				keyboardRowLower.add(0, "Hexagonal");
				keyboardRowLower.add(1, "Trigonal");
				keyboardRowLower.add(2, "Isometric");

				List<KeyboardRow> keyboard = new ArrayList<>();
				keyboard.add(keyboardRowUpper);
				keyboard.add(keyboardRowLower);

				ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
				replyMarkup.setKeyboard(keyboard).setOneTimeKeyboad(true);

				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"In crystallography, the terms crystal system, crystal family and lattice system"
								+ " each refer to one of several classes of space groups, lattices, point groups"
								+ " or crystals."
								+ "\n_Source: Wikipedia_")
						.enableMarkdown(true)
						.setReplyMarkup(replyMarkup);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// /Triclinic
			if (update.getMessage().getText().equals("Triclinic")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"In crystallography, the triclinic (or anorthic) crystal system is one of the 7 "
								+ "crystal systems. A crystal system is described by three basis vectors. In the "
								+ "triclinic system, the crystal is described by vectors of unequal length, as in "
								+ "the orthorhombic system. In addition, no vector is at right angles (90°) "
								+ "orthogonal to another."
								+ "\nhttps://goo.gl/Ka29tv"
								+ "\n_Source: Wikipedia_")
						.enableMarkdown(true);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// /Monoclinic
			if (update.getMessage().getText().equals("Monoclinic")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"In crystallography, the monoclinic crystal system is one of the 7 crystal systems."
								+ " A crystal system is described by three vectors. In the monoclinic system, the "
								+ "crystal is described by vectors of unequal lengths, as in the orthorhombic system."
								+ " They form a rectangular prism with a parallelogram as its base. Hence two vectors"
								+ " are perpendicular (meet at right angles), while the third vector meets the other"
								+ " two at an angle other than 90°."
								+ "\nhttps://goo.gl/Yosn2m"
								+ "\n_Source: Wikipedia_")
						.enableMarkdown(true);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// /Orthorhombic
			if (update.getMessage().getText().equals("Orthorhombic")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"In crystallography, the orthorhombic crystal system is one of the 7 crystal systems. "
								+ "Orthorhombic lattices result from stretching a cubic lattice along two of its orthogonal "
								+ "pairs by two different factors, resulting in a rectangular prism with a rectangular"
								+ " base (a by b) and height (c), such that a, b, and c are distinct. All three bases"
								+ " intersect at 90° angles, so the three lattice vectors remain mutually orthogonal."
								+ "\nhttps://goo.gl/t6lSl1"
								+ "\n_Source: Wikipedia_")
						.enableMarkdown(true);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// /Tetragonal
			if (update.getMessage().getText().equals("Tetragonal")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"In crystallography, the tetragonal crystal system is one of the 7 crystal systems."
								+ " Tetragonal crystal lattices result from stretching a cubic lattice along one of "
								+ "its lattice vectors, so that the cube becomes a rectangular prism with a square"
								+ " base (a by a) and height (c, which is different from a)."
								+ "\nhttps://goo.gl/8EvD4K"
								+ "\n_Source: Wikipedia_")
						.enableMarkdown(true);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// /Hexagonal
			if (update.getMessage().getText().equals("Hexagonal")) {
				String smallGamma = "\u03b3";
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"In crystallography, the hexagonal crystal family is one of the 6 crystal families. "
								+ "In the hexagonal family, the crystal is conventionally described by a right rhombic"
								+ " prism unit cell with two equal axes (a by a), an included angle of 120° (" + smallGamma + ") and a "
								+ "height (c, which can be different from a) perpendicular to the two base axes."
								+ "\nhttps://goo.gl/txDjSc"
								+ "\n_Source: Wikipedia_")
						.enableMarkdown(true);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// /Trigonal
			if (update.getMessage().getText().equals("Trigonal")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"The trigonal crystal system is the only crystal system whose point groups have"
								+ " more than one lattice system associated with their space groups: the hexagonal"
								+ " and rhombohedral lattices both appear."
								+ "\nhttps://goo.gl/txDjSc"
								+ "\n_Source: Wikipedia_")
						.enableMarkdown(true);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// /Isometric(cubic)
			if (update.getMessage().getText().equals("Isometric")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"In crystallography, the cubic (or isometric) crystal system is a crystal system where"
								+ " the unit cell is in the shape of a cube. This is one of the most common and simplest "
								+ "shapes found in crystals and minerals."
								+ "\nhttps://goo.gl/OnpkIM"
								+ "\n_Source: Wikipedia_")
						.enableMarkdown(true);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// /Luster
			if (update.getMessage().getText().equals("Luster")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"Lustre or luster is the way light interacts with the surface of a crystal,"
								+ " rock, or mineral. The word traces its origins back to the latin lux,"
								+ " meaning \"light\", and generally implies radiance, gloss, or brilliance."
								+ "A range of terms are used to describe lustre, such as earthy, metallic, greasy, and silky.")
						.enableMarkdown(true);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// /Fracture
			if (update.getMessage().getText().equals("Fracture")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"In the field of mineralogy, fracture is the texture and shape of a rock's "
								+ "surface formed when a mineral is fractured. Minerals often have a highly"
								+ " distinctive fracture, making it a principal feature used in their"
								+ " identification.")
						.enableMarkdown(true);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// closing ifUpdateHasText
		}

		// closing onUpdate
	}

	// closing class
}
