package diplom.time.mvp.models
import com.activeandroid.Model
import com.activeandroid.annotation.Column
import com.activeandroid.annotation.Table
@Table(name = "Pas")
class Pas : Model {
    @Column(name = "title")
    var title: String? = null
    constructor(title: String) {
        this.title = title
    }
    constructor()
    fun getInfo(): String = "Название:\n$title\n";
}