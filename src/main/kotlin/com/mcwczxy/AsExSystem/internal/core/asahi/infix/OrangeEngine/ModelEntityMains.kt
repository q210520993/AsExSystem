package com.mcwczxy.AsExSystem.internal.core.asahi.infix.OrangeEngine

import com.skillw.asahi.api.annotation.AsahiInfix
import com.skillw.asahi.api.member.parser.infix.namespacing.BaseInfix
import ltd.icecold.orangeengine.api.data.model.ModelType
import ltd.icecold.orangeengine.api.model.ModelEntity

@AsahiInfix
object ModelEntityMains:BaseInfix<ModelEntity>(ModelEntity::class.java, "OrangeEngine") {
    init {
        infix("PlayAnimation"){
            it.playAnimation(
                parseString(),
                parseInt(),
                parseInt()
            )
        }
        infix("setAnimation"){
            it.setAnimation(
                parseString(),
                parseInt(),
                parseInt()
            )
        }
        infix("setModel"){
            it.setModel(
                parseString(),
                parse<ModelType>()
            )
        }
    }
}