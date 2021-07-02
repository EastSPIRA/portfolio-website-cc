package pawel.hn.coinmarketapp.database

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface WalletDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = Wallet::class)
    suspend fun insertIntoWall