package com.example.githubsearchbar.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Proyecto : Serializable {

    @SerializedName("id")
    var id: Int? = null

    @SerializedName("node_id")
    var nodeId: String? = null
        private set

    @SerializedName("name")
    var name: String? = null

    @SerializedName("full_name")
    var fullName: String? = null
        private set

    @SerializedName("private")
    var _private: Boolean? = null
        private set

    @SerializedName("owner")
    var owner: owner? = null
        private set

    @SerializedName("html_url")
    var htmlUrl: String? = null
        private set

    @SerializedName("description")
    var description: Object? = null
        private set

    @SerializedName("fork")
    var fork: Boolean? = null
        private set

    @SerializedName("url")
    var url: String? = null
        private set

    @SerializedName("forks_url")
    var forksUrl: String? = null
        private set

    @SerializedName("keys_url")
    var keysUrl: String? = null
        private set

    @SerializedName("collaborators_url")
    var collaboratorsUrl: String? = null
        private set

    @SerializedName("teams_url")
    var teamsUrl: String? = null
        private set

    @SerializedName("hooks_url")
    var hooksUrl: String? = null
        private set

    @SerializedName("issue_events_url")
    var issueEventsUrl: String? = null
        private set

    @SerializedName("events_url")
    var eventsUrl: String? = null
        private set

    @SerializedName("assignees_url")
    var assigneesUrl: String? = null
        private set

    @SerializedName("branches_url")
    var branchesUrl: String? = null
        private set

    @SerializedName("tags_url")
    var tagsUrl: String? = null
        private set

    @SerializedName("blobs_url")
    var blobsUrl: String? = null
        private set

    @SerializedName("git_tags_url")
    var gitTagsUrl: String? = null
        private set

    @SerializedName("git_refs_url")
    var gitRefsUrl: String? = null
        private set

    @SerializedName("trees_url")
    var treesUrl: String? = null
        private set

    @SerializedName("statuses_url")
    var statusesUrl: String? = null
        private set

    @SerializedName("languages_url")
    var languagesUrl: String? = null
        private set

    @SerializedName("stargazers_url")
    var stargazersUrl: String? = null
        private set

    @SerializedName("contributors_url")
    var contributorsUrl: String? = null
        private set

    @SerializedName("subscribers_url")
    var subscribersUrl: String? = null
        private set

    @SerializedName("subscription_url")
    var subscriptionUrl: String? = null
        private set

    @SerializedName("commits_url")
    var commitsUrl: String? = null
        private set

    @SerializedName("git_commits_url")
    var gitCommitsUrl: String? = null
        private set

    @SerializedName("comments_url")
    var commentsUrl: String? = null
        private set

    @SerializedName("issue_comment_url")
    var issueCommentUrl: String? = null
        private set

    @SerializedName("contents_url")
    var contentsUrl: String? = null
        private set

    @SerializedName("compare_url")
    var compareUrl: String? = null
        private set

    @SerializedName("merges_url")
    var mergesUrl: String? = null
        private set

    @SerializedName("archive_url")
    var archiveUrl: String? = null
        private set

    @SerializedName("downloads_url")
    var downloadsUrl: String? = null
        private set

    @SerializedName("issues_url")
    var issuesUrl: String? = null
        private set

    @SerializedName("pulls_url")
    var pullsUrl: String? = null
        private set

    @SerializedName("milestones_url")
    var milestonesUrl: String? = null
        private set

    @SerializedName("notifications_url")
    var notificationsUrl: String? = null
        private set

    @SerializedName("labels_url")
    var labelsUrl: String? = null
        private set

    @SerializedName("releases_url")
    var releasesUrl: String? = null
        private set

    @SerializedName("deployments_url")
    var deploymentsUrl: String? = null
        private set

    @SerializedName("created_at")
    var createdAt: String? = null
        private set

    @SerializedName("updated_at")
    var updatedAt: String? = null
        private set

    @SerializedName("pushed_at")
    var pushedAt: String? = null
        private set

    @SerializedName("git_url")
    var gitUrl: String? = null
        private set

    @SerializedName("ssh_url")
    var sshUrl: String? = null
        private set

    @SerializedName("clone_url")
    var cloneUrl: String? = null
        private set

    @SerializedName("svn_url")
    var svnUrl: String? = null
        private set

    @SerializedName("homepage")
    var homepage: String? = null
        private set

    @SerializedName("language")
    var language: String? = null
        private set

    @SerializedName("default_branch")
    var defaultBranch: String? = null
        private set

    @SerializedName("size")
    var size: Int? = null
        private set

    @SerializedName("stargazers_count")
    var stargazersCount: Int? = null
        private set

    @SerializedName("watchers_count")
    var watchersCount: Int? = null
        private set

    @SerializedName("forks_count")
    var forksCount: Int? = null
        private set

    @SerializedName("open_issues_count")
    var openIssuesCount: Int? = null
        private set

    @SerializedName("forks")
    var forks: Int? = null
        private set

    @SerializedName("open_issues")
    var open_issues: Int? = null
        private set

    @SerializedName("has_issues")
    var hasIssues: String? = null
        private set

    @SerializedName("has_projects")
    var hasProjects: Boolean? = null
        private set

    @SerializedName("has_downloads")
    var hasDownloads: Boolean? = null
        private set

    @SerializedName("has_wiki")
    var hasWiki: Boolean? = null
        private set

    @SerializedName("has_pages")
    var hasPages: Boolean? = null
        private set

    @SerializedName("archived")
    var archived: Boolean? = null
        private set

    @SerializedName("disabled")
    var disabled: Boolean? = null
        private set

    //  @SerializedName("license")
    //   var license: License?  = null private set

    @SerializedName("openIssues")
    var openIssues: Int? = null
        private set

    @SerializedName("watchers")
    var watchers: Int? = null
        private set


    @SerializedName("score")
    var score: Double? = null
        private set

    @SerializedName("mirror_url")
    var mirrorUrl: Object? = null
        private set

}


class owner : Serializable {
    @SerializedName("login")
    var login: String? = null
        private set

    @SerializedName("id")
    var id: Int? = null
        private set

    @SerializedName("node_id")
    var nodeId: String? = null
        private set

    @SerializedName("avatar_url")
    var avatarUrl: String? = null
        private set

    @SerializedName("gravatar_id")
    var gravatarId: String? = null
        private set

    @SerializedName("url")
    var url: String? = null
        private set

    @SerializedName("html_url")
    var htmlUrl: String? = null
        private set

    @SerializedName("followers_url")
    var followersUrl: String? = null
        private set

    @SerializedName("following_url")
    var followingUrl: String? = null
        private set

    @SerializedName("gists_url")
    var gistsUrl: String? = null
        private set

    @SerializedName("starred_url")
    var starredUrl: String? = null
        private set

    @SerializedName("subscriptions_url")
    var subscriptionsUrl: String? = null
        private set

    @SerializedName("organizations_url")
    var organizationsUrl: String? = null
        private set

    @SerializedName("repos_url")
    var reposUrl: String? = null
        private set

    @SerializedName("events_url")
    var eventsUrl: String? = null
        private set

    @SerializedName("received_events_url")
    var receivedEventsUrl: String? = null
        private set

    @SerializedName("type")
    var type: String? = null
        private set

    @SerializedName("site_admin")
    var siteAdmin: Boolean? = null
        private set

}


