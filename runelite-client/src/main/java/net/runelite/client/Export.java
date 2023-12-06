package net.runelite.client;

import net.runelite.http.api.RuneLiteAPI;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Export {
    public static void main(String[] args) throws IOException {
        File apiJar = new File("./runelite-api/target/runelite-api-" + RuneLiteProperties.getVersion() + ".jar");
        File clientJar = new File("./runelite-client/target/client-" + RuneLiteProperties.getVersion() + ".jar");
        File hotliteDir = new File(System.getProperty("user.home") + "/.runelite/hotlite/" + RuneLiteProperties.getVersion() + "/");

        File targetApiJar = new File(hotliteDir, "runelite-api-" + RuneLiteProperties.getVersion() + ".jar");
        File targetClientJar = new File(hotliteDir, "client-" + RuneLiteProperties.getVersion() + ".jar");
        if (apiJar.exists() && clientJar.exists()) {
            hotliteDir.mkdirs();
            Files.copy(apiJar.toPath(), targetApiJar.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(clientJar.toPath(), targetClientJar.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Success");
        }
    }
}
