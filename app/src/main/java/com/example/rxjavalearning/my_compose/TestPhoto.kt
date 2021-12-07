package com.example.rxjavalearning.my_compose

import com.example.rxjavalearning.R
import com.example.rxjavalearning.my_retrofit.view.MarsPhotoGalleryFragment

data class TestPhoto(val id:Int, val imageFromResource:Int) {}

fun getTestPhotoList():List<TestPhoto> {
    val list:MutableList<TestPhoto> = mutableListOf()
    for (i in 0..10){
        list.add(TestPhoto(i, R.drawable.ic_loading_mars_photo))
    }
    return list
}


data class GeneratedMarsPhoto(val id:Int, val url:String){}
val list:MutableList<GeneratedMarsPhoto> = mutableListOf(
    GeneratedMarsPhoto(424905, "http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg"),
    GeneratedMarsPhoto(424906, "http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg"),
    GeneratedMarsPhoto(424907, "http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg"),
    GeneratedMarsPhoto(424908, "http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg"),
    GeneratedMarsPhoto(424909, "http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg"),
    GeneratedMarsPhoto(424910, "http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg"),
    GeneratedMarsPhoto(424911, "http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg"),
    GeneratedMarsPhoto(424912, "http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg"),
    GeneratedMarsPhoto(424913, "http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg"),
    GeneratedMarsPhoto(424914, "http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg"),
)

