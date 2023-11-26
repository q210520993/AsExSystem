package com.mcwczxy.AsExSystem.internal.core.asahi.infix.OrangeEngine

import com.mcwczxy.AsExSystem.api.UUIDS
import com.skillw.pouvoir.internal.core.asahi.infix.bukkit.InfixPlayer
import ltd.icecold.orangeengine.api.OrangeEngineAPI
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake


object OeMains{
    @Awake(LifeCycle.ENABLE)
    fun actions(){
        UUIDS.infix("getModelEntity"){
            OrangeEngineAPI.getModelManager().getModelEntity(it)
        }
    }
}