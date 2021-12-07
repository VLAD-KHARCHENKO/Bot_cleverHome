import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
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
                        add(KeyboardButton("Про SmartHome"))
                    }, KeyboardRow().apply {
                        add(KeyboardButton("Наш офіс у Києві"))
                    },
                    KeyboardRow().apply {
                        add(KeyboardButton("Посилання на наші ресурси"))
                    },
                    KeyboardRow().apply {
                        add(KeyboardButton("Замовити послуги"))
                    }
                )
                execute(
                    SendMessage()
                        .setReplyMarkup(keyboard)
                        .setChatId(update.message.chatId)
                        .setText("Цей бот створений щоб полегшити нашу комунікацію та відповісти на деякі ваші питання." +
                                "Оберіть питання із списку яке вас цікавить")
                )
            }

            if (update != null) {
                if (update.message.text == "Про SmartHome") {

                    execute(
                        SendMessage()
                            .setText(
                                "Компанія СмартХоум вже 5 років займається встановленням обладнання для розумного дому." +
                                        "Інтегруємо комплекс розумних даттчиків у ваш будинок які обєднуються в одну централізовану " +
                                        "систему контролю стану вашого будинку. Також це надає вам можливість управляти системою за " +
                                        "допомогою смартфону і створювати необхідний вам затишок."
                            )
                            .setChatId(update.message.chatId)
                    )

                }
            }
            if (update != null) {
                if (update.message.text == "Посилання на наші ресурси") {

                    execute(
                        SendMessage()
                            .setText("Наші соц-мережі")
                            .setChatId(update.message.chatId)
                            .setReplyMarkup(InlineKeyboardMarkup().apply {
                                keyboard = listOf(listOf(InlineKeyboardButton("Наш сайт").apply {
                                    url = "https://lun.ua/uk/%D0%B6%D0%BA-smart-house-%D0%BA%D0%B8%D1%97%D0%B2"
                                },
                                    InlineKeyboardButton("Наш Фейсбук").apply {
                                        url = "https://www.facebook.com/"
                                    },
                                    InlineKeyboardButton("Наш Інстаграм").apply {
                                        url = "https://www.instagram.com/"
                                    }
                                ))
                            })
                    )

                }
            }

            if (update != null) {
                if (update.message.text == "Наш офіс у Києві") {

                    execute(
                        SendPhoto()
                            .setCaption("вул. Світлицького 25")
                            .setChatId(update.message.chatId)
                            .setPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSu_4jVNTI1Lw-Z0vR5ivmyEem9l-IHIT-Jw&usqp=CAU")
                    )

                }
            }

            if (update != null) {
                if (update.message.text == "Замовити послуги") {

                    execute(
                        SendMessage()
                            .setText("Вкажіть свій телефон і ми з вами зв'яжемося найближчим часом")
                            .setChatId(update.message.chatId)
                    )

                }
            }

            if (update != null) {
                if (update.message.text.contains("0" )) {

                    execute(
                        SendMessage()
                            .setText("Найближчим часом наш менеджер зв'яжемося з вами")
                            .setChatId(update.message.chatId)
                    )

                }
            }



        }

    }
}