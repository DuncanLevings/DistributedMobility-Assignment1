package sheridan.levings.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import sheridan.levings.assignment1.databinding.ActivityMainBinding;
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlay.setOnClickListener{confirmAction()}
    }

    private fun confirmAction(){
        val play = when (binding.rdGroup1.checkedRadioButtonId) {
            R.id.rbtnPaper-> getString(R.string.paper)
            R.id.rbtnScissors -> getString(R.string.scissors)
            R.id.rbtnRock -> getString(R.string.rock)
            else -> getString(R.string.undefined)
        }

        var cpuPlay = when (Random().nextInt(3)) {
            0 -> getString(R.string.paper)
            1 -> getString(R.string.scissors)
            2 -> getString(R.string.rock)
            else -> getString(R.string.undefined)
        }

        val intent = Intent(this, PlayActivity::class.java).apply {
            putExtra(PlayActivity.SELECTED_PLAY_TEXT, play)
            putExtra(PlayActivity.CPU_PLAY_TEXT, cpuPlay)
        }
        startActivity(intent)
    }
}