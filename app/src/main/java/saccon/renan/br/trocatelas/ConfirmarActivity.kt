package saccon.renan.br.trocatelas

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import android.net.Uri

import androidx.appcompat.app.AppCompatActivity


class ConfirmarActivity : AppCompatActivity() {

    private lateinit var tvCod : TextView
    private lateinit var tvQnt : TextView
    private lateinit var tvValor : TextView

    private lateinit var btEnviar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmar)

        tvCod = findViewById(R.id.tvCod)
        tvQnt = findViewById(R.id.tvQnt)
        tvValor = findViewById(R.id.tvValor)
        btEnviar = findViewById(R.id.btEnviar)


        btEnviar.setOnClickListener{
            btEnviarOnClick()
        }

        val cod = intent.getStringExtra("Cod")
        val qnt = intent.getStringExtra("Qnt.")
        val valor = intent.getStringExtra("Valor")

        tvCod.setText( cod )
        tvQnt.setText( qnt )
        tvValor.setText( valor )

    }

    private fun btEnviarOnClick() {

        val sms_body = "Cod: ${tvCod.text} / Qnt: ${tvQnt.text} / Valor: ${tvValor.text} "
        val phone_number = "sms:+55485248756"

        val intent = Intent( Intent.ACTION_VIEW ) //Abrir aplicativo de SMS juntamente com o corpo e número de celular. Também fazendo a validação se o aplicativo foi aberto
        intent.setData(Uri.parse( phone_number ))
        intent.putExtra( "sms_body", sms_body)

        if ( intent.resolveActivity ( getPackageManager() ) != null){
            startActivity( intent )
        }

    }
}