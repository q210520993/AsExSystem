package com.mcwczxy.AsExSystem.internal.core.asahi.infix.planners

import com.bh.planners.core.pojo.player.PlayerJob
import com.skillw.asahi.api.annotation.AsahiInfix
import com.skillw.asahi.api.member.parser.infix.namespacing.BaseInfix

/**
 * @className ActionPlayer
 *
 * @author JiuShi Wang
 * @date 2023/11/25 Copyright 2023 user. All rights reserved.
 */
@AsahiInfix
object Job : BaseInfix<PlayerJob>(PlayerJob::class.java,"Planner") {
    init {
        infix("getJobID"){ zxy->
            zxy.id
        }
        infix("getName"){wc->
            wc.name
        }
        infix("getPoint"){job->
            job.point
        }
        infix("level"){level->
            level.level
        }
    }
}