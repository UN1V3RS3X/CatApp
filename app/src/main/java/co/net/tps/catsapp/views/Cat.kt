package co.net.tps.catsapp.views

data class Cat(
    private val name: String?,
    private val origin: String?,
    private val affectionLevel: Int?,
    private val intelligence: Int?,
    private val reference_image_id: String?
) {
    fun getName(): String? {
        return name
    }
    fun getOrigin(): String? {
        return origin
    }
    fun getAffectionLevel(): Int? {
        return affectionLevel
    }
    fun getIntelligence(): Int? {
        return intelligence
    }
    fun getImage(): String? {
        return reference_image_id
    }
}
