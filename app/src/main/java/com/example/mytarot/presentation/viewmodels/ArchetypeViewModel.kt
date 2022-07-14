package com.example.mytarot.presentation.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mytarot.data.TarotRepositoryImpl
import com.example.mytarot.domain.usecases.GetArchetypesByIdUseCase
import com.example.mytarot.domain.usecases.GetCardsByArcanaUseCase
import java.time.DateTimeException
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ArchetypeViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = TarotRepositoryImpl(application)

    private val getArchetypesByIdUseCase = GetArchetypesByIdUseCase(repository)
    private val getCardsByArcanaUseCase = GetCardsByArcanaUseCase(repository)

    private val _archList = MutableLiveData<List<String>>()
    val archList: LiveData<List<String>>
        get() = _archList

    val numListTemp = getCardsByArcanaUseCase.getCardsByArcana("Старшая")

        private val _numList = MutableLiveData<List<Int>>()
    val numList: LiveData<List<Int>>
        get() = _numList


    private val _errorInputDate = MutableLiveData<Boolean>()
    val errorInputDate: LiveData<Boolean>
        get() = _errorInputDate



//    private fun getArcNames(list: List<Int>): List<String>{
//        val listOfArcNames = mutableListOf<String>()
//        numListTemp.observe(){
//            for(i in list){
//                listOfArcNames.add(it[i].name)
//            }
//        }
//        return listOfArcNames
//    }


    suspend fun processDate(dateStr: String){
        if(checkValidDate(dateStr)){
            val date = getDateFromString(dateStr)
            val arcListNum = calculateArchetypes(date)
//            val arcListName = getArcNames(arcListNum)
            _numList.postValue(arcListNum)
            Log.d("MY_TAROT", arcListNum.toString())
            _archList.postValue(getArchetypeListCalc(arcListNum))
//            Log.d("MY_TAROT", numListTemp.toString())
        }

    }

    private fun getDateFromString(str:String) : List<String>{
        val list = mutableListOf<String>()
        list.add(str.substring(0..1))
        list.add(str.substring(3..4))
        list.add(str.substring(6 until str.length))
        return list
    }

    private fun calculateArchetypes(date: List<String>): List<Int>{
        val list = mutableListOf<Int>()
        //1
        if(date[0].toInt() > 22 ){
            list.add(date[0].toInt() - 22)
        } else {
            list.add(date[0].toInt())
        }
        //2
        list.add(date[1].toInt())
        //3


        var temp3 = (date[2].substring(0..0).toInt() + date[2].substring(1..1).toInt()
        + date[2].substring(2..2).toInt() + date[2].substring(3..3).toInt())

        while(temp3 > 22){
            temp3 -= 22
        }
        list.add(temp3)

        //4
        val temp4 = (date[0].substring(0..0).toInt() + date[0].substring(1..1).toInt()
        + date[1].substring(0..0).toInt() + date[1].substring(1..1).toInt() + list[2])
        if(temp4 > 22){
            list.add(temp4 - 22)
        } else {
            list.add(temp4)
        }
        //5
        var temp5 = list[0] + list[1] + list[2]
        while(temp5 > 22){
            temp5 -= 22
        }
        list.add(temp5)
        //6
        val temp6 = list[0] + list[1]
        if(temp6 > 22){
            list.add(temp6 - 22)
        } else {
            list.add(temp6)
        }
        //7
        val temp7 = list[1] + list[2]
        if(temp7 > 22){
            list.add(temp7 - 22)
        } else {
            list.add(temp7)
        }
        //8
        val temp8 = list[3] + list[4]
        if(temp8 > 22){
            list.add(temp8 - 22)
        } else {
            list.add(temp8)
        }
        //9
        val temp9 = list[5] + list[6]
        if(temp9 > 22){
            list.add(temp9 - 22)
        } else {
            list.add(temp9)
        }
        return list
    }

    private fun checkValidDate(dateString: String): Boolean {
        val readingFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        return try{
            LocalDate.parse(dateString, readingFormatter)
            true
        } catch (e: DateTimeException){
            _errorInputDate.value = true
            false
        }
    }

    fun resetErrorInputDate() {
        _errorInputDate.value = false
    }

    private suspend fun getArchetypeListCalc(list: List<Int>): List<String>{
        val listOfArcs = mutableListOf<String>()
        var tempStr: String
        for((index, i) in list.withIndex()){
            tempStr = if(i !=22){
                 getArchetypesByIdUseCase.getArchetypesById(i).getPosByNum(index+1)
            } else {
                getArchetypesByIdUseCase.getArchetypesById(0).getPosByNum(index+1)
            }

            listOfArcs.add(tempStr)
        }
        return listOfArcs
    }
}