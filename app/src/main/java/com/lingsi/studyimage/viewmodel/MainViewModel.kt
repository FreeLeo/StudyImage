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
    val dataList: ArrayList<ImageModel> = arrayListOf()

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
        dataList.add(elephant)
        val tiger = ImageModel(
            R.string.tiger_pinyin,
            R.string.tiger,
            R.drawable.tiger,
            R.string.tiger_des,
            R.raw.tiger,
            R.raw.tiger_story,
        )
        dataList.add(tiger)
        val lion = ImageModel(
            R.string.lion_pinyin,
            R.string.lion,
            R.drawable.lion,
            R.string.lion_des,
            R.raw.lion,
            R.raw.lion_story,
        )
        dataList.add(lion)
        val giraffe = ImageModel(
            R.string.giraffe_pinyin,
            R.string.giraffe,
            R.drawable.giraffe,
            R.string.giraffe_des,
            R.raw.giraffe,
            R.raw.giraffe_story,
        )
        dataList.add(giraffe)
        val monkey = ImageModel(
            R.string.monkey_pinyin,
            R.string.monkey,
            R.drawable.monkey,
            R.string.monkey_des,
            R.raw.monkey,
            R.raw.monkey_story,
        )
        dataList.add(monkey)
        val rabbit = ImageModel(
            R.string.rabbit_pinyin,
            R.string.rabbit,
            R.drawable.rabbit,
            R.string.rabbit_des,
            R.raw.rabbit,
            R.raw.rabbit_story,
        )
        dataList.add(rabbit)
        val dog = ImageModel(
            R.string.dog_pinyin,
            R.string.dog,
            R.drawable.dog,
            R.string.dog_des,
            R.raw.dog,
            R.raw.dog_story,
        )
        dataList.add(dog)
        val cat = ImageModel(
            R.string.cat_pinyin,
            R.string.cat,
            R.drawable.cat,
            R.string.cat_des,
            R.raw.cat,
            R.raw.cat_story,
        )
        dataList.add(cat)
        val pig = ImageModel(
            R.string.pig_pinyin,
            R.string.pig,
            R.drawable.pig,
            R.string.pig_des,
            R.raw.pig,
            R.raw.pig_story,
        )
        dataList.add(pig)
        val sheep = ImageModel(
            R.string.sheep_pinyin,
            R.string.sheep,
            R.drawable.sheep,
            R.string.sheep_des,
            R.raw.sheep,
            R.raw.sheep_story,
        )
        dataList.add(sheep)
        val horse = ImageModel(
            R.string.horse_pinyin,
            R.string.horse,
            R.drawable.horse,
            R.string.horse_des,
            R.raw.horse,
            R.raw.horse_story,
        )
        dataList.add(horse)
        val cow = ImageModel(
            R.string.cow_pinyin,
            R.string.cow,
            R.drawable.cow,
            R.string.cow_des,
            R.raw.cow,
            R.raw.cow_story,
        )
        dataList.add(cow)
        val panda = ImageModel(
            R.string.panda_pinyin,
            R.string.panda,
            R.drawable.panda,
            R.string.panda_des,
            R.raw.panda,
            R.raw.panda_story,
        )
        dataList.add(panda)
        val zebra = ImageModel(
            R.string.zebra_pinyin,
            R.string.zebra,
            R.drawable.zebra,
            R.string.zebra_des,
            R.raw.zebra,
            R.raw.zebra_story,
        )
        dataList.add(zebra)
        val fox = ImageModel(
            R.string.fox_pinyin,
            R.string.fox,
            R.drawable.fox,
            R.string.fox_des,
            R.raw.fox,
            R.raw.fox_story,
        )
        dataList.add(fox)
        val mouse = ImageModel(
            R.string.mouse_pinyin,
            R.string.mouse,
            R.drawable.mouse,
            R.string.mouse_des,
            R.raw.mouse,
            R.raw.mouse_story,
        )
        dataList.add(mouse)
        val snake = ImageModel(
            R.string.snake_pinyin,
            R.string.snake,
            R.drawable.snake,
            R.string.snake_des,
            R.raw.snake,
            R.raw.snake_story,
        )
        dataList.add(snake)
        val penguin = ImageModel(
            R.string.penguin_pinyin,
            R.string.penguin,
            R.drawable.penguin,
            R.string.penguin_des,
            R.raw.penguin,
            R.raw.penguin_story,
        )
        dataList.add(penguin)
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