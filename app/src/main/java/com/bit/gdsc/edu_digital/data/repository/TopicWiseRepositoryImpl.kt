package com.bit.gdsc.edu_digital.data.repository

import android.util.Log
import com.bit.gdsc.edu_digital.common.Resource
import com.bit.gdsc.edu_digital.data.remote.FirebaseManager
import com.bit.gdsc.edu_digital.data.remote.dto.DSATopicWiseDto
import com.bit.gdsc.edu_digital.data.remote.dto.QuestionDto
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
            emit(Resource.Success<DSATopicWiseDto>(data = data))
        }catch (e : Exception){
            emit(Resource.Error<DSATopicWiseDto>(message = "Something went wrong"))
        }
    }

    override fun getQuestionTopicWise(): Flow<Resource<QuestionDto>> = flow {
        emit(Resource.Loading<QuestionDto>())
        try {
            val data = firebaseManager.getQuestion()
            emit(Resource.Success<QuestionDto>(data = data))
        }catch (e : Exception){
            emit(Resource.Error<QuestionDto>(message = "Something went wrong"))
        }
    }
}