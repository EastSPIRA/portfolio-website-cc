package pawel.hn.coinmarketapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pawel.hn.coinmarketapp.database.Wallet
import pawel.hn.coinmarketapp.repository.CoinsRepository
import javax.inject.Inject

@HiltViewModel
class AddCoinViewModel @Inject constructor (private val coinsRepository: CoinsRepository)
    : ViewModel() {

    val coins = coinsRepository.coins.coinsAll

    fun createWalletCoin(coinName: String, coinVolume: Double, walle