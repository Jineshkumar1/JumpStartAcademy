package com.brightsprouts.data.database.converters

import androidx.room.TypeConverter
import com.brightsprouts.core.domain.model.LessonDomain
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DomainConverters {
    
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
    
    @TypeConverter
    fun fromDomain(domain: LessonDomain): String {
        return domain.name
    }
    
    @TypeConverter
    fun toDomain(domain: String): LessonDomain {
        return LessonDomain.valueOf(domain)
    }
    
    @TypeConverter
    fun fromLocalDateTime(dateTime: LocalDateTime?): String? {
        return dateTime?.format(formatter)
    }
    
    @TypeConverter
    fun toLocalDateTime(dateTime: String?): LocalDateTime? {
        return dateTime?.let { LocalDateTime.parse(it, formatter) }
    }
}
