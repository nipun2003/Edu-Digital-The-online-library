package com.bit.gdsc.edu_digital.data.remote

import com.bit.gdsc.edu_digital.data.remote.dto.DSATopicWiseDto
import com.bit.gdsc.edu_digital.data.remote.dto.QuestionDto
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.google.gson.Gson
import kotlinx.coroutines.tasks.await

class FirebaseManager {
    private val remoteConfig = Firebase.remoteConfig
    private val configSettings = remoteConfigSettings {
        minimumFetchIntervalInSeconds = 3600
    }
    init {
        remoteConfig.setConfigSettingsAsync(configSettings)
        initialiseRemoteConfig()
    }
    private fun initialiseRemoteConfig(){
        remoteConfig.fetchAndActivate()
    }

    fun getTopicWiseDetail(key : String) : DSATopicWiseDto{
        val gson = Gson()
        return gson.fromJson(remoteConfig.getString(key),DSATopicWiseDto::class.java)
    }

    fun getQuestion() : QuestionDto{
        val gson = Gson()
        return gson.fromJson(remoteConfig.getString("QuestionsTopicWise"),QuestionDto::class.java)
    }
}