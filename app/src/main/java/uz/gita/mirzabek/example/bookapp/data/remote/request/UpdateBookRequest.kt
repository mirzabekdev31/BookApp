package uz.gita.mirzabek.example.bookapp.data.remote.request

data class UpdateBookRequest (
    val id:Int,
    val title:String,
    val author:String,
    val description:String,
    val pageCount:Int
    )

/*
- id:Int
  - title:String
  - author:String
  - description:String
  - pageCount:Int
 */