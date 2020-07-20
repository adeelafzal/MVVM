package com.adeelcheema.mvvm.ui

import android.view.View
import com.adeelcheema.mvvm.data.model.Movies

interface callbackListeners {

    fun recyclerItemClickListener(view: View, movie:Movies)

}