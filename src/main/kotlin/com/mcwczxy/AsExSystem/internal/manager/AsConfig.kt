package com.mcwczxy.AsExSystem.internal.manager

import com.mcwczxy.AsExSystem.AsExSystem
import com.skillw.pouvoir.api.manager.ConfigManager
import org.spigotmc.AsyncCatcher
import taboolib.common.platform.function.info

object AsConfig : ConfigManager(AsExSystem) {
    override val priority = 0

    override fun onLoad() {
        AsyncCatcher.enabled = false
    }
    var debugMode = false
    val debug
        get() = debugMode || this["config"].getBoolean("debug")
    @JvmStatic
    fun debug(debug: () -> Unit){
        if(this.debug){
            debug.invoke()
        }
    }
    @JvmStatic
    fun debugMessage(vararg msg: String){
        if(this.debug){
            debug { info(msg) }
        }
    }
}
