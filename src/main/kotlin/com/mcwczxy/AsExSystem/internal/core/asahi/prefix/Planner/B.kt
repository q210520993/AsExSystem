package com.mcwczxy.AsExSystem.internal.core.asahi.prefix.Planner

import com.bh.planners.api.PlannersAPI
import com.skillw.asahi.api.annotation.AsahiPrefix
import com.skillw.asahi.api.prefixParser
import com.skillw.asahi.api.quester
import org.bukkit.entity.Player

@AsahiPrefix(["PskillCast"], "Planner")
private fun PskillCast() = prefixParser {
    val map = if (peek() == "[" || peek() == "{") questTypeMap()
    else quester { emptyMap<String, Any>() }
    val player =  map.quester { it["player"] }
    val kill = map.quester { it["skill"] }
    val mark = map.quester { it.getOrDefault("mark", false) }
    result {
        return@result PlannersAPI.cast(
            player.get<Any?>() as Player,
            kill.get<Any?>() as String,
            mark.get<Any?>() as Boolean
        )
    }
}
@AsahiPrefix(["DirectCast"], "Planner")
private fun PdirectCast() = prefixParser {
    val map = if (peek() == "[" || peek() == "{") questTypeMap()
    else quester { emptyMap<String, Any>() }
    val player =  map.quester { it["player"] }
    val kill = map.quester { it["skill"] }
    val level = map.quester { it.getOrDefault("level", false) }
    result {
        return@result PlannersAPI.directCast(
            player.get<Any?>() as Player,
            kill.get<Any?>() as String,
            level.get<Any?>() as Int
        )
    }
}
