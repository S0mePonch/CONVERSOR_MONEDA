package com.example.agregar_moneda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Se declaran las variabnles
        var btnAG = findViewById<Button>(R.id.btnAgregar)
        var btnCLC = findViewById<Button>(R.id.btnCalcular)
        var txtTipoMoneda = findViewById<EditText>(R.id.txtMoneda)
        var txtValor = findViewById<EditText>(R.id.txtValorMoneda)
        var txtMxn = findViewById<EditText>(R.id.txtMXN)

        /* En esta parte se crean las listas*/
        var monedaAgregarTipo = mutableListOf<String>("YEN")
        var valor = mutableListOf<Float>(7.12f)
        /*-------------------------------------------------------------------*/

        val spinnerAgregar: Spinner = findViewById(R.id.SpnMonedas)
        val arrayAgregar: ArrayAdapter<*>

        // Funcion para el boton de agregar y sus validaciones
        btnAG.setOnClickListener {
            if (txtTipoMoneda.text.isEmpty() || txtValor.text.isEmpty()) {
                Toast.makeText(this, "Llena todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                // Se agregan los datos al spinner
                monedaAgregarTipo.add(txtTipoMoneda.text.toString())
                valor.add(txtValor.text.toString().toFloat())

                Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
            }
        }

        // Muetsra la lista para el spinner
        arrayAgregar = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, monedaAgregarTipo)
        spinnerAgregar.adapter = arrayAgregar

        // Funcion del boton "Calcular"
        btnCLC.setOnClickListener {
            if(txtMxn.text.isEmpty()){
                Toast.makeText(this, "Ingrese un valor para la conversion", Toast.LENGTH_SHORT).show()
            }else{
                val Intent = Intent(this, ConversorMonedaActivity::class.java)

                //Con esa linea de codigo especifica el index de la moneda que escoge
                var i = spinnerAgregar.selectedItemPosition

                Intent.putExtra("TipoM", spinnerAgregar.selectedItem.toString())
                Intent.putExtra("ValorM", valor[i])
                Intent.putExtra("ValorMX", txtMxn.text.toString().toFloat())

                startActivity(Intent)
            }
        }



    }
}