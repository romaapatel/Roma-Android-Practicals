package com.example.androidoverview.architecture

data class ResponseModel (
    val data: List<User>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)