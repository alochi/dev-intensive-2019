package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.trim()?.split(" ")

        var firstName = parts?.getOrNull(0)
        if (firstName.isNullOrBlank()) firstName = null
        val lastName = parts?.getOrNull(1)

        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        var result = ""
        payload.forEachIndexed { index, element ->
            when (element.toLowerCase()) {
                'а' -> result += if (element.isUpperCase()) "A" else "a"
                'б' -> result += if (element.isUpperCase()) "B" else "b"
                'в' -> result += if (element.isUpperCase()) "V" else "v"
                'г' -> result += if (element.isUpperCase()) "G" else "g"
                'д' -> result += if (element.isUpperCase()) "D" else "d"
                'е', 'ё', 'э' -> result += if (element.isUpperCase()) "E" else "e"
                'ж' -> result += if (element.isUpperCase()) "Zh" else "zh"
                'з' -> result += if (element.isUpperCase()) "Z" else "z"
                'и', 'й', 'ы' -> result += if (element.isUpperCase()) "I" else "i"
                'к' -> result += if (element.isUpperCase()) "K" else "k"
                'л' -> result += if (element.isUpperCase()) "L" else "l"
                'м' -> result += if (element.isUpperCase()) "M" else "m"
                'н' -> result += if (element.isUpperCase()) "N" else "n"
                'о' -> result += if (element.isUpperCase()) "O" else "o"
                'п' -> result += if (element.isUpperCase()) "P" else "p"
                'р' -> result += if (element.isUpperCase()) "R" else "r"
                'с' -> result += if (element.isUpperCase()) "S" else "s"
                'т' -> result += if (element.isUpperCase()) "T" else "t"
                'у' -> result += if (element.isUpperCase()) "U" else "u"
                'ф' -> result += if (element.isUpperCase()) "F" else "f"
                'х' -> result += if (element.isUpperCase()) "H" else "h"
                'ц' -> result += if (element.isUpperCase()) "C" else "c"
                'ч' -> result += if (element.isUpperCase()) "Ch" else "ch"
                'ш', 'щ' -> result += if (element.isUpperCase()) "Sh" else "sh"
                'ъ', 'ь' -> result += if (element.isUpperCase()) "" else ""
                'ю' -> result += if (element.isUpperCase()) "Yu" else "yu"
                'я' -> result += if (element.isUpperCase()) "Ya" else "ya"
                ' ' -> result += divider
                else -> result += payload[index]
            }
        }
        return result
    }

    fun toInitials(firstName: String?, lastName: String?): String? =
        if (!firstName.isNullOrBlank() && lastName.isNullOrBlank())
            firstName[0].toUpperCase().toString()
        else if (firstName.isNullOrBlank() && !lastName.isNullOrBlank())
            lastName[0].toUpperCase().toString()
        else if (!firstName.isNullOrBlank() && !lastName.isNullOrBlank())
            "${firstName.first().toUpperCase()}${lastName.first().toUpperCase()}"
        else null

}