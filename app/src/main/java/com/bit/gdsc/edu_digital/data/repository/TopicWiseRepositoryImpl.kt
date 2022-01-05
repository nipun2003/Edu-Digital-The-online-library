package com.bit.gdsc.edu_digital.data.repository

import android.util.Log
import com.bit.gdsc.edu_digital.common.Resource
import com.bit.gdsc.edu_digital.data.remote.FirebaseManager
import com.bit.gdsc.edu_digital.data.remote.dto.DSATopicWiseDto
import com.bit.gdsc.edu_digital.domain.repository.TopicWiseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TopicWiseRepositoryImpl (
    private val firebaseManager: FirebaseManager
) : TopicWiseRepository {
    override fun getDsaTopicWise(key: String): Flow<Resource<DSATopicWiseDto>> = flow {
        emit(Resource.Loading<DSATopicWiseDto>())
        try {
            val data = firebaseManager.getTopicWiseDetail(key)
            data.forEach { d->
                Log.e("Data","Topic name -> ${d.topicName}")
            }
            emit(Resource.Success<DSATopicWiseDto>(data = data))
        }catch (e : Exception){
            emit(Resource.Error<DSATopicWiseDto>(message = "Something went wrong"))
        }
    }
}