package com.sumaya.hw_week06_day04


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sumaya.hw_week06_day04.R


class YoutubeAdapter(val userData: List<YTData>) : RecyclerView.Adapter<CustomHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.ytrv_item, parent, false)
        return CustomHolder(view)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val video = userData[position]

        holder.videoId.text = "ID: ${video.id.toString()}"
        holder.nameOfVideo.text = "Video name: ${video.name}"
        holder.channelName.text = "Channel name: ${video.channel.name}"
        holder.numberOfViews.text = "Number of views: ${video.numberOfViews.toString()}"
        holder.imageUrl.load(video.imageUrl)
    }

    override fun getItemCount(): Int {
        return userData.size
    }

}

class CustomHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val videoId: TextView = itemView.findViewById(R.id.tvId)
    val nameOfVideo: TextView = itemView.findViewById(R.id.tvName)
    val channelName: TextView = itemView.findViewById(R.id.tvChannel)
    val numberOfViews: TextView = itemView.findViewById(R.id.tvNumOfViews)
    val imageUrl: ImageView = itemView.findViewById(R.id.iV)
}