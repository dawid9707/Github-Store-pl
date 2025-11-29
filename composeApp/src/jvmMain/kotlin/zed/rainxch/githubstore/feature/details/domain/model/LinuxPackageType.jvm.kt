package zed.rainxch.githubstore.feature.details.domain.model

actual fun detectLinuxPackageType(): LinuxPackageType {
    return try {
        val aptCheck = ProcessBuilder("which", "apt").start()
        if (aptCheck.waitFor() == 0) {
            return LinuxPackageType.DEB
        }

        val dnfCheck = ProcessBuilder("which", "dnf").start()
        if (dnfCheck.waitFor() == 0) {
            return LinuxPackageType.RPM
        }

        val yumCheck = ProcessBuilder("which", "yum").start()
        if (yumCheck.waitFor() == 0) {
            return LinuxPackageType.RPM
        }

        val zypperCheck = ProcessBuilder("which", "zypper").start()
        if (zypperCheck.waitFor() == 0) {
            return LinuxPackageType.RPM
        }

        LinuxPackageType.UNIVERSAL
    } catch (e: Exception) {
        LinuxPackageType.UNIVERSAL
    }
}