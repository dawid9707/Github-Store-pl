package zed.rainxch.githubstore.feature.details.domain.model

enum class LinuxPackageType {
    DEB,
    RPM,
    UNIVERSAL
}

expect fun detectLinuxPackageType() : LinuxPackageType