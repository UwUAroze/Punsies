package me.aroze.punsies.punishment

data class Reason private constructor(
    val text: String,
    val preset: String?
) {
    companion object {
//        fun fromPreset(id: String) = Reason(getPresetReason(id), id) // TODO: Implement getPresetReason
        fun from(text: String) = Reason(text, null)
    }
}