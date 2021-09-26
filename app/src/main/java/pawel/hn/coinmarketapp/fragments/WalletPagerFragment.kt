package pawel.hn.coinmarketapp.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import pawel.hn.coinmarketapp.R
import pawel.hn.coinmarketapp.databinding.PageWalletBinding
import pawel.hn.coinmarketapp.util.WALLET_NO

class WalletPagerFragment : Fragment(R.layout.page_wallet) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = PageWalletBinding.bind(view)
        binding.walletPager.adapter = WalletsPagerAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.walletPager) { tab, position ->
            tab.text = if (position == 3) {
                context?.getString(R.string.total)
            } else {
                "${context?.getString(R.string.wallet)} ${position+1}" }
            }.attach()
 