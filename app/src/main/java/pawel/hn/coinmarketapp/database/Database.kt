
package pawel.hn.coinmarketapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pawel.hn.coinmarketapp.util.DATABASE_NAME


@Database(entities = [Coin::class, Wallet::class, Notifications::class], version = 1)