package com.lingsi.studyimage.viewmodel

import android.content.Context
import android.content.res.AssetFileDescriptor
import android.media.MediaPlayer
import androidx.annotation.RawRes
import androidx.lifecycle.ViewModel
import com.lingsi.studyimage.R
import com.lingsi.studyimage.data.ImageModel


class MainViewModel : ViewModel() {
    private var mediaPlayer: MediaPlayer? = null
    val animalList: ArrayList<ImageModel> = arrayListOf()
    val vegetableList: ArrayList<ImageModel> = arrayListOf()
    val fruitList: ArrayList<ImageModel> = arrayListOf()

//    private var soundPool: SoundPool? = null
//    private var currentSoundId: Int? = null

    init {
        val elephant = ImageModel(
            R.string.elephant_pinyin,
            R.string.elephant,
            R.drawable.elephant,
            R.string.elephant_des,
            R.raw.elephant,
            R.raw.elephant_story,
        )
        animalList.add(elephant)
        val tiger = ImageModel(
            R.string.tiger_pinyin,
            R.string.tiger,
            R.drawable.tiger,
            R.string.tiger_des,
            R.raw.tiger,
            R.raw.tiger_story,
        )
        animalList.add(tiger)
        val lion = ImageModel(
            R.string.lion_pinyin,
            R.string.lion,
            R.drawable.lion,
            R.string.lion_des,
            R.raw.lion,
            R.raw.lion_story,
        )
        animalList.add(lion)
        val giraffe = ImageModel(
            R.string.giraffe_pinyin,
            R.string.giraffe,
            R.drawable.giraffe,
            R.string.giraffe_des,
            R.raw.giraffe,
            R.raw.giraffe_story,
        )
        animalList.add(giraffe)
        val monkey = ImageModel(
            R.string.monkey_pinyin,
            R.string.monkey,
            R.drawable.monkey,
            R.string.monkey_des,
            R.raw.monkey,
            R.raw.monkey_story,
        )
        animalList.add(monkey)
        val rabbit = ImageModel(
            R.string.rabbit_pinyin,
            R.string.rabbit,
            R.drawable.rabbit,
            R.string.rabbit_des,
            R.raw.rabbit,
            R.raw.rabbit_story,
        )
        animalList.add(rabbit)
        val dog = ImageModel(
            R.string.dog_pinyin,
            R.string.dog,
            R.drawable.dog,
            R.string.dog_des,
            R.raw.dog,
            R.raw.dog_story,
        )
        animalList.add(dog)
        val cat = ImageModel(
            R.string.cat_pinyin,
            R.string.cat,
            R.drawable.cat,
            R.string.cat_des,
            R.raw.cat,
            R.raw.cat_story,
        )
        animalList.add(cat)
        val pig = ImageModel(
            R.string.pig_pinyin,
            R.string.pig,
            R.drawable.pig,
            R.string.pig_des,
            R.raw.pig,
            R.raw.pig_story,
        )
        animalList.add(pig)
        val sheep = ImageModel(
            R.string.sheep_pinyin,
            R.string.sheep,
            R.drawable.sheep,
            R.string.sheep_des,
            R.raw.sheep,
            R.raw.sheep_story,
        )
        animalList.add(sheep)
        val horse = ImageModel(
            R.string.horse_pinyin,
            R.string.horse,
            R.drawable.horse,
            R.string.horse_des,
            R.raw.horse,
            R.raw.horse_story,
        )
        animalList.add(horse)
        val cow = ImageModel(
            R.string.cow_pinyin,
            R.string.cow,
            R.drawable.cow,
            R.string.cow_des,
            R.raw.cow,
            R.raw.cow_story,
        )
        animalList.add(cow)
        val panda = ImageModel(
            R.string.panda_pinyin,
            R.string.panda,
            R.drawable.panda,
            R.string.panda_des,
            R.raw.panda,
            R.raw.panda_story,
        )
        animalList.add(panda)
        val zebra = ImageModel(
            R.string.zebra_pinyin,
            R.string.zebra,
            R.drawable.zebra,
            R.string.zebra_des,
            R.raw.zebra,
            R.raw.zebra_story,
        )
        animalList.add(zebra)
        val fox = ImageModel(
            R.string.fox_pinyin,
            R.string.fox,
            R.drawable.fox,
            R.string.fox_des,
            R.raw.fox,
            R.raw.fox_story,
        )
        animalList.add(fox)
        val mouse = ImageModel(
            R.string.mouse_pinyin,
            R.string.mouse,
            R.drawable.mouse,
            R.string.mouse_des,
            R.raw.mouse,
            R.raw.mouse_story,
        )
        animalList.add(mouse)
        val snake = ImageModel(
            R.string.snake_pinyin,
            R.string.snake,
            R.drawable.snake,
            R.string.snake_des,
            R.raw.snake,
            R.raw.snake_story,
        )
        animalList.add(snake)
        val penguin = ImageModel(
            R.string.penguin_pinyin,
            R.string.penguin,
            R.drawable.penguin,
            R.string.penguin_des,
            R.raw.penguin,
            R.raw.penguin_story,
        )
        animalList.add(penguin)

        val carrot = ImageModel(
            R.string.carrot_pinyin,
            R.string.carrot,
            R.drawable.huluobo,
            R.string.carrot_des,
            R.raw.huluobo,
            R.raw.huluobo_story,
        )
        vegetableList.add(carrot)
        val eggplant = ImageModel(
            R.string.eggplant_pinyin,
            R.string.eggplant,
            R.drawable.qiezi,
            R.string.eggplant_des,
            R.raw.qiezi,
            R.raw.qiezi_story,
        )
        vegetableList.add(eggplant)
        val onion = ImageModel(
            R.string.onion_pinyin,
            R.string.onion,
            R.drawable.yangcong,
            R.string.onion_des,
            R.raw.yangcong,
            R.raw.yangcong_story,
        )
        vegetableList.add(onion)
        val potato = ImageModel(
            R.string.potato_pinyin,
            R.string.potato,
            R.drawable.potato,
            R.string.potato_des,
            R.raw.potato,
            R.raw.potato_story,
        )
        vegetableList.add(potato)
        val tomato = ImageModel(
            R.string.tomato_pinyin,
            R.string.tomato,
            R.drawable.tomato,
            R.string.tomato_des,
            R.raw.tomato,
            R.raw.tomato_story,
        )
        vegetableList.add(tomato)
        val cucumber = ImageModel(
            R.string.cucumber_pinyin,
            R.string.cucumber,
            R.drawable.cucumber,
            R.string.cucumber_des,
            R.raw.cucumber,
            R.raw.cucumber_story,
        )
        vegetableList.add(cucumber)
        val corn = ImageModel(
            R.string.corn_pinyin,
            R.string.corn,
            R.drawable.corn,
            R.string.corn_des,
            R.raw.corn,
            R.raw.corn_story,
        )
        vegetableList.add(corn)
        val mushroom = ImageModel(
            R.string.mushroom_pinyin,
            R.string.mushroom,
            R.drawable.mushroom,
            R.string.mushroom_des,
            R.raw.mushroom,
            R.raw.mushroom_story,
        )
        vegetableList.add(mushroom)
        val broccoli = ImageModel(
            R.string.broccoli_pinyin,
            R.string.broccoli,
            R.drawable.broccoli,
            R.string.broccoli_des,
            R.raw.broccoli,
            R.raw.broccoli_story,
        )
        vegetableList.add(broccoli)
        val lotus = ImageModel(
            R.string.lotus_pinyin,
            R.string.lotus,
            R.drawable.lotus,
            R.string.lotus_des,
            R.raw.lotus,
            R.raw.lotus_story,
        )
        vegetableList.add(lotus)
        val ginger = ImageModel(
            R.string.ginger_pinyin,
            R.string.ginger,
            R.drawable.ginger,
            R.string.ginger_des,
            R.raw.ginger,
            R.raw.ginger_story,
        )
        vegetableList.add(ginger)
        val pumpkin = ImageModel(
            R.string.pumpkin_pinyin,
            R.string.pumpkin,
            R.drawable.pumpkin,
            R.string.pumpkin_des,
            R.raw.pumpkin,
            R.raw.pumpkin_story,
        )
        vegetableList.add(pumpkin)
        val spinach = ImageModel(
            R.string.spinach_pinyin,
            R.string.spinach,
            R.drawable.spinach,
            R.string.spinach_des,
            R.raw.spinach,
            R.raw.spinach_story,
        )
        vegetableList.add(spinach)
        val garlic = ImageModel(
            R.string.garlic_pinyin,
            R.string.garlic,
            R.drawable.garlic,
            R.string.garlic_des,
            R.raw.garlic,
            R.raw.garlic_story,
        )
        vegetableList.add(garlic)
        val pea = ImageModel(
            R.string.pea_pinyin,
            R.string.pea,
            R.drawable.pea,
            R.string.pea_des,
            R.raw.pea,
            R.raw.pea_story,
        )
        vegetableList.add(pea)
        val chili = ImageModel(
            R.string.chili_pinyin,
            R.string.chili,
            R.drawable.chili,
            R.string.chili_des,
            R.raw.chili,
            R.raw.chili_story,
        )
        vegetableList.add(chili)

        val apple = ImageModel(
            R.string.apple_pinyin,
            R.string.apple,
            R.drawable.apple,
            R.string.apple_des,
            R.raw.apple,
            R.raw.apple_story,
        )
        fruitList.add(apple)
        val orange = ImageModel(
            R.string.orange_pinyin,
            R.string.orange,
            R.drawable.orange,
            R.string.orange_des,
            R.raw.orange,
            R.raw.orange_story,
        )
        fruitList.add(orange)
        val pear = ImageModel(
            R.string.pear_pinyin,
            R.string.pear,
            R.drawable.pear,
            R.string.pear_des,
            R.raw.pear,
            R.raw.pear_story,
        )
        fruitList.add(pear)
        val mango = ImageModel(
            R.string.mango_pinyin,
            R.string.mango,
            R.drawable.mango,
            R.string.mango_des,
            R.raw.mango,
            R.raw.mango_story,
        )
        fruitList.add(mango)
        val pineapple = ImageModel(
            R.string.pineapple_pinyin,
            R.string.pineapple,
            R.drawable.pineapple,
            R.string.pineapple_des,
            R.raw.pineapple,
            R.raw.pineapple_story,
        )
        fruitList.add(pineapple)
        val strawberry = ImageModel(
            R.string.strawberry_pinyin,
            R.string.strawberry,
            R.drawable.strawberry,
            R.string.strawberry_des,
            R.raw.strawberry,
            R.raw.strawberry_story,
        )
        fruitList.add(strawberry)
        val cherry = ImageModel(
            R.string.cherry_pinyin,
            R.string.cherry,
            R.drawable.cherry,
            R.string.cherry_des,
            R.raw.cherry,
            R.raw.cherry_story,
        )
        fruitList.add(cherry)
        val banana = ImageModel(
            R.string.banana_pinyin,
            R.string.banana,
            R.drawable.banana,
            R.string.banana_des,
            R.raw.banana,
            R.raw.banana_story,
        )
        fruitList.add(banana)
        val grape = ImageModel(
            R.string.grape_pinyin,
            R.string.grape,
            R.drawable.grape,
            R.string.grape_des,
            R.raw.grape,
            R.raw.grape_story,
        )
        fruitList.add(grape)
        val lemon = ImageModel(
            R.string.lemon_pinyin,
            R.string.lemon,
            R.drawable.lemon,
            R.string.lemon_des,
            R.raw.lemon,
            R.raw.lemon_story,
        )
        fruitList.add(lemon)

    }

