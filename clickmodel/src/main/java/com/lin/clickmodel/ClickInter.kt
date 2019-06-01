package com.lin.clickmodel

interface ClickInter {
    /**
     * 页面通用参数，一般为Activity或者Fragment继承使用
     */
    fun getPageParam(): Map<String,String>
}