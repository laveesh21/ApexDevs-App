import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apexdevs.models.RecycleViewModel

class SharedViewModel : ViewModel() {
    val dataArrayList: MutableLiveData<ArrayList<RecycleViewModel>> by lazy {
        MutableLiveData<ArrayList<RecycleViewModel>>()
    }
}
