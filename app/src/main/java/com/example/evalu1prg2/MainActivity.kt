package com.example.evalu1prg2

import android.os.Bundle
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // precios
        val pastelPrecio = 36000
        val cazuelaPrecio = 10000

        // recuperar elementos
        val nroCantPastelChoclo = findViewById<TextInputEditText>(R.id.nroCtadPastelChoclo)
        val nroCantCazuela = findViewById<TextInputEditText>(R.id.nroCtadCazuela)
        val switchPropina = findViewById<Switch>(R.id.switchPropina)

        val nroComida = findViewById<TextView>(R.id.nroComida)
        val nroPropina = findViewById<TextView>(R.id.nroPropina)
        val nroTotal = findViewById<TextView>(R.id.nroTotal)

        // función para actualizar valores
        fun actualizarTotales() {
            // obtener cantidades ingresadas
            val cantPasteldeChoclo = nroCantPastelChoclo.text?.toString()?.toIntOrNull() ?: 0
            val cantCazuela = nroCantCazuela.text?.toString()?.toIntOrNull() ?: 0

            // calcular totales
            val totalComida = (cantPasteldeChoclo * pastelPrecio) + (cantCazuela * cazuelaPrecio)
            val propina = if (switchPropina.isChecked) totalComida * 0.2 else 0.0
            val totalFinal = totalComida + propina

            // actualizar TextViews
            nroComida.text = "$${totalComida}"
            nroPropina.text = "$${propina.toInt()}"
            nroTotal.text = "$${totalFinal.toInt()}"
        }


        // listeners y actualización
        nroCantPastelChoclo.addTextChangedListener {
            actualizarTotales()
        }
        nroCantCazuela.addTextChangedListener {
            actualizarTotales()
        }
        switchPropina.setOnCheckedChangeListener { _, _ ->
            actualizarTotales()
        }
    }
}