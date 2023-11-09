package diplom.time.mvp.models
// Импорт необходтмых библиотек
import com.activeandroid.Model
import com.activeandroid.annotation.Column
import com.activeandroid.annotation.Table
import diplom.time.utils.formatDate
import java.util.*
//Создание реляционной БД Notes
@Table(name = "Notes")
//Описание модели Note с объявлением полей
class Note : Model {
    @Column(name = "pascade")
    var pascade: Int? = null
    @Column(name = "title")
    var title: String? = null
    @Column(name = "text")
    var text: String? = null
    @Column(name = "create_date")
    var createDate: Date? = null
    @Column(name = "change_date")
    var changeDate: Date? = null
    @Column(name = "event")
    var event: Long =0
    //Конструктор для внутреннего использования
    constructor(pascade: Int, title: String, createDate: Date,event: Long) {
        this.pascade=pascade
        this.title = title
        this.createDate = createDate
        this.changeDate = createDate
        this.event=event
    }
    //Конструктор для автообновления
    constructor()
    //Метод формирования выдачи информацци о записи
    fun getInfo(): String = "Название:\n$title\n" +
            "Время создания:\n${formatDate(createDate)}\n" +
            "Время изменения:\n${formatDate(changeDate)}";
}