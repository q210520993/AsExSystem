package com.mcwczxy.AsExSystem.internal.core.asahi.prefix.OrangeEngine

import com.skillw.asahi.api.annotation.AsahiPrefix
import com.skillw.asahi.api.prefixParser
import com.skillw.asahi.api.quest
import com.skillw.asahi.api.quester
import ltd.icecold.orangeengine.api.model.ModelEntity

@AsahiPrefix(["OeModelEntity"], "OrangeEngine")
private fun OeModelEntity() = prefixParser {
    val player = quest<ModelEntity>()
    when {
        expect("ModelData")->{
            result {
                return@result player.get().modelData
            }
        }
        expect("UUID") -> {
            result {
                return@result player.get().entityUUID
            }
        }
        expect("playAni") -> {
            val map = if (peek() == "[" || peek() == "{") questTypeMap() else quester { emptyMap<String, Any>() }
            val XSDS = map.quester { it.get("animation") }
            val ASDA = map.quester { it.getOrDefault("transition", 1) }
            val iZXZ = map.quester { it.getOrDefault("priority", 1) }
            result {
                return@result player.get().playAnimation(XSDS.get() as String, ASDA.get() as Int, iZXZ.get() as Int)
            }
        }
        expect("setAni") -> {
            val map = if (peek() == "[" || peek() == "{") questTypeMap() else quester { emptyMap<String, Any>() }
            val XSDS = map.quester { it.get("animation") }
            val ASDA = map.quester { it.getOrDefault("transition", 1) }
            val iZXZ = map.quester { it.getOrDefault("priority", 1) }
            result {
                return@result player.get().setAnimation(XSDS.get() as String, ASDA.get() as Int, iZXZ.get() as Int)
            }
        }
        else -> {
            result {
                println("Unknown OrangeEngine Command")
                return@result null
            }
        }
    }
}