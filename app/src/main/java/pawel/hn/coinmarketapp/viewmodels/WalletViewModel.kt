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

    fun calculateTotalBalance(list: List<Wallet>): Double = list.sumOf { it.total }

    fun totalWallet(list: List<Wallet>): List<Wallet> {

        val totalList = mutableListOf<Wallet>()
        val listOfCoinIds = mutableListOf<Int>()

        for (coinLoop in list) {
            if (listOfCoinIds.contains(coinLoop.coinId)) {
                continue
            } else {
                listOfCoinIds.add(coinLoop.coinId)
                val tempList = list.filter { it.coinId == coinLoop.coinId }
                val newVolume = tempList.sumOf{ it.volume }
                val newTotal = tempList.sumOf { it.total }
                totalList.add(
                    Wallet(
                        coinId = coinLoop.coinId,
                        name = coinLoop.name,
                        symbol = coinLoop.symbol,
                        volume = newVolume,
                        price = coinLoop.price,
                        total = newTotal,
                        walletNo = 3
                    )
                )
            }
        }

        return totalList.sortedByDescending { it.total }
    }

    fun onTaskSwiped(coin: Wallet) = viewModelScope.launch {
        coinsRepository.wallet.deleteFromWallet(coin)
    }

    fun walletRefresh(list: List<Coin>) = viewModelScope.launch {

        val listTemp = list.filter { coin ->
            coin.name == walletLiveData.value?.find { it.name == coin.name }?.name
        }
        if (listTemp.isNullOrEmpty()) {
            eventProgressBar.toMutableLiveData().value = false
            return@launch
        }
        walletLiveData.value!!.forEach { coin ->
            val newPrice = listTemp.filter { it.name == coin.name }[0].price
            coinsRepository.wallet.updateWallet(coin, newPrice)
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            coinsRepository.wallet.deleteAllFromWallets()
        }
    }


    fun setChart(list: List<Wallet>, pieChart: PieChart, context: Context) {
        val entries = ArrayList<PieEntry>()
        if (!list.isNullOrEmpty()) {
            list.forEach {
                entries.add(
                    PieEntry(it.total.toFloat(), it.symbol)
                )
            }
        }

        val 