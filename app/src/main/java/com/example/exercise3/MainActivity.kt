package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myData : PremiumModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myData = ViewModelProviders.of(this).get(PremiumModel::class.java)
        btnCalculate.setOnClickListener {


            myData.premiumAmount= getPremium()
            display()
        }
        btnReset.setOnClickListener {
            txtResult.text = ""
            radioGroup.clearCheck()
            spinnerAge.setSelection(0)
            chkSmoker.isChecked = false;
            myData.premiumAmount = 0.00
        }
    }
    fun display()
    {
        if(myData.premiumAmount !=0.00) {
            txtResult.text = myData.premiumAmount.toString()
        }
    }

    fun getPremium():Double{
        return when(spinnerAge.selectedItemPosition)
        {
            0-> 60.00
            1->70.00 + (if(btnMale.isChecked)50.00 else 0.00) + (if(chkSmoker.isChecked) 100.00 else 0.00 )
            2->90.00 + (if(btnMale.isChecked)100.00 else 0.00) + (if(chkSmoker.isChecked) 150.00 else 0.00 )
            3->120.00 + (if(btnMale.isChecked)150.00 else 0.00) + (if(chkSmoker.isChecked) 200.00 else 0.00 )
            4->150.00 + (if(btnMale.isChecked)200.00 else 0.00) + (if(chkSmoker.isChecked) 250.00 else 0.00 )
            else ->
                150 + (if(btnMale.isChecked)200.00 else 0.00) + (if(chkSmoker.isChecked) 300.00 else 0.00 )


        }
    }
}
