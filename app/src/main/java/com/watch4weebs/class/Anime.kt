package com.watch4weebs.`class`

import java.io.Serializable

data class Anime (
    val id : String,
    val name: String,
    val author: String)  : Serializable {
    val description: String = "pas de description"
    val cover: String = "image de base "
}
