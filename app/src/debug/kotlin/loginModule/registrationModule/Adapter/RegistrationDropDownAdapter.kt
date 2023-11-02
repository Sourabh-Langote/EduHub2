package loginModule.registrationModule.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eduhub.R
import org.json.JSONObject

class RegistrationDropDownAdapter(
    var context: Context,
    var list: ArrayList<JSONObject>
    ): RecyclerView.Adapter<RegistrationDropDownAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.registration_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RegistrationDropDownAdapter.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

    }

    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {

    }
}