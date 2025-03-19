package show_property_of_file;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File dictionary = new File("D:\\HTML&CSS");
        if(!dictionary.exists()){
            System.out.println("Dictionary not found");
            return;
        }

        FileSystemComponent folderComposite = new FolderComposite(dictionary);
        folderComposite.showInfo();
    }
}