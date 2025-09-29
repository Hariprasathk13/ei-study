
/**
   * Created a simple example to demonstrate composite pattern 
     A file system contains both files (leaf nodes) and folders (composite nodes).
     the client treat them uniformly without any additonal method 
 */

import java.util.ArrayList;
import java.util.List;

/**
 * FileSystem:common behavior for both files and folders
 */
interface FileSystem {
    void ls(); // prints filename
}

// leaf node :a file
class File implements FileSystem {
    String filename;

    File(String filename) {
        this.filename = filename;
    }

    @Override
    public void ls() {
        System.out.println(filename);
    }
}

// composite node: folder contains files and folders
class Folder implements FileSystem {
    List<FileSystem> items;
    String folderName;

    Folder(String folderName) {
        items = new ArrayList<>();
        this.folderName = folderName;
    }

    // adds file or folder to a folder
    public void addItems(FileSystem item) {
        items.add(item);
    }

    @Override
    public void ls() {
        System.out.println(folderName);
        for (FileSystem fs : items) {
            fs.ls();
        }
    }
}

// client
public class CompositePatternDemo {

    public static void main(String[] args) {
        // creating main directory
        Folder mainDir = new Folder("MainFolder");
        File file1 = new File("FileA");

        mainDir.addItems(file1);

        // creating sub directory
        Folder subDir1 = new Folder("Sub Folder 1");

        File file2 = new File("FileB");
        File file3 = new File("FileC");

        // adding files to subdirectories
        subDir1.addItems(file2);
        subDir1.addItems(file3);

        Folder subDir2 = new Folder("Sub Folder 1");
        File file4 = new File("FileD");

        subDir2.addItems(file4);

        // adding subdirectories to main
        mainDir.addItems(subDir1);
        mainDir.addItems(subDir2);

        // prints entire structure of maindir
        mainDir.ls();
    }

}