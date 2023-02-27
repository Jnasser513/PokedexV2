package latmobile.app.pokedex.data.dto

data class PokemonResponse(
    val name: String,
    val id: Int,
    val sprites: SpritesResponse,
    val types: List<TypesResponse>
)

data class SpritesResponse(
    val front_default: String
)

data class TypesResponse(
    val type: TypeV2Response
)

data class TypeV2Response(
    val name: String
)
