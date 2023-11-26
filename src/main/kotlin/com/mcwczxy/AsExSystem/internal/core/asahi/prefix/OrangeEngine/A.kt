package com.mcwczxy.AsExSystem.internal.core.asahi.prefix.OrangeEngine

import com.bh.planners.api.PlannersAPI.plannersProfile
import com.skillw.asahi.api.annotation.AsahiPrefix
import com.skillw.asahi.api.prefixParser
import com.skillw.asahi.api.quest
import ltd.icecold.orangeengine.api.OrangeEngineAPI
import ltd.icecold.orangeengine.core.OrangeEngine
import org.bukkit.entity.Player

@AsahiPrefix(["OrangeModelManager"], "OrangeEngine")
private fun ModelManager() = prefixParser {
    val player = questObj()
    when {
        expect("ModelType")->{
            result {
                return@result OrangeEngineAPI.
                getModelManager().
                getModelTypeByName(player.get() as String)
            }
        }
        expect("ModelEntity") -> {
            result {
                return@result OrangeEngineAPI.
                getModelManager().
                getModelEntity((player.get() as Player).uniqueId)
            }
        }
        //返回一个List
        expect("ModelData") -> {
            result {
                return@result OrangeEngineAPI.
                getModelManager().
                getModelDataByName(player.get() as String)
            }
        }
        else -> {
            result {
                println("Unknown OrangeEngine Command")
                return@result null
            }
        }
    }
}