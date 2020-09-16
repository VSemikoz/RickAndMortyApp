package ru.vssemikoz.rickandmortyapp.utils.typeConverters

import java.text.SimpleDateFormat
import java.util.*

object DateTypeConverter {

    fun toDate(string: String, format: String): Date? {
        return SimpleDateFormat(format, Locale.ENGLISH).parse(string)
    }

    fun toString(date: Date, format: String): String {
        return SimpleDateFormat(format, Locale.ENGLISH).format(date)
    }
}
