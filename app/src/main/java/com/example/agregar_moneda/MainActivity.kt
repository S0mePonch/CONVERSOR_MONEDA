package com.example.agregar_moneda

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

        var btnAG =  findViewById<Button>(R.id.btnAgregar)
        var txtTipoMoneda = findViewById<EditText>(R.id.txtMoneda)
        var txtValor = findViewById<EditText>(R.id.txtValorMoneda)

        var monedaAgregarTipo = mutableListOf<String>()
        var valor = mutableListOf<Int>()
        val spinnerAgregar : Spinner = findViewById(R.id.SpnMonedas)
        val arrayAgregar : ArrayAdapter<*>


        btnAG.setOnClickListener{
            if (txtTipoMoneda.text.isEmpty() || txtValor.text.isEmpty()){
                Toast.makeText(this, "Llena todos los campos", Toast.LENGTH_SHORT).show()
            }else{
                // Se agregan los datos al spinner
                monedaAgregarTipo.add(txtTipoMoneda.text.toString())
                valor.add(txtValor.text.toString().toInt())

                Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
            }
    }

        // Muetsra la lista
        arrayAgregar = ArrayAdapter(this, android.R.layout.simple_list_item_1,monedaAgregarTipo)
        spinnerAgregar.adapter = arrayAgregar


    }
}