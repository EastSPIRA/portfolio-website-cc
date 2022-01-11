package pawel.hn.coinmarketapp.viewmodels


import android.content.Context
import android.graphics.Typeface
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewModelScope
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pawel.hn.coinmarketapp.R
import pawel.hn.coinmarketapp.database.Coin
import pawel.hn.coinmarketapp.database.Wallet
import pawel.hn.coinmarketapp.repository.CoinsRepository
import pawel.hn.coinmarketapp.util.toMutableLiveData
import javax.inject.Inject

@HiltViewModel
class WalletViewModel @Inject constructor(
    private val coinsRepository: CoinsRepository) : BaseViewModel(coinsRepository) {

    val walletLiveData = coinsRepository.wallet.wallet
    val coinLiveData = coinsRepository.coins.coinsAll

    fun calculateTotalBalance(list: List<Wallet>): Double = 