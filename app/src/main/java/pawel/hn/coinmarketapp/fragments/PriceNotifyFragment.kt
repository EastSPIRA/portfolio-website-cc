package pawel.hn.coinmarketapp.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.preference.PreferenceManager
import dagger.hilt.android.AndroidEntryPoint
import pawel.hn.coinmarketapp.R
import pawel.hn.coinmarketapp.databinding.FragmentPriceNotifyBinding
import pawel.hn.coinmarketapp.viewmodels.PriceNotifyViewModel
import pawel.hn.coinmarketapp.util.*

@AndroidEntryPoint
class PriceNotifyFragment : Fragment(R.layout.fragment_price_notify) {

    private val viewModel: PriceNotifyViewModel by viewModels()
    lateinit var binding: FragmentPriceNotifyBinding
    private var latestPrice = 0.0
    private var currency = ""


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences: SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(requireContext())
        currency = sharedPreferences.getString(
            context?.getString(R.string.settings_currency_key),
            CURRENCY_USD
        )!!

        binding = FragmentPriceNotifyBinding.bind(view)

        val sharedPref = requireActi