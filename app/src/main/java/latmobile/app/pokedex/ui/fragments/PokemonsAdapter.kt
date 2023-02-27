package latmobile.app.pokedex.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import latmobile.app.pokedex.data.dto.Pokemon
import latmobile.app.pokedex.databinding.PokemonItemBinding

class PokemonsAdapter: RecyclerView.Adapter<PokemonsAdapter.PokemonViewHolder>() {

    private var pokemonList: List<Pokemon>? = null

    inner class PokemonViewHolder(private val binding: PokemonItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pokemon) {
            binding.namePokemon.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PokemonItemBinding.inflate(inflater, parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val item = pokemonList?.get(position)
        holder.bind(item!!)
    }

    override fun getItemCount() = pokemonList?.size ?: 0

    fun setData(list: List<Pokemon>) {
        pokemonList = list
        notifyDataSetChanged()
    }
}