package latmobile.app.pokedex.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import latmobile.app.pokedex.databinding.ActivityMainBinding
import latmobile.app.pokedex.presentation.PokemonViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    private val viewModel: PokemonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

}