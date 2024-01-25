package nkk.mkk.db;

import nkk.mkk.Main;
import java.io.FileWriter;
import java.io.IOException;
import org.bukkit.entity.Player;
import org.json.JSONObject;

public class database {

    public database() {
    }

   /*
    public Object playerDataGet(UUID uuid) throws FileNotFoundException {
        Gson gson = new Gson();
        File file = new File(Main.getPlugin().getDataFolder().getAbsolutePath() + "/players/" + uuid + ".json");
        if (file.exists()){
            Reader reader = new FileReader(file);
            return gson.fromJson(reader, Note[].class);
        }

        return null;
    }

    public void playerDataSet(UUID uuid) throws FileNotFoundException {
        Gson gson = new Gson();
        File file = new File(Main.getPlugin().getDataFolder().getAbsolutePath() + "/players/" + uuid + ".json");
        if (file.exists()){
            Reader reader = new FileReader(file);
        }
    }

    */

    public void writeToJson(String key, Object value, String filePath) {
        JSONObject obj = new JSONObject();
        obj.put(key, value);

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(obj.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playerDataCreate(Player p) {
        writeToJson("uuid", p.getUniqueId(), Main.getPlugin().getDataFolder().getAbsolutePath() + "/players/" + p.getUniqueId() + ".json");
        System.out.println("Player data create!");
    }
}
