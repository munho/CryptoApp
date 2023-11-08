package com.jeremy.crypto.model.socket.request

sealed interface UpbitRequest

data class RequestTicketField(
    val ticket: String
): UpbitRequest

data class RequestTypeField(
    val type: String,
    val codes: List<String>
): UpbitRequest

data class RequestFormatField(
    val format: String = "DEFAULT"
): UpbitRequest