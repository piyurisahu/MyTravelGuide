package com.example.mytravelguide.Model


class City{
    var city:String?=null
    var hotel:String?=null
    var state:String?=null
    var description:String?=null
    var weather:String? = null
    var image:Int?=null
    var placesToVisit: ArrayList<String>? = null
    constructor(city:String ,hotel:String ,description:String, weather:String, state: String, image:Int, placesToVisit: ArrayList<String>){
        this.city = city
        this.hotel = hotel
        this.description = description
        this.weather = weather
        this.state = state
        this.image=image
        this.placesToVisit = placesToVisit
    }
}
