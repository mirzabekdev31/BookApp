package uz.gita.mirzabek.example.bookapp.data.remote.response

data class UserBooksResponse(
    val id:Int,
    val author:String,
    val description:String,
    val pageCount:String,
    val fav:Boolean,
    val isLike:Boolean,
    val likeCount:Int,
    val disLikeCount:Int
)

/*
"id": 1,
        "title": "Yengil Amallar",
        "author": "Muhammad Usmon Taqiy",
        "description": "Bu kitob qanday yengil amal qilsak ko'proq savob ishlab olishimiz haqida",
        "pageCount": 191,
        "fav": false,
        "isLike": true,
        "likeCount": 1,
        "disLikeCount": 0
 */

