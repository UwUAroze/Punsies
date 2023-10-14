package me.aroze.punsies.commands

import me.aroze.arozeutils.minecraft.generic.text.translator.translate
import me.vaperion.blade.annotation.argument.Optional
import me.vaperion.blade.annotation.argument.Sender
import me.vaperion.blade.annotation.command.Command
import me.vaperion.blade.annotation.command.Permission
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import me.vaperion.blade.context.Context;

class ClearChatCommand {

    @Command("clearchat", "cc")
    @Permission("punsies.clearchat")
    fun clearchat(
        @Sender sender: CommandSender,
        @Optional target: Player?,
    ) {

        if (target != null) {
            clearChat(target)
            if (sender == target) {
                sender.sendMessage(translate("<p>okayy... but- but <s>why?"))
                return
            }
            target.sendMessage(translate("<p>Your chat was cleared by <s>${sender.name}"))
            sender.sendMessage(translate("<p>You've cleared <s>${target.name}'s <p>chat"))
            return
        }

        for (player in Bukkit.getOnlinePlayers()) {
            if (player == sender) player.sendMessage(translate("<p>You've cleared the chat, <s>but you're immune!"))
            else if (!player.hasPermission("punsies.clearchat")) {
                clearChat(player)
                player.sendMessage(translate("<p>The chat has been cleared by <s>${sender.name}"))
            }
            else player.sendMessage(translate("<p>The chat was cleared by <s>${sender.name}<p>, but you're immune!"))
        }

    }

    private fun clearChat(player: Player) = player.sendMessage(translate("<br>".repeat(100)))

}