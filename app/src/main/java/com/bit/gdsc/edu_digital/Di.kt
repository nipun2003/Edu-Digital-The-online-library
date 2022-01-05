package com.bit.gdsc.edu_digital

import com.bit.gdsc.edu_digital.data.remote.FirebaseManager
import com.bit.gdsc.edu_digital.data.repository.TopicWiseRepositoryImpl
import com.bit.gdsc.edu_digital.domain.repository.TopicWiseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Di {

    @Provides
    @Singleton
    fun provideTopicWiseRepository() : TopicWiseRepository{
        return TopicWiseRepositoryImpl(FirebaseManager())
    }
}