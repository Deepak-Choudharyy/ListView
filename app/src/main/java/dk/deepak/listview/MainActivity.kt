package dk.deepak.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    lateinit var userArrayList: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val name = arrayOf("Deepak","Pankaj","Naveen","Arya","Ravi")
        val lastMsg = arrayOf("Hey wssup","I am fine","Good","Awsome","How are you")
        val lastMsgTime = arrayOf("5:45 AM", "4:35 AM","2:10 PM","12:40 PM" ,"1:20 AM")
        val phoneNumber = arrayOf("1233456677","2345678912","3456789012","4567890123","8723461782")
        val imgId = intArrayOf(R.drawable.pic0,R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4)

        userArrayList = ArrayList()

        for (eachIndex in name.indices){
            val user = User(name[eachIndex], lastMsg[eachIndex],lastMsgTime[eachIndex],phoneNumber[eachIndex],imgId[eachIndex])

            userArrayList.add(user)
        }

        val listView = findViewById<ListView>(R.id.listView)
        listView.isClickable =true
        listView.adapter = MyAdapater(this , userArrayList)
        
        listView.setOnItemClickListener { adapterView, view, position, Id ->

            val userName = name[position]
            val userPhone = phoneNumber[position]
            val imageId = imgId[position]
            val msg = lastMsg[position]

            val i = Intent(this, UserActivity::class.java)
            i.putExtra("name",userName)
            i.putExtra("phone",userPhone)
            i.putExtra("image",imageId)
            i.putExtra("msg",msg)
            startActivity(i)
        }
    }
}