package com.example.todoapp

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun getDateInFormat(dateInMillis: Long): String {
    val instant = Instant.ofEpochMilli(dateInMillis)
    val localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate()
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    return localDate.format(formatter)
}