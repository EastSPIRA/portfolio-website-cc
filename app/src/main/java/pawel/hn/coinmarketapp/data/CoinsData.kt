package pawel.hn.coinmarketapp.data

import androidx.lifecycle.LiveData
import pawel.hn.coinmarketapp.database.Coin
import pawel.hn.coinmarketapp.database.CoinDao
import pawel.hn.coinmarketapp.database.Notifications
import javax.inject.Inject


class CoinsData @Inject constructor(private val coinDao: CoinDao) {

    fun getCoinsList(searchQuery: String, favourites: Boolean): LiveData<List<Coin>>
    = if (favourites) coinDao.getCheckedCoins(searchQuery) 