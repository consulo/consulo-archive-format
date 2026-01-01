package consulo.archive.format._7zip;

import consulo.localize.LocalizeValue;
import consulo.virtualFileSystem.VirtualFileManager;
import consulo.virtualFileSystem.archive.ArchiveFileType;
import jakarta.annotation.Nonnull;

/**
 * @author VISTALL
 * @since 2026-01-01
 */
public class _7ZipArchiveFileType extends ArchiveFileType {
    public static final _7ZipArchiveFileType INSTANCE = new _7ZipArchiveFileType();

    public _7ZipArchiveFileType() {
        super(VirtualFileManager.getInstance());
    }

    @Nonnull
    @Override
    public String getDefaultExtension() {
        return "7z";
    }

    @Nonnull
    @Override
    public String getId() {
        return "7ZIP_ARCHIVE";
    }

    @Nonnull
    @Override
    public LocalizeValue getDescription() {
        return LocalizeValue.localizeTODO("7-Zip Archive");
    }

    @Nonnull
    @Override
    public String getProtocol() {
        return _7ZipArchiveFileSystemProvider.PROTOCOL;
    }
}
