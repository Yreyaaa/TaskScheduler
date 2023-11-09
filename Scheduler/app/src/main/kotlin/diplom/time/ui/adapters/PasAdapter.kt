package diplom.time.ui.adapters
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import diplom.time.R
import diplom.time.mvp.models.Pas
import java.util.*
class PasAdapter : RecyclerView.Adapter<PasAdapter.ViewHolder> {
    private var mPasList: List<Pas> = ArrayList()
    constructor(pasList: List<Pas>) {
        mPasList = pasList
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): PasAdapter.ViewHolder {
        var v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.pas_item_layout, viewGroup, false)
        return PasAdapter.ViewHolder(v);
    }
    override
    fun onBindViewHolder(viewHolder: PasAdapter.ViewHolder, i: Int) {
        var pas = mPasList[i];
        viewHolder.mPasTitle.text = pas.title;
    }
    override fun getItemCount(): Int {
        return mPasList.size
    }
    class ViewHolder : RecyclerView.ViewHolder {
        var mPasTitle: TextView
        constructor(itemView: View) : super(itemView) {
            mPasTitle = itemView.findViewById(R.id.tvItemPasTitle) as TextView
        }
    }
}
