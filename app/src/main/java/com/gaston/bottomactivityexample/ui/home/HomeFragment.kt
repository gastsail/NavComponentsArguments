package com.gaston.bottomactivityexample.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.gaston.bottomactivityexample.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_home, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    btn_nav_frag_b.setOnClickListener {
      val bundle = Bundle()
      bundle.putString("nombre","Sociedad Androide")
      findNavController().navigate(R.id.navigation_frag_b,bundle)
    }

    findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>("key")?.observe(viewLifecycleOwner,
      Observer { texto ->
        txt_info_frag_b.text = texto
      })
  }

}
