package saccon.renan.br.trocatelas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class LancamentoActivity : AppCompatActivity() {

    private lateinit var etCod : EditText
    private lateinit var etQnt : EditText
    private lateinit var etValor : EditText

    private lateinit var btConfirmar : Button
    private lateinit var btListar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lancamento)

        etCod = findViewById(R.id.etCod)
        etQnt = findViewById(R.id.etQnt)
        etValor = findViewById(R.id.etValor)

        btConfirmar = findViewById(R.id.btConfirmar)
        btListar = findViewById(R.id.btListar)

        btConfirmar.setOnClickListener{
            btconfirmarOnClick()
        }

        btListar.setOnClickListener{
            btListarOnClick()
        }


    }

    private fun btListarOnClick() {

    }

    private fun btconfirmarOnClick() {
        val intent = Intent( this, ConfirmarActivity :: class.java)
        intent.putExtra("Cod", etCod.text.toString())
        intent.putExtra("Qnt.", etQnt.text.toString())
        intent.putExtra("Valor", etValor.text.toString())
        startActivity( intent )
    }
}