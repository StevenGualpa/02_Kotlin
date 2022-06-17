package com.geek.a02_volley

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class getVolley : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_volley)

       InvocaJson()


    }
    private fun InvocaJson()
    {
        val txtresul=findViewById<TextView>(R.id.multi)
        val url="https://gorest.co.in/public/v1/users"
        /*
        val queue=Volley.newRequestQueue(this)
        val stringRequest=StringRequest(Request.Method.GET,url, Response.Listener { response ->
            //txtresul.text="La respuesta es: ${response}"
        },Response.ErrorListener {
            txtresul.text="Algo Salio Mal"
        })
        queue.add(stringRequest)

        val url = "http://my-json-feed"
*/
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->

                var cadena :String=""
/*
                for(i in 0 until response.length())
                {
                    val obj=response.getJSONObject(i.toString())
                    cadena=obj.getString("id")+"\n"
                    //Log.d(i.toString(), obj.getString("id"))
                }
*/
                //val jsonObject :JSONObject=response.getJSONObject("data")
                val jsonArray : JSONArray= response.getJSONArray("data")

                for (i in 0 until jsonArray.length())
                {
                    //      cadena=cadena+"\n"
                    // cadena=cadena+"{ \n"
                    val jarr : JSONObject=jsonArray.getJSONObject(i)
                    val did: String=jarr.getString("id")
                    val dname: String=jarr.getString("name")
                    val demail: String=jarr.getString("email")
                    val dgender: String=jarr.getString("gender")
                    val dstatus: String=jarr.getString("status")

                    cadena=cadena+"{ id: $did, \n name: $dname, \n email: $demail, \n gender: $dgender, \n status: $dstatus } \n \n "

                    //                       cadena=cadena+jsonArray.get(i).toString()
                }

                txtresul.text=cadena

                //txtresul.text = response.get("data").toString()
            },
            Response.ErrorListener { error ->
                error.printStackTrace()
                txtresul.text ="Algo Salio Mal"
            }
        )

        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)




    }
}