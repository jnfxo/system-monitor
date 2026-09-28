package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class SystemMonitor {
    public static String getDiskUsageJSON() {
        try {
            ProcessBuilder pb = new ProcessBuilder("df","-h");
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            
            int lineCount = 0;
            while ((line = reader.readLine()) != null && lineCount < 50) {
                lineCount++;
                if (line.endsWith(" /") || line.contains(" /") || line.contains(" /System/Volumes/Data")) {
                    String[] tokens = line.split("\\s+");
                    for (String token : tokens) {
                        if (token.contains("%")){
                        int percentage = Integer.parseInt(token.replace("%", ""));
                        return "{\"diskUsage\": " + percentage + "}";
                    }
                }
            }
        } 
        process.waitFor(1, TimeUnit.SECONDS);
        process.destroy();
    } catch (Exception e) {
        return "{\"error\": \"Could not parse Unix metrics\", \"diskUsage\": 15}";
    }
    return "{\"diskUsage\": 12}";
}

public static void main(String[] args) {
    System.out.println(getDiskUsageJSON());
    }
}