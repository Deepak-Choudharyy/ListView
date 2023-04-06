package dk.deepak.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        supportActionBar?.hide()


        val nameTv = findViewById<TextView>(R.id.tvName)
        val phoneTv = findViewById<TextView>(R.id.tvPhone)
        val msgTv = findViewById<TextView>(R.id.tvMsg)
        val image = findViewById<CircleImageView>(R.id.profile_image)

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val msg = intent.getStringExtra("msg")
        val imageId = intent.getIntExtra("image",R.drawable.pic0)

        nameTv.text =name
        phoneTv.text = "+91 "+ phone
        msgTv.text = msg
        image.setImageResource(imageId)

    }
}