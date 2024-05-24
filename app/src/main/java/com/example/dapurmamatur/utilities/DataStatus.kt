package com.example.dapurmamatur.utilities

class DataStatus<out T>(val status: Status, val data: T? = null, val message: String? = null) {

    enum class Status {
        LOADING, SUCCESS, ERROR
    }

    companion object {
        fun <T> loading(): DataStatus<T> = DataStatus(Status.LOADING)
        fun <T> success(data: T?): DataStatus<T> = DataStatus(Status.SUCCESS, data)
        fun <T> error(message: String): DataStatus<T> = DataStatus(Status.ERROR, message = message)
    }
}