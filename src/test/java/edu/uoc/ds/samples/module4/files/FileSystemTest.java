package edu.uoc.ds.samples.module4.files;

import edu.uoc.ds.traversal.Iterator;
import org.junit.Assert;
import org.junit.Test;

public class FileSystemTest {

    @Test
    public void test() throws Exception {
        FileSystem fileSystem = new FileSystem("/");
        String workDir = fileSystem.getWorkDir();
        Assert.assertEquals("/", workDir);

        fileSystem.newFile("file1.txt", "Content 1");
        Assert.assertEquals("Content 1", fileSystem.getFileContent("file1.txt"));

        Assert.assertThrows(FileSystemException.class, () ->
                fileSystem.newFile("file1.txt", "Content 1"));

        fileSystem.newFile("file2.txt", "Content 2");
        Assert.assertEquals("Content 2", fileSystem.getFileContent("file2.txt"));

        fileSystem.newFile("file3.txt", "Content 3");
        Assert.assertEquals("Content 3", fileSystem.getFileContent("file3.txt"));


        fileSystem.addDir("/tmp");
        fileSystem.upDirectory("/tmp");
        Assert.assertEquals("/tmp", fileSystem.getWorkDir());
        fileSystem.newFile("TMP_file4.txt", "Content TMP F4");
        fileSystem.newFile("TMP_file5.txt", "Content TMP F5");

        fileSystem.downDirectory();
        Assert.assertEquals("/", fileSystem.getWorkDir());

        fileSystem.deleteEntry("file3.txt");
        Assert.assertThrows(FileSystemException.class, () ->
                fileSystem.deleteEntry("file3.txt"));

        Iterator<FSEntry> entries = fileSystem.values();
        Assert.assertEquals("file1.txt", entries.next().getName());
        Assert.assertEquals("file2.txt", entries.next().getName());
        Assert.assertEquals("/tmp", entries.next().getName());
        Assert.assertFalse(entries.hasNext());

        fileSystem.upDirectory("/tmp");
        Assert.assertEquals("/tmp", fileSystem.getWorkDir());

        Iterator<FSEntry> entriesTmp = fileSystem.values();
        Assert.assertEquals("TMP_file4.txt", entriesTmp.next().getName());
        Assert.assertEquals("TMP_file5.txt", entriesTmp.next().getName());
        Assert.assertFalse(entriesTmp.hasNext());

    }
}
