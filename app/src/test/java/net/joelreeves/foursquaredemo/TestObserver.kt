package net.joelreeves.foursquaredemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock

/**
 * Starts observing `this` LiveData and returns the [Observer].
 *
 * The observer will be a [mock][org.mockito.Mockito.mock] that keeps track of invocations so that they can be [verified][org.mockito.Mockito.verify].
 *
 *    val myObserver = myLiveData.test()
 *    ...
 *    verifyZeroInteractions(myObserver)
 *    verify(myObserver, never()).onChanged(any())
 *    verify(myObserver).onChanged(eq(expected))
 *    verify(myObserver, times(2)).onChanged(eq(expected))
 */
fun <T> LiveData<T>.test(): Observer<T> =
    mock<Observer<T>>().apply {
        observeForever(this)
    }
