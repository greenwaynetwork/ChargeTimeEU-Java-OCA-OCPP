/*
 * ChargeTime.eu - Java-OCA-OCPP
 *
 * Copyright (C) 2023 Robert Schlabbach (robert.schlabbach@ubitricity.com)
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package eu.chargetime.ocpp.test;

import eu.chargetime.ocpp.v201.feature.function.ServerProvisioningEventHandler;
import eu.chargetime.ocpp.v201.model.messages.BootNotificationRequest;
import eu.chargetime.ocpp.v201.model.messages.BootNotificationResponse;
import eu.chargetime.ocpp.v201.model.messages.HeartbeatRequest;
import eu.chargetime.ocpp.v201.model.messages.HeartbeatResponse;
import eu.chargetime.ocpp.v201.model.messages.NotifyReportRequest;
import eu.chargetime.ocpp.v201.model.messages.NotifyReportResponse;
import eu.chargetime.ocpp.v201.model.types.RegistrationStatusEnum;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;

/** Dummy handlers for multiple protocol server functions up to OCPP 2.0.1 */
public class OCPP201MultiProtocolDummyHandlers extends DummyHandlers {

  /* OCPP 2.0.1 Provisioning function handlers */

  public ServerProvisioningEventHandler createServerProvisioningEventHandler() {
    return new ServerProvisioningEventHandler() {
      @Override
      public BootNotificationResponse handleBootNotificationRequest(
          UUID sessionIndex, BootNotificationRequest request) {
        BootNotificationResponse response =
            new BootNotificationResponse(
                ZonedDateTime.now(ZoneOffset.UTC), 20100, RegistrationStatusEnum.Accepted);
        return failurePoint(response);
      }

      @Override
      public HeartbeatResponse handleHeartbeatRequest(UUID sessionIndex, HeartbeatRequest request) {
        HeartbeatResponse response = new HeartbeatResponse(ZonedDateTime.now(ZoneOffset.UTC));
        return failurePoint(response);
      }

      @Override
      public NotifyReportResponse handleNotifyReportRequest(
          UUID sessionIndex, NotifyReportRequest request) {
        NotifyReportResponse response = new NotifyReportResponse();
        return failurePoint(response);
      }
    };
  }
}
