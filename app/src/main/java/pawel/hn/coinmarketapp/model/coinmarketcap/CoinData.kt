package pawel.hn.coinmarketapp.model.coinmarketcap

import com.google.gson.annotations.SerializedName
import pawel.hn.coinmarketapp.database.Coin
import pawel.hn.coinmarketapp.util.CURRENCY_PLN
import pawel.hn.coinmarketapp.util.CURRENCY_USD

data class CoinData(
    @SerializedName("id")
    val id: Int,

  