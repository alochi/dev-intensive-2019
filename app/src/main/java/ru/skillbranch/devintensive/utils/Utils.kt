package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        //if(fullName!!.isBlank()) return

        val parts: List<String>? = fullName?.trim()?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        return firstName to lastName
    }

    fun transliterations(payload: String, divider: String = " "): String {
        var result = ""
        payload.withIndex().forEach { (index, element) -> when (element.toLowerCase()) {
                'а' -> result += if (element.isUpperCase()) "A" else "a"
                'б' -> result += if (element.isUpperCase()) "B" else "b"
                'в' -> result += if (element.isUpperCase()) "V" else "v"
                'г' -> result += if (element.isUpperCase()) "V" else "g"
                'д' -> result += if (element.isUpperCase()) "V" else "d"
                'е', 'э' -> result += if (element.isUpperCase()) "E" else "e"
                'ё' -> result += if (element.isUpperCase()) "Jo" else "jo"
                'ж' -> result += if (element.isUpperCase()) "Zh" else "zh"
                'з' -> result += if (element.isUpperCase()) "Z" else "z"
                'и' -> result += if (element.isUpperCase()) "I" else "i"
                'й' -> result += if (element.isUpperCase()) "J" else "j"
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
                'ц' -> result += if (element.isUpperCase()) "Ts" else "ts"
                'ч' -> result += if (element.isUpperCase()) "Ch" else "ch"
                'ш', 'щ' -> result += if (element.isUpperCase()) "Sh" else "sh"
                'ъ', 'ь' -> result += if (element.isUpperCase()) "'" else "'"
                'ы' -> result += if (element.isUpperCase()) "Y" else "y"
                'ю' -> result += if (element.isUpperCase()) "Yu" else "yu"
                'я' -> result += if (element.isUpperCase()) "Ya" else "ya"
                ' ' -> result += divider
                else -> result += payload[index]
            }
        }
        return result
    }

    fun initials(firstName: String?, lastName: String?): String? =
        "${firstName?.first()?.toUpperCase()}${lastName?.first()?.toUpperCase()}"

}