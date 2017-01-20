package com.tanguy.rssfeed.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String mLogin;
    private String mPassword;

    public User(String login, String password) {
        this.mLogin = password;
        this.mPassword = password;
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public User(Parcel in) {
        this.mLogin = in.readString();
        this.mPassword = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mLogin);
        dest.writeString(this.mPassword);
    }

    public String getmLogin() {
        return this.mLogin;
    }

    public String getmPassword() {
        return this.mPassword;
    }
}
