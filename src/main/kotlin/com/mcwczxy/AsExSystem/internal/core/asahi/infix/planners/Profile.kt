package com.mcwczxy.AsExSystem.internal.core.asahi.infix.planners

import com.bh.planners.api.PlannersAPI.cast
import com.bh.planners.core.pojo.player.PlayerProfile
import com.skillw.asahi.api.annotation.AsahiInfix
import com.skillw.asahi.api.member.parser.infix.namespacing.BaseInfix

/**
 * @className ActionPlayer
 *
 * @author JiuShi Wang
 * @date 2023/11/25 Copyright 2023 user. All rights reserved.
 */
@AsahiInfix
object Profile: BaseInfix<PlayerProfile>(PlayerProfile::class.java,"Planner") {
    init {
        infix("getJob"){ zxy->
            zxy.job
        }
        infix("getPlayer"){wc->
            wc.player
        }
        infix("getPoint"){job->
            job.point
        }
        infix("level"){level->
            level.level
        }
        infix("skills"){level->
            level.getSkills()
        }
        infix("cast"){
            it.cast(
                parseString(),
                parseBoolean()
            )
        }
    }
}