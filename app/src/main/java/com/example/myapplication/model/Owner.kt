package com.example.myapplication.model

data class Owner(
    var login: String = "",

    var ownerId: Int = 0,

    var nodeId: String = "",

    var avatarUrl: String = "",

    var gravatarId: String = "",

    var ownerUrl: String = "",

    var ownerHtmlUrl: String = "",

    var followersUrl: String = "",

    var followingUrl: String = "",

    var gistsUrl: String = "",

    var starredUrl: String = "",

    var subscriptionsUrl: String = "",

    var organizationsUrl: String = "",

    var reposUrl: String = "",

    var ownerEventsUrl: String = "",

    var receivedEventsUrl: String = "",

    var type: String = "",

    var siteAdmin: Boolean = false
)