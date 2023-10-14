package me.aroze.punsies.commands

import me.aroze.arozeutils.minecraft.generic.text.translate
import me.vaperion.blade.annotation.argument.Sender
import me.vaperion.blade.annotation.command.Command
import me.vaperion.blade.annotation.command.Permission
import org.bukkit.command.CommandSender

class ExampleCommand {

    @Command("exampley")
    @Permission("punsies.exampley")
    fun exampley(
        @Sender sender: CommandSender
    ) {
        sender.sendMessage(translate("<#cef5d4>no way!"))
    }


}