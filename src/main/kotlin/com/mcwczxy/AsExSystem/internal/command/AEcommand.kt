package com.mcwczxy.AsExSystem.internal.command

import com.mcwczxy.AsExSystem.AsExSystem
import com.mcwczxy.AsExSystem.internal.manager.AsConfig
import com.skillw.pouvoir.util.soundClick
import com.skillw.pouvoir.util.soundFail
import com.skillw.pouvoir.util.soundSuccess
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.CommandBody
import taboolib.common.platform.command.CommandHeader
import taboolib.common.platform.command.mainCommand
import taboolib.common.platform.command.subCommand
import taboolib.module.lang.sendLang
import taboolib.platform.util.sendLang


@CommandHeader(name = "AsEx")
object AEcommand {
    internal fun ProxyCommandSender.soundSuccess() {
        (this.origin as? Player?)?.soundSuccess()
    }

    internal fun ProxyCommandSender.soundFail() {
        (this.origin as? Player?)?.soundFail()
    }

    internal fun ProxyCommandSender.soundClick() {
        (this.origin as? Player?)?.soundClick()
    }

    @CommandBody
    val help = subCommand {
        execute<ProxyCommandSender> { sender, _, _ ->
            sender.sendLang("command-info")
        }
    }

    @CommandBody
    val main = mainCommand {
        incorrectSender { sender, _ ->
            sender.soundFail()
            sender.sendLang("command-per")
        }
        incorrectCommand { sender, _, _, _ ->
            sender.soundFail()
            sender.sendLang("command-per")
        }

        execute<ProxyCommandSender> { sender, _, _ ->
            sender.soundSuccess()
            sender.sendLang("command-info")
        }
    }

    @CommandBody(permission = "asex.command.reload")
    val reload = subCommand {
        execute<CommandSender> { sender, _, _ ->
            (sender as? Player)?.soundSuccess()
            AsExSystem.reload()
            sender.sendLang("Reload")
        }
    }
    @CommandBody(permission = "asex.command.debug")
    val debug = subCommand {
        execute<ProxyCommandSender> { sender, _, _ ->
            sender.soundSuccess()
            AsConfig.debugMode = !AsConfig.debugMode
            if (AsConfig.debugMode)
                sender.sendLang("command-debug-on")
            else
                sender.sendLang("command-debug-off")
        }
    }

}
