package com.example.baru

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var editname : EditText? = null
    var spinnergender : Spinner? = null
    var editemail : EditText? = null
    var editTelp : EditText? = null
    var editAddress : EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editname = findViewById(R.id.editname)
        spinnergender = findViewById(R.id.spinnergender)
        editemail = findViewById(R.id.editemail)
        editTelp = findViewById(R.id.editTelp)
        editAddress = findViewById(R.id.editAddress)

        buttonSave.setOnClickListener{
            validasiInput()
        }

        setDataSpinner()

    }

    fun setDataSpinner(){
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.gender_list, android.R.layout.simple_spinner_dropdown_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnergender?.adapter = adapter
    }

    fun validasiInput(){
        val namaInput : String = editname?.text.toString()
        val emailInput : String = editemail?.text.toString()
        val telpInput : String = editTelp?.text.toString()
        val alamatInput : String = editAddress?.text.toString()
        val genderInput : String = spinnergender?.selectedItem.toString()

        when{
            genderInput.equals("Pilih Jenis Kelamin")->
                Toast.makeText(this, "Kelamin harus dipilih",Toast.LENGTH_SHORT).show()
            namaInput.isEmpty() -> editname?.error = "Nama gaoleh kosong cak!!!"
            emailInput.isEmpty() -> editemail?.error = "Email gaoleh kosong cak!!!"
            telpInput.isEmpty() -> editTelp?.error = "Telephone gaoleh kosong cak!!!"
            alamatInput.isEmpty() -> editAddress?.error = "Alamat gaoleh kosong cak!!!"

        else -> {
            Toast.makeText(this, "Data berhasil terkirim",Toast.LENGTH_SHORT).show()
            }

        }

    }

}

