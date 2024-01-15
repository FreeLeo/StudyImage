package com.lingsi.studyimage.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class ImageModel(
    @StringRes
    val name: Int,
    @DrawableRes
    val drawable: Int
)