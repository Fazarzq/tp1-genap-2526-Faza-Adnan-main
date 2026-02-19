import java.util.Scanner;

public class BurhanQuest {
    // Banner pembuka, silakan manfaatkan variabel ini untuk menampilkan banner di awal dan di akhir program
    private static final String BANNER =  
        "_______                                     __                                     ______                                     __    \n" +
        "|       \\                                   |  \\                                   /      \\                                   |  \\   \n" +
        "| $$$$$$$\\ __    __   ______    | $$____    ______    _______         |  $$$$$$\\ __    __   ______    _______  _| $$_  \n" +
        "| $$__/ $$|  \\  |  \\ /      \\ | $$    \\  |      \\ |       \\       | $$  | $$|  \\  |  \\ /      \\  /       \\|   $$ \\ \n" +
        "| $$    $$| $$  | $$|  $$$$$$\\| $$$$$$$\\  \\$$$$$$\\| $$$$$$$\\      | $$  | $$| $$  | $$|  $$$$$$\\|  $$$$$$$ \\$$$$$$ \n" +
        "| $$$$$$$\\| $$  | $$| $$   \\$$| $$   | $$ /      $$| $$   | $$      | $$ _| $$| $$  | $$| $$    $$ \\$$    \\   | $$ __ \n" +
        "| $$__/ $$| $$__/ $$| $$      | $$   | $$|  $$$$$$$| $$   | $$      | $$/ \\ $$| $$__/ $$| $$$$$$$$ _\\$$$$$$\\  | $$|  \\\n" +
        "| $$    $$ \\$$    $$| $$      | $$   | $$ \\$$    $$| $$   | $$       \\$$ $$ $$ \\$$    $$ \\$$     \\|      $$   \\$$  $$\n" +
        " \\$$$$$$$   \\$$$$$$  \\$$       \\$$    \\$$  \\$$$$$$$ \\$$    \\$$        \\$$$$$$\\  \\$$$$$$   \\$$$$$$$ \\$$$$$$$     \\$$$$ \n" +
        "                                                                          \\$$$";                                       
                                                                                                 
    private static final String STUDENT_NAME = "Muhammad Faza Adnan Rieziq";
    private static final String STUDENT_ID = "2506657062";

    // Penanda atribut, silakan manfaatkan variabel ini untuk menandai atribut di dalam data
    // Atribut yang sama
    private static final char NAME_IDENTIFIER = '!';
    private static final char STATUS_IDENTIFIER = '@';
    private static final char EXP_IDENTIFIER = '#';

    // Atribut khusus quest
    private static int questId = 1;
    private static final char REWARD_IDENTIFIER = '$';
    private static final char DESC_IDENTIFIER = '%';
    private static final char DIFFICULTY_IDENTIFIER = '^';

    // Atribut khusus pengembara
    private static int travelerId = 1;
    private static final char LEVEL_IDENTIFIER = '$';

    private static final int MAX_EXP = 1_310_720_000;

    // Scanner untuk input, silakan manfaatkan variabel ini untuk mengambil input dari user
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // TODO: Tampilkan banner
        System.out.println(BANNER);
        System.out.println("Selamat datang di BurhanQuest!");
        System.out.println("Dibuat oleh: " + STUDENT_NAME + " - " + STUDENT_ID);
        System.out.println("Mari kita mulai dengan membuat sejumlah data quest dan pengembara.");

        // TODO: Seeding data quest dan pengembara
        int questCount = 0;
        int travelerCount = 0;
        boolean invalidInput = true;

        // TODO: Input banyak quest dan pengembara
        while (invalidInput) {
            System.out.print("Silakan masukkan banyak quest yang ingin didaftarkan: ");
            String questCountInput = input.nextLine();
            // TODO: Validasi input jumlah quest
            try {
                questCount = Integer.parseInt(questCountInput);
                if (questCount >= 0) {
                    invalidInput = false;
                    break;
                }else {
                    System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
                } 
            }catch(NumberFormatException e) {
                    System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
                }
        }
        
