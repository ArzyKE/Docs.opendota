package com.example.docsopendota.models

import com.google.gson.annotations.SerializedName

data class DocsHeroesModel(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("localized_name")
    val location_name: String,

    @SerializedName("primary_attr")
    val primary_attr: String,

    @SerializedName("attack_type")
    val attack_type: String
)

