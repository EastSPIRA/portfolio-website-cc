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
import pawel.hn.coinmarketapp.viewmodels.CoinsViewMod