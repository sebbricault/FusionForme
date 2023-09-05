package com.example.fusionforme.data

import com.google.gson.annotations.SerializedName


data class ExerciceKtKotlin (

  @SerializedName("name"             ) var name             : String?           = null,
  @SerializedName("force"            ) var force            : String?           = null,
  @SerializedName("level"            ) var level            : String?           = null,
  @SerializedName("mechanic"         ) var mechanic         : String?           = null,
  @SerializedName("equipment"        ) var equipment        : String?           = null,
  @SerializedName("primaryMuscles"   ) var primaryMuscles   : ArrayList<String> = arrayListOf(),
  @SerializedName("secondaryMuscles" ) var secondaryMuscles : ArrayList<String> = arrayListOf(),
  @SerializedName("instructions"     ) var instructions     : ArrayList<String> = arrayListOf(),
  @SerializedName("category"         ) var category         : String?           = null,
  @SerializedName("images"           ) var images           : ArrayList<String> = arrayListOf(),
  @SerializedName("id"               ) var id               : String?           = null

)