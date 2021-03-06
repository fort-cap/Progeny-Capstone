package com.progeny.model;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "recordings")
public class Recording {
    // --------------------------------------------
    // -------------------BEAN---------------------
    // --------------------------------------------

    // ---------- TABLE SETUP -----------
    // 1. Create a primary key for the progeny_db table of recordings
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "recording")
    private String recordingUrl;

    @Column(name = "`timestamp`")
    @CreationTimestamp
    private Date timestamp;

    @Column(name = "updated_on")
    @UpdateTimestamp
    private Date updatedOn;

    @Column(nullable = false, length = 45)
    private String title;

    @Column(name = "group_id")
    private long groupId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="story_recordings",
            joinColumns={@JoinColumn(name="recordings_id")},
            inverseJoinColumns={@JoinColumn(name="stories_id")}
    )
    private List<Recording> recordingList;



    // ---------- CONSTRUCTOR METHOD(S) -----------

    // ----- MEMORY SPACE CONSTRUCTOR ----
    public Recording() {}


    // ----- COPY CONSTRUCTOR ----
    public Recording(Recording copy){
        id = copy.id;
        recordingUrl = copy.recordingUrl;
        title = copy.title;
        groupId = copy.groupId;
        timestamp = copy.timestamp;
        updatedOn = copy.updatedOn;
        user = copy.user;
        recordingList = copy.recordingList;
    }
    //----------------------------


    // ----- WITH ID CONSTRUCTOR ----
    public Recording(String recordingUrl, Date timestamp, Date updatedOn, String title, long groupId, User user, List<Recording> recordingList) {
        this.recordingUrl = recordingUrl;
        this.timestamp = timestamp;
        this.updatedOn = updatedOn;
        this.title = title;
        this.groupId = groupId;
        this.user = user;
        this.recordingList = recordingList;
    }


    // ----- WITHOUT ID CONSTRUCTOR ----
    public Recording(long id, String recordingUrl, Date timestamp, Date updatedOn, String title, long groupId, User user, List<Recording> recordingList) {
        this.id = id;
        this.recordingUrl = recordingUrl;
        this.timestamp = timestamp;
        this.updatedOn = updatedOn;
        this.title = title;
        this.groupId = groupId;
        this.user = user;
        this.recordingList = recordingList;
    }

    // ----- WITHOUT ID & USER CONSTRUCTOR ----
    public Recording(String recordingUrl, String title, long groupId) {
        this.recordingUrl = recordingUrl;
        this.title = title;
        this.groupId = groupId;
    }

    public Recording( String recordingUrl, Timestamp timestamp, String title, long groupId, User user, List<Recording> recordingList) {
        this.recordingUrl = recordingUrl;
        this.timestamp = timestamp;
        this.title = title;
        this.groupId = groupId;
        this.user = user;
        this.recordingList = recordingList;
    }

    public Recording(long id, String recordingUrl, Timestamp timestamp, String title, long groupId, User user, List<Recording> recordingList) {
        this.id = id;
        this.recordingUrl = recordingUrl;
        this.timestamp = timestamp;
        this.title = title;
        this.groupId = groupId;
        this.user = user;
        this.recordingList = recordingList;
    }

    // ---------- GET AND SET METHODS -----------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRecordingUrl() {
        return recordingUrl;
    }

    public void setRecordingUrl(String recordingUrl) {
        this.recordingUrl = recordingUrl;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Recording> getRecordingList() {
        return recordingList;
    }

    public void setRecordingList(List<Recording> recordingList) {
        this.recordingList = recordingList;
    }
}
