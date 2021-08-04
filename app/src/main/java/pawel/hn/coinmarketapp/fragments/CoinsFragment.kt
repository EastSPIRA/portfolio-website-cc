package pawel.hn.coinmarketapp.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.preference.PreferenceManager
import dagger.hilt.android.AndroidEntryPoint
import pawel.hn.coinmarketapp.R
import pawel.hn.coinmarketapp.adapters.CoinsAdapter
import pawel.hn.coinmarketapp.databinding.FragmentCoinsBinding
import pawel.hn.coinmarketapp.util.CURRENCY_USD
import pawel.hn.coinmarketapp.util.onQueryTextChanged
import pawel.hn.coinmarketapp.viewmodels.CoinsViewModel


@AndroidEntryPoint
class CoinsFragment : Fragment(R.layout.fragment_coins) {

    private val viewModel: CoinsViewModel by viewModels()
    private lateinit var searchView: SearchView
    private lateinit var binding: FragmentCoinsBinding
    private lateinit var adapter: CoinsAdapter
    private var currency = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())
        currency = sharedPreferences.getString(
            requireContext().getString(R.string.settings_currency_key),
            CURRENCY_USD
        ) ?: CURRENCY_USD


        viewModel.refreshData(currency)
        adapter = CoinsAdapter { coin, isChecked ->
            viewModel.coinFavouriteClicked(coin, isChecked)
        }
        binding = FragmentCoinsBinding.inflate(inflater, container, false)

        binding.apply {
            lifecycleOwner = this@CoinsFragment
            coinViewModel = viewModel
            errorLayo