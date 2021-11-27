package com.shubham.bookreader

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BookReaderApplication: Application(){

    init {
        instance = this
    }

    companion object {
        private var instance: BookReaderApplication? = null

        fun applicationContext(): BookReaderApplication {
            return instance as BookReaderApplication
        }
    }
}