package com.example.salarioobrero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
class MainActivity : AppCompatActivity() {

    private lateinit var editTextHoras: EditText
    private lateinit var buttonCalcular: Button
    private lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextHoras = findViewById(R.id.editTextHoras)
        buttonCalcular = findViewById(R.id.buttonCalcular)
        textViewResultado = findViewById(R.id.textViewResultado)

        buttonCalcular.setOnClickListener {
            val horasTrabajadas = editTextHoras.text.toString().toIntOrNull()
            if (horasTrabajadas != null && horasTrabajadas >= 0) { // Chequea si es positivo
                val salario = calcularSalario(horasTrabajadas)
                textViewResultado.text = "Salario semanal: S/. $salario"
            } else {
                Toast.makeText(this, "Ingrese un número válido", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun calcularSalario(horas: Int): Double {
        val tarifaNormal = 16.0 // Usa Double directamente
        val tarifaExtra = 20.0
        val horasNormales = 40

        return if (horas <= horasNormales) {
            horas * tarifaNormal
        } else {
            val horasExtras = horas - horasNormales
            (horasNormales * tarifaNormal) + (horasExtras * tarifaExtra)
        }
    }
}