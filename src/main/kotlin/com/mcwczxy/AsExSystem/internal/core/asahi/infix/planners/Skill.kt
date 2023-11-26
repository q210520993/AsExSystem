package com.mcwczxy.AsExSystem.internal.core.asahi.infix.planners

import com.bh.planners.core.pojo.player.PlayerJob
import com.skillw.asahi.api.annotation.AsahiInfix
import com.skillw.asahi.api.member.parser.infix.namespacing.BaseInfix

object Skill {
    /**
     * @className PlannerJob
     *
     * @author JiuShi Wang
     * @date 2023/11/25 Copyright 2023 user. All rights reserved.
     */
    @AsahiInfix
    object Skill : BaseInfix<PlayerJob.Skill>(PlayerJob.Skill::class.java,"Planner") {
        init {
            infix("getID"){
                it.id
            }
            infix("getLevel"){
                it.level
            }
            infix("getKey"){
                it.key
            }
        }
    }
}