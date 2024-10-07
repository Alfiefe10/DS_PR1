package edu.uoc.ds.samples.module4.files;

import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.adt.nonlinear.GeneralTreeDelImpl;
import edu.uoc.ds.adt.nonlinear.Tree;
import edu.uoc.ds.traversal.Iterator;
import edu.uoc.ds.traversal.IteratorTraversalImpl;
import edu.uoc.ds.traversal.Traversal;


public class FileSystem {

    private final Tree<FSEntry> directoriesTree;
    private Position<FSEntry> workDir;

    public FileSystem(String rootDirectoryStr) {
        directoriesTree = new GeneralTreeDelImpl<>();
        Directory rootDirectory = new Directory(rootDirectoryStr, null);
        workDir = directoriesTree.add(null, rootDirectory);
    }


    public String getWorkDir() {
        return workDir.toString();
    }


    public void addDir(String name) throws FileSystemException {
        if (seekChild(name) != null)
            throw new FileSystemException(workDir + " already exists: " + name);
        Directory subdirectory = new Directory(name, workDir);
        directoriesTree.add(workDir, subdirectory);
    }


    public void newFile(String name, String content) throws FileSystemException {
        if (seekChild(name) != null)
            throw new FileSystemException(workDir + " already exists: " + name);
        TextFile fichero = new TextFile(name, workDir);
        directoriesTree.add(workDir, fichero);
        fichero.setContent(content);
    }


    public void deleteEntry(String name) throws FileSystemException {
        Position<FSEntry> entry2Delete = seekChild(name);
        if (entry2Delete == null)
            throw new FileSystemException(workDir + " don't exist: " + name);
        directoriesTree.delete(workDir, entry2Delete);
    }


    public Iterator<FSEntry> values() {
        Traversal<FSEntry> children = directoriesTree.children(workDir);
        return new IteratorTraversalImpl<FSEntry, FSEntry>(children);
    }


    public void rename(String oldName, String newName) throws FileSystemException {
        Position<FSEntry> entry2Rename = seekChild(oldName);
        if (entry2Rename == null)
            throw new FileSystemException(workDir + " don't exists:  " + oldName);
        entry2Rename.getElem().setName(newName);
    }


    public void upDirectory(String name) throws FileSystemException {
        Position<FSEntry> child = seekChild(name);
        if (child == null)
            throw new FileSystemException(workDir + " has no element: " + name);
        if (!child.getElem().isDirectory())
            throw new FileSystemException(child.getElem().getName() + " is not a directory");
        workDir = child;
    }


    public void downDirectory() throws FileSystemException {
        Position<FSEntry> parent = workDir.getElem().getParent();
        if (parent == null)
            throw new FileSystemException(workDir + " is the root directory");
        workDir = parent;
    }


    public String getFileContent(String name) throws FileSystemException {
        Position<FSEntry> child = seekChild(name);
        if (child == null)
            throw new FileSystemException(workDir + " don't exist " + name);
        if (child.getElem().isDirectory())
            throw new FileSystemException(child.getElem().getName() + " is not a file");
        return ((TextFile) child.getElem()).getContent();
    }


    private Position<FSEntry> seekChild(String name) {
        Traversal<FSEntry> children = directoriesTree.children(workDir);
        Position<FSEntry> childFound = null;
        while (children.hasNext() && childFound == null) {
            Position<FSEntry> child = children.next();
            if (child.getElem().getName().equals(name))
                childFound = child;
        }
        return childFound;
    }


}
