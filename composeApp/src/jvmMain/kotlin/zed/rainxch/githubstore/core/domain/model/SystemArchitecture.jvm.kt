package zed.rainxch.githubstore.core.domain.model

actual fun detectSystemArchitecture(): Architecture {
    val osArch = System.getProperty("os.arch") ?: return Architecture.UNKNOWN
    return Architecture.fromString(osArch)
}