package consulo.archive.format._7zip;

import consulo.annotation.component.ExtensionImpl;
import consulo.virtualFileSystem.archive.ArchiveFile;
import consulo.virtualFileSystem.archive.ArchiveFileSystemProvider;
import jakarta.annotation.Nonnull;

import java.io.IOException;

/**
 * @author VISTALL
 * @since 2026-01-01
 */
@ExtensionImpl
public class _7ZipArchiveFileSystemProvider implements ArchiveFileSystemProvider {
    public static final String PROTOCOL = "7Zip";

    @Nonnull
    @Override
    public String getProtocol() {
        return PROTOCOL;
    }

    @Nonnull
    @Override
    public ArchiveFile createArchiveFile(@Nonnull String filePath) throws IOException {
        return new _7ZipArchiveFile(filePath);
    }
}