        // TODO: Input jumlah pengembara
        invalidInput = true;
        while (invalidInput) {
            System.out.print("Silakan masukkan banyak pengembara yang ingin didaftarkan: ");
            String travelerCountInput = input.nextLine();
            // TODO: Validasi input jumlah pengembara
            try {
                travelerCount = Integer.parseInt(travelerCountInput);
                if (travelerCount >= 0) {
                    invalidInput = false;
                } else {
                    System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
            }
        }
        System.out.println();

        String questData = "";
        String travelerData = "";
        System.out.println("Mulai memasukkan data quest.");
        // TODO: Input data quest sebanyak quest yang diminta
        for (int i = 0; i < questCount; i++) {
            System.out.println("Quest " + (i + 1));
            
            String qName = "";
            String qDesc = "";
            int qReward = 0;
            int qBonus = 0;
            String qDifficulty = "";
            
            boolean validQuestInput = false;

            while (!validQuestInput) {
                try {
                    System.out.print("Masukkan nama quest: ");
                    qName = input.nextLine();
                    if (!qName.matches("^[a-zA-Z0-9 ]+$")) {
                        throw new Exception();
                    }

                    System.out.print("Masukkan deskripsi quest: ");
                    qDesc = input.nextLine();
                    if (!qDesc.matches("^[a-zA-Z0-9 ]+$")) {
                        throw new Exception();
                    }

                    System.out.print("Masukkan reward quest berupa bilangan bulat nonnegatif: ");
                    qReward = Integer.parseInt(input.nextLine());
                    if (qReward < 0) throw new Exception();

                    System.out.print("Masukkan bonus exp quest berupa bilangan bulat nonnegatif: ");
                    qBonus = Integer.parseInt(input.nextLine());
                    if (qBonus < 0) throw new Exception();

                    System.out.print("Masukkan tingkat kesulitan quest (opsi: mudah, menengah, sulit): ");
                    qDifficulty = input.nextLine();

                    if (!qDifficulty.equalsIgnoreCase("mudah") && 
                        !qDifficulty.equalsIgnoreCase("menengah") && 
                        !qDifficulty.equalsIgnoreCase("sulit")) {
                        throw new Exception();
                    }

                    validQuestInput = true;

                } catch (Exception e) {
                    System.out.println("Input tidak valid. Harap masukkan data dengan benar.");
                    System.out.println("Quest " + (i + 1)); 
                }
            }

            questData += "Q" + questId + NAME_IDENTIFIER + qName + DESC_IDENTIFIER + qDesc + 
                         REWARD_IDENTIFIER + qReward + EXP_IDENTIFIER + qBonus + 
                         DIFFICULTY_IDENTIFIER + qDifficulty.toLowerCase() + STATUS_IDENTIFIER + "tersedia" + "\n";
            questId++;
        }
        System.out.println();

        System.out.println("Mulai memasukkan data pengembara.");
        // TODO: Input data pengembara sebanyak pengembara yang diminta
        for (int i = 0; i < travelerCount; i++) {
            System.out.println("Pengembara " + (i + 1));
            
            String tName = "";
            int tLevel = 0;
            boolean validTravelerInput = false;

            while (!validTravelerInput) {
                try {
                    System.out.print("Masukkan nama pengembara: ");
                    tName = input.nextLine();
                    if (!tName.matches("^[a-zA-Z0-9 ]+$")) {
                        throw new Exception();
                    }

                    System.out.print("Masukkan level pengembara berupa bilangan bulat [1,20]: ");
                    tLevel = Integer.parseInt(input.nextLine());
                    if (tLevel < 1 || tLevel > 20) {
                        throw new Exception();
                    }

                    validTravelerInput = true;

                } catch (Exception e) {
                    System.out.println("Input tidak valid. Harap masukkan data dengan benar.");
                    System.out.println("Pengembara " + (i + 1));
                }
            }

            int initialExp = 0;
            if (tLevel > 1) {
                initialExp = 5000 * (int)Math.pow(2, tLevel - 2);
            }
            
            travelerData += "T" + travelerId + NAME_IDENTIFIER + tName + 
                            LEVEL_IDENTIFIER + tLevel + EXP_IDENTIFIER + initialExp + 
                            STATUS_IDENTIFIER + "kosong" + "\n";
            travelerId++;
        }
        System.out.println("Data berhasil dimasukkan.");
        System.out.println();

        boolean running = true;
        // TODO: Loop menu utama
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Lihat daftar quest");
            System.out.println("2. Lihat daftar pengembara");
            System.out.println("3. Tambah quest");
            System.out.println("4. Tambah pengembara");
            System.out.println("5. Menjalankan quest");
            System.out.println("6. Menyelesaikan quest");
            System.out.println("7. Filter daftar quest");
            System.out.println("8. Filter daftar pengembara");
            System.out.println("9.Tampilkan daftar quest terurut");
            System.out.println("10.Tampilkan daftar pengembara terurut");
            System.out.println("11. Keluar");
            System.out.print("Masukkan pilihan: ");
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1": {
                    // TODO: Tampilkan daftar quest
                    if (questData.length() == 0) {
                        System.out.println("Belum ada data quest.");
                    } else {
                        System.out.println("Quest yang terdaftar:");
                        Scanner scQuest = new Scanner(questData);
                        while (scQuest.hasNextLine()) {
                            String line = scQuest.nextLine();
                            
                            String id = line.substring(0, line.indexOf(NAME_IDENTIFIER));
                            String nama = line.substring(line.indexOf(NAME_IDENTIFIER) + 1, line.indexOf(DESC_IDENTIFIER));
                            String deskripsi = line.substring(line.indexOf(DESC_IDENTIFIER) + 1, line.indexOf(REWARD_IDENTIFIER));
                            String reward = line.substring(line.indexOf(REWARD_IDENTIFIER) + 1, line.indexOf(EXP_IDENTIFIER));
                            String bonus = line.substring(line.indexOf(EXP_IDENTIFIER) + 1, line.indexOf(DIFFICULTY_IDENTIFIER));
                            String kesulitan = line.substring(line.indexOf(DIFFICULTY_IDENTIFIER) + 1, line.indexOf(STATUS_IDENTIFIER));
                            String status = line.substring(line.indexOf(STATUS_IDENTIFIER) + 1);

                            String starEmoji = "";
                            if (kesulitan.equals("mudah")) starEmoji = "\u2605"; 
                            else if (kesulitan.equals("menengah")) starEmoji = "\u2605\u2605"; 
                            else if (kesulitan.equals("sulit")) starEmoji = "\u2605\u2605\u2605"; 

                            String statusEmoji = "";
                            if (status.equals("tersedia")) statusEmoji = "\ud83d\udfe2"; // 🟢
                            else if (status.startsWith("diambil")) statusEmoji = "\u231b"; // ⏳
                            else if (status.equals("selesai")) statusEmoji = "\ud83c\udfc6"; // 🏆

                            System.out.println("ID Quest: " + id.replace("Q", "Q")); // Memastikan format Q1, Q2 dst
                            System.out.println("Nama Quest: " + nama);
                            System.out.println("Deskripsi Quest: " + deskripsi);
                            System.out.println("Reward Quest: " + reward + " koin");
                            System.out.println("Bonus Exp Quest: " + bonus + " poin exp");
                            System.out.println("Tingkat Kesulitan Quest: " + starEmoji);
                            System.out.println("Status Quest: " + status + " " + statusEmoji);
                            System.out.println();
                        }
                    }
                    break;
                }
                case "2": {
                    // TODO: Tampilkan daftar pengembara
                    if (travelerData.length() == 0) {
                        System.out.println("Belum ada data pengembara.");
                    } else {
                        Scanner scTraveler = new Scanner(travelerData);
                        while (scTraveler.hasNextLine()) {
                            String line = scTraveler.nextLine();

                            String id = line.substring(0, line.indexOf(NAME_IDENTIFIER));
                            String nama = line.substring(line.indexOf(NAME_IDENTIFIER) + 1, line.indexOf(LEVEL_IDENTIFIER));
                            String level = line.substring(line.indexOf(LEVEL_IDENTIFIER) + 1, line.indexOf(EXP_IDENTIFIER));
                            String exp = line.substring(line.indexOf(EXP_IDENTIFIER) + 1, line.indexOf(STATUS_IDENTIFIER));
                            String status = line.substring(line.indexOf(STATUS_IDENTIFIER) + 1);

                            String statusEmoji = "";
                            if (status.equals("kosong")) statusEmoji = "\u2705"; // ✅
                            else if (status.startsWith("dalam quest")) statusEmoji = "\u274c"; // ❌

                            System.out.println("ID Pengembara: " + id);
                            System.out.println("Nama Pengembara: " + nama);
                            System.out.println("Level Pengembara: " + level);
                            System.out.println("Exp Pengembara: " + exp + " poin exp");
                            System.out.println("Status Pengembara: " + status + " " + statusEmoji);
                            System.out.println();
                        }
                    }
                    break;
                }
                case "3": {
                    // TODO: Tambah quest
                    System.out.println("Quest " + questId);
                    boolean cancelQ = false;
                    String qN = "", qD = "", qDiff = "";
                    int qR = 0, qB = 0;

                    while (true) {
                        System.out.print("Masukkan nama quest (masukkan 'x' atau 'X' untuk kembali): ");
                        String in = input.nextLine();
                        if (in.equalsIgnoreCase("x")) { cancelQ = true; break; }
                        if (in.matches("^[a-zA-Z0-9 ]+$")) { qN = in; break; }
                        System.out.println("Input tidak valid. Harap masukkan data dengan benar.");
                        System.out.println("Quest " + questId);
                    }
                    if (cancelQ) break; 

                    System.out.println("Deskripsi Quest " + questId);
                    while (true) {
                        System.out.print("Masukkan deskripsi quest (masukkan 'x' atau 'X' untuk kembali): ");
                        String in = input.nextLine();
                        if (in.equalsIgnoreCase("x")) { cancelQ = true; break; }
                        if (in.matches("^[a-zA-Z0-9 ]+$")) { qD = in; break; }
                        System.out.println("Input tidak valid. Harap masukkan data dengan benar.");
                        System.out.println("Deskripsi Quest " + questId);
                    }
                    if (cancelQ) break;

                    while (true) {
                        System.out.print("Masukkan reward quest berupa bilangan bulat (masukkan 'x' atau 'X' untuk kembali): ");
                        String in = input.nextLine();
                        if (in.equalsIgnoreCase("x")) { cancelQ = true; break; }
                        try {
                            int val = Integer.parseInt(in);
                            if (val >= 0) { qR = val; break; }
                        } catch (Exception e) {}
                        System.out.println("Input tidak valid. Harap masukkan data dengan benar.");
                    }
                    if (cancelQ) break;

                    while (true) {
                        System.out.print("Masukkan bonus exp quest berupa bilangan bulat (masukkan 'x' atau 'X' untuk kembali): ");
                        String in = input.nextLine();
                        if (in.equalsIgnoreCase("x")) { cancelQ = true; break; }
                        try {
                            int val = Integer.parseInt(in);
                            if (val >= 0) { qB = val; break; }
                        } catch (Exception e) {}
                        System.out.println("Input tidak valid. Harap masukkan data dengan benar.");
                    }
                    if (cancelQ) break;

                    while (true) {
                        System.out.print("Masukkan tingkat kesulitan quest (opsi: mudah, menengah, sulit) (masukkan 'x' atau 'X' untuk kembali): ");
                        String in = input.nextLine();
                        if (in.equalsIgnoreCase("x")) { cancelQ = true; break; }
                        if (in.equalsIgnoreCase("mudah") || in.equalsIgnoreCase("menengah") || in.equalsIgnoreCase("sulit")) {
                            qDiff = in; break;
                        }
                        System.out.println("Input tidak valid. Harap masukkan data dengan benar.");
                    }
                    if (cancelQ) break;

                    questData += "Q" + questId + NAME_IDENTIFIER + qN + DESC_IDENTIFIER + qD + 
                                 REWARD_IDENTIFIER + qR + EXP_IDENTIFIER + qB + 
                                 DIFFICULTY_IDENTIFIER + qDiff.toLowerCase() + STATUS_IDENTIFIER + "tersedia" + "\n";
                    questId++;
                    System.out.println("Quest berhasil ditambahkan.");
                    break;
                }
                case "4": {
                    // TODO: Tambah pengembara
                    System.out.println("Pengembara " + travelerId);
                    boolean cancelT = false;
                    String tN = "";
                    int tL = 0;

                    while (true) {
                        System.out.print("Masukkan nama pengembara (masukkan 'x' atau 'X' untuk kembali): ");
                        String in = input.nextLine();
                        if (in.equalsIgnoreCase("x")) { cancelT = true; break; }
                        if (in.matches("^[a-zA-Z0-9 ]+$")) { tN = in; break; }
                        System.out.println("Input tidak valid. Harap masukkan data dengan benar.");
                        System.out.println("Pengembara " + travelerId);
                    }
                    if (cancelT) break;

                    System.out.println("Pengembara " + travelerId);
                    while (true) {
                        System.out.print("Masukkan level pengembara berupa bilangan bulat (masukkan 'x' atau 'X' untuk kembali): ");
                        String in = input.nextLine();
                        if (in.equalsIgnoreCase("x")) { cancelT = true; break; }
                        try {
                            int val = Integer.parseInt(in);
                            if (val >= 1 && val <= 20) { tL = val; break; }
                        } catch (Exception e) {}
                        System.out.println("Input tidak valid. Harap masukkan data dengan benar.");
                        System.out.println("Pengembara " + travelerId);
                    }
                    if (cancelT) break;

                    int initExp = 0;
                    if (tL > 1) initExp = 5000 * (int)Math.pow(2, tL - 2);
                    
                    travelerData += "T" + travelerId + NAME_IDENTIFIER + tN + 
                                    LEVEL_IDENTIFIER + tL + EXP_IDENTIFIER + initExp + 
                                    STATUS_IDENTIFIER + "kosong" + "\n";
                    travelerId++;
                    System.out.println("Pengembara berhasil ditambahkan.");
                    break;
                }
                case "5": {
                    // TODO: Menjalankan quest
                    boolean keepRunningQuest = true;
                    while (keepRunningQuest) {
                        System.out.print("Masukkan ID Quest yang ingin diambil (atau 'X'/'x' untuk kembali): ");
                        String qIdInput = input.nextLine().trim();
                        if (qIdInput.equalsIgnoreCase("x")) break; // Kembali ke menu utama

                        boolean questFound = false;
                        String selectedQuestLine = "";
                        String qDifficultyCheck = "";
                        
                        Scanner scQ = new Scanner(questData);
                        while (scQ.hasNextLine()) {
                            String line = scQ.nextLine();
                            String currentId = line.substring(0, line.indexOf(NAME_IDENTIFIER)); // Ambil Q1, Q2, dst

                            if (currentId.equalsIgnoreCase(qIdInput)) {
                                String status = line.substring(line.indexOf(STATUS_IDENTIFIER) + 1);
                                if (status.equals("tersedia")) {
                                    questFound = true;
                                    selectedQuestLine = line;
                                    qDifficultyCheck = line.substring(line.indexOf(DIFFICULTY_IDENTIFIER) + 1, line.indexOf(STATUS_IDENTIFIER));
                                }
                                break; 
                            }
                        }

                        if (!questFound) {
                            System.out.println("Quest tidak ditemukan atau sudah diambil/selesai.");
                            continue;
                        }

                        System.out.print("Masukkan ID Pengembara yang akan mengambil quest (atau 'X'/'x' untuk kembali): ");
                        String tIdInput = input.nextLine().trim();
                        if (tIdInput.equalsIgnoreCase("x")) break; // Kembali ke menu utama

                        boolean travelerFound = false;
                        String selectedTravelerLine = "";
                        int tLevelCheck = 0;
                        String tIdReal = ""; 

                        Scanner scT = new Scanner(travelerData);
                        while (scT.hasNextLine()) {
                            String line = scT.nextLine();
                            String currentId = line.substring(0, line.indexOf(NAME_IDENTIFIER));
                            
                            if (currentId.equalsIgnoreCase(tIdInput)) {
                                String status = line.substring(line.indexOf(STATUS_IDENTIFIER) + 1);
                                if (status.equals("kosong")) {

                                    String lvlStr = line.substring(line.indexOf(LEVEL_IDENTIFIER) + 1, line.indexOf(EXP_IDENTIFIER));
                                    tLevelCheck = Integer.parseInt(lvlStr);
                                    
                                    boolean levelEligible = true;
                                    if (qDifficultyCheck.equals("sulit") && tLevelCheck < 16) levelEligible = false;
                                    if (qDifficultyCheck.equals("menengah") && tLevelCheck < 6) levelEligible = false;
                                    
                                    if (levelEligible) {
                                        travelerFound = true;
                                        selectedTravelerLine = line;
                                        tIdReal = currentId;
                                    }
                                }
                                break;
                            }
                        }

                        if (!travelerFound) {
                            System.out.println("Pengembara tidak ditemukan atau tidak memenuhi persyaratan untuk mengambil quest.");
                            continue;
                        }

                        String newQuestData = "";
                        scQ = new Scanner(questData);
                        while (scQ.hasNextLine()) {
                            String line = scQ.nextLine();
                            if (line.equals(selectedQuestLine)) {
                                String prefix = line.substring(0, line.indexOf(STATUS_IDENTIFIER) + 1);
                                newQuestData += prefix + "diambil-" + tIdReal + "\n";
                            } else {
                                newQuestData += line + "\n";
                            }
                        }
                        questData = newQuestData;

                        String newTravelerData = "";
                        scT = new Scanner(travelerData);
                        while (scT.hasNextLine()) {
                            String line = scT.nextLine();
                            if (line.equals(selectedTravelerLine)) {
                                String prefix = line.substring(0, line.indexOf(STATUS_IDENTIFIER) + 1);
                                newTravelerData += prefix + "dalam quest" + "\n";
                            } else {
                                newTravelerData += line + "\n";
                            }
                        }
                        travelerData = newTravelerData;

                        System.out.println("Berhasil mengambil quest.");
                        keepRunningQuest = false;
                    }
                    break;
                }
                case "6": {
                    // TODO: Menyelesaikan quest
                    boolean keepFinishingQuest = true;
                    while (keepFinishingQuest) {
                        System.out.print("Masukkan ID Quest yang ingin diselesaikan (atau 'X'/'x' untuk kembali): ");
                        String qIdInput = input.nextLine().trim();
                        if (qIdInput.equalsIgnoreCase("x")) break;

                        boolean validToFinish = false;
                        String targetQuestLine = "";
                        String associatedTravelerId = "";
                        int questBonusExp = 0;

                        Scanner scQ = new Scanner(questData);
                        while (scQ.hasNextLine()) {
                            String line = scQ.nextLine();
                            String currentId = line.substring(0, line.indexOf(NAME_IDENTIFIER));
                            
                            if (currentId.equalsIgnoreCase(qIdInput)) {
                                String status = line.substring(line.indexOf(STATUS_IDENTIFIER) + 1);
                                if (status.startsWith("diambil-")) {
                                    validToFinish = true;
                                    targetQuestLine = line;

                                    associatedTravelerId = status.substring(8); 
                                    String bonusStr = line.substring(line.indexOf(EXP_IDENTIFIER) + 1, line.indexOf(DIFFICULTY_IDENTIFIER));
                                    questBonusExp = Integer.parseInt(bonusStr);
                                }
                                break;
                            }
                        }

                        if (!validToFinish) {
                            System.out.println("Quest tidak ditemukan atau statusnya bukan diambil, tampilkan pesan eror dan minta input lagi.");
                            continue;
                        }

                        String targetTravelerLine = "";
                        int currentTLevel = 0;
                        int currentTExp = 0;

                        Scanner scT = new Scanner(travelerData);
                        while (scT.hasNextLine()) {
                            String line = scT.nextLine();
                            String currentId = line.substring(0, line.indexOf(NAME_IDENTIFIER));
                            if (currentId.equals(associatedTravelerId)) {
                                targetTravelerLine = line;
                                String lvlStr = line.substring(line.indexOf(LEVEL_IDENTIFIER) + 1, line.indexOf(EXP_IDENTIFIER));
                                String expStr = line.substring(line.indexOf(EXP_IDENTIFIER) + 1, line.indexOf(STATUS_IDENTIFIER));
                                currentTLevel = Integer.parseInt(lvlStr);
                                currentTExp = Integer.parseInt(expStr);
                                break;
                            }
                        }

                        long newExpLong = (long)currentTExp + questBonusExp;
                        int newLevel = currentTLevel;
                        
                        long expToNextLevel = 5000 * (long)Math.pow(2, currentTLevel - 1);

                        if (newLevel < 20 && newExpLong >= expToNextLevel) {
                            newLevel++;
                        }
                        
                        if (newExpLong > MAX_EXP) {
                            newExpLong = MAX_EXP;
                        }
                        if (newLevel == 20 && newExpLong < MAX_EXP) {
                        }
                        if (newLevel == 20) newExpLong = MAX_EXP;

                        String newQuestData = "";
                        scQ = new Scanner(questData);
                        while (scQ.hasNextLine()) {
                            String line = scQ.nextLine();
                            if (line.equals(targetQuestLine)) {
                                String prefix = line.substring(0, line.indexOf(STATUS_IDENTIFIER) + 1);
                                newQuestData += prefix + "selesai" + "\n";
                            } else {
                                newQuestData += line + "\n";
                            }
                        }
                        questData = newQuestData;

                        String newTravelerData = "";
                        scT = new Scanner(travelerData);
                        while (scT.hasNextLine()) {
                            String line = scT.nextLine();
                            if (line.equals(targetTravelerLine)) {
                                String tId = line.substring(0, line.indexOf(NAME_IDENTIFIER));
                                String tName = line.substring(line.indexOf(NAME_IDENTIFIER) + 1, line.indexOf(LEVEL_IDENTIFIER));
                                
                                newTravelerData += tId + NAME_IDENTIFIER + tName + 
                                                   LEVEL_IDENTIFIER + newLevel + 
                                                   EXP_IDENTIFIER + (int)newExpLong + 
                                                   STATUS_IDENTIFIER + "kosong" + "\n";
                            } else {
                                newTravelerData += line + "\n";
                            }
                        }
                        travelerData = newTravelerData;

                        System.out.println("Quest berhasil diselesaikan.");
                        keepFinishingQuest = false;
                    }
                    break;
                }
                case "7":
                    // TODO: Filter daftar quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "8":
                    // TODO: Filter daftar pengembara
                    System.out.println("Belum diimplementasikan");
                    break;
                case "9":
                    // TODO: Tampilkan daftar quest terurut
                    System.out.println("Belum diimplementasikan");
                    break;
                case "10":
                    // TODO: Tampilkan daftar pengembara terurut
                    System.out.println("Belum diimplementasikan");
                    break;
                case "11": {
                    // TODO: Keluar
                    System.out.println("Terima kasih telah menggunakan BurhanQuest!");
                    System.out.println("Dibuat oleh: " + STUDENT_NAME + " - " + STUDENT_ID); 
                    System.out.println("_______                                     __                                     ______                                     __    \n" +
                                        "|       \\                                   |  \\                                   /      \\                                   |  \\   \n" +
                                        "| $$$$$$$\\ __    __   ______    | $$____    ______    _______         |  $$$$$$\\ __    __   ______    _______  _| $$_  \n" +
                                        "| $$__/ $$|  \\  |  \\ /      \\ | $$    \\  |      \\ |       \\       | $$  | $$|  \\  |  \\ /      \\  /       \\|   $$ \\ \n" +
                                        "| $$    $$| $$  | $$|  $$$$$$\\| $$$$$$$\\  \\$$$$$$\\| $$$$$$$\\      | $$  | $$| $$  | $$|  $$$$$$\\|  $$$$$$$ \\$$$$$$ \n" +
                                        "| $$$$$$$\\| $$  | $$| $$   \\$$| $$   | $$ /      $$| $$   | $$      | $$ _| $$| $$  | $$| $$    $$ \\$$    \\   | $$ __ \n" +
                                        "| $$__/ $$| $$__/ $$| $$      | $$   | $$|  $$$$$$$| $$   | $$      | $$/ \\ $$| $$__/ $$| $$$$$$$$ _\\$$$$$$\\  | $$|  \\\n" +
                                        "| $$    $$ \\$$    $$| $$      | $$   | $$ \\$$    $$| $$   | $$       \\$$ $$ $$ \\$$    $$ \\$$     \\|      $$   \\$$  $$\n" +
                                        " \\$$$$$$$   \\$$$$$$  \\$$       \\$$    \\$$  \\$$$$$$$ \\$$    \\$$        \\$$$$$$\\  \\$$$$$$   \\$$$$$$$ \\$$$$$$$     \\$$$$ \n" +
                                        "                                                                          \\$$$");                                       
                                                                                                                                                                        
                    running = false;
                    break;
                }
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }
}