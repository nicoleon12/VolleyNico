package leon.gudino.volleynico

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val queue=Volley.newRequestQueue(this)
        val url= "https:/www.google.com"

        val StringRequest = StringRequest(Request.Method.GET,
            url,
            Response.Listener { response ->
                Log.d("Respuesta", "${response.substring(0, 500)}")

                mostrarRespuesta.text = "Respuesta es: ${response.substring(0, 500)}"
            },
            Response.ErrorListener { error ->
                mostrarRespuesta.text="Error: ${error.message}"
                Log.d("Error", "${error.message}")

            })
        queue.add(StringRequest)

    }
}