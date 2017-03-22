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

	List<Minerals> mineralsList = FetchMinerals.fetchMinerals();

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
				String winky = "\\U+1F609";
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						.setText(
						// @formatter:off
								"*Here is what this bot can do:*"
								+ "\n\nType \"/\" for main options (start, help, learn, quiz, acknowledgments or glossary)"
								+ "\nOnce inside the main options use 1, 2, 3, 4, 5 and 6 to navigate the bot, have fun !"
								+ "\n\nErrors: if you keep asking for more minerals and they're not coming, well...why don't you read the text and wait a little " + winky + " ?")
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

				// pick random element in the array
				int random = new Random().nextInt(mineralsList.size());

				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						.setText(
								// @formatter:off
								mineralsList.get(random).toString())						
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
								+ "\nThe Reprint Policy of the Minerals Education Coalition is available at [https://mineralseducationcoalition.org/reprint-policy/]"
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
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"booyah MinClass !!")
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
								"booyah Streak !!")
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
								"booyah Mohs Hardness !!")
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
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// @formatter:off
						.setText(
								"booyah Crystals !!")
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
								"booyah Luster !!")
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
								"booyah Fracture !!")
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
