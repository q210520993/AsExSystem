package com.mcwczxy.AsExSystem.internal.core.asahi.prefix.DragonCore

import com.skillw.asahi.api.annotation.AsahiPrefix
import com.skillw.asahi.api.prefixParser
import com.skillw.asahi.api.quest
import com.skillw.asahi.api.quester
import eos.moe.dragoncore.network.PacketSender
import org.bukkit.entity.Player
import java.util.UUID

@AsahiPrefix(["Dsound"], "DragonCore")
private fun testMagic() = prefixParser {
    val map = if (peek() == "[" || peek() == "{") questTypeMap()
                else quester { emptyMap<String, Any>() }
    val player =  map.quester { it["player"] }
    val key = map.quester { it.getOrDefault("key", UUID.randomUUID()) }
    val sound = map.quester { it["sound"] }
    val volume = map.quester { it.getOrDefault("volume", 1.0f) }
    val pitch = map.quester { it.getOrDefault("pitch", 1.0f) }
    val loop = map.quester { it.getOrDefault("loop", false) }
    val x = map.quester { it["x"] }
    val y = map.quester { it["y"] }
    val z = map.quester { it["z"] }
    result {
        PacketSender.sendPlaySound(
            player.get() as Player?,
            key.get() as String?,
            sound.get() as String?,
            volume.get() as Float,
            pitch.get() as Float,
            loop.get() as Boolean,
            x.get() as Float,
            y.get() as Float,
            z.get() as Float
            )
    }
}
@AsahiPrefix(["DsoundStop"], "DragonCore")
private fun test() = prefixParser {
    val quest = quest<Player>()
    val quest2 = questString()
    result {
        PacketSender.sendStopSound(
            quest.get(),
            quest2.get()
        )
    }
}
