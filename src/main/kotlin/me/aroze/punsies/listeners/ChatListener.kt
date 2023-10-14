package me.aroze.punsies.listeners

import io.papermc.paper.event.player.AsyncChatEvent
import me.aroze.arozeutils.minecraft.generic.text.translator.translate
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

object ChatListener : Listener {

    var chatMuted = false // TODO: Move this to db.. probably?

    @EventHandler
    fun onChat(event: AsyncChatEvent) {
        if (!chatMuted) return
        if (event.player.hasPermission("punsies.mutechat")) return
        event.isCancelled = true

        event.player.sendMessage(translate("<p>The chat is muted!"))
    }

}