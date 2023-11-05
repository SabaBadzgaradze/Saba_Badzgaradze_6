package com.example.saba_badzgaradze_6

import com.google.gson.annotations.SerializedName

data  class Data<T>(

    var page: Int?,

    @SerializedName("per_page")
    var perPage: Int?,

    var total: Int?,
    @SerializedName("total_pages")
    var totalPages: Int?,

    var data: T?

)

data class Person(
    var id: Long?,

    var email: String?,

    @SerializedName("first_name")
    var firstName: String?,

    @SerializedName("last_name")
    var lastName: String?,

    var avatar: String?
)