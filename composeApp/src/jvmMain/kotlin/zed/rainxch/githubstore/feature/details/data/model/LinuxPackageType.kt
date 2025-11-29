package zed.rainxch.githubstore.feature.details.data.model

enum class LinuxPackageType {
    DEB,        // Debian/Ubuntu/Mint
    RPM,        // Fedora/RHEL/CentOS/openSUSE
    UNIVERSAL   // Unknown - show AppImage only
}