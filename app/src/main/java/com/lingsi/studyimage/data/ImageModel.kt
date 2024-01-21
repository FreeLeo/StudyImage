package com.lingsi.studyimage.data

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.annotation.StringRes

class ImageModel(
    @StringRes
    val namePinYin: Int,
    @StringRes
    val name: Int,
    @DrawableRes
    val drawable: Int,
    @StringRes
    val description: Int,
    @RawRes
    val nameAudio: Int,
    @RawRes
    val storyAudio: Int,
){
    fun aa(){}
}