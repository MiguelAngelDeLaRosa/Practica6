package mx.edu.itson.potros.practica6

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class catalogo : AppCompatActivity() {
    var adapter: PeliculaAdapter? = null
    var seriesAdapter: PeliculaAdapter? = null
    var peliculas = ArrayList<Pelicula>()
    var series = ArrayList<Pelicula>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)
        var option : String? = intent.getStringExtra("menuType")

        cargarPeliculas()
        cargarSeries()

        adapter = PeliculaAdapter(this, peliculas)
        seriesAdapter = PeliculaAdapter(this, series)
        var gridPelis: GridView = findViewById(R.id.movies_catalogo)
        var gridSeries: GridView = findViewById(R.id.series_catalogo)

        gridPelis.adapter = adapter
        gridSeries.adapter = seriesAdapter
    }

    fun cargarPeliculas(){
        peliculas.add(Pelicula("Demon Slayer: Kimetsu no Yaiba -To the hashira training", R.drawable.demon, R.drawable.demo, "Demon Slayer: Kimetsu no Yaiba -To the Hashira Training- proyectará por primera vez en cines el\n" +
                "episodio 11 del Arco de la Aldea de los Herreros, mostrando así la conclusión de la feroz batalla\n" +
                "entre Tanjiro y la Cuarta Luna Creciente, Hatengu, además de cómo Nezuko logra caminar bajo el\n" +
                "sol. Le seguirá el episodio 1 del Arco del Entrenamiento de los Pilares, donde veremos el inicio del\n" +
                "entrenamiento de los Pilares para prepararse de cara a la próxima batalla contra Muzan Kibutsuji,\n" +
                "que se podrá ver por primera vez."))
        peliculas.add(Pelicula("Dune", R.drawable.dune, R.drawable.dune2, "Duna: Parte Dos&quot; explorará el viaje mítico de Paul Atreides mientras se une con Chani y los\n" +
                "Fremen mientras está en un camino de venganza contra los conspiradores que destruyeron a su\n" +
                "familia. Enfrentando una elección entre el amor de su vida y el destino del universo conocido, se\n" +
                "esfuerza por evitar un futuro terrible que solo él pueda prever."))
        peliculas.add(Pelicula("Ghostbusters Apocalipsis", R.drawable.ghostbusters2, R.drawable.ghostbusters, "En Ghostbusters Apocalipsis Fantasma, regresa la familia Spengler a donde todo empezó – la\n" +
                "icónica estación de bomberos en Nueva York – donde hace equipo junto con los Ghostbusters\n" +
                "originales que han desarrollado un laboratorio de investigación ultrasecreto para llevar la cacería\n" +
                "de fantasmas al siguiente nivel. Pero cuando el descubrimiento de un artefacto antiguo libera una\n" +
                "fuerza maligna, los nuevos y viejos Ghostbusters unen sus fuerzas para proteger su hogar y salvar\n" +
                "al mundo de una segunda era de hielo."))
        peliculas.add(Pelicula("Héroe Por Encargo", R.drawable.heroeencargo, R.drawable.heroexencargo, "Un ex agente de las fuerzas especiales acepta un trabajo para brindar seguridad a una periodista\n" +
                "mientras entrevista a un dictador, pero estalla un golpe militar en medio de la entrevista y se ven\n" +
                "obligados a escapar a la jungla donde deben sobrevivir."))
        peliculas.add(Pelicula("Madame Web", R.drawable.madameweb, R.drawable.madame, "Mientras tanto, en otro universo… En un cambio del típico género, Madame Web cuenta la\n" +
                "historia independiente del origen de una de las heroínas más enigmáticas de la editorial Marvel. El\n" +
                "thriller de suspenso protagonizado por Dakota Johnson como Cassandra Webb, una paramédico\n" +
                "de Manhattan que puede tener habilidades clarividentes. Forzada a enfrentarse a revelaciones de\n" +
                "su pasado, ella forja una relación con tres mujeres jóvenes destinadas a tener poderosos futuros…\n" +
                "si pueden sobrevivir a un presente mortal."))
        peliculas.add(Pelicula("Vidas Pasadas", R.drawable.vidaspasadas, R.drawable.vidaspasadas1, "Nora y Hae Sung, dos amigos de la infancia profundamente unidos, son separados después de que\n" +
                "la familia de Nora emigrara de Corea del Sur. Veinte años después, se reúnen durante una fatídica\n" +
                "semana para enfrentarse al amor y al destino."))
    }

    fun cargarSeries(){
        series.add(Pelicula("Halo", R.drawable.halo, R.drawable.halos, "Una evacuación mortal cambia la guerra del Jefe Maestro con el Covenant. En Reach, un nuevo\n" +
                "régimen toma el mando en FLEETCOM. John siente una amenaza inminente cerca. Estreno de\n" +
                "temporada."))
        series.add(Pelicula("Leveling", R.drawable.sololeveling, R.drawable.sololevelings, "En un mundo en el que ciertos humanos llamados “cazadores” poseen habilidades mágicas, estos\n" +
                "deben luchar contra monstruos para proteger a la raza humana de una aniquilación segura. Un\n" +
                "cazador muy débil llamado Sung Jinwoo se encuentra en una lucha en la que solo puede tratar de\n" +
                "sobrevivir."))
        series.add(Pelicula("Mi adorable demonio", R.drawable.adorabledemonio, R.drawable.adorabledemonios, "Se centra en la vida de Jung Koo Won, un temerario demonio que pierde sus poderes tras conocer\n" +
                "a Do Do-Hee, una exitosa empresaria con la que deberá de colaborar para recuperarlos."))
        series.add(Pelicula("El Monstruo de la Vieja Seúl", R.drawable.elmonstruo, R.drawable.elmonstruovieja, "Gyeongseong, 1945. En la oscura era colonial de Seúl, un empresario y una investigadora luchan\n" +
                "por sobrevivir y se enfrentan a un monstruo nacido de la avaricia humana."))
        series.add(Pelicula("Witcher", R.drawable.thewitcher, R.drawable.thewitchers, "Geralt de Rivia, un cazador de monstruos mutante, viaja en pos de su destino por un mundo\n" +
                "turbulento en el que, a menudo, los humanos son peores que las bestias."))
    }

    class PeliculaAdapter: BaseAdapter {
        var peliculas = ArrayList<Pelicula>()
        var context: Context? = null

        constructor(context: Context, peliculas: ArrayList<Pelicula>){
            this.peliculas = peliculas
            this.context = context
        }

        override fun getCount(): Int {
            return peliculas.count()
        }

        override fun getItem(position: Int): Any {
            return peliculas[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var pelicula = peliculas[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.peliculas, null)
            var image: ImageView = vista.findViewById<ImageView>(R.id.image_movie_cell)
            var title: TextView = vista.findViewById(R.id.movie_title_cell)

            image.setImageResource(pelicula.image)
            title.setText(pelicula.Titulo)

            image.setOnClickListener() {
                val intento = Intent(context, detalle_pelicula::class.java)
                intento.putExtra("titulo", pelicula.Titulo)
                intento.putExtra("imagen", pelicula.image)
                intento.putExtra("header", pelicula.header)
                intento.putExtra("sinopsis", pelicula.sinopsis)
                context!!.startActivity(intento)
            }
            return vista
        }

    }
}