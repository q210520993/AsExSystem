package com.mcwczxy.AsExSystem.api

import com.skillw.asahi.api.annotation.AsahiInfix
import com.skillw.asahi.api.member.parser.infix.namespacing.BaseInfix
import java.util.UUID


@AsahiInfix
object UUIDS : BaseInfix<UUID>(UUID::class.java){
    init {
        infix("randomUUID"){
            UUID.randomUUID()
        }
    }
}

