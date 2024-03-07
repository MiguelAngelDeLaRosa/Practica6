package mx.edu.itson.potros.practica6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class detalle_pelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val iv_pelicula_image: ImageView = findViewById(R.id.iv_pelicula_imagen)
        val tv_nombre_pelicula: TextView = findViewById(R.id.iv_nombre_pelicula)
        val tv_desc_pelicula: TextView = findViewById(R.id.iv_pelicula_desc)
        val btnTicket: Button = findViewById(R.id.buyTickets)
        val seats: TextView = findViewById(R.id.seatLeft)
        val boletos: String? = intent.getStringExtra("seats")

        Toast.makeText(this, "Boletos:"+ boletos, Toast.LENGTH_LONG).show()
        btnTicket.setOnClickListener {
            var intent: Intent = Intent(this, SeatSelection::class.java)
            startActivity(intent)
        }

        val bundle = intent.extras
        if(bundle !=null){
            iv_pelicula_image.setImageResource(bundle.getInt("header"))
            tv_nombre_pelicula.setText(bundle.getString("titulo"))
            tv_desc_pelicula.setText(bundle.getString("sinopsis"))
            seats.setText(boletos);
        }

    }
}