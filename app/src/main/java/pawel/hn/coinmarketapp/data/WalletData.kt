package pawel.hn.coinmarketapp.data

import pawel.hn.coinmarketapp.database.Coin
import pawel.hn.coinmarketapp.database.Wallet
import pawel.hn.coinmarketapp.database.WalletDao
import javax.inject.Inject


class WalletData @Inject constructor(private val walletDao: WalletDao) {

    val wallet = walletDao.getWallet()

    suspend fun addToWallet(newCoin: