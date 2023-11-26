package com.mcwczxy.AsExSystem

import com.mcwczxy.AsExSystem.internal.manager.AsConfig
import com.skillw.pouvoir.api.manager.ManagerData
import com.skillw.pouvoir.api.plugin.SubPouvoir
import com.skillw.pouvoir.api.plugin.annotation.PouManager
import taboolib.common.platform.Plugin
import taboolib.module.configuration.Config
import taboolib.module.configuration.ConfigFile
import taboolib.platform.BukkitPlugin

object AsExSystem : Plugin(), SubPouvoir {

    override val key = "AsExSystem"
    override lateinit var managerData: ManagerData
    override val plugin by lazy {
        BukkitPlugin.getInstance()
    }

    /** Configs */

    @Config("config.yml", migrate = true, autoReload = true)
    lateinit var config: ConfigFile

    @Config("options.yml", migrate = true, autoReload = true)
    lateinit var options: ConfigFile

    /** Managers */

    @JvmStatic
    @PouManager
    lateinit var configManager: AsConfig


    override fun onLoad() {
        load()
    }

    override fun onEnable() {
        enable()
    }

    override fun onActive() {
        active()
    }

    override fun onDisable() {
        disable()
    }

}
