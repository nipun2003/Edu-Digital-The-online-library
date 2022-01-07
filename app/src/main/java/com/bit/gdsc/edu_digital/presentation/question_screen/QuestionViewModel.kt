package com.bit.gdsc.edu_digital.presentation.question_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bit.gdsc.edu_digital.common.Resource
import com.bit.gdsc.edu_digital.domain.repository.TopicWiseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(
    private val topicWiseRepository: TopicWiseRepository
) : ViewModel() {

    private val _questionState = mutableStateOf(QuestionState())
    val questionState : State<QuestionState> = _questionState

    init {
        getQuestions()
    }

    private fun getQuestions(){
        topicWiseRepository.getQuestionTopicWise().onEach { result->
            when(result){
                is Resource.Success ->{
                    _questionState.value = QuestionState(
                        isLoading = false,
                        data = result.data?: emptyList()
                    )
                }
                is Resource.Error ->{
                    _questionState.value = QuestionState(
                        isLoading = false,
                        message = result.message
                    )
                }
                is Resource.Loading ->{
                    _questionState.value = QuestionState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}