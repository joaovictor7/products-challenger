package enums

internal enum class Flavor {
    DEVELOP,
    STAGING,
    PRODUCTION,
    FORM,
    PRODUCTS;

    val isDefault get() = this == PRODUCTS

    override fun toString() = name.lowercase()
}