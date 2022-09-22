package com.b2c.pruebawebviewconhtml

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class FragmentUno : Fragment() {
    private lateinit var vista: View
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_uno, container, false)

        btn1 = vista.findViewById(R.id.btnUno)
        btn2 = vista.findViewById(R.id.btnDos)
        btn3 = vista.findViewById(R.id.btnTres)

        btn1.setOnClickListener {
            Toast.makeText(requireActivity(), "HOLA", Toast.LENGTH_SHORT).show()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentDos()).commit()
        }

        btn2.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentTRES()).commit()
        }

        btn3.setOnClickListener {

        }

        return vista
    }

}