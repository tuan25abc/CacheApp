package com.example.myapplication.helper

import com.example.myapplication.model.Owner
import com.example.myapplication.model.Repo
import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter

class CustomTypeAdapterFactory : TypeAdapterFactory {
    override fun <T : Any?> create(gson: Gson?, type: TypeToken<T>?): TypeAdapter<T> {
        return RepoListTypeAdapter() as TypeAdapter<T>
    }
}

class RepoListTypeAdapter : TypeAdapter<List<Repo>>() {
    override fun write(out: JsonWriter?, value: List<Repo>?) {
        out?.value("String")
    }

    override fun read(jsonReader: JsonReader?): List<Repo> {
        var repos: List<Repo> = ArrayList()
        if (jsonReader == null)
            return repos

        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            repos = readRepoList(jsonReader)
        }
        return repos
    }

    private fun readRepoList(jsonReader: JsonReader): List<Repo> {
        val repos = ArrayList<Repo>()

        jsonReader.beginArray()
        while (jsonReader.hasNext()) {
            repos.add(readRepo(jsonReader))
        }
        jsonReader.endArray()

        return repos
    }

    private fun readRepo(jsonReader: JsonReader): Repo {
        val repo = Repo()

        jsonReader.beginObject()
        while (jsonReader.hasNext()) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull()
                continue
            }
            val name = jsonReader.nextName()
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.skipValue()
                continue
            }
            when (name) {
                "id" -> repo.id = jsonReader.nextInt()
                "node_id" -> repo.nodeId = jsonReader.nextString()
                "name" -> repo.name = jsonReader.nextString()
                "full_name" -> repo.fullName = jsonReader.nextString()
                "private" -> repo.private = jsonReader.nextBoolean()
                "owner" -> repo.owner = readOwner(jsonReader)
                "html_url" -> repo.htmlUrl = jsonReader.nextString()
                "description" -> repo.description = jsonReader.nextString()
                "fork" -> repo.fork = jsonReader.nextBoolean()
                "url" -> repo.url = jsonReader.nextString()
                "forks_url" -> repo.forksUrl = jsonReader.nextString()
                "keys_url" -> repo.keysUrl = jsonReader.nextString()
                "collaborators_url" -> repo.collaboratorsUrl = jsonReader.nextString()
                "teams_url" -> repo.teamsUrl = jsonReader.nextString()
                "hooks_url" -> repo.hooksUrl = jsonReader.nextString()
                "issue_events_url" -> repo.issueEventsUrl = jsonReader.nextString()
                "events_url" -> repo.eventsUrl = jsonReader.nextString()
                "assignees_url" -> repo.assigneesUrl = jsonReader.nextString()
                "branches_url" -> repo.branchesUrl = jsonReader.nextString()
                "tags_url" -> repo.tagsUrl = jsonReader.nextString()
                "blobs_url" -> repo.blobsUrl = jsonReader.nextString()
                "git_tags_url" -> repo.gitTagsUrl = jsonReader.nextString()
                "git_refs_url" -> repo.gitRefsUrl = jsonReader.nextString()
                "trees_url" -> repo.treesUrl = jsonReader.nextString()
                "statuses_url" -> repo.statusesUrl = jsonReader.nextString()
                "languages_url" -> repo.languagesUrl = jsonReader.nextString()
                "stargazers_url" -> repo.stargazersUrl = jsonReader.nextString()
                "contributors_url" -> repo.contributorsUrl = jsonReader.nextString()
                "subscribers_url" -> repo.subscribersUrl = jsonReader.nextString()
                "subscription_url" -> repo.subscriptionUrl = jsonReader.nextString()
                "commits_url" -> repo.commitsUrl = jsonReader.nextString()
                "git_commits_url" -> repo.gitCommitsUrl = jsonReader.nextString()
                "comments_url" -> repo.commentsUrl = jsonReader.nextString()
                "issue_comment_url" -> repo.issueCommentUrl = jsonReader.nextString()
                "contents_url" -> repo.contentsUrl = jsonReader.nextString()
                "compare_url" -> repo.compareUrl = jsonReader.nextString()
                "merges_url" -> repo.mergesUrl = jsonReader.nextString()
                "archive_url" -> repo.archiveUrl = jsonReader.nextString()
                "downloads_url" -> repo.downloadsUrl = jsonReader.nextString()
                "issues_url" -> repo.issuesUrl = jsonReader.nextString()
                "pulls_url" -> repo.pullsUrl = jsonReader.nextString()
                "milestones_url" -> repo.milestonesUrl = jsonReader.nextString()
                "notifications_url" -> repo.notificationsUrl = jsonReader.nextString()
                "labels_url" -> repo.labelsUrl = jsonReader.nextString()
                "releases_url" -> repo.releasesUrl = jsonReader.nextString()
                "deployments_url" -> repo.deploymentsUrl = jsonReader.nextString()
                "created_at" -> repo.createdAt = jsonReader.nextString()
                "updated_at" -> repo.updatedAt = jsonReader.nextString()
                "pushed_at" -> repo.pushedAt = jsonReader.nextString()
                "git_url" -> repo.gitUrl = jsonReader.nextString()
                "ssh_url" -> repo.svnUrl = jsonReader.nextString()
                "clone_url" -> repo.cloneUrl = jsonReader.nextString()
                "svn_url" -> repo.svnUrl = jsonReader.nextString()
                "homepage" -> repo.homepage = jsonReader.nextString()
                "size" -> repo.size = jsonReader.nextInt()
                "stargazers_count" -> repo.stargazersCount = jsonReader.nextInt()
                "watchers_count" -> repo.watchersCount = jsonReader.nextInt()
                "language" -> repo.language = jsonReader.nextString()
                "has_issues" -> repo.hasIssues = jsonReader.nextBoolean()
                "has_projects" -> repo.hasProjects = jsonReader.nextBoolean()
                "has_downloads" -> repo.hasDownloads = jsonReader.nextBoolean()
                "has_wiki" -> repo.hasWiki = jsonReader.nextBoolean()
                "has_pages" -> repo.hasPages = jsonReader.nextBoolean()
                "forks_count" -> repo.forksCount = jsonReader.nextInt()
                "mirror_url" -> repo.mirrorUrl = jsonReader.nextString()
                "archived" -> repo.archived = jsonReader.nextBoolean()
                "disabled" -> repo.disabled = jsonReader.nextBoolean()
                "open_issues_count" -> repo.openIssuesCount = jsonReader.nextInt()
                "forks" -> repo.forks = jsonReader.nextInt()
                "open_issues" -> repo.openIssues = jsonReader.nextInt()
                "watchers" -> repo.watchers = jsonReader.nextInt()
                "default_branch" -> repo.defaultBranch = jsonReader.nextString()
                else -> jsonReader.skipValue()
            }
        }
        jsonReader.endObject()

        return repo
    }

    private fun readOwner(jsonReader: JsonReader): Owner {
        val owner = Owner()

        jsonReader.beginObject()
        while (jsonReader.hasNext()) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull()
                continue
            }
            val name = jsonReader.nextName()
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.skipValue()
                continue
            }
            when (name) {
                "login" -> owner.login = jsonReader.nextString()
                "id" -> owner.id = jsonReader.nextInt()
                "node_id" -> owner.nodeId = jsonReader.nextString()
                "avatar_url" -> owner.avatarUrl = jsonReader.nextString()
                "gravatar_id" -> owner.gravatarId = jsonReader.nextString()
                "url" -> owner.url = jsonReader.nextString()
                "html_url" -> owner.htmlUrl = jsonReader.nextString()
                "followers_url" -> owner.followersUrl = jsonReader.nextString()
                "following_url" -> owner.followingUrl = jsonReader.nextString()
                "gists_url" -> owner.gistsUrl = jsonReader.nextString()
                "starred_url" -> owner.starredUrl = jsonReader.nextString()
                "subscriptions_url" -> owner.subscriptionsUrl = jsonReader.nextString()
                "organizations_url" -> owner.organizationsUrl = jsonReader.nextString()
                "repos_url" -> owner.reposUrl = jsonReader.nextString()
                "events_url" -> owner.eventsUrl = jsonReader.nextString()
                "received_events_url" -> owner.receivedEventsUrl = jsonReader.nextString()
                "type" -> owner.type = jsonReader.nextString()
                "site_admin" -> owner.siteAdmin = jsonReader.nextBoolean()
                else -> jsonReader.skipValue()
            }
        }
        jsonReader.endObject()

        return owner
    }
}