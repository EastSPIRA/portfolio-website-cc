package pawel.hn.coinmarketapp.repository

import pawel.hn.coinmarketapp.data.CoinsData
import pawel.hn.coinmarketapp.data.RemoteData
import pawel.hn.coinmarketapp.data.WalletData
import pawel.hn.coinmarketapp.database.Coin
import pawel.hn.coinmarketapp.model.coinmarketcap.ApiResponseArray
import pawel.hn.coinmarketapp.model.coinmarketcap.CoinData
import pawel.hn.coinmarketapp.util.*
import javax.inject.Inject


class CoinsRepository @Inject constructor(
    val coins: CoinsData,
    val wallet: WalletData,
    private val remote: RemoteData
) {
    var responseError = true

    suspend fun getCoinsData(currency: String) {
        runCatching {
            remote.getCoins(
                API_QUERY_START,
                API_QUERY_LIMIT,
                currency
            )
        }.onSuccess {
            responseSuccess(it.body(), currency)
        }.onFailure {
            responseError = tr