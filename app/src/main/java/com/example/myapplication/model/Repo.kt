package com.example.myapplication.model

data class Repo(
    var id: Int = 0,

    var nodeId: String = "",

    var name: String = "",

    var fullName: String = "",

    var private: Boolean = false,

    var owner: Owner = Owner(),

    var htmlUrl: String = "",

    var description: String = "",

    var fork: Boolean = false,

    var url: String = "",

    var forksUrl: String = "",

    var keysUrl: String = "",

    var collaboratorsUrl: String = "",

    var teamsUrl: String = "",

    var hooksUrl: String = "",

    var issueEventsUrl: String = "",

    var eventsUrl: String = "",

    var assigneesUrl: String = "",

    var branchesUrl: String = "",

    var tagsUrl: String = "",

    var blobsUrl: String = "",

    var gitTagsUrl: String = "",

    var gitRefsUrl: String = "",

    var treesUrl: String = "",

    var statusesUrl: String = "",

    var languagesUrl: String = "",

    var stargazersUrl: String = "",

    var contributorsUrl: String = "",

    var subscribersUrl: String = "",

    var subscriptionUrl: String = "",

    var commitsUrl: String = "",

    var gitCommitsUrl: String = "",

    var commentsUrl: String = "",

    var issueCommentUrl: String = "",

    var contentsUrl: String = "",

    var compareUrl: String = "",

    var mergesUrl: String = "",

    var archiveUrl: String = "",

    var downloadsUrl: String = "",

    var issuesUrl: String = "",

    var pullsUrl: String = "",

    var milestonesUrl: String = "",

    var notificationsUrl: String = "",

    var labelsUrl: String = "",

    var releasesUrl: String = "",

    var deploymentsUrl: String = "",

    var createdAt: String = "",

    var updatedAt: String = "",

    var pushedAt: String = "",

    var gitUrl: String = "",

    var sshUrl: String = "",

    var cloneUrl: String = "",

    var svnUrl: String = "",

    var homepage: String = "",

    var size: Int = 0,

    var stargazersCount: Int = 0,

    var watchersCount: Int = 0,

    var language: String = "",

    var hasIssues: Boolean = false,

    var hasProjects: Boolean = false,

    var hasDownloads: Boolean = false,

    var hasWiki: Boolean = false,

    var hasPages: Boolean = false,

    var forksCount: Int = 0,

    var mirrorUrl: String = "",

    var archived: Boolean = false,

    var disabled: Boolean = false,

    var openIssuesCount: Int = 0,

    var forks: Int = 0,

    var openIssues: Int = 0,

    var watchers: Int = 0,

    var defaultBranch: String = ""
)