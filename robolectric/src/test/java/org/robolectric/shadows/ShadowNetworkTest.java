package org.robolectric.shadows;

import android.net.Network;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Shadows;
import org.robolectric.TestRunners;
import org.robolectric.annotation.Config;

import static android.os.Build.VERSION_CODES.LOLLIPOP;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(TestRunners.MultiApiSelfTest.class)
@Config(minSdk = LOLLIPOP)
public class ShadowNetworkTest {
  @Test
  public void getNetId_shouldReturnConstructorNetId() {
    final int netId = 123;

    Network network = ShadowNetwork.newInstance(netId);
    ShadowNetwork shadowNetwork = Shadows.shadowOf(network);
    assertThat(shadowNetwork.getNetId()).isEqualTo(netId);
  }
}
