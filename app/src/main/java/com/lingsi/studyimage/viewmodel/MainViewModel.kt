package com.lingsi.studyimage.viewmodel

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import androidx.annotation.RawRes
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var soundPool: SoundPool? = null
    private var currentSoundId: Int? = null

    fun play(context: Context, @RawRes resId: Int) {
        if (soundPool == null) {
            val builder = SoundPool.Builder()
            builder.setMaxStreams(1)
            val attrBuilder = AudioAttributes.Builder()
            attrBuilder.setLegacyStreamType(AudioManager.STREAM_MUSIC)
            builder.setAudioAttributes(attrBuilder.build())
            soundPool = builder.build()
        }
        stop()
        currentSoundId = soundPool?.load(context, resId, 1)
        soundPool?.setOnLoadCompleteListener { soundPool, sampleId, status ->
            if (status == 0) {
                soundPool.play(currentSoundId!!, 1F, 1F, 1, 0, 1F)
            }
        }
    }

    fun stop() {
        soundPool?.let { pool ->
            currentSoundId?.let { id ->
                pool.stop(id)
                pool.unload(id)
                currentSoundId = null
            }
        }
    }

}