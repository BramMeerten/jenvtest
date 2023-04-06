package io.javaoperatorsdk.jenvtest;

import java.util.List;
import java.util.Optional;

public class KubeAPIServerConfig {

  /**
   * Set directory where binaries and other assets are present. Default is ~/.jenvtest.
   **/
  private final String jenvtestDir;

  /**
   * If not set the latest binary will be selected automatically. Sample: '1.26.1', '1.25.0'.
   * Wildcards for patch version is supported, like: '1.25.*'. In this case latest patch version is
   * used.
   */
  private final String apiServerVersion;

  /**
   * If true, tries to download binaries. If the apiServerVersion is not set and some local binaries
   * found won't try to download them again.
   */
  private final boolean offlineMode;

  /**
   * Flags to pass to Kube API Server on startup. Key and value are two separated items, like
   * specifying min-request-timeout needs to add in order two values: "--min-request-timeout" and
   * "300" for the actual desired value.
   *
   * See Kubernetes docs for possible flags:
   * https://kubernetes.io/docs/reference/command-line-tools-reference/kube-apiserver/
   */
  private final List<String> apiServerFlags;

  /**
   * If kube config (in ~/kube/config ) file should be updated.
   */
  private final boolean updateKubeConfig;

  KubeAPIServerConfig(String jenvtestDir, String apiServerVersion, boolean offlineMode,
      List<String> apiServerFlags, boolean updateKubeConfig) {
    this.jenvtestDir = jenvtestDir;
    this.apiServerVersion = apiServerVersion;
    this.offlineMode = offlineMode;
    this.apiServerFlags = apiServerFlags;
    this.updateKubeConfig = updateKubeConfig;
  }

  public String getJenvtestDir() {
    return jenvtestDir;
  }

  public Optional<String> getApiServerVersion() {
    return Optional.ofNullable(apiServerVersion);
  }

  public boolean isOfflineMode() {
    return offlineMode;
  }

  public List<String> getApiServerFlags() {
    return apiServerFlags;
  }

  public boolean isUpdateKubeConfig() {
    return updateKubeConfig;
  }
}
