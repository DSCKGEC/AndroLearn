package com.example.androlearn.models

class ComponentDetail (
    var comp_desc : String = "",
    var comp_image : String = "",
    var comp_name : String = "",
    var comp_ness_att : ArrayList<Map<String, String>> = ArrayList(),
    var comp_oth_att : ArrayList<Map<String, String>> = ArrayList(),
)