package ru.vizzi.launchermodules.minesocialsupport;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import pro.gravit.launcher.HTTPRequest;
import pro.gravit.launchserver.auth.handler.AuthHandler;
import pro.gravit.launchserver.auth.provider.AuthProviderResult;
import pro.gravit.utils.helper.LogHelper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MinesocialAuthHandler extends AuthHandler {
    private static final Gson gson = new Gson();
    public static URL joinServer;

    static {
        try {
            joinServer = new URL("https://sessionserver.minesocial.net/session/minecraft/join");
        } catch (MalformedURLException e) {
            LogHelper.error(e);
        }
    }

    public final HashMap<String, UUID> usernameToUUID = new HashMap<>();
    boolean returnSuccess = true;

    @Override
    public UUID auth(AuthProviderResult authResult) {
        if (authResult instanceof MinesocialAuthProviderResult) {
            MinesocialAuthProviderResult result = (MinesocialAuthProviderResult) authResult;
            usernameToUUID.put(result.username, result.uuid);
            return result.uuid;
        }
        return null;
    }

    @Override
    public UUID checkServer(String username, String serverID) {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public boolean joinServer(String username, String accessToken, String serverID) throws IOException {
        minesocialJoinServerRequest request = new minesocialJoinServerRequest();
        request.agent = new MinesocialAuthProvider.minesocialAgent();
        request.agent.name = "Minecraft";
        request.agent.version = 1;
        request.accessToken = accessToken;
        request.selectedProfile = usernameToUUID(username).toString().replace("-", "");
        request.serverId = serverID;
        try {
            JsonObject response = HTTPRequest.jsonRequest(gson.toJsonTree(request), joinServer).getAsJsonObject();
            if (response != null) {
                JsonElement errorMessage = response.get("errorMessage");
                if (errorMessage != null)
                    authError(errorMessage.getAsString());
            }

        } catch (IllegalStateException ignore) {
            //Ignored
        }
        return true;
    }

    @Override
    public UUID usernameToUUID(String username) {
        return usernameToUUID.get(username);
    }

    @Override
    public String uuidToUsername(UUID uuid) {
        for (Map.Entry<String, UUID> entry : usernameToUUID.entrySet()) {
            if (entry.getValue().equals(uuid)) return entry.getKey();
        }
        return null;
    }

    public static class minesocialJoinServerRequest {
        public MinesocialAuthProvider.minesocialAgent agent;
        public String accessToken;
        public String selectedProfile;
        public String serverId;
    }
}
