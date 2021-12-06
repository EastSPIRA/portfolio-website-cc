package pawel.hn.coinmarketapp.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prof.rssparser.Channel
import com.prof.rssparser.Parser
import kotlinx.coroutines.launch
import pawel.hn.coinmarketapp.util.BASE_URL_NEWS
import pawel.hn.coinmarketapp.util.hasInternetConnection
import pawel.hn.coinmarketapp.util.sh