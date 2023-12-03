package com.mcwczxy.AsExSystem.internal.core.asahi.prefix.FightSystem

import com.skillw.asahi.api.annotation.AsahiPrefix
import com.skillw.asahi.api.prefixParser
import com.skillw.asahi.api.quest
import com.skillw.asahi.api.quester
import com.skillw.fightsystem.api.FightAPI
import com.skillw.fightsystem.api.fight.FightData
import org.bukkit.entity.LivingEntity

@AsahiPrefix(["FightData"], "FightSystem")
private fun newFightData() = prefixParser {
    val player = quest<LivingEntity>()
    val player2 = quest<LivingEntity>()
    result {
        FightData(player.get(),player2.get())
    }
}
@AsahiPrefix(["runFight"], "FightSystem")
private fun runFight() = prefixParser {
    val map = if (peek() == "[" || peek() == "{")
        questTypeMap()
    else
        quester { emptyMap<String, Any>() }
    val string = map.quester { it.get("name") }
    val data = map.quester { it.get("data") }
    val message = map.quester { it.getOrDefault("message", true) }
    val damage = map.quester { it.getOrDefault("damage", true) }
    result {
        FightAPI.runFight(string.get() as String,
            data.get() as FightData,
            message.get() as Boolean,
            damage.get() as Boolean
        )
    }
}