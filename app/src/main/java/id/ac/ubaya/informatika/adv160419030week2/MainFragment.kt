package id.ac.ubaya.informatika.adv160419030week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*


/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    var winCount:Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        x1.text = (0..20).random().toString()
        x2.text = (0..20).random().toString()
        buttonSubmit.setOnClickListener {
            //ambil jawaban
            val answer:Int = txtAnswer.text.toString().toInt()
            //dapatkan action yg ingin dijalankan
            val action = MainFragmentDirections.actionGameFragment(winCount.toString())
            if ((x1.text.toString().toInt() + x2.text.toString().toInt()) == answer){
                x1.text = (0..20).random().toString()
                x2.text = (0..20).random().toString()
                winCount++
            }else{
                //jalankan action tsb
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

}