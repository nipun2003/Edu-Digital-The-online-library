package com.bit.gdsc.edu_digital.presentation.course_detail_screen.components

import com.bit.gdsc.edu_digital.data.remote.dto.DSATopicWiseDtoItem

data class TopicWiseState(
    val isLoading : Boolean = false,
    val data : List<DSATopicWiseDtoItem> = emptyList(),
    val message : String? = null
)
