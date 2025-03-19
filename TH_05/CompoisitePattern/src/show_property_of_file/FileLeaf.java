package show_property_of_file;

import java.io.File;

public class FileLeaf implements FileSystemComponent{

    private File file;

    public FileLeaf(File file) {
        this.file = file;
    }

    @Override
    public void showInfo() {
        System.out.println("File: " + file.getName() + "(Size: "+ file.length() +")");
    }

}
