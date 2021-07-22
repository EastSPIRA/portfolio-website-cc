package pawel.hn.coinmarketapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pawel.hn.coinmarketapp.R
import pawel.hn.coinmarketapp.databinding.FragmentDialogAddEditBinding
import pawel.hn.coinmarketapp.viewmodels.AddCoinViewModel

@AndroidEntryPoint
class AddCoinFragmentDialog : DialogFragment() {


    private lateinit var binding: FragmentDialogAddEditBinding
    private var coinName: String = ""
    private var coinVolume: Double = 0.0

    private val viewModel: AddCoinViewModel by viewModels()

    override fun onCreateView(
        infl