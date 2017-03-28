package geoLearnBot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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

	// @formatter:off
	// =============================== Constants ============================================================
	// @formatter:on

	// Create a chat pseudo-db
	Map<Long, Chat> chatMap = new HashMap<>();

	// Fetch list of minerals
	List<Minerals> mineralsList = FetchMinerals.fetchMinerals();

	// pick a random mineral number from the list to display
	int random = randomNumberPicker(mineralsList);

	// random number picker
	public static int randomNumberPicker(List<Minerals> mineralsList) {
		int random = new Random().nextInt(mineralsList.size());
		return random;
	}

	// name of last displayed mineral (for collection addition or removal)
	String lastMineralSeen;

	// index of last displayed mineral in mineral list (for collection addition)
	int indexOfLastMineralSeen;

	// text of last user input
	String lastUserInput;

	// hints seen this round of gaming
	List<Integer> hintsSeenThisRound = new ArrayList<>();

	// randomHint number
	Integer randomHint = -1;

	// initialise random numbers and scores for game
	int random0 = -1;
	int random1 = -1;
	int random2 = -1;
	int random3 = -1;
	int randomNum = -1;
	int gameScore = 0;
	int highScore = 0;

	// @formatter:off
	// =============================== Main Listener ============================================================
	// @formatter:on

	@Override
	public void onUpdateReceived(Update update) {
		// check if the update has a message and the message has text
		if (update.hasMessage() && update.getMessage().hasText()) {

			lastUserInput = update.getMessage().getText();

			if (chatMap.containsKey(update.getMessage().getChatId()) == false) {
				Map<String, Minerals> seenMinerals = new HashMap<>();
				Map<String, Minerals> favoriteMinerals = new HashMap<>();
				List<Minerals> mineralQuizList = new ArrayList<>();
				Chat newChat = new Chat(update.getMessage().getChatId(), seenMinerals, favoriteMinerals,
						mineralQuizList);
				chatMap.put(newChat.getId(), newChat);
			}

			// initialise high score
			// int playerHighScore =
			// chatMap.get(update.getMessage().getChatId()).getHighScore();

			// @formatter:off
			// =============================== Main Options ============================================================
			// @formatter:on

			// /start || 1
			if (update.getMessage().getText().equals("/start") || update.getMessage().getText().equals("1")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						.setText(
						// @formatter:off
								"*You can discover this Bot by picking a number or with the /menu to the right of your text input*"
								+ "\n\n*1*. /start Show this start menu"
								+ "\n*2*. /help Need help ?"
								+ "\n*3*. /random See a random mineral"
								+ "\n*4*. /collection See your mineral collection"
								+ "\n*5*. /clear Clear your mineral collection"
								//	+ "\n*X*. /filter Filter minerals (sorry, nothing here yet...)"
								//	+ "\n*X*. /search Search for a specific mineral (sorry, nothing here yet...)"
								//	+ "\n*X*. /compare Compare two minerals (sorry, nothing here yet...)"
								+ "\n*6*. /list Choose from a selection of minerals"
								+ "\n*7*. /play Test your knowledge (sorry, still work in progress...)"
								+ "\n*8*. /glossary Glossary"								
								+ "\n*9*. /acknowledgements Acknowledgements")
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
								+ "\n\nType \"/\" for main options:"
								+ "\n/start, /help, /random, /collection, /clear, /list, /play, /glossary or /acknowledgements "
								+ "\n\nYou can also use numbers (1, 2, 3...) to navigate the main options, have fun !"
								+ "\n\n*Errors:* if you keep asking for more minerals and they're not coming, well... why "
								+ "don't you read the text and wait a little " + winky + " ?")
								// @formatter:on
						.enableMarkdown(true);
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// /random || 3
			if (update.getMessage().getText().equals("/random") || update.getMessage().getText().equals("3")) {

				// create custom keyboard
				KeyboardRow keyboardFavoriteActions = new KeyboardRow();
				keyboardFavoriteActions.add(0, "Add to my collection! \ud83d\udcb0");
				keyboardFavoriteActions.add(1, "Remove from my collection! \ud83d\udc4e");
				keyboardFavoriteActions.add(2, "/help");

				List<KeyboardRow> keyboard = new ArrayList<>();
				keyboard.add(keyboardFavoriteActions);

				ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
				replyMarkup.setKeyboard(keyboard).setOneTimeKeyboad(true).setResizeKeyboard(true);

				// pick a random mineral to display
				random = randomNumberPicker(mineralsList);

				// add random mineral to Chat instance
				String keyMineralName = mineralsList.get(random).getTitle();
				Minerals valueMineralObject = mineralsList.get(random);
				chatMap.get(update.getMessage().getChatId()).getSeenMinerals().put(keyMineralName, valueMineralObject);

				// send mineral to Chat
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						.setText(
								// @formatter:off
								mineralsList.get(random).toString("singleMineral"))						
								.enableHtml(true)
								.setReplyMarkup(replyMarkup);
								lastMineralSeen = mineralsList.get(random).getTitle();
								indexOfLastMineralSeen = random;
								// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// /Add to my collection!
			if (update.getMessage().getText().equals("Add to my collection! \ud83d\udcb0")) {
				Map<String, Minerals> favoriteMinerals = chatMap.get(update.getMessage().getChatId())
						.getFavoriteMinerals();
				if (favoriteMinerals.containsKey(lastMineralSeen) == false) {
					chatMap.get(update.getMessage().getChatId()).getFavoriteMinerals().put(lastMineralSeen,
							mineralsList.get(indexOfLastMineralSeen));
					SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
							// @formatter:off
							.setText(
									"There you go "
											+ update.getMessage().getChat().getFirstName()
											+ ", *"
											+ lastMineralSeen
											+ "* has been added to your collection. \ud83d\udc4d"
									)
							.enableMarkdown(true);
					// @formatter:on
					try {
						sendMessage(message);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				} else {
					SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
							// @formatter:off
							.setText(
									"Sorry "
									+ update.getMessage().getChat().getFirstName()
									+ ", *"
									+ lastMineralSeen
									+ "* is already in your collection. \ud83d\ude1e"
									)
							.enableMarkdown(true);
						// @formatter:on
					try {
						sendMessage(message);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				}
			}

			// /Remove from my collection !
			if (update.getMessage().getText().equals("Remove from my collection! \ud83d\udc4e")) {
				Map<String, Minerals> favoriteMinerals = chatMap.get(update.getMessage().getChatId())
						.getFavoriteMinerals();
				if (favoriteMinerals.containsKey(lastMineralSeen)) {
					chatMap.get(update.getMessage().getChatId()).getFavoriteMinerals().remove(lastMineralSeen);
					SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
							// @formatter:off
							.setText(
									"There you go "
									+ update.getMessage().getChat().getFirstName()
									+ ", *"
									+ lastMineralSeen
									+ "* has been removed from your collection. \ud83d\udc4d"
									)
							.enableMarkdown(true);
					// @formatter:on
					try {
						sendMessage(message);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				} else {
					SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
							// @formatter:off
							.setText(
									"Sorry "
									+ update.getMessage().getChat().getFirstName()
									+ ", *"
									+ lastMineralSeen
									+ "* is not in your collection yet. \ud83d\ude1e"
									)
							.enableMarkdown(true);
						// @formatter:on
					try {
						sendMessage(message);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				}
			}

			// /Show my collection || 4
			if (update.getMessage().getText().equals("/collection") || update.getMessage().getText().equals("4")) {
				Map<String, Minerals> favoriteMinerals = chatMap.get(update.getMessage().getChatId())
						.getFavoriteMinerals();
				if (favoriteMinerals.isEmpty()) {
					SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
							// @formatter:off
							.setText(
									"Sorry "
									+ update.getMessage().getChat().getFirstName()
									+ ", you have no minerals in your collection yet."
									);
							// @formatter:on
					try {
						sendMessage(message);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				} else {
					SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
							// @formatter:off
							.setText(
									"Here you go "
											+ update.getMessage().getChat().getFirstName()
											+ ": your mineral collection. \ud83d\udc8e"
									);
					// @formatter:on
					try {
						sendMessage(message);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					favoriteMinerals.forEach((k, v) -> {
						SendMessage messageCollectionMineral = new SendMessage()
								.setChatId(update.getMessage().getChatId()).setText(v.toString("collectionMineral"))
								.enableHtml(true);
						try {
							sendMessage(messageCollectionMineral);
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					});
				}
			}

			// /clear your collection || 5
			if (update.getMessage().getText().equals("/clear") || update.getMessage().getText().equals("5")) {
				if (chatMap.get(update.getMessage().getChatId()).getFavoriteMinerals().isEmpty()) {
					SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
							.setText("Sorry " + update.getMessage().getChat().getFirstName()
									+ ", you have no minerals in your collection yet.");
					try {
						sendMessage(message);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				} else {
					chatMap.get(update.getMessage().getChatId()).getFavoriteMinerals().clear();
					SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
							.setText("Your collection has been cleared.");
					try {
						sendMessage(message);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				}

			}

			// @formatter:off
			// =============================== List, Browse, Search ============================================================
			// @formatter:on

			// /List Mineral selection || 6
			if (update.getMessage().getText().equals("/list") || update.getMessage().getText().equals("6")) {

				KeyboardRow keyboardRow = new KeyboardRow();
				keyboardRow.add(0, "Browse");
				keyboardRow.add(1, "Search");
				keyboardRow.add(2, "/help");

				List<KeyboardRow> keyboard = new ArrayList<>();
				keyboard.add(keyboardRow);

				ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
				replyMarkup.setKeyboard(keyboard).setOneTimeKeyboad(true).setResizeKeyboard(true);

				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"Ok, what kind of list would you like to see ?")						
						.setReplyMarkup(replyMarkup);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}

			// /Browse
			if (update.getMessage().getText().equals("Browse")) {

				KeyboardRow keyboardRow = new KeyboardRow();
				keyboardRow.add(0, "by Mineral Classification");
				keyboardRow.add(1, "by Crystal System");
				keyboardRow.add(2, "/list");

				List<KeyboardRow> keyboard = new ArrayList<>();
				keyboard.add(keyboardRow);

				ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
				replyMarkup.setKeyboard(keyboard).setOneTimeKeyboad(true).setResizeKeyboard(true);

				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"And how would you like me to filter the results?")						
						.setReplyMarkup(replyMarkup);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}

			// /by Mineral Classification
			if (update.getMessage().getText().equals("by Mineral Classification")) {

				KeyboardRow keyboardRowUpper = new KeyboardRow();
				keyboardRowUpper.add(0, "Carbonates");
				keyboardRowUpper.add(1, "Halides");
				keyboardRowUpper.add(2, "Natives");
				keyboardRowUpper.add(3, "Phyllosilicates");

				KeyboardRow keyboardRowLower = new KeyboardRow();
				keyboardRowLower.add(0, "Pyroxenes");
				keyboardRowLower.add(1, "Silicates");
				keyboardRowLower.add(2, "Sulfates");
				keyboardRowLower.add(3, "Sulfides");
				keyboardRowLower.add(4, "/list");

				List<KeyboardRow> keyboard = new ArrayList<>();
				keyboard.add(keyboardRowUpper);
				keyboard.add(keyboardRowLower);

				ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
				replyMarkup.setKeyboard(keyboard).setResizeKeyboard(true);

				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"Ok, which mineral group do you want to search for ?")
						.enableMarkdown(true)
						.setReplyMarkup(replyMarkup);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// /Carbonates
			if (update.getMessage().getText().equals("Carbonates")) {
				int i = 0;
				for (Minerals minerals : mineralsList) {
					i++;
					if (minerals.getMineralClassification().equals("Carbonate")) {
						int matchPosition = i - 1;
						SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
								.setText("Here are your results for <strong>Carbonates</strong>: "
										+ mineralsList.get(matchPosition).toString("singleMineral"))
								.enableHtml(true);
						try {
							sendMessage(message);
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
			}

			// /Halides
			if (update.getMessage().getText().equals("Halides")) {
				int i = 0;
				for (Minerals minerals : mineralsList) {
					i++;
					if (minerals.getMineralClassification().equals("Halide")) {
						int matchPosition = i - 1;
						SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
								.setText("Here are your results for <strong>Halides</strong>: "
										+ mineralsList.get(matchPosition).toString("singleMineral"))
								.enableHtml(true);
						try {
							sendMessage(message);
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
			}

			// /Natives
			if (update.getMessage().getText().equals("Natives")) {
				int i = 0;
				for (Minerals minerals : mineralsList) {
					i++;
					if (minerals.getMineralClassification().equals("Native")) {
						int matchPosition = i - 1;
						SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
								.setText("Here are your results for <strong>Natives</strong>: "
										+ mineralsList.get(matchPosition).toString("singleMineral"))
								.enableHtml(true);
						try {
							sendMessage(message);
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
			}

			// /Phyllosilicates
			if (update.getMessage().getText().equals("Phyllosilicates")) {
				int i = 0;
				for (Minerals minerals : mineralsList) {
					i++;
					if (minerals.getMineralClassification().equals("Phyllosilicates")) {
						int matchPosition = i - 1;
						SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
								.setText("Here are your results for <strong>Phyllosilicates</strong>: "
										+ mineralsList.get(matchPosition).toString("singleMineral"))
								.enableHtml(true);
						try {
							sendMessage(message);
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
			}

			// /Pyroxenes
			if (update.getMessage().getText().equals("Pyroxenes")) {
				int i = 0;
				for (Minerals minerals : mineralsList) {
					i++;
					if (minerals.getMineralClassification().equals("Pyroxene")) {
						int matchPosition = i - 1;
						SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
								.setText("Here are your results for <strong>Pyroxenes</strong>: "
										+ mineralsList.get(matchPosition).toString("singleMineral"))
								.enableHtml(true);
						try {
							sendMessage(message);
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
			}

			// /Silicates
			if (update.getMessage().getText().equals("Silicates")) {
				int i = 0;
				for (Minerals minerals : mineralsList) {
					i++;
					if (minerals.getMineralClassification().equals("Silicate")) {
						int matchPosition = i - 1;
						SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
								.setText("Here are your results for <strong>Silicates</strong>: "
										+ mineralsList.get(matchPosition).toString("singleMineral"))
								.enableHtml(true);
						try {
							sendMessage(message);
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
			}

			// /Sulfates
			if (update.getMessage().getText().equals("Sulfates")) {
				int i = 0;
				for (Minerals minerals : mineralsList) {
					i++;
					if (minerals.getMineralClassification().equals("Sulfate")) {
						int matchPosition = i - 1;
						SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
								.setText("Here are your results for <strong>Sulfates</strong>: "
										+ mineralsList.get(matchPosition).toString("singleMineral"))
								.enableHtml(true);
						try {
							sendMessage(message);
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
			}

			// /Sulfides
			if (update.getMessage().getText().equals("Sulfides")) {
				int i = 0;
				for (Minerals minerals : mineralsList) {
					i++;
					if (minerals.getMineralClassification().equals("Sulfide")) {
						int matchPosition = i - 1;
						SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
								.setText("Here are your results for <strong>Sulfides</strong>: "
										+ mineralsList.get(matchPosition).toString("singleMineral"))
								.enableHtml(true);
						try {
							sendMessage(message);
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
			}

			// /by Crystal System
			if (update.getMessage().getText().equals("by Crystal System")) {

				KeyboardRow keyboardRowUpper = new KeyboardRow();
				keyboardRowUpper.add(0, "Triclinics");
				keyboardRowUpper.add(1, "Monoclinics");
				keyboardRowUpper.add(2, "Orthorhombics");
				keyboardRowUpper.add(3, "Tetragonals");

				KeyboardRow keyboardRowLower = new KeyboardRow();
				keyboardRowLower.add(0, "Hexagonals");
				keyboardRowLower.add(1, "Trigonals");
				keyboardRowLower.add(2, "Isometrics");
				keyboardRowLower.add(3, "/list");

				List<KeyboardRow> keyboard = new ArrayList<>();
				keyboard.add(keyboardRowUpper);
				keyboard.add(keyboardRowLower);

				ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
				replyMarkup.setKeyboard(keyboard).setResizeKeyboard(true);

				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"Ok, which crystal system do you want to search for ?")
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
			if (update.getMessage().getText().equals("Triclinics")) {
				int i = 0;
				for (Minerals minerals : mineralsList) {
					i++;
					if (minerals.getCrystalSystem().equals("Triclinic")) {
						int matchPosition = i - 1;
						SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
								.setText("Here are your results for <strong>Triclinics</strong>: "
										+ mineralsList.get(matchPosition).toString("singleMineral"))
								.enableHtml(true);
						try {
							sendMessage(message);
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
			}

			// /Monoclinic
			if (update.getMessage().getText().equals("Monoclinics")) {
				int i = 0;
				for (Minerals minerals : mineralsList) {
					i++;
					if (minerals.getCrystalSystem().equals("Monoclinic")) {
						int matchPosition = i - 1;
						SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
								.setText("Here are your results for <strong>Monoclinics</strong>: "
										+ mineralsList.get(matchPosition).toString("singleMineral"))
								.enableHtml(true);
						try {
							sendMessage(message);
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
			}

			// /Orthorhombic
			if (update.getMessage().getText().equals("Orthorhombics")) {
				int i = 0;
				for (Minerals minerals : mineralsList) {
					i++;
					if (minerals.getCrystalSystem().equals("Orthorhombic")) {
						int matchPosition = i - 1;
						SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
								.setText("Here are your results for <strong>Orthorhombics</strong>: "
										+ mineralsList.get(matchPosition).toString("singleMineral"))
								.enableHtml(true);
						try {
							sendMessage(message);
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
			}

			// /Tetragonal
			if (update.getMessage().getText().equals("Tetragonals")) {
				int i = 0;
				for (Minerals minerals : mineralsList) {
					i++;
					if (minerals.getCrystalSystem().contains("Tetragonal")) {
						int matchPosition = i - 1;
						SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
								.setText("Here are your results for <strong>Tetragonals</strong>: "
										+ mineralsList.get(matchPosition).toString("singleMineral"))
								.enableHtml(true);
						try {
							sendMessage(message);
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
			}

			// /Hexagonal
			if (update.getMessage().getText().equals("Hexagonals")) {
				int i = 0;
				for (Minerals minerals : mineralsList) {
					i++;
					if (minerals.getCrystalSystem().equals("Hexagonal")) {
						int matchPosition = i - 1;
						SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
								.setText("Here are your results for <strong>Hexagonals</strong>: "
										+ mineralsList.get(matchPosition).toString("singleMineral"))
								.enableHtml(true);
						try {
							sendMessage(message);
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
			}

			// /Trigonal
			if (update.getMessage().getText().equals("Trigonals")) {
				int i = 0;
				for (Minerals minerals : mineralsList) {
					i++;
					if (minerals.getCrystalSystem().equals("Trigonal")) {
						int matchPosition = i - 1;
						SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
								.setText("Here are your results for <strong>Trigonals</strong>: "
										+ mineralsList.get(matchPosition).toString("singleMineral"))
								.enableHtml(true);
						try {
							sendMessage(message);
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
			}

			// /Isometric
			if (update.getMessage().getText().equals("Isometrics")) {
				int i = 0;
				for (Minerals minerals : mineralsList) {
					i++;
					if (minerals.getCrystalSystem().equals("Isometric")) {
						int matchPosition = i - 1;
						SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
								.setText("Here are your results for <strong>Isometrics</strong>: "
										+ mineralsList.get(matchPosition).toString("singleMineral"))
								.enableHtml(true);
						try {
							sendMessage(message);
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
			}

			// /Search
			if (update.getMessage().getText().equals("Search")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"Please type the *name* of the mineral you'd like me to search for "
								+ "using the following format:\n"
								+ "*:mineralName*	\n"
								+ "remember to include the *\" : \"* !")						
						.enableMarkdown(true);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// Retrieve mineral from list
			if (update.getMessage().getText().contains(":")) {
				String userQuery = update.getMessage().getText().substring(1).toLowerCase();
				int positionCounter = 0;
				for (Minerals minerals : mineralsList) {
					positionCounter++;
					if (minerals.getTitle().toLowerCase().contains(userQuery)) {
						int matchPosition = positionCounter - 1;
						SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
								// @formatter:off
								.setText(
									"Here you go "
									+ update.getMessage().getChat().getFirstName()
									+ ", this is the information I have about "
									+ userQuery
									+ ":"
									+ mineralsList.get(matchPosition).toString("singleMineral"))
								.enableHtml(true);
								// @formatter:on
						try {
							sendMessage(message);
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
				int countNoMatch = 0;
				for (Minerals minerals : mineralsList) {
					int lengthOfMineralsList = mineralsList.size();
					if (minerals.getTitle().toLowerCase().contains(userQuery) == false) {
						countNoMatch++;
					}
					if (countNoMatch == lengthOfMineralsList) {
						SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
								.setText("Sorry I couldn't match \"*" + userQuery + "*\" to a mineral in my database."
										+ "\nYou may search again with *:mineralName* (e.g. :gold)")
								.enableMarkdown(true);
						try {
							sendMessage(message);
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
			}

			// @formatter:off
			// =============================== Play track ============================================================
			// @formatter:on

			// /Play || 7
			if (update.getMessage().getText().equals("/play") || update.getMessage().getText().equals("7")) {

				// create custom keyboard
				KeyboardRow keyboardFavoriteActions = new KeyboardRow();
				keyboardFavoriteActions.add(0, "Start new quiz");
				keyboardFavoriteActions.add(1, "Continue quiz");
				keyboardFavoriteActions.add(2, "/help");
				List<KeyboardRow> keyboard = new ArrayList<>();
				keyboard.add(keyboardFavoriteActions);
				ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
				replyMarkup.setKeyboard(keyboard).setOneTimeKeyboad(true).setResizeKeyboard(true);

				// send instructions to User
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId()).setText(
						// @formatter:off
								"*Mineral Quiz*\n\n"
								+ "I will now pick a random mineral and give you 1 hint and 4 options"
								+ ", it's up to you to guess which mineral is the correct one.\n"
								+ "A correct answer will always earn you 3 points *but !* \n"
								+ "...each successive *hint* will take *1 point* off your game score "
								+ "and each wrong guess will also take *1 point* off your game score.\n\n"
								+ "\"*Start new quiz*\" resets your current game score (not your high score)\n"
								+ "\"*Continue quiz*\" allows you to try more questions to increase your high score")														
								.enableMarkdown(true)
								.setReplyMarkup(replyMarkup);
								// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// /Start quiz
			if (update.getMessage().getText().equals("Start new quiz")) {

				// clear random minerals from Chat instance
				chatMap.get(update.getMessage().getChatId()).getMineralQuizList().clear();

				// reset hint lists and game score
				hintsSeenThisRound.clear();
				chatMap.get(update.getMessage().getChatId()).setGameScore(0);

				// add random minerals to Chat instance
				random0 = randomNumberPicker(mineralsList);
				random1 = randomNumberPicker(mineralsList);
				random2 = randomNumberPicker(mineralsList);
				random3 = randomNumberPicker(mineralsList);

				String keyRandomMineralName0 = mineralsList.get(random0).getTitle();
				Minerals valueRandomMineralObject0 = mineralsList.get(random0);
				chatMap.get(update.getMessage().getChatId()).getMineralQuizList().add(valueRandomMineralObject0);

				String keyRandomMineralName1 = mineralsList.get(random1).getTitle();
				Minerals valueRandomMineralObject1 = mineralsList.get(random1);
				chatMap.get(update.getMessage().getChatId()).getMineralQuizList().add(valueRandomMineralObject1);

				String keyRandomMineralName2 = mineralsList.get(random2).getTitle();
				Minerals valueRandomMineralObject2 = mineralsList.get(random2);
				chatMap.get(update.getMessage().getChatId()).getMineralQuizList().add(valueRandomMineralObject2);

				String keyRandomMineralName3 = mineralsList.get(random3).getTitle();
				Minerals valueRandomMineralObject3 = mineralsList.get(random3);
				chatMap.get(update.getMessage().getChatId()).getMineralQuizList().add(valueRandomMineralObject3);

				// set one mineral to correctGuess
				randomNum = ThreadLocalRandom.current().nextInt(0, 3 + 1);
				chatMap.get(update.getMessage().getChatId()).getMineralQuizList().get(randomNum)
						.setIsCorrectGuess(true);
				System.out.println("correctMineral setting stage: " + chatMap.get(update.getMessage().getChatId())
						.getMineralQuizList().get(randomNum).toString("collectionMineral"));

				// create custom keyboard
				KeyboardRow keyboardRowUpper = new KeyboardRow();
				keyboardRowUpper.add(0, "\\" + keyRandomMineralName0);
				keyboardRowUpper.add(1, "\\" + keyRandomMineralName1);
				keyboardRowUpper.add(2, "new hint");

				KeyboardRow keyboardRowLower = new KeyboardRow();
				keyboardRowLower.add(0, "\\" + keyRandomMineralName2);
				keyboardRowLower.add(1, "\\" + keyRandomMineralName3);
				keyboardRowLower.add(2, "/play");

				List<KeyboardRow> keyboard = new ArrayList<>();
				keyboard.add(keyboardRowUpper);
				keyboard.add(keyboardRowLower);

				ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
				replyMarkup.setKeyboard(keyboard).setResizeKeyboard(true);

				// choose random hint and keep track of hints this round
				randomHint = ThreadLocalRandom.current().nextInt(0, 7 + 1);
				hintsSeenThisRound.add(randomHint);

				switch (randomHint) {
				case 0:
					SendMessage message0 = new SendMessage().setChatId(update.getMessage().getChatId())
							.setText("The correct mineral's Mineral Classification is:\n" + "*"
									+ chatMap.get(update.getMessage().getChatId()).getMineralQuizList().get(randomNum)
											.getMineralClassification()
									+ "*")
							.enableMarkdown(true).setReplyMarkup(replyMarkup);
					try {
						sendMessage(message0);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					break;

				case 1:
					SendMessage message1 = new SendMessage().setChatId(update.getMessage().getChatId())
							.setText("The correct mineral's Chemical Formula is:\n" + "*"
									+ chatMap.get(update.getMessage().getChatId()).getMineralQuizList().get(randomNum)
											.getChemicalFormula()
									+ "*")
							.enableMarkdown(true).setReplyMarkup(replyMarkup);
					try {
						sendMessage(message1);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					break;

				case 2:
					SendMessage message2 = new SendMessage().setChatId(update.getMessage().getChatId())
							.setText(
									"The correct mineral's Streak is:\n" + "*"
											+ chatMap.get(update.getMessage().getChatId()).getMineralQuizList()
													.get(randomNum).getStreak()
											+ "*")
							.enableMarkdown(true).setReplyMarkup(replyMarkup);
					try {
						sendMessage(message2);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					break;

				case 3:
					SendMessage message3 = new SendMessage().setChatId(update.getMessage().getChatId())
							.setText(
									"The correct mineral's Hardness is:\n" + "*"
											+ chatMap.get(update.getMessage().getChatId()).getMineralQuizList()
													.get(randomNum).getMohsHardness()
											+ "*")
							.enableMarkdown(true).setReplyMarkup(replyMarkup);
					try {
						sendMessage(message3);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					break;

				case 4:
					SendMessage message4 = new SendMessage().setChatId(update.getMessage().getChatId())
							.setText(
									"The correct mineral's Crystal System is:\n" + "*"
											+ chatMap.get(update.getMessage().getChatId()).getMineralQuizList()
													.get(randomNum).getCrystalSystem()
											+ "*")
							.enableMarkdown(true).setReplyMarkup(replyMarkup);
					try {
						sendMessage(message4);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					break;

				case 5:
					SendMessage message5 = new SendMessage().setChatId(update.getMessage().getChatId())
							.setText(
									"The correct mineral's Color is:\n" + "*"
											+ chatMap.get(update.getMessage().getChatId()).getMineralQuizList()
													.get(randomNum).getColor()
											+ "*")
							.enableMarkdown(true).setReplyMarkup(replyMarkup);
					try {
						sendMessage(message5);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					break;

				case 6:
					SendMessage message6 = new SendMessage().setChatId(update.getMessage().getChatId())
							.setText(
									"The correct mineral's Luster is:\n" + "*"
											+ chatMap.get(update.getMessage().getChatId()).getMineralQuizList()
													.get(randomNum).getLuster()
											+ "*")
							.enableMarkdown(true).setReplyMarkup(replyMarkup);
					try {
						sendMessage(message6);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					break;

				case 7:
					SendMessage message7 = new SendMessage().setChatId(update.getMessage().getChatId())
							.setText(
									"The correct mineral's Fracture is:\n" + "*"
											+ chatMap.get(update.getMessage().getChatId()).getMineralQuizList()
													.get(randomNum).getFracture()
											+ "*")
							.enableMarkdown(true).setReplyMarkup(replyMarkup);
					try {
						sendMessage(message7);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					break;
				}
			}

			// new hint
			if (update.getMessage().getText().equals("new hint")) {
				if (hintsSeenThisRound.size() < 4) {
					int newRandomHint = ThreadLocalRandom.current().nextInt(0, 7 + 1);
					while (hintsSeenThisRound.contains(newRandomHint)) {
						newRandomHint = ThreadLocalRandom.current().nextInt(0, 7 + 1);
					}
					randomHint = newRandomHint;
					hintsSeenThisRound.add(newRandomHint);
					if (chatMap.get(update.getMessage().getChatId()).getMineralQuizList().get(randomNum)
							.getIsCorrectGuess().equals(true)) {
						chatMap.get(update.getMessage().getChatId())
								.setGameScore(chatMap.get(update.getMessage().getChatId()).getGameScore() - 1);
					}
				} else {
					randomHint = 8;
				}

				switch (randomHint) {
				case 0:
					SendMessage message0 = new SendMessage().setChatId(update.getMessage().getChatId())
							.setText(
									"The correct mineral's Mineral Classification is:\n" + "*"
											+ chatMap.get(update.getMessage().getChatId()).getMineralQuizList()
													.get(randomNum).getMineralClassification()
											+ "*")
							.enableMarkdown(true);
					try {
						sendMessage(message0);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					break;

				case 1:
					SendMessage message1 = new SendMessage().setChatId(update.getMessage().getChatId())
							.setText("The correct mineral's Chemical Formula is:\n" + "*"
									+ chatMap.get(update.getMessage().getChatId()).getMineralQuizList().get(randomNum)
											.getChemicalFormula()
									+ "*")
							.enableMarkdown(true);
					try {
						sendMessage(message1);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					break;

				case 2:
					SendMessage message2 = new SendMessage().setChatId(update.getMessage().getChatId())
							.setText("The correct mineral's Streak is:\n" + "*"
									+ chatMap.get(update.getMessage().getChatId()).getMineralQuizList().get(randomNum)
											.getStreak()
									+ "*")
							.enableMarkdown(true);
					try {
						sendMessage(message2);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					break;

				case 3:
					SendMessage message3 = new SendMessage().setChatId(update.getMessage().getChatId())
							.setText("The correct mineral's Hardness is:\n" + "*"
									+ chatMap.get(update.getMessage().getChatId()).getMineralQuizList().get(randomNum)
											.getMohsHardness()
									+ "*")
							.enableMarkdown(true);
					try {
						sendMessage(message3);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					break;

				case 4:
					SendMessage message4 = new SendMessage().setChatId(update.getMessage().getChatId())
							.setText("The correct mineral's Crystal System is:\n" + "*"
									+ chatMap.get(update.getMessage().getChatId()).getMineralQuizList().get(randomNum)
											.getCrystalSystem()
									+ "*")
							.enableMarkdown(true);
					try {
						sendMessage(message4);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					break;

				case 5:
					SendMessage message5 = new SendMessage().setChatId(update.getMessage().getChatId())
							.setText("The correct mineral's Color is:\n" + "*" + chatMap
									.get(update.getMessage().getChatId()).getMineralQuizList().get(randomNum).getColor()
									+ "*")
							.enableMarkdown(true);
					try {
						sendMessage(message5);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					break;

				case 6:
					SendMessage message6 = new SendMessage().setChatId(update.getMessage().getChatId())
							.setText("The correct mineral's Luster is:\n" + "*"
									+ chatMap.get(update.getMessage().getChatId()).getMineralQuizList().get(randomNum)
											.getLuster()
									+ "*")
							.enableMarkdown(true);
					try {
						sendMessage(message6);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					break;

				case 7:
					SendMessage message7 = new SendMessage().setChatId(update.getMessage().getChatId())
							.setText("The correct mineral's Fracture is:\n" + "*"
									+ chatMap.get(update.getMessage().getChatId()).getMineralQuizList().get(randomNum)
											.getFracture()
									+ "*")
							.enableMarkdown(true);
					try {
						sendMessage(message7);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					break;

				case 8:
					SendMessage message8 = new SendMessage().setChatId(update.getMessage().getChatId())
							.setText("Sorry " + update.getMessage().getChat().getFirstName()
									+ ", but you have run out of hints. \ud83d\ude1e"
									+ "\nYou can still be a *geologist* \u2692 and give me your best guess ! \ud83d\ude0e")
							.enableMarkdown(true);
					try {
						sendMessage(message8);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				}
			}

			// Continue quiz
			if (update.getMessage().getText().equals("Continue quiz")) {
				System.out.println("in the continue");
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"*Ok let's continue!!*")
						.enableMarkdown(true);
						// @formatter:on
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}

			// quiz answer logic
			if (update.getMessage().getText().contains("\\")) {

				System.out.println("gameScore: " + chatMap.get(update.getMessage().getChatId()).getGameScore());
				System.out.println("highScore: " + chatMap.get(update.getMessage().getChatId()).getHighScore());

				String userAnswer = update.getMessage().getText().substring(1).toLowerCase();
				String correctMineralName = "";
				if (chatMap.get(update.getMessage().getChatId()).getMineralQuizList().get(randomNum).getIsCorrectGuess()
						.equals(true)) {
					correctMineralName = chatMap.get(update.getMessage().getChatId()).getMineralQuizList()
							.get(randomNum).getTitle().toLowerCase();
				}

				if (userAnswer.equals(correctMineralName)) {
					chatMap.get(update.getMessage().getChatId())
							.setGameScore(chatMap.get(update.getMessage().getChatId()).getGameScore() + 3);
					if (chatMap.get(update.getMessage().getChatId()).getGameScore() > chatMap
							.get(update.getMessage().getChatId()).getHighScore()) {
						chatMap.get(update.getMessage().getChatId())
								.setHighScore(chatMap.get(update.getMessage().getChatId()).getGameScore());
					}
					SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
							// @formatter:off
							.setText(
									"Congratulations "
									+ update.getMessage().getChat().getFirstName()
									+ ", you guessed correctly, and here is the information card about "
									+ "<strong>"
									+ chatMap.get(update.getMessage().getChatId()).getMineralQuizList().get(randomNum).getTitle()
									+ "</strong>\n"
									+ "Well done! \u2692 \ud83d\ude0e"
									+ "\nYour current game score is: "
									+ "<strong>" + chatMap.get(update.getMessage().getChatId()).getGameScore() + "</strong>\n"
									+ "and your current High score is: "
									+ "<strong>" + chatMap.get(update.getMessage().getChatId()).getHighScore() + "</strong>\n"
									+ chatMap.get(update.getMessage().getChatId()).getMineralQuizList().get(randomNum).toString("singleMineral"))
							.enableHtml(true);
							// @formatter:on
					try {
						sendMessage(message);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					chatMap.get(update.getMessage().getChatId()).getMineralQuizList().get(randomNum)
							.setIsCorrectGuess(false);
				} else {
					if (chatMap.get(update.getMessage().getChatId()).getMineralQuizList().get(randomNum)
							.getIsCorrectGuess().equals(true)) {

						chatMap.get(update.getMessage().getChatId())
								.setGameScore(chatMap.get(update.getMessage().getChatId()).getGameScore() - 1);
						SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
								.setText("Sorry " + update.getMessage().getChat().getFirstName()
										+ ", try again, use a hint or start a new game. \n*Starting a new game will reset your current game score !*")
								.enableMarkdown(true);
						try {
							sendMessage(message);
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
			}

			// @formatter:off
			// =============================== Glossary track ============================================================
			// @formatter:on

			// /Glossary || 8
			if (update.getMessage().getText().equals("/glossary") || update.getMessage().getText().equals("8")) {

				KeyboardRow keyboardRowUpper = new KeyboardRow();
				keyboardRowUpper.add(0, "Mineral Classification");
				keyboardRowUpper.add(1, "Streak");
				keyboardRowUpper.add(2, "Mohs Hardness");

				KeyboardRow keyboardRowLower = new KeyboardRow();
				keyboardRowLower.add(0, "Crystal System");
				keyboardRowLower.add(1, "Luster");
				keyboardRowLower.add(2, "Fracture");
				keyboardRowLower.add(3, "/help");

				List<KeyboardRow> keyboard = new ArrayList<>();
				keyboard.add(keyboardRowUpper);
				keyboard.add(keyboardRowLower);

				ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
				replyMarkup.setKeyboard(keyboard).setResizeKeyboard(true);

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

			// /acknowledgements || 9
			if (update.getMessage().getText().equals("/acknowledgements")
					|| update.getMessage().getText().equals("9")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId()).setText(
						// @formatter:off
											"*geoLearnBot Acknowledges, Credits and Thanks*"
											+ "\n*The Minerals Education Coalition*"
											+ "\n*for all the geological data displayed inside this bot*"
											+ "\n\nThe original material is available at [https://mineralseducationcoalition.org]"
											+ "\nThe Reprint Policy of the Minerals Education Coalition is available at"
											+ " [https://mineralseducationcoalition.org/reprint-policy/]"
											+ "\n\nAdditionally geoLearnBot states that:"
											+ "\nThis bot is in no way affiliated nor partnered with nor sponsored by the Minerals Education Coalition")
											// @formatter:on
						.enableMarkdown(true);
				try {
					sendMessage(message); // Call method to send message
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// @formatter:off
			// =============================== Glossary Options ============================================================
			// @formatter:on

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
				keyboardRowLower.add(4, "/help");

				List<KeyboardRow> keyboard = new ArrayList<>();
				keyboard.add(keyboardRowUpper);
				keyboard.add(keyboardRowLower);

				ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
				replyMarkup.setKeyboard(keyboard).setResizeKeyboard(true);

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
								"*Carbonate* minerals are those minerals containing the carbonate ion: CO3\n_Source: Wikipedia_")
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
								"The *halide* mineral class include those minerals with a dominant halide anion (F−, Cl−, Br− and I−)."
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
								"*Native* element minerals are those elements that occur in nature in uncombined form with a "
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
								"*Phyllosilicates* are sheet Silicate minerals, formed by parallel sheets of silicate tetrahedra with "
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
								"The *pyroxenes* (commonly abbreviated to Px) are a group of important rock-forming inosilicate minerals"
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
								"*Silicate* minerals are rock-forming minerals made up of silicate groups. They are the largest"
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
								"The *sulfate* minerals are a class of minerals which include the sulfate ion (SO42−) within"
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
								"The *sulfide* minerals are a class of minerals containing sulfide (S2−) as the major anion."
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
								"The *streak* (also called \"powder color\") of a mineral is the color of the powder produced"
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
								"The *Mohs scale* of mineral hardness is a qualitative ordinal scale characterizing scratch "
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
				keyboardRowLower.add(3, "/help");

				List<KeyboardRow> keyboard = new ArrayList<>();
				keyboard.add(keyboardRowUpper);
				keyboard.add(keyboardRowLower);

				ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
				replyMarkup.setKeyboard(keyboard).setResizeKeyboard(true);

				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"In crystallography, the terms *crystal system*, crystal family and lattice system"
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
								"In crystallography, the *triclinic* (or anorthic) crystal system is one of the 7 "
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
								"In crystallography, the *monoclinic* crystal system is one of the 7 crystal systems."
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
								"In crystallography, the *orthorhombic* crystal system is one of the 7 crystal systems. "
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
								"In crystallography, the *tetragonal* crystal system is one of the 7 crystal systems."
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
								"In crystallography, the *hexagonal* crystal family is one of the 6 crystal families. "
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
								"The *trigonal* crystal system is the only crystal system whose point groups have"
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
								"In crystallography, the *cubic* (or *isometric*) crystal system is a crystal system where"
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
								"Lustre or *luster* is the way light interacts with the surface of a crystal,"
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
								"In the field of mineralogy, *fracture* is the texture and shape of a rock's "
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

			// @formatter:off
			// =============================== Profanity Filter ============================================================
			// @formatter:on

			// /profanity filter
			String swear0 = "fuck";
			String swear1 = "mierd";
			String swear2 = "shit";
			String swear3 = "screw";
			String winky = "\ud83d\ude09";
			if (update.getMessage().getText().toLowerCase().contains(swear0) || //
					update.getMessage().getText().toLowerCase().contains(swear1) || //
					update.getMessage().getText().toLowerCase().contains(swear2) || //
					update.getMessage().getText().toLowerCase().contains(swear3)) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"Hey there "
								+ update.getMessage().getChat().getFirstName()
								+ ", I'll be taking you less seriously from now on "
								+ winky)
						.enableMarkdown(true);
						// @formatter:on
				try {
					// sendVideo(video);
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
