package com.adeelcheema.mvvm.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

object Corountines {

    fun <T : Any> ioThreadMain(work: suspend (() -> T?), callback: ((T?) -> Unit)) =

        CoroutineScope(Dispatchers.Main).launch {
            val data = CoroutineScope((Dispatchers.IO)).async rt@{
                return@rt work()
            }.await()

            callback(data)


        }

}