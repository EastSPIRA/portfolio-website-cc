package pawel.hn.coinmarketapp.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.prof.rssparser.Parser
import pawel.hn.coinmarketapp.R
import pawel.hn.coinmarketapp.adapters.NewsAdapter
import pawel.hn.coinmarketapp.databinding.FragmentNewsBinding
import pawel.hn.coinmarketapp.viewmodels.NewsViewModel



class NewsFragment : Fragment(R.layout.fragment_news) {

    private lateinit var ne