package sheridan.levings.assignment1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import sheridan.levings.assignment1.databinding.ActivityPlayBinding;

class PlayActivity : AppCompatActivity() {

    companion object{
        const val SELECTED_PLAY_TEXT = "play"
        const val CPU_PLAY_TEXT = "cpu_play"
    }

    private lateinit var binding: ActivityPlayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var playerText = intent.getStringExtra(SELECTED_PLAY_TEXT)
        var cpuText = intent.getStringExtra(CPU_PLAY_TEXT)
        var outputText = ""

        binding.txtPlayer.text = playerText
        binding.txtCPU.text = cpuText

        if (playerText == cpuText) {
            outputText = getString(R.string.output_tie)
        } else if ((playerText == getString(R.string.paper) && cpuText == getString(R.string.rock)) ||
            playerText == getString(R.string.scissors) && cpuText == getString(R.string.paper) ||
            playerText == getString(R.string.rock) && cpuText == getString(R.string.scissors)) {
            outputText = getString(R.string.output_won)
        } else {
            outputText = getString(R.string.output_lost)
        }

        binding.txtOutput.text = outputText

        binding.btnPlayAgain.setOnClickListener { finish() }
    }
}