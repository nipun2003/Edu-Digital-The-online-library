package com.bit.gdsc.edu_digital.domain.repository

import com.bit.gdsc.edu_digital.common.Resource
import com.bit.gdsc.edu_digital.data.remote.dto.DSATopicWiseDto
import kotlinx.coroutines.flow.Flow

interface TopicWiseRepository {

    fun getDsaTopicWise(key:String) : Flow<Resource<DSATopicWiseDto>>
}