    fun play(context: Context, @RawRes resId: Int) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer()
        }
        mediaPlayer?.reset()
        val file: AssetFileDescriptor = context.resources.openRawResourceFd(resId)
        mediaPlayer?.setDataSource(file.fileDescriptor, file.startOffset, file.length)
        mediaPlayer?.prepare()
        mediaPlayer?.start()
        file.close()
    }

    fun stop() {
        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.stop()
        }
    }

    override fun onCleared() {
        super.onCleared()
        mediaPlayer?.release()
    }

//    private var soundPool: SoundPool? = null
//    private var currentSoundId: Int? = null
//
//    fun play(context: Context, @RawRes resId: Int) {
//        if (soundPool == null) {
//            val builder = SoundPool.Builder()
//            builder.setMaxStreams(1)
//            val attrBuilder = AudioAttributes.Builder()
//            attrBuilder.setLegacyStreamType(AudioManager.STREAM_MUSIC)
//            builder.setAudioAttributes(attrBuilder.build())
//            soundPool = builder.build()
//        }
//        stop()
//        currentSoundId = soundPool?.load(context, resId, 1)
//        soundPool?.setOnLoadCompleteListener { soundPool, sampleId, status ->
//            if (status == 0) {
//                soundPool.play(currentSoundId!!, 1F, 1F, 1, 0, 1F)
//            }
//        }
//    }
//
//    fun stop() {
//        soundPool?.let { pool ->
//            currentSoundId?.let { id ->
//                pool.stop(id)
//                pool.unload(id)
//                currentSoundId = null
//            }
//        }
//    }

}