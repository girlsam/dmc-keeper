package com.dmckeeper.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class DmcThread {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // DMC code (e.g. 310, BLANC)
    private String code;
    // DMC's name for the color
    private String colorName;
    // Whether the skein is owned or not
    private boolean owned;
    // How many skeins we have
    private int skeinCount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public int getSkeinCount() {
        return skeinCount;
    }

    public void setSkeinCount(int skeinCount) {
        this.skeinCount = skeinCount;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
