package com.lingsi.studyimage.data

import androidx.annotation.DrawableRes
import androidx.annotation.IntDef
import com.lingsi.studyimage.R
import com.lingsi.studyimage.data.CategoryType.Companion.ANIMAL
import com.lingsi.studyimage.data.CategoryType.Companion.FRUIT
import com.lingsi.studyimage.data.CategoryType.Companion.UNKNOWN
import com.lingsi.studyimage.data.CategoryType.Companion.VEGETABLE

sealed class Category {
    abstract val name: String

    @get:DrawableRes
    abstract val drawableRes: Int

    @CategoryType
    abstract val type: Int

    data class Animal(
        override val name: String = "动物",
        override val drawableRes: Int = R.drawable.category_animal,
        override val type: Int = CategoryType.ANIMAL
    ) : Category()

    data class Vegetable(
        override val name: String = "蔬菜",
        override val drawableRes: Int = R.drawable.category_vegetable,
        override val type: Int = CategoryType.VEGETABLE
    ) : Category()

    data class Fruit(
        override val name: String = "水果",
        override val drawableRes: Int = R.drawable.category_fruit,
        override val type: Int = CategoryType.FRUIT
    ) : Category()

    data class Unknown(
        override val name: String = "敬请期待",
        override val drawableRes: Int = R.drawable.category_unknown,
        override val type: Int = CategoryType.UNKNOWN
    ) : Category()
}

@IntDef(value = [ANIMAL, VEGETABLE, FRUIT, UNKNOWN])
@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.PROPERTY)
annotation class CategoryType {
    companion object {
        const val ANIMAL = 5001
        const val VEGETABLE = 5002
        const val FRUIT = 5003
        const val UNKNOWN = 5004
    }
}
