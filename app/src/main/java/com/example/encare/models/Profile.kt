package com.example.encare.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Profile{
    @SerializedName("userId")
    @Expose
    var userId: String? = null

    @SerializedName("accountResponse")
    @Expose
    var accountResponse: AccountResponse? = null

    class AccountResponse{
        @SerializedName("accountId")
        @Expose
        var accountId: Int? = null

        @SerializedName("phone")
        @Expose
        var phone: String? = null

        @SerializedName("password")
        @Expose
        var password: String? = null

        @SerializedName("role")
        @Expose
        var role: String? = null

        @SerializedName("name")
        @Expose
        var name: String? = null

        @SerializedName("avatar")
        @Expose
        var avatar: String? = null

        @SerializedName("description")
        @Expose
        var description: String? = null

        @SerializedName("birthday")
        @Expose
        var birthday: String? = null

        @SerializedName("createDate")
        @Expose
        var createDate: String? = null
    }

}