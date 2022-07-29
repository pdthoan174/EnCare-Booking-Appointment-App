package com.example.encare.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProfileResponse: Response() {
    // name trong api: phai trung voi api
    @SerializedName("data")
    @Expose
    var data: Profile? = null
}