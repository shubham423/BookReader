package com.shubham.bookreader.utils

import android.annotation.SuppressLint
import android.icu.text.DateFormat
import android.os.Build
import androidx.annotation.RequiresApi
import com.google.firebase.Timestamp


@SuppressLint("NewApi")
fun formatDate(timestamp: Timestamp): String {
    return DateFormat.getDateInstance().format(timestamp.toDate()).toString().split(",")[0] // March 12
}