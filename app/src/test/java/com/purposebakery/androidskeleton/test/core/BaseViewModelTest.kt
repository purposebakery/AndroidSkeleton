package com.purposebakery.androidskeleton.test.core

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.purposebakery.androidskeleton.test.extensions.mockStringResources
import org.junit.Before
import org.junit.Rule
import org.mockito.Mock

abstract class BaseViewModelTest : BaseUnitTest() {
    @Mock
    protected lateinit var app: Application

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupBaseViewModelTest() {
        app.mockStringResources()
    }
}