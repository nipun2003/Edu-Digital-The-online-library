package com.bit.gdsc.edu_digital.presentation.question_screen

import com.bit.gdsc.edu_digital.data.remote.dto.QuestionDtoItem

data class QuestionState(
    val isLoading : Boolean = false,
    val data : List<QuestionDtoItem> = emptyList(),
    val message : String? = null
)
