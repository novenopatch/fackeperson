package com.jerrykel.fackeperson

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import com.jerrykel.fackeperson.models.FakeGeneratorResults
import com.jerrykel.fackeperson.models.FakeProfile
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private var retrofit:Retrofit? = null
    private var service:FakeProfileService? =null
    private var spinner:Spinner? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofit = Retrofit.Builder().baseUrl("https://randomuser.me/api").addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit?.create(FakeProfileService::class.java)
        spinner = findViewById(R.id.spinnerLang)
        spinner?.isSelected =true
        (findViewById<Button>(R.id.buttonGenerate)).setOnClickListener {
            randomProfile()
        }
        randomProfile()
    }
    private fun initView(){

    }
    private fun randomProfile(){
        service?.randomProfile(spinner?.selectedItem.toString())?.enqueue(object:Callback<FakeGeneratorResults>{
            override fun onResponse(
                call: Call<FakeGeneratorResults>,
                response: Response<FakeGeneratorResults>
            ) {
                var profile: FakeProfile? = response.body()?.getResult()

                (findViewById<TextView>(R.id.textViewName)).text= profile?.getLastName()
                (findViewById<TextView>(R.id.textViewSurname)).text= profile?.getFirstName()
                (findViewById<TextView>(R.id.textViewAddress)).text = profile?.getFullAddress()

                //Glide.with(applicationContext).load(Uri.parse(profile?.getPicture())).into((findViewById<ImageView>(R.id.imageViewPicture)))



            }

            override fun onFailure(call: Call<FakeGeneratorResults>, t: Throwable) {
                Log.e("FakeGeneretooo","Fake to load");
            }

        } )
    }
}