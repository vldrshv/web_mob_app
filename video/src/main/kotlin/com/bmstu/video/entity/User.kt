package com.bmstu.video.entity

class User (
        var id: Int = 0,
        var email: String? = null,
        var name: String? = null,
        var pin: String? = null
) {
    override fun toString(): String {
        return "User(id=$id, email=$email, name=$name, password=$pin)"
    }
}