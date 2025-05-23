package com.farukayata.t_vac_kotlin.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.farukayata.t_vac_kotlin.model.SensorData
import com.farukayata.t_vac_kotlin.model.SensorDataManager
import com.farukayata.t_vac_kotlin.model.Tree
import com.farukayata.t_vac_kotlin.model.treeList

class HomeViewModel : ViewModel() {

    private val _sensorData = MutableLiveData<SensorData>()
    val sensorData: LiveData<SensorData> get() = _sensorData

    private val _filteredTreeList = MutableLiveData<List<Tree>>()
    val filteredTreeList: LiveData<List<Tree>> get() = _filteredTreeList

    init {
        refreshSensorData()
    }

    fun refreshSensorData() {
        val data = SensorDataManager.fetchSensorData()
        _sensorData.value = data
    }

    fun onLocationUpdated(cityName: String) {
        val current = _sensorData.value ?: SensorDataManager.fetchSensorData()
        val updated = current.copy(locationName = cityName)
        SensorDataManager.sensorData = updated
        _sensorData.value = updated
    }

    fun fetchTreeList(temperature: Int, humidity: Int) {
        val list = treeList.filter { it.isSuitable(temperature, humidity) }
        _filteredTreeList.value = list
    }

    fun getPhStatus(value: Float): String = when {
        value < 5.0f -> "Very Low"
        value < 5.5f -> "Low"
        value < 6.5f -> "Normal"
        value < 7.5f -> "High"
        else         -> "Very High"
    }

    fun getTemperatureStatus(value: Float): String = when {
        value < 5f   -> "Very Low"
        value < 10f  -> "Low"
        value < 25f  -> "Normal"
        value < 30f  -> "High"
        else         -> "Very High"
    }

    fun getConductivityStatus(value: Float): String = when {
        value < 0.2f -> "Very Low"
        value < 0.5f -> "Low"
        value < 1.5f -> "Normal"
        value < 2.5f -> "High"
        else         -> "Very High"
    }

    fun getPhosphorusStatus(value: Float): String = when {
        value < 5f   -> "Very Low"
        value < 10f  -> "Low"
        value < 30f  -> "Normal"
        value < 50f  -> "High"
        else         -> "Very High"
    }

    fun getPotassiumStatus(value: Float): String = when {
        value < 50f  -> "Very Low"
        value < 100f -> "Low"
        value < 200f -> "Normal"
        value < 300f -> "High"
        else         -> "Very High"
    }

    fun getNitrogenStatus(value: Float): String = when {
        value < 0.1f -> "Very Low"
        value < 0.5f -> "Low"
        value < 1.0f -> "Normal"
        value < 2.0f -> "High"
        else         -> "Very High"
    }

    fun getHumidityStatus(value: Float): String = when {
        value < 10f  -> "Very Low"
        value < 25f  -> "Low"
        value < 40f  -> "Normal"
        value < 60f  -> "High"
        else         -> "Very High"
    }

    fun getPhColor(value: Float): String = when {
        value < 5.0f -> "#FF0000"
        value < 5.5f -> "#FFA500"
        value < 6.5f -> "#00FF00"
        value < 7.5f -> "#FFA500"
        else         -> "#FF0000"
    }

    fun getTemperatureColor(value: Float): String = when {
        value < 5f   -> "#FF0000"
        value < 10f  -> "#FFA500"
        value < 25f  -> "#00FF00"
        value < 30f  -> "#FFA500"
        else         -> "#FF0000"
    }

    fun getConductivityColor(value: Float): String = when {
        value < 0.2f -> "#FF0000"
        value < 0.5f -> "#FFA500"
        value < 1.5f -> "#00FF00"
        value < 2.5f -> "#FFA500"
        else         -> "#FF0000"
    }

    fun getPhosphorusColor(value: Float): String = when {
        value < 5f   -> "#FF0000"
        value < 10f  -> "#FFA500"
        value < 30f  -> "#00FF00"
        value < 50f  -> "#FFA500"
        else         -> "#FF0000"
    }

    fun getPotassiumColor(value: Float): String = when {
        value < 50f  -> "#FF0000"
        value < 100f -> "#FFA500"
        value < 200f -> "#00FF00"
        value < 300f -> "#FFA500"
        else         -> "#FF0000"
    }

    fun getNitrogenColor(value: Float): String = when {
        value < 0.1f -> "#FF0000"
        value < 0.5f -> "#FFA500"
        value < 1.0f -> "#00FF00"
        value < 2.0f -> "#FFA500"
        else         -> "#FF0000"
    }

    fun getHumidityColor(value: Float): String = when {
        value < 10f  -> "#FF0000"
        value < 25f  -> "#FFA500"
        value < 40f  -> "#00FF00"
        value < 60f  -> "#FFA500"
        else         -> "#FF0000"
    }
}

