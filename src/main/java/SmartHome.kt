import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow


fun main() {
    ApiContextInitializer.init()
    TelegramBotsApi().registerBot(SmartHome())
}

class SmartHome : TelegramLongPollingBot() {

    override fun getBotToken(): String = "5097987543:AAF7pyrOVvyqNdyjsbw9eMXg6XQ5enLXofc"

    override fun getBotUsername() = "MySmartHome1_bot"


    override fun onUpdateReceived(update: Update?) {
        if (update != null) {
            if (update.message.text == "/start") {

                val keyboard = ReplyKeyboardMarkup()
                keyboard.keyboard = listOf(
                    KeyboardRow().apply {
                        add(KeyboardButton("Температура в будинку"))
                    }, KeyboardRow().apply {
                        add(KeyboardButton("Насиченість повітря киснем"))
                    },
                    KeyboardRow().apply {
                        add(KeyboardButton("Контроль електроприборів"))
                    },
                    KeyboardRow().apply {
                        add(KeyboardButton("Статистика за добу"))
                    }
                )
                execute(
                    SendMessage()
                        .setReplyMarkup(keyboard)
                        .setChatId(update.message.chatId)
                        .setText(
                            "Данний бот створений для контролю та керування станом вашого будинку"
                        )
                )
            }

                if (update != null) {
                    if (update.message.text == "Температура в будинку") {

                        execute(
                            SendMessage()
                                .setText("Температура в будинку +25 градусів")
                                .setChatId(update.message.chatId))

                    }
                }
            if (update != null) {
                    if (update.message.text == "Насиченість повітря киснем") {

                        execute(
                            SendMessage()
                                .setText("Повітря насичене киснем на 50%")
                                .setChatId(update.message.chatId))

                    }
                }

            if (update != null) {
                    if (update.message.text == "Контроль електроприборів") {

                        execute(
                            SendMessage()
                                .setText("Усі електроприбори у вашому домі вимкнені")
                                .setChatId(update.message.chatId))

                    }
                }
            if (update != null) {
                    if (update.message.text == "Статистика за добу") {

                        execute(
                            SendPhoto()
                            .setCaption("Статистика за поточний місяць")
                            .setChatId(update.message.chatId)
                            .setPhoto("http://applia-europe.eu/statistical-report-2017-2018/images/APPLiA_SG35.png")
                        )

                    }
                }

        }

    }
}