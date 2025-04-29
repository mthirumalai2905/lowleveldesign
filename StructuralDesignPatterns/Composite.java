// Component
interface FileSystem {
    void showDetails();
}

// Leaf
class File implements FileSystem {
    private String name;
    private int size; // size of the file in KB

    File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name + " | Size: " + size + "KB");
    }
}

// Composite
class Directory implements FileSystem {
    private String name;
    private List<FileSystem> contents = new ArrayList<>();

    Directory(String name) {
        this.name = name;
    }

    void addFileSystem(FileSystem fileSystem) {
        contents.add(fileSystem);
    }

    @Override
    public void showDetails() {
        System.out.println("Directory: " + name);
        for (FileSystem fileSystem : contents) {
            fileSystem.showDetails();
        }
    }
}

public class CompositePatternExample {
    public static void main(String[] args) {
        // Create files
        File file1 = new File("file1.txt", 100);
        File file2 = new File("file2.jpg", 250);
        File file3 = new File("file3.mp4", 1024);

        // Create directories
        Directory dir1 = new Directory("Documents");
        Directory dir2 = new Directory("Media");

        // Add files to directories
        dir1.addFileSystem(file1);
        dir1.addFileSystem(file2);
        dir2.addFileSystem(file3);

        // Add sub-directory to root directory
        Directory rootDir = new Directory("Root");
        rootDir.addFileSystem(dir1);
        rootDir.addFileSystem(dir2);

        // Display details
        rootDir.showDetails();
    }
}
