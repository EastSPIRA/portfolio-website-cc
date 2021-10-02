package pawel.hn.coinmarketapp.model.coinmarketcap

import com.google.gson.annotations.SerializedName
import pawel.hn.coinmarketapp.database.Coin
import pawel.hn.coinmarketapp.util.CURRENCY_PLN
import pawel.hn.coinmarketapp.util.CURRENCY_USD

data class CoinData(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("quote")
    val quote: Quote,

    @SerializedName("symbol")
    val symbol: String,

    @SerializedName("cmc_rank")
    val cmcRank: Int
) {

  fun apiResponseConvertToCoin(ccy: String): Coin {
        val price = when(ccy) {
            CURRENCY_USD -> this.quote.USD.pri