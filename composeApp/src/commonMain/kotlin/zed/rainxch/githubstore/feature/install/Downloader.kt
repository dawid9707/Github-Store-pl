package zed.rainxch.githubstore.feature.install

import kotlinx.coroutines.flow.Flow

data class DownloadProgress(
    val bytesDownloaded: Long,
    val totalBytes: Long?,
    val percent: Int?,
)

/**
 * Platform-agnostic downloader contract. Platform implementations are provided via DI.
 */
interface Downloader {
    /**
     * Streams the file from [url] into an app-controlled downloads directory.
     * Returns a Flow of progress updates and completes when fully written.
     * The final file path is returned from [saveToFile] if needed.
     */
    fun download(url: String, suggestedFileName: String? = null): Flow<DownloadProgress>

    /**
     * Convenience: downloads and returns the absolute file path when complete.
     */
    suspend fun saveToFile(url: String, suggestedFileName: String? = null): String
}
