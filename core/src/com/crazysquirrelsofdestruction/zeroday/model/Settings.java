package com.crazysquirrelsofdestruction.zeroday.model;

/**
 * Created by Klaudia on 2016-04-12.
 */
public class Settings {

    private Boolean music;
    private Boolean effects;

    public Settings() {
        this.music = true;
        this.effects = true;
    }

    public Boolean getMusic() {
        return music;
    }

    public Boolean getEffects() {
        return effects;
    }

    public void setMusic(Boolean music) {
        this.music = music;
    }

    public void setEffects(Boolean effects) {
        this.effects = effects;
    }
}
