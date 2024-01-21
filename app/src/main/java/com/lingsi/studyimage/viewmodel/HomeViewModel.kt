package com.lingsi.studyimage.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.lingsi.studyimage.data.Category

private const val TAG = "HomeViewModel"
class HomeViewModel : ViewModel() {
    private val _categoryList = arrayListOf<Category>()
    val categoryList:List<Category>

    init {
        _categoryList.add(Category.Animal())
        _categoryList.add(Category.Vegetable())
        _categoryList.add(Category.Fruit())
        _categoryList.add(Category.Unknown())
        categoryList = _categoryList.toList()
        Log.d(TAG,"${_categoryList.size.toString()} , ${categoryList.size.toString()}")
    }
}