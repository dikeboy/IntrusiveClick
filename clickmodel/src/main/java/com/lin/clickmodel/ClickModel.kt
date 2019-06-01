package com.lin.clickmodel

import android.util.Log
import android.view.View

object ClickModel {


    fun doClick(view: View, m: Map<String,String>) {
        var data = view.getTag(R.id.snow_click_id) as String
        var map = mutableMapOf<String,String>()
        map.putAll(m);
        data?.split(",").forEach {
            if(it.contains(":")){
                map.put(it.split(":")[0],it.split(":")[1])
            }
        }
        Log.e("lin",map.toString())
    }
}
