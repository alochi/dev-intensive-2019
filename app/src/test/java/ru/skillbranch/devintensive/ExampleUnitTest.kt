package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.extensions.toUserView
import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.Chat
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user2 = User("2", "John", "Cena")
    }

    @Test
    fun test_factory() {
        val user = User.makeUser("")
        val user2 = user.copy(id = "2", lastName = "Sena")

        println("$user \n$user2")
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Wick")

        fun getUserInfo() = user

        val (id, firstName, lastName) = getUserInfo()

        println("$id, $firstName, $lastName")
        println("${user.component1()}, ${user.component2()}, ${user.component3()}")
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
        var user2 = user.copy(lastVisit = Date())
        var user3 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        var user4 = user.copy(lastVisit = Date().add(3, TimeUnits.HOUR))

        println(
            """
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}            
            ${user4.lastVisit?.format()}            
        """.trimIndent()
        )
    }

    @Test
    fun test_data_maping() {
        val user = User.makeUser(" ")
        val userNew = user.copy(lastVisit = Date().add(-1, TimeUnits.DAY))
        val userView = userNew.toUserView()

        userView.printMe()
    }

    @Test
    fun test_transliteration() {
        println(Utils.transliteration("Женя Стереотипов")) //Zhenya Stereotipov
        println(Utils.transliteration("Amazing Петр", "_")) //Amazing_Petr
    }

    @Test
    fun test_parseFullName() {
        println(Utils.parseFullName(null))
        println(Utils.parseFullName(""))
        println(Utils.parseFullName(" "))
        println(Utils.parseFullName("Sdg"))
        println(Utils.parseFullName("Sdg sdffsdf"))
    }

    @Test
    fun test_toInitials() {
        println(Utils.toInitials("john", "doe")) //JD
        println(Utils.toInitials("John", null)) //J
        println(Utils.toInitials(null, null)) //null
        println(Utils.toInitials("John", "")) //null
        println(Utils.toInitials(" ", " ")) //null
    }

    @Test
    fun test_dateFormat() {
        println(Date().format()) //14:00:00 27.06.19
        print(Date().format("HH:mm")) //14:00
    }

    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Очиров Алдар")
        val txtMessage = BaseMessage.makeMessage(user,
            Chat("0"),
            date = Date(),
            payload = "any text message",
            type = "text")
        val imgMessage = BaseMessage.makeMessage(user,
            Chat("0"),
            date = Date().add(-1, TimeUnits.DAY),
            payload = "any image url",
            type = "image")

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())

    }
}
