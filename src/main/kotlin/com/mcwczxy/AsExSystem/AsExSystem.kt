package com.mcwczxy.AsExSystem

import com.skillw.pouvoir.api.manager.ManagerData
import com.skillw.pouvoir.api.plugin.SubPouvoir
import taboolib.common.platform.Plugin
import taboolib.platform.BukkitPlugin

object AsExSystem : Plugin(), SubPouvoir {

    override val key = "AsExSystem"
    override lateinit var managerData: ManagerData
    override val plugin by lazy {
        BukkitPlugin.getInstance()
    }

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
