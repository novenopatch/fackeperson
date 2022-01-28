package com.jerrykel.fackeperson.models

class FakeProfile(var name:Name, var location: Location, var picture: Picture) {
    public fun getFirstName():String{
        return name.first
    }
    public fun getLastName():String{
        return name.last
    }
    public fun getPicture():String{
        return picture.large
    }
    public fun getFullAddress():String{
        return location.street.number +"  " +location.street.name
    }

}