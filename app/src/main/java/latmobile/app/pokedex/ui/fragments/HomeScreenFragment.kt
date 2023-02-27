package latmobile.app.pokedex.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import latmobile.app.pokedex.databinding.HomeScreenFragmentBinding
import latmobile.app.pokedex.presentation.PokemonViewModel

class HomeScreenFragment: Fragment() {

    private var mBinding: HomeScreenFragmentBinding? = null
    private val binding get() = mBinding!!

    private val viewModel: PokemonViewModel by activityViewModels()

    val pokemonAdapter = PokemonsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = HomeScreenFragmentBinding.inflate(inflater, container, false)
            .apply {
                viewmodel = viewModel
                lifecycleOwner = viewLifecycleOwner
            }

        binding.pokedexSearchInputEdit.doAfterTextChanged { message ->
            viewModel.cantidad.value = message.toString()
        }

        setUpRecyclerView()

        return binding.root
    }

    private fun setUpRecyclerView() {
        with(binding.pokedexRecyclerview) {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = pokemonAdapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.pokemons.observe(viewLifecycleOwner) { pokemons ->
            pokemonAdapter.setData(pokemons)
        }
    }

}