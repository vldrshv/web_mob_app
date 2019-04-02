package com.bmstu.video.entity

class User {
    var id: Int = 0
    var email: String? = null
    var name: String? = null
    var password: String? = null
    override fun toString(): String {
        return "User(id=$id, email=$email, name=$name, password=$password)"
    }


}