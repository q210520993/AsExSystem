package com.mcwczxy.AsExSystem.internal.core.asahi.prefix.DragonCore

import com.skillw.asahi.api.annotation.AsahiPrefix
import com.skillw.asahi.api.prefixParser
import com.skillw.asahi.api.quester
import eos.moe.dragoncore.network.PacketSender
import org.bukkit.entity.Player

@AsahiPrefix(["Dfunction"], "DragonCore")
private fun Dfunction() = prefixParser {
    val map = if (peek() == "[" || peek() == "{") questTypeMap()
    else quester { emptyMap<String, Any>() }
    val player =  map.quester { it["player"] }
    val guiName = map.quester { it["guiname"] }
    val function = map.quester { it["funtion"] }
    val async = map.quester { it.getOrDefault("async", true) }
    result {
        PacketSender.sendRunFunction(
            player.get() as Player?,
            guiName.get() as String?,
            function.get() as String,
            async.get() as Boolean
        )
    }
}
