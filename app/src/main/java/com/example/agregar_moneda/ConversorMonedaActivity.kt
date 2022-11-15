package com.example.agregar_moneda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ConversorMonedaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_moneda)

        // En este se mandan a llamar los valores de todos las variables
        val bundle = intent.extras

        // Y en este es donde se usan los valores y se guardan
        val datoTipoM = bundle?.getString("TipoM")
        val datoMX = bundle?.getFloat("ValorMX")
        val datoValorM = bundle?.getFloat("ValorM")

        // Se hace el calculo para saber cuando es la conversion de la moneda
        var total = datoMX!!*datoValorM!!

        // Se declara en unas varibale donde guarda y se muestre el resultado
        val txtTotal = findViewById<EditText>(R.id.pltxtResultados)
        val txtTipo = findViewById<EditText>(R.id.txtTipoMoneda)

        // Se imprime el resultado del tipo de moneda que fue seleccionado
        txtTipo.setText(datoTipoM.toString())

        // Se imprime el resultado de la cantidad convertida a la otra moneda
        txtTotal.setText(total.toString())

        //Funcion para regresar al menu principal
        val btnBCK = findViewById<Button>(R.id.btnBack)
        btnBCK.setOnClickListener {
            finish()
        }
    }
}