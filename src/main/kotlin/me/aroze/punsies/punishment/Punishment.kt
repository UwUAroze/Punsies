package me.aroze.punsies.punishment

import java.util.UUID

class Punishment(
    val player: UUID,
    val username: String,
    val type: PunishmentType,

    val punisher: UUID,
    val reverter: UUID?,

    val reason: Reason,
) {

}