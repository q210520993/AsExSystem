package com.mcwczxy.AsExSystem.internal.core.asahi.prefix.Planner

import com.skillw.asahi.api.annotation.AsahiPrefix
import com.skillw.asahi.api.prefixParser
import com.bh.planners.api.PlannersAPI.plannersProfile
import com.skillw.asahi.api.quest
import org.bukkit.entity.Player
/*
* 这个只是给中缀解释器做个前提
* */
@AsahiPrefix(["PlayerPlannerData"], "Planner")
private fun getPlayerProfiles() = prefixParser {
    val player = quest<Player>()
    when {
        expect("PlannersProfile")->{
            result {
                return@result player.get().plannersProfile
            }
        }
        expect("Job") -> {
            result {
                return@result player.get().plannersProfile.job
            }
        }
        //返回一个List
        expect("Skills") -> {
            result {
                return@result player.get().plannersProfile.getSkills()
            }
        }
        else -> {
            result {
                println("Unknown Planner Command")
                return@result null
            }
        }
    }
}