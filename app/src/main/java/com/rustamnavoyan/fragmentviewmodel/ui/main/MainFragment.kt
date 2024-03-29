package com.rustamnavoyan.fragmentviewmodel.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.rustamnavoyan.fragmentviewmodel.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var f = false
        message.setOnClickListener {
            f = !f
            viewModel.addValue(if (f) "245" else "str")
        }

        message2.setOnClickListener {
            viewModel.changeSwitchLiveData()
        }

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        viewModel.integerMapObservable.observe(viewLifecycleOwner, Observer {
            println()
        })

        viewModel.integerSwitchMapObservable.observe(viewLifecycleOwner, Observer {
            println()
        })
    }

}
