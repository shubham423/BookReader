package com.shubham.bookreader.screens.details

import androidx.lifecycle.ViewModel
import com.shubham.bookreader.data.Resource
import com.shubham.bookreader.model.Item
import com.shubham.bookreader.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: BookRepository)

    : ViewModel() {
    suspend fun getBookInfo(bookId: String): Resource<Item> {
        return repository.getBookInfo(bookId)
    }
}
