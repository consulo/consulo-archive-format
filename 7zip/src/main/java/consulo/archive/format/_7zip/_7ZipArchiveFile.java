package consulo.archive.format._7zip;

import consulo.virtualFileSystem.archive.ArchiveEntry;
import consulo.virtualFileSystem.archive.ArchiveFile;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author VISTALL
 * @since 2026-01-01
 */
public class _7ZipArchiveFile implements ArchiveFile {
    private final String myFilePath;

    private SevenZFile mySevenZFile;

    public _7ZipArchiveFile(String filePath) throws IOException {
        myFilePath = filePath;

        mySevenZFile = new SevenZFile(new File(myFilePath));
    }

    @Nonnull
    @Override
    public String getName() {
        return myFilePath;
    }

    @Nullable
    @Override
    public ArchiveEntry getEntry(String entryName) {
        Iterable<SevenZArchiveEntry> entries = mySevenZFile.getEntries();
        for (SevenZArchiveEntry entry : entries) {
            if (Objects.equals(entry.getName(), entryName)) {
                return new _7ZipArchiveEntry(entry);
            }
        }
        return null;
    }

    @Nullable
    @Override
    public InputStream getInputStream(@Nonnull ArchiveEntry archiveEntry) throws IOException {
        _7ZipArchiveEntry zipEntry = (_7ZipArchiveEntry) archiveEntry;
        return mySevenZFile.getInputStream(zipEntry.getEntry());
    }

    @Nonnull
    @Override
    public Iterator<? extends ArchiveEntry> entries() {
        Iterable<SevenZArchiveEntry> entries = mySevenZFile.getEntries();

        Iterator<SevenZArchiveEntry> iterator = entries.iterator();
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public ArchiveEntry next() {
                return new _7ZipArchiveEntry(iterator.next());
            }
        };
    }

    @Override
    public int getSize() {
        Iterable<SevenZArchiveEntry> entries = mySevenZFile.getEntries();
        if (entries instanceof Collection collection) {
            return collection.size();
        }

        int count = 0;
        for (SevenZArchiveEntry ignored : entries) {
            count ++;
        }
        return count;
    }

    @Override
    public void close() throws IOException {
        if (mySevenZFile != null) {
            mySevenZFile.close();
            mySevenZFile = null;
        }
    }
}
