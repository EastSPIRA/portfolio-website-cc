package pawel.hn.coinmarketapp.data

import pawel.hn.coinmarketapp.database.Coin
import pawel.hn.coinmarketapp.database.Wallet
import pawel.hn.coinmarketapp.database.WalletDao
import javax.inject.Inject


class WalletData @Inject constructor(private val walletDao: WalletDao) {

    val wallet = walletDao.getWallet()

    suspend fun addToWallet(newCoin: Wallet) {
        val oldCoin =
            wallet.value?.find { it.coinId == newCoin.coinId && it.walletNo == newCoin.walletNo }

        if (oldCoin != null) {
            val newVolume = newCoin.volume + oldCoin.volume
            updateWallet(
                oldCoin.copy(volume = newVolume),
