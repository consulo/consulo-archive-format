package consulo.archive.format._7zip;

import consulo.annotation.component.ExtensionImpl;
import consulo.virtualFileSystem.fileType.FileTypeConsumer;
import consulo.virtualFileSystem.fileType.FileTypeFactory;
import jakarta.annotation.Nonnull;

/**
 * @author VISTALL
 * @since 2026-01-01
 */
@ExtensionImpl
public class _7ZipArchiveFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@Nonnull FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(_7ZipArchiveFileType.INSTANCE);
    }
}
