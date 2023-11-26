package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian;

import java.util.*;

public class FileSizeStatistics {
    public static void main(String[] args) {
        FileSizeStatistics fileSizeStatistics = new FileSizeStatistics();
        fileSizeStatistics.insert(new File("a", 100), "-1");
        fileSizeStatistics.insert(new File("w", 200), "1");
        fileSizeStatistics.insert(new File("c", 200), "1");
        fileSizeStatistics.insert(new File("d", 300), "2");
        fileSizeStatistics.insert(new File("f", 500), "1");
        fileSizeStatistics.insert(new File("g", 400), "3");
        fileSizeStatistics.insert(new File("e", 100), "-1");

        fileSizeStatistics.getTotalSize();

        fileSizeStatistics.topKsize(3);

    }

    HashMap<String, Integer> collectionMap = new HashMap<>();
    List<File> fileList = new ArrayList<>();

    static class File {
        String name;
        int size;
        String collectionId;


        public String getCollectionId() {
            return collectionId;
        }

        public void setCollectionId(String collectionId) {
            this.collectionId = collectionId;
        }

        public File(String name, int size) {
            this.name = name;
            this.size = size;
            this.collectionId = "";
        }

    }

    public void insert(File file, String cid) {
        file.setCollectionId(cid);
        this.fileList.add(file);
    }


    public void getTotalSize() {
        int totalSize = 0;
        for (File f : fileList) {
            totalSize += f.size;
        }
        System.out.println("The total size of files processed: " + totalSize);
    }

    public void topKsize(int k) {
        //Top 2 collections: collection1 : 400 collection2 : 300
        for (File f : fileList) {
            if (f.collectionId != "-1") {
                String cId = f.getCollectionId();
                this.collectionMap.put(cId, this.collectionMap.getOrDefault(cId, 0) + f.size);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(this.collectionMap.entrySet());
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
        System.out.println("Top " + k + " collections: ");
        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.print("collection" + entry.getKey() + ": " + entry.getValue() + " ");
        }
    }
}
