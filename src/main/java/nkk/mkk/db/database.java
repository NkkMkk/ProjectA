package nkk.mkk.db;

import nkk.mkk.Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.json.JSONObject;

public class database {

    public database() {}

    public String playerDataPath(UUID uuid) {
        return Main.getPlugin().getDataFolder().getAbsolutePath() + "/db/players/" + uuid + ".json";
    }

    public void writeToJson(String key, Object value, String filePath) throws IOException {
        JSONObject obj = new JSONObject();
        File f = new File(filePath); f.getParentFile().mkdirs();

        if (f.exists()) {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            obj = new JSONObject(content);
        }

        obj.put(key, value);
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(obj.toString(4));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playerDataCreate(UUID uuid) throws IOException {
        writeToJson("username", Bukkit.getPlayer(uuid).getDisplayName(), playerDataPath(uuid));
    }
}
