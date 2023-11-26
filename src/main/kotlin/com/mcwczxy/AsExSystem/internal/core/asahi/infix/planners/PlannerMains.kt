package com.mcwczxy.AsExSystem.internal.core.asahi.infix.planners

import com.bh.planners.api.PlannersAPI.plannersProfile
import com.skillw.pouvoir.internal.core.asahi.infix.bukkit.InfixPlayer
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object PlannerMains {
    @Awake(LifeCycle.ENABLE)
    fun action() {
        InfixPlayer.infix("getPlannerProfiles") {
            it.plannersProfile
        }
        InfixPlayer.infix("UUID") {
            it.uniqueId
        }
    }
}