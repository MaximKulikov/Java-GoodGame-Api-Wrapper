package com.mb3364.twitch.api.handlers;

import com.mb3364.twitch.api.models.User_Twitch;

public interface UserResponseHandler extends BaseFailureHandler {
    void onSuccess(User_Twitch user);
}
