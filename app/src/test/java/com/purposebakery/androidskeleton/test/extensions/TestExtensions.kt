package com.purposebakery.androidskeleton.test.extensions

import android.app.Application
import androidx.annotation.StringRes
import org.junit.Assert.assertEquals
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

fun Application.mockStringResources() {
    whenever(getString(any())).thenAnswer {
        (it.arguments[0] as Int).toString()
    }
}

fun assertEqualsStringResource(text: String?, @StringRes stringRes: Int) {
    assertEquals(text, stringRes.toString())
}
