package geoLearnBot;

import java.util.List;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
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

			// /start command
			if (update.getMessage().getText().equals("/start")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId()).setText(
						// @formatter:off
								"*Would you like to learn or play?*"
								+ "\n\n*1*. Learn !"
								+ "\n*2*. Play ! (sorry, I'm not implemented yet...)"
								+ "\n*3*. Acknowledgments")
								// @formatter:on
						.enableMarkdown(true);
				try {
					sendMessage(message); // Call method to send message
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// /help command
			if (update.getMessage().getText().equals("/help")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId()).setText(
						// @formatter:off
								"*Here is what this bot can do:*"
								+ "\n\nType \"/\" for main options (start, help, learn, quiz or acknowledgments)"
								+ "\nOnce inside the main options, use \"1\", \"2\", \"3\" and \"4\" to navigate the bot, have fun !")
								// @formatter:on
						.enableMarkdown(true);
				try {
					sendMessage(message); // Call method to send message
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			// /acknowledgments command
			if (update.getMessage().getText().equals("/acknowledgements")
					|| update.getMessage().getText().equals("3")) {
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

			// /learn || 1
			if (update.getMessage().getText().equals("/learn") || update.getMessage().getText().equals("1")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						.setText(
						// @formatter:off
						mineralsList.get(0).toString())						
						// @formatter:on
						.enableMarkdown(true);
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}

			// /quiz || 2
			if (update.getMessage().getText().equals("/quiz") || update.getMessage().getText().equals("2")) {
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
						// .setReplyMarkup(ReplyKeyboardMarkup)
						.setText(
						// @formatter:off
							"*quiz placeholder*")						
						// @formatter:on
						.enableMarkdown(true);
				try {
					sendMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}

		}

	}
}
