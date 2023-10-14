package me.aroze.punsies.commands

import me.aroze.arozeutils.minecraft.generic.text.translator.translate
import me.aroze.punsies.listeners.ChatListener
import me.aroze.punsies.listeners.ChatListener.chatMuted
import me.vaperion.blade.annotation.argument.Optional
import me.vaperion.blade.annotation.argument.Sender
import me.vaperion.blade.annotation.command.Command
import me.vaperion.blade.annotation.command.Permission
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object MuteChatCommand {

    @Command("mutechat", "lockchat")
    @Permission("punsies.mutechat")
    fun muteChat(@Sender sender: CommandSender) {

        chatMuted = !chatMuted

        if (chatMuted) {
            for (player in Bukkit.getOnlinePlayers()) {
                if (!player.hasPermission("punsies.mutechat")) player.sendMessage(translate("<p>The chat has been <s>muted"))
                else player.sendMessage(translate("<p>The chat has been <s>muted<p>, but you're immune!"))
            }
        }

        else Bukkit.broadcast(translate("<p>The chat has been <s>unmuted"))
    }

}