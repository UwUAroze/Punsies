package me.aroze.punsies

import me.aroze.arozeutils.kotlin.reflection.getClassesInPackage
import me.aroze.arozeutils.minecraft.FancyPlugin
import me.aroze.arozeutils.minecraft.generic.text.translator.addCustomReplacements
import me.vaperion.blade.Blade
import me.vaperion.blade.bukkit.BladeBukkitPlatform

class Punsies : FancyPlugin() {

    override fun onEnable() {
        registerColourCodes()
        registerCommands()
    }

    override fun onPluginDisable() {
        // Plugin shutdown logic
    }

    private fun registerCommands() {
        val commandHandler = Blade.forPlatform(BladeBukkitPlatform(this))
            .config { it.defaultPermissionMessage = "<#ff6e6e>⚠ <#ff7f6e>Nuh uh!" }
            .build()
        for (command in getClassesInPackage("me.aroze.punsies.commands"))
            commandHandler.register(command.getField("INSTANCE")[null])
    }

    private fun registerColourCodes() {
        addCustomReplacements(mapOf(
            "p" to ("<color:#efd4ff>" to "</color>"),
            "s" to ("<color:#e4b5ff>" to "</color>"),
        ))
    }

}
