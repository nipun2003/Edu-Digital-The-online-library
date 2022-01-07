package com.bit.gdsc.edu_digital.presentation.course_detail_screen.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bit.gdsc.edu_digital.common.Constants
import com.bit.gdsc.edu_digital.common.Resource
import com.bit.gdsc.edu_digital.domain.model.courses
import com.bit.gdsc.edu_digital.domain.repository.TopicWiseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CourseDetailViewModel @Inject constructor(
    private val topicWiseRepository: TopicWiseRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _title = mutableStateOf("")
    val title : State<String> = _title

    private val _dsaTopicWiseState = mutableStateOf(TopicWiseState())
    val dsaTopicWiseState : State<TopicWiseState> = _dsaTopicWiseState

    init {
        savedStateHandle.get<Int>("id")?.let { id->
            _title.value = courses[id-1].name
            Constants.courseMap[id]?.let {
                getDsaTopicWise(it)
            }
        }
    }

    private fun getDsaTopicWise(key : String){
        topicWiseRepository.getDsaTopicWise(key).onEach { result ->
            when(result){
                is Resource.Success ->{
                    _dsaTopicWiseState.value = TopicWiseState(
                        isLoading = false,
                        data = result.data?: emptyList()
                    )
                }
                is Resource.Error ->{
                    _dsaTopicWiseState.value = TopicWiseState(
                        isLoading = false,
                        message = result.message
                    )
                }
                is Resource.Loading ->{
                    _dsaTopicWiseState.value = TopicWiseState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}