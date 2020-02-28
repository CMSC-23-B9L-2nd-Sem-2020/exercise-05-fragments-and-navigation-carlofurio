package com.example.myapplication

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {

         super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.done_button).setOnClickListener {
            var countText = findViewById<TextView>(R.id.count_text)
            addNickname(it)     //calling the function addNickname
            var grid = createList()     //creating an array of array of textview and assigning it to a variable
            boxVisible(grid)    // calling the function boxVisible
            listener(grid, countText)
            var resetButton: Button = findViewById(R.id.reset_button)
            resetButton.setOnClickListener {        //Listener for the reset button
                resetGrid(grid,countText)
                count = 0
            }
        }

    }

    private fun createList():Array<Array<TextView>>{
        val box1 = findViewById<TextView>(R.id.box_1_text)
        val box2 = findViewById<TextView>(R.id.box_2_text)          //assigning every box to a variable
        val box3 = findViewById<TextView>(R.id.box_3_text)
        val box4 = findViewById<TextView>(R.id.box_4_text)
        val box5 = findViewById<TextView>(R.id.box_5_text)
        val box6 = findViewById<TextView>(R.id.box_6_text)
        val box7 = findViewById<TextView>(R.id.box_7_text)
        val box8 = findViewById<TextView>(R.id.box_8_text)
        val box9 = findViewById<TextView>(R.id.box_9_text)
        val box10 = findViewById<TextView>(R.id.box_10_text)
        val box11 = findViewById<TextView>(R.id.box_11_text)
        val box12 = findViewById<TextView>(R.id.box_12_text)
        val box13 = findViewById<TextView>(R.id.box_13_text)
        val box14 = findViewById<TextView>(R.id.box_14_text)
        val box15 = findViewById<TextView>(R.id.box_15_text)
        val box16 = findViewById<TextView>(R.id.box_16_text)
        val box17 = findViewById<TextView>(R.id.box_17_text)
        val box18 = findViewById<TextView>(R.id.box_18_text)
        val box19 = findViewById<TextView>(R.id.box_19_text)
        val box20 = findViewById<TextView>(R.id.box_20_text)
        val box21 = findViewById<TextView>(R.id.box_21_text)
        val box22 = findViewById<TextView>(R.id.box_22_text)
        val box23 = findViewById<TextView>(R.id.box_23_text)
        val box24 = findViewById<TextView>(R.id.box_24_text)
        val box25 = findViewById<TextView>(R.id.box_25_text)


         var boxListID: Array<Array<TextView>> = arrayOf( //creating array with value of the id's of the box
             arrayOf(box1,box2,box3,box4,box5),
             arrayOf(box6,box7,box8,box9,box10),
             arrayOf(box11,box12,box13,box14,box15),
             arrayOf(box16,box17,box18,box19,box20),        //creating an array of array
             arrayOf(box21,box22,box23,box24,box25)


        )

        //boxVisible(boxListID)
        return boxListID            //returning the
    }

    private fun boxVisible(grid: Array<Array<TextView>>){ //function for making every box becomes color BLUE
        for(i: Int in 0..4){
            for(j: Int in 0..4){
                grid[i][j].visibility = View.VISIBLE
                (grid[i][j].background as ColorDrawable).color = Color.BLUE
            }
        }
    }


    private fun addNickname(view: View) { // function for making visible and gone
        val editText = findViewById<EditText>(R.id.nickname)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_style)
        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
        reset_button.visibility = View.VISIBLE
        count_text.visibility = View.VISIBLE

    }
    private fun listener(box: Array<Array<TextView>>, countText: TextView){
       // var rowCount = -1
       // var columnCount = -1


        for(i: Int in 0 until 4){
            //rowCount ++
            for(j: Int in 0 until 4){
                //columnCount++
                //box[i][j].setOnClickListener{(onClick(it,box,rowCount,columnCount,countText))
                box[i][j].setOnClickListener{(onClick(it,box,i,j,countText))}


            }
        }


    }
    private fun onClick(indiv: View, indivList: Array<Array<TextView>>, positionX: Int,positionY:Int,countText: TextView){


        if((indiv.background as ColorDrawable).color == Color.BLUE){        //if blue then yellow
            (indiv.background as ColorDrawable).color = Color.YELLOW
        }else{
            (indiv.background as ColorDrawable).color = Color.BLUE
        }

        count++
        countText.text = count.toString()
        if((positionX+1) >= 1  || (positionX+1) < 5 ){
            if((indivList[positionX+1][positionY].background as ColorDrawable).color == Color.BLUE){ //for the adjacent boxes
                (indivList[positionX+1][positionY].background as ColorDrawable).color = Color.YELLOW
            }else{
                (indivList[positionX+1][positionY].background as ColorDrawable).color = Color.BLUE
            }
        }
        if((positionX-1) <=3 && (positionX-1) >=0){
            if((indivList[positionX-1][positionY].background as ColorDrawable).color == Color.BLUE){
                (indivList[positionX-1][positionY].background as ColorDrawable).color = Color.YELLOW
            }else{
                (indivList[positionX-1][positionY].background as ColorDrawable).color = Color.BLUE
            }
        }
        if((positionY+1) >=1 && (positionY+1) <5){
            if((indivList[positionX][positionY+1].background as ColorDrawable).color == Color.BLUE){
                (indivList[positionX][positionY+1].background as ColorDrawable).color = Color.YELLOW
            }else{
                (indivList[positionX][positionY+1].background as ColorDrawable).color = Color.BLUE
            }
        }
        if((positionY-1) <=3 && (positionY-1) >=0){
            if((indivList[positionX][positionY-1].background as ColorDrawable).color == Color.BLUE){
                (indivList[positionX][positionY-1].background as ColorDrawable).color = Color.YELLOW
            }else{
                (indivList[positionX][positionY-1].background as ColorDrawable).color = Color.BLUE
            }
        }

    }


} private fun resetGrid(grid: Array<Array<TextView>>,countText: TextView){  //making all boxes BLUE at first
    for(i: Int in 0 until 4){
        for(j: Int in 0 until 4){
            (grid[i][j].background as ColorDrawable).color = Color.BLUE
        }
    }
    val count = 0
    countText.text = count.toString()

}

