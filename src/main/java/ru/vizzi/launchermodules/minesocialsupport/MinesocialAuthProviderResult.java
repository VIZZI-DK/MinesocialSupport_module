package ru.vizzi.launchermodules.minesocialsupport;

import pro.gravit.launchserver.auth.provider.AuthProviderResult;

import java.util.UUID;

public final class MinesocialAuthProviderResult extends AuthProviderResult {
    public final UUID uuid;
    public final String launcherToken;

    public MinesocialAuthProviderResult(String username, String accessToken, UUID uuid, String launcherToken) {
        super(username, accessToken);
        this.uuid = uuid;
        this.launcherToken = launcherToken;
    }
}
