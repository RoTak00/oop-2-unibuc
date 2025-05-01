package db;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class AuditService {
    private static AuditService instance;

    private final String AUDIT_PATH = "audit_log.csv";

    private AuditService() {
        File file = new File(AUDIT_PATH);
        if (!file.exists() || file.length() == 0) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write("action,timestamp\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static AuditService getInstance() {
        if (instance == null) {
            instance = new AuditService();
        }

        return instance;
    }

    public void audit(String action) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(AUDIT_PATH, true))) {
            StringBuilder sb = new StringBuilder();

            sb.append(action);
            sb.append(",");
            sb.append(LocalDateTime.now().toString());
            sb.append("\n");

            bw.write(sb.toString());

            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
