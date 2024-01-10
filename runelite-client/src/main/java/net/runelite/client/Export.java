package net.runelite.client;

import net.runelite.http.api.RuneLiteAPI;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Export {
    public static void main(String[] args) throws IOException {
        String version = RuneLiteProperties.getVersion();

        File hotliteDir = new File(System.getProperty("user.home") + "/.runelite/hotlite/" + version + "/");
        hotliteDir.mkdirs();

        File apiJar = new File("./runelite-api/target/runelite-api-" + version + ".jar");
        File clientJar = new File("./runelite-client/target/client-" + version + ".jar");

        if (!apiJar.exists())
            throw new RuntimeException("API jar missing, Maven install first.");

        if (!clientJar.exists())
            throw new RuntimeException("Client jar missing, Maven install first.");

        System.out.println("Hotlite Exporting " + version);

        File targetApiJar = new File(hotliteDir, "runelite-api-" + version + ".jar");
        File targetClientJar = new File(hotliteDir, "client-" + version + ".jar");

        Files.copy(apiJar.toPath(), targetApiJar.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(clientJar.toPath(), targetClientJar.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
