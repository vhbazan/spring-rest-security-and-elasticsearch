package com.vhbazanm.model;

import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Document(indexName = "#{@getPostIndexName}", type = "content")
public class Post {

    private String id;
    private String title;
    private String description;
    private String[] tags;
    private String createdByUserId;
    private Date createdAt;

    public Post(String id, String title, String description, String[] tags, String createdByUserId, Date createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.createdByUserId = createdByUserId;
        this.createdAt = createdAt;
    }

    public Post() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(String createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
