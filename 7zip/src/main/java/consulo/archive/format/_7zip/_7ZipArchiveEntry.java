package consulo.archive.format._7zip;

import consulo.virtualFileSystem.archive.ArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;

/**
 * @author VISTALL
 * @since 2026-01-01
 */
public class _7ZipArchiveEntry implements ArchiveEntry {
   private final SevenZArchiveEntry myEntry;

    public _7ZipArchiveEntry(SevenZArchiveEntry entry) {
        myEntry = entry;
    }

    public SevenZArchiveEntry getEntry() {
        return myEntry;
    }

    @Override
    public String getName() {
        return myEntry.getName();
    }

    @Override
    public long getSize() {
        return myEntry.getSize();
    }

    @Override
    public long getTime() {
        return myEntry.getCreationDate().getTime();
    }

    @Override
    public boolean isDirectory() {
        return myEntry.isDirectory();
    }
}
