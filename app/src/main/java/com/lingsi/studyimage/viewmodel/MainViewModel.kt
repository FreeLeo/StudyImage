package com.lingsi.studyimage.viewmodel

import android.R
import android.content.Context
import android.content.res.AssetFileDescriptor
import android.media.MediaPlayer
import androidx.annotation.RawRes
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {
    private var mediaPlayer: MediaPlayer? = null

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
        if (mediaPlayer?.isPlaying == true){
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