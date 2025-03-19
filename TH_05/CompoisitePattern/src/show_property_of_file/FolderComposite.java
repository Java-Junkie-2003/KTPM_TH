package show_property_of_file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderComposite implements FileSystemComponent {

    private File folder;
    private List<FileSystemComponent> children = new ArrayList<>();

    public FolderComposite(File folder) {
        this.folder = folder;
        loadChildren();
    }

    private void loadChildren() {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    children.add(new FolderComposite(file));
                } else {
                    children.add(new FileLeaf(file));
                }
            }
        }
    }

    @Override
    public void showInfo() {
        System.out.println("Folder: " + folder.getName());
        for (FileSystemComponent component : children) {
            component.showInfo();
        }
    }
}
