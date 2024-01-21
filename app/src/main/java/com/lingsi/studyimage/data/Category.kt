package com.lingsi.studyimage.data

import androidx.annotation.DrawableRes
import com.lingsi.studyimage.R

sealed class Category {
    abstract val name: String

    @get:DrawableRes
    abstract val drawableRes: Int

    data class Animal(
        override val name: String = "动物",
        override val drawableRes: Int = R.drawable.category_animal
    ) : Category()

    data class Vegetable(
        override val name: String = "蔬菜",
        override val drawableRes: Int = R.drawable.category_vegetable
    ) : Category()

    data class Fruit(
        override val name: String = "水果",
        override val drawableRes: Int = R.drawable.category_fruit
    ) : Category()

    data class Unknown(
        override val name: String = "敬请期待",
        override val drawableRes: Int = R.drawable.category_unknown
    ) : Category()
}
