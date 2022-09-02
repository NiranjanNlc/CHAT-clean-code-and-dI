package org.lniranjan.chatclone.utils

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment


inline fun Context.toast(message:()->String){
    Toast.makeText(this, message() , Toast.LENGTH_LONG).show()
}

inline fun Fragment.toast(message:()->String){
    Toast.makeText(this.context, message() , Toast.LENGTH_LONG).show()
}