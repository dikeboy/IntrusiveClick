package com.lin.aopdemo

import android.content.Context
import android.view.View

fun View.getClickData():String{
    return "nihaoya" +getTag()
}