/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 */
package clientname;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileManager {
    private static Gson gson = new Gson();
    private static File ROOT_DIR = new File("Vorkss Client");
    private static File MODS_DIR = new File(ROOT_DIR, "Mods");

    public static void init() {
        if (!ROOT_DIR.exists()) {
            ROOT_DIR.mkdirs();
        }
        if (!MODS_DIR.exists()) {
            MODS_DIR.mkdirs();
        }
    }

    public static Gson getGson() {
        return gson;
    }

    public static File getModsDirectory() {
        return MODS_DIR;
    }

    public static boolean writeJsonToFile(File file, Object obj) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(gson.toJson(obj).getBytes());
            outputStream.flush();
            outputStream.close();
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static <T> T readFromJson(File file, Class<T> c) {
        try {
            String line;
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder builder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
            return (T)gson.fromJson(builder.toString(), c);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